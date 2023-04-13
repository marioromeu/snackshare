package br.com.itads.snackshare.frontend.controller.interfaces;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.itads.snackshare.model.Order;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public interface OrderControllerInterface extends GenericControllerInterface {

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/newOrder", method = RequestMethod.GET)
	public ModelAndView newOrder(
			HttpSession session,
			@Validated @ModelAttribute("order") Order order, 
			BindingResult result,			
			ModelMap model);
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listOrder", method = RequestMethod.GET)
	public ModelAndView listOrder(
			HttpSession session,
			@Validated @ModelAttribute("orders") List<Order> orders, 
			BindingResult result,			
			ModelMap model);	

	/**
	 * 
	 * @return
	 */
	@PostMapping(value = "/processOrder")
	public ModelAndView processOrder(
			HttpSession session,
			@Validated @ModelAttribute("order") Order order, 
			BindingResult result,			
			ModelMap model);

}
