package br.com.itads.snackshare.frontend.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.itads.snackshare.frontend.controller.interfaces.AccessControlControllerInterface;
import br.com.itads.snackshare.frontend.pojo.User;
import br.com.itads.snackshare.frontend.services.interfaces.AccessControlServiceInterface;

/**
 * 
 * @author marioromeu
 *
 */
@Controller
public class AccessControlController extends GenericController implements AccessControlControllerInterface {

	/**
	 * 
	 */
	@Autowired
	private AccessControlServiceInterface acessControlService;
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(
			HttpSession session,
			@Validated @ModelAttribute("user") User user, 
			BindingResult result,
			ModelMap model) {

		return new ModelAndView("/index", "user" , new User()  );

	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView empty(
			HttpSession session,
			@Validated @ModelAttribute("user") User user, 
			BindingResult result,
			ModelMap model) {

		return new ModelAndView("/index", "user" , new User()  );

	}	

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(
			HttpSession session,
			@Validated @ModelAttribute("user") User user, 
			BindingResult result,
			ModelMap model) {

		return new ModelAndView("/home", "user" , new User()  );

	}	

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact(
			HttpSession session,
			@Validated @ModelAttribute("user") User user, 
			BindingResult result,
			ModelMap model) {

		return new ModelAndView("/contact", "user" , new User()  );

	}	

	/**
	 * 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(
			HttpSession session,
			@Validated @ModelAttribute("user") User user,
			BindingResult result,
			ModelMap model) {

		user = acessControlService.login(user);
		
		if (user != null) {		
			session.setAttribute( "loggedUser", user );
			return new ModelAndView("/home", "user" , user );
		}

		return new ModelAndView("/index", "user" , new User() );

	}
	
}
