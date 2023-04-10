package br.com.itads.snackshare.frontend.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.itads.snackshare.frontend.controller.interfaces.RestOrderControllerInterface;
import br.com.itads.snackshare.frontend.services.RestTemplateService;

/**
 * 
 * @author marioromeu
 * @email  mario.romeu@gmail.com
 *
 */
@RestController
public class RestOrderController implements RestOrderControllerInterface {

	/**
	 * 
	 */
	@Autowired
	RestTemplateService service; 
	
}
