package br.com.itads.snackshare.frontend.controller.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import br.com.itads.snackshare.frontend.controller.interfaces.OrderControllerInterface;
import br.com.itads.snackshare.frontend.services.interfaces.OrderServiceInterface;
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
	public ModelAndView newOrder(
			HttpSession session,
			@Validated @ModelAttribute("order") Order order, 
			BindingResult result,			
			ModelMap model) {

		return new ModelAndView("/newOrder", "order" , order  );

	}
	
	/**
	 * 
	 */
	public ModelAndView listOrder(
			HttpSession session,
			@Validated @ModelAttribute("orders") List<Order> orders, 
			BindingResult result,			
			ModelMap model) {

		return new ModelAndView("/listOrder", "orders" , orders  );

	}	

	/**
	 * 
	 */
	public ModelAndView processOrder(
			HttpSession session,
			@Validated @ModelAttribute("order") Order order, 
			BindingResult result,			
			ModelMap model) {

		order = orderService.processOrder(order);
		
		if (order != null) {		
			session.setAttribute( "order", order );
			return new ModelAndView("/showResultOrder", "order" , order );
		}

		return new ModelAndView("/newOrder", "order" , order );

	}
	
}
