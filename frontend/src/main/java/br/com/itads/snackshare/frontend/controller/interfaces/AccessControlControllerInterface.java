package br.com.itads.snackshare.frontend.controller.interfaces;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.itads.snackshare.frontend.pojo.User;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public interface AccessControlControllerInterface extends GenericControllerInterface {

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(
			HttpSession session,
			@Validated @ModelAttribute("user") User user, 
			BindingResult result,			
			ModelMap model);
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(
			HttpSession session,
			@Validated @ModelAttribute("user") User user, 
			BindingResult result,			
			ModelMap model);	

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact(
			HttpSession session,
			@Validated @ModelAttribute("user") User user, 
			BindingResult result,			
			ModelMap model);	

	/**
	 * 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(
			HttpSession session,
			@Validated @ModelAttribute("user") User user, 
			BindingResult result,			
			ModelMap model);

}
