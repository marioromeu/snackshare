package br.com.itads.snackshare.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import br.com.itads.snackshare.controller.responses.RefundsResponse;
import br.com.itads.snackshare.dto.RefundsDTO;
import br.com.itads.snackshare.pool.RestTemplateFactory;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public abstract class PaymentsMethod {

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
	public void init(String url) {
		template = restTemplateFactory.generateRestTemplate(url);
	}	
	
	/**
	 * 
	 * @return
	 */
	public abstract String generatePaymentsLink(Double value);

	/**
	 * 
	 * @return
	 */
	public abstract RefundsResponse sendPaymentsOrder (RefundsDTO dto);

	/**
	 * 
	 * @return
	 */
	public abstract Object authenticate (Object dto);	
	
}
