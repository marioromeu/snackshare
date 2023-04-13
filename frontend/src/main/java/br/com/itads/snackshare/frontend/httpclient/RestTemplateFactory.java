package br.com.itads.snackshare.frontend.httpclient;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@Service
public class RestTemplateFactory implements ConnectionFactoryInterface {

	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(RestTemplateFactory.class);

	/**
	 * Instância do Pool de HttpClient
	 */
	private PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();

	/**
	 * 
	 */
	public RestTemplate generateRestTemplate(String url) {

		HttpClient httpClient = generateHttpClient(url);

		/**
		 * 
		 */
		RestTemplate templateFromPool = new RestTemplateBuilder().rootUri(url)
				.messageConverters(
						new StringHttpMessageConverter(), 
						new MappingJackson2HttpMessageConverter(), 
						new ByteArrayHttpMessageConverter() //para o qrCode
				)
				.requestFactory(() -> new HttpComponentsClientHttpRequestFactory(httpClient))
				.build();

		return templateFromPool;
	}

	/**
	 * 
	 * @param url
	 * @return
	 */
	private HttpClient generateHttpClient(String url) {

		HttpClient httpClient = null;

		httpClient = HttpClientBuilder.create().setConnectionManager(connectionManager).build();

		return httpClient;

	}

}
