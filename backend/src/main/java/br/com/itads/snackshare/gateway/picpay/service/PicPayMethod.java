package br.com.itads.snackshare.gateway.picpay.service;

import org.springframework.beans.factory.annotation.Value;

import br.com.itads.snackshare.controller.responses.RefundsResponse;
import br.com.itads.snackshare.dto.RefundsDTO;
import br.com.itads.snackshare.gateway.PaymentsMethod;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 * https://picpay.github.io/picpay-docs-digital-payments/checkout/resources/api-reference/
 *
 */
//@Service
public class PicPayMethod extends PaymentsMethod {

	@Value("${snackshare.payments.picpay.url}")
	private String url;
	
	/**
	 * 
	 */
	@Override
	public String generatePaymentsLink(Double value) {
		//TODO colocar o valor do recebimento no formato do PicPay
		return url;
	}

	/**
	 * 
	 */
	@Override
	public RefundsResponse sendPaymentsOrder(RefundsDTO dto) {
		// TODO Auto-generated method stub
		return null;
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
