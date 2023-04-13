package br.com.itads.snackshare.frontend.controller.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import br.com.itads.snackshare.controller.responses.RefundsResponse;
import br.com.itads.snackshare.controller.responses.SnackResponse;
import br.com.itads.snackshare.frontend.controller.interfaces.OrderControllerInterface;
import br.com.itads.snackshare.frontend.pojo.FrontendDTO;
import br.com.itads.snackshare.frontend.services.interfaces.OrderServiceInterface;
import br.com.itads.snackshare.model.Item;
import br.com.itads.snackshare.model.Order;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@Controller
public class OrderController extends GenericController implements OrderControllerInterface {

	/**
	 * 
	 */
	@Autowired
	private OrderServiceInterface orderService;

	/**
	 * 
	 * @return
	 */
	public ModelAndView newOrder(HttpSession session, 
			@Validated @ModelAttribute("item") Item item,
			@ModelAttribute("order") Order order,
			BindingResult result, ModelMap model) {

		Order sessionOrder = (Order) session.getAttribute("sessionOrder");

		if (sessionOrder != null) {
			order = sessionOrder;
		} else if (order.getItemMap() == null) {
			Map<String, Item> itemMap = new HashMap<String, Item>();
			order.setItemMap(itemMap);
		}

		session.setAttribute("sessionOrder", order);

		return new ModelAndView("/order/newOrder", "order", order);

	}

	/**
	 * 
	 */
	public ModelAndView listOrder(HttpSession session, 
			@Validated 
			@ModelAttribute("orders") List<Order> orders,
			BindingResult result, ModelMap model) {

		List<Order> sessionOrders = (List<Order>) session.getAttribute("sessionOrders");

		if (sessionOrders != null) {
			orders = sessionOrders;
		}

		session.setAttribute("sessionOrders", orders);

		return new ModelAndView("/order/listOrder", "orders", orders);

	}

	/**
	 * 
	 */
	public ModelAndView saveOrUpdateItemOnOrder(HttpSession session,
			@Validated @ModelAttribute("item") Item item,
			BindingResult result, ModelMap model) {

		Order sessionOrder = (Order) session.getAttribute("sessionOrder");

		if (sessionOrder == null) {
			sessionOrder = Order.builder().build();
		}

		if (item.getId() == null) {
			item.setId(UUID.randomUUID().toString());
		}
		sessionOrder.getItemMap().put(item.getId(), item);

		session.setAttribute("sessionOrder", sessionOrder);

		return new ModelAndView("/order/newOrder", "order", sessionOrder);

	}
	
	/**
	 * 
	 */
	public ModelAndView removeItemOnOrder(HttpSession session,
			@Validated @ModelAttribute("item") Item item,
			BindingResult result, ModelMap model) {

		Order sessionOrder = (Order) session.getAttribute("sessionOrder");

		if (sessionOrder == null) {
			sessionOrder = Order.builder().build();
		}

		sessionOrder.getItemMap().remove(item.getId());

		session.setAttribute("sessionOrder", sessionOrder);

		return new ModelAndView("/order/newOrder", "order", sessionOrder);

	}	
	
	/**
	 * 
	 */
	public ModelAndView processOrder(HttpSession session, 
			@Validated @ModelAttribute("item") Item item, 
			@ModelAttribute("order") Order order,
			BindingResult result, ModelMap model) {

		Order sessionOrder = (Order) session.getAttribute("sessionOrder");

		if (sessionOrder != null) {
			
			SnackResponse snackResponse = orderService.processOrder(sessionOrder);

			RefundsResponse refundsResponse = orderService.getRefundMethod(snackResponse);

			FrontendDTO frontendDTO = 
					FrontendDTO.builder()
								.snackResponse(snackResponse)
								.refundsResponse(refundsResponse)
								.build();			
			
			if (snackResponse != null && refundsResponse != null) {
				session.setAttribute("frontendDTO", frontendDTO);
				return new ModelAndView("/order/showResultOrder", "frontendDTO", frontendDTO);
			}

			return new ModelAndView("/newOrder", "order", order);

		} else {

			return new ModelAndView("/error");

		}

	}

}
