package br.com.itads.snackshare.frontend.httpclient;

import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public interface ConnectionFactoryInterface {

	/**
	 * 
	 * @param url
	 * @return
	 */
	public RestTemplate generateRestTemplate(String url);

}