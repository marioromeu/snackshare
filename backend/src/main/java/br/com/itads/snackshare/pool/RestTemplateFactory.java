package br.com.itads.snackshare.pool;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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
	 * 
	 */
	@Value("${snackshare.payments.brcode.security.ssl-certificate-full-path-and-name}")
	String sslCertificate;

	/**
	 * Instância do Pool de HttpClient
	 */
	private PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();

	/**
	 * 
	 * @param event
	 * @return
	 */
	public RestTemplate generateRestTemplate(String url) {

		HttpClient httpClient = generateHttpClient(url);

		/**
		 * Novo restTemplate para o pool
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
	 * @param event
	 * @return
	 */
	private HttpClient generateHttpClient(String url) {

		HttpClient httpClient = null;

		try {
			httpClient = createHttpClient();
		} catch (Exception e) {
			httpClient = HttpClientBuilder.create().setConnectionManager(connectionManager).build();
			e.printStackTrace();
		}

		return httpClient;

	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	private HttpClient createHttpClient() throws Exception {
		return (HttpClient) HttpClientBuilder.create()
				.setSSLSocketFactory((LayeredConnectionSocketFactory) sslConnectionSocketFactory()).build();
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	private SSLConnectionSocketFactory sslConnectionSocketFactory() throws Exception {
		return new SSLConnectionSocketFactory(createSSLContext(), (HostnameVerifier) NoopHostnameVerifier.INSTANCE);
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	private SSLContext createSSLContext() throws Exception {

		KeyStore trustKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		trustKeyStore.load(null);// Make an empty store

		File f = new File(sslCertificate);
		System.out.println(f.list());
		InputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);

		CertificateFactory cf = CertificateFactory.getInstance("X.509");

		while (bis.available() > 0) {
			Certificate cert = cf.generateCertificate(bis);
			trustKeyStore.setCertificateEntry("snackshare" + bis.available(), cert);
			log.debug("CERTIFICATE [" + cert + "]");
		}

		return SSLContextBuilder.create().loadTrustMaterial(trustKeyStore, new TrustSelfSignedStrategy()).build();
	}

}
