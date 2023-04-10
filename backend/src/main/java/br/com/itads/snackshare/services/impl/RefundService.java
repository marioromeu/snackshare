package br.com.itads.snackshare.services.impl;

import org.springframework.stereotype.Service;

import br.com.itads.snackshare.services.interfaces.PaymentsMethod;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@Service
public class RefundService {

	/**
	 * 
	 * @param method
	 * @return
	 */
	public String generateRefundLink(PaymentsMethod method) {
		return method.generatePaymentsLink();
	}
	
}
