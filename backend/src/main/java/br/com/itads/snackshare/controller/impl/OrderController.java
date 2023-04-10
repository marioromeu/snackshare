package br.com.itads.snackshare.controller.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import br.com.itads.snackshare.controller.interfaces.OrderControllerInterface;
import br.com.itads.snackshare.controller.requests.SnackRequest;
import br.com.itads.snackshare.controller.responses.SnackResponse;
import br.com.itads.snackshare.dto.OrderDTO;
import br.com.itads.snackshare.services.impl.OrderService;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@RestController
public class OrderController implements OrderControllerInterface {

	@Autowired
	private OrderService orderService;
	
	/**
	 * 
	 */
	@Override
	public ResponseEntity<SnackResponse> processOrder(MultiValueMap<String, String> header, @Valid SnackRequest body) {

		OrderDTO dto = OrderDTO.builder()
				.order(body.getOrder())
				.build();
		
		SnackResponse response = orderService.calculateSharedValueByOwner(dto); 
		
		ResponseEntity<SnackResponse> entity = new ResponseEntity<SnackResponse>(response, HttpStatus.OK);
		
		return entity;

	}

	
	
}
