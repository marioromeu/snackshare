package br.com.itads.snackshare.frontend.services.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.itads.snackshare.controller.requests.RefundsRequest;
import br.com.itads.snackshare.controller.requests.SnackRequest;
import br.com.itads.snackshare.controller.responses.RefundsResponse;
import br.com.itads.snackshare.controller.responses.SnackResponse;
import br.com.itads.snackshare.dto.ResponseDTO;
import br.com.itads.snackshare.frontend.constants.FrontendConstants;
import br.com.itads.snackshare.frontend.httpclient.RestTemplateFactory;
import br.com.itads.snackshare.frontend.services.interfaces.OrderServiceInterface;
import br.com.itads.snackshare.model.Order;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@Service
public class OrderServiceImpl implements OrderServiceInterface {

	/**
	 * 
	 */
	@Value("${snackshare.backend.url}")
	private String url;
	
	/**
	 * 
	 */
	protected RestTemplate template;
	
	/**
	 * 
	 */
	@Autowired
	protected RestTemplateFactory restTemplateFactory;

	/**
	 * 
	 */
	public void init() {
		template = restTemplateFactory.generateRestTemplate(url);
	}

	/**
	 * 
	 */
	@Override
	public Order saveOrUpdate(Order t) {
		throw new NotImplementedException();
	}

	/**
	 * 
	 */
	@Override
	public Order update(Order t) {
		throw new NotImplementedException();
	}

	/**
	 * 
	 */
	@Override
	public Order delete(Order t) {
		throw new NotImplementedException();
	}

	/**
	 * 
	 */
	@Override
	public List<Order> listAll(Order t) {
		throw new NotImplementedException();
	}

	/**
	 * 
	 */
	@Override
	public Order get(Order t) {
		throw new NotImplementedException();
	}

	/**
	 * 
	 */
	@Override
	public Order getByID(long id) {
		throw new NotImplementedException();
	}

	/**
	 * 
	 */
	@Override
	public RefundsResponse getRefundMethod(SnackResponse snackResponse) {
		init();

		Map<String, ResponseDTO> refundsMap = snackResponse.getSharedValue();
		
		RefundsRequest request = 
				RefundsRequest.builder()
							.sharedValue(refundsMap)
							.build();
		
		ResponseEntity<RefundsResponse> response =
				template.postForEntity(url+FrontendConstants.SUFIX_REFUNDS, request, RefundsResponse.class);
		
		return response.getBody();

	}

	/**
	 * 
	 */
	@Override
	public SnackResponse processOrder(Order order) {
		init();
		
		SnackRequest request = 
				SnackRequest.builder()
							.order(order)
							.build();
		
		ResponseEntity<SnackResponse> response =
				template.postForEntity(url+FrontendConstants.SUFIX_ORDER, request, SnackResponse.class);
		
		return response.getBody();

	}

}
