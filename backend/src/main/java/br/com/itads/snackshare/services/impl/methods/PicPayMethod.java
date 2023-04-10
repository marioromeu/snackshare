package br.com.itads.snackshare.services.impl.methods;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.itads.snackshare.services.interfaces.PaymentsMethod;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@Service
public class PicPayMethod implements PaymentsMethod {

	@Value("${snackshare.payments.url.picpay}")
	private String url;
	
	/**
	 * 
	 */
	public String generatePaymentsLink() {
		return url;
	}

}
