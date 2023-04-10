package br.com.itads.snackshare.services.impl;

import br.com.itads.snackshare.services.interfaces.PaymentsMethod;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
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
