package br.com.itads.snackshare.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.itads.snackshare.controller.responses.RefundsResponse;
import br.com.itads.snackshare.dto.RefundsDTO;
import br.com.itads.snackshare.gateway.PaymentsMethod;

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
	 */
	@Autowired
	private PaymentsMethod method;
	
	/**
	 * 
	 * @param method
	 * @return
	 */
	public RefundsResponse generateRefundLink(RefundsDTO dto) {

		return method.sendPaymentsOrder(dto);

	}
	
}
