package br.com.itads.snackshare.tests.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.itads.snackshare.builder.OrderBuilder;
import br.com.itads.snackshare.dto.OrderDTO;
import br.com.itads.snackshare.exception.EmptyOrderException;
import br.com.itads.snackshare.model.Order;
import br.com.itads.snackshare.services.impl.OrderService;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@ExtendWith(SpringExtension.class)
public class OrderServiceTest {

	/**
	 * 
	 */
	@InjectMocks
	OrderService service;

	/**
	 * 
	 */
	@Test
	void whenCompleteOrderIsSubmittedReturnsOK() {

		Order order = OrderBuilder.buildNormalOrder();
		
		OrderDTO orderDTO = OrderDTO.builder()
				.order(order)
				.build();

		assertDoesNotThrow(() -> service.calculateSharedValueByOwner(orderDTO));

	}
	
	/**
	 * 
	 */
	@Test
	void whenEmptyOrderIsSubmittedReturnsFail() {

		Order order = OrderBuilder.buildEmptyOrder();
		
		OrderDTO orderDTO = OrderDTO.builder()
				.order(order)
				.build();
		
		assertThrows(EmptyOrderException.class, () -> service.calculateSharedValueByOwner(orderDTO));

	}	

}
