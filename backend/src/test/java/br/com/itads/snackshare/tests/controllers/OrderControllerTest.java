package br.com.itads.snackshare.tests.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.itads.snackshare.builder.OrderBuilder;
import br.com.itads.snackshare.controller.requests.SnackRequest;
import br.com.itads.snackshare.controller.responses.SnackResponse;
import br.com.itads.snackshare.dto.OrderDTO;
import br.com.itads.snackshare.exception.EmptyOrderException;
import br.com.itads.snackshare.services.impl.OrderService;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(OrderControllerTest.class)
@AutoConfigureMockMvc
public class OrderControllerTest {

	/**
	 * 
	 */
	@Autowired
	private MockMvc mockMvc;

	/**
	 * 
	 */
	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * 
	 */
	@MockBean
	private OrderService service;

	/**
	 * Empry Request
	 */
	private final SnackRequest emptyRequest = OrderBuilder.buildEmptySnackRequest();

	/**
	 * Normal Request
	 */
	private final SnackRequest request = OrderBuilder.buildNormalSnackRequest();

	private final static String PATH_ORDER = "/snackShare/order/";
	private final static String APPLICATION_JSON = "application/json";

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	void whenSendOrderReturnRefundsMethod() throws Exception {

		OrderDTO dto =
				OrderDTO.builder()
						.order(request.getOrder())
						.build();
		
		SnackResponse response = OrderBuilder.buildEmptySnackResponse(request.getOrder());
		
		when(service.calculateSharedValueByOwner(dto)).thenReturn(response);
		
		mockMvc.perform(
				post(PATH_ORDER)
				.contentType(APPLICATION_JSON)
				.accept(APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))
		).andExpect(status().isOk());
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	void whenSendEmptyOrderReturnEmptyResponse() throws Exception {
		
		doThrow(EmptyOrderException.class).when(service).calculateSharedValueByOwner(any());
		
		mockMvc.perform(
				post(PATH_ORDER)
				.contentType(APPLICATION_JSON)
				.accept(APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(emptyRequest))
		).andExpect(status().isBadRequest());
	}

}
