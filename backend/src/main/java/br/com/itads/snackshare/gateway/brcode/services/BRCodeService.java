package br.com.itads.snackshare.gateway.brcode.services;

import org.springframework.beans.factory.annotation.Value;

import br.com.itads.snackshare.dto.RefundsDTO;
import br.com.itads.snackshare.gateway.PaymentsMethod;
import br.com.itads.snackshare.gateway.brcode.dto.BRCodeResponseDTO;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public class BRCodeService extends PaymentsMethod {

	/**
	 * 
	 */
	private String name = "Mário Romeu";
	
	/**
	 * 
	 */
	private String city = "Salvador";
	
	/**
	 * 
	 */
	private String pixKey = "02525440560";

	/**
	 * 
	 */
	@Value("${snackshare.payments.brcode.url.service}")
	private String url;	
	
	/**
	 * 
	 */
	public BRCodeService() {
		init(url);
	}
	
	/**
	 * 
	 */
	@Override
	public String generatePaymentsLink() {		
		return url+"?nome="+name+"&cidade="+city+"&saida=qr&chave="+pixKey;
	}

	/**
	 * 
	 */
	@Override
	public Object sendPaymentsOrder(RefundsDTO dto) {

		String urlToQrCode = generatePaymentsLink();
		
		return template.postForEntity(urlToQrCode, null, BRCodeResponseDTO.class);
	}

	/**
	 * 
	 */
	@Override
	public Object authenticate(Object dto) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
