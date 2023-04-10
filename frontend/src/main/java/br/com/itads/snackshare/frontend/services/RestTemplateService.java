package br.com.itads.snackshare.frontend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.itads.snackshare.controller.responses.SnackResponse;
import br.com.itads.snackshare.model.Order;

/**
 * 
 * @author marioromeu
 * @email  mario.romeu@gmail.com
 *
 */
@Service
public class RestTemplateService {

	/**
	 * 
	 */
	@Value("${snackshare.backend.url}")
	private String backendsEndpoint;
	
	/**
	 * 
	 */
	private RestTemplate restTemplate;
	
	/**
	 * 
	 * @param order
	 */
	public void sendOrder(Order order) {
		
		restTemplate = buildRestTemplate();
		
		restTemplate.postForEntity(backendsEndpoint, order, SnackResponse.class);
		
	}
	
	/**
	 * 
	 * @return
	 */
	private RestTemplate buildRestTemplate() {
		
		RestTemplate restTemplate = new RestTemplateBuilder()
				.rootUri(backendsEndpoint)				
				.messageConverters(new StringHttpMessageConverter(), new MappingJackson2HttpMessageConverter())
				.requestFactory(() -> new HttpComponentsClientHttpRequestFactory())
				.build();
		
		return restTemplate;
		
	}
	
}
