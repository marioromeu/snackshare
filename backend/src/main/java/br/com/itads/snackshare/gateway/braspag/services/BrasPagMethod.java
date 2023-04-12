package br.com.itads.snackshare.gateway.braspag.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.itads.snackshare.controller.responses.RefundsResponse;
import br.com.itads.snackshare.dto.RefundsDTO;
import br.com.itads.snackshare.gateway.PaymentsMethod;
import br.com.itads.snackshare.gateway.braspag.dto.BrasPagRequestDTO;
import br.com.itads.snackshare.gateway.braspag.model.Customer;
import br.com.itads.snackshare.gateway.braspag.model.Payment;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 * https://braspag.github.io//en/manual/braspag-pagador
 *
 */
@Service
public class BrasPagMethod extends PaymentsMethod {

	@Value("${snackshare.payments.braspag.url.service}")
	private String url;	

	/**
	 * 
	 */
	public BrasPagMethod() {
		init(url);
	}
	
	/**
	 * 
	 */
	@Override
	public String generatePaymentsLink(Double value) {
		//TODO colocar o valor do recebimento no formato do BrasPag
		return url;
	}

	/**
	 * 
	 */
	public RefundsResponse sendPaymentsOrder(RefundsDTO dto) {
		
		Customer customer = generateCustomer(dto);
		
		Payment payment = generatePayment(dto);
		
		BrasPagRequestDTO brasPagRequestDTO =
				BrasPagRequestDTO.builder()
					.merchantOrderId(UUID.randomUUID().toString())
					.customer(customer)
					.payment(payment)
					.build();
		
		ResponseEntity<RefundsResponse> response = 
				template.postForEntity(url, brasPagRequestDTO, RefundsResponse.class);
		
		return response.getBody();
	}

	/**
	 * 
	 * @return
	 */
	private Customer generateCustomer(RefundsDTO dto) {
		Customer customer = 
				Customer.builder()
						.address(null)
						.birthdate(null)
						.deliveryAddress(null)
						.email(url)
						.identity(url)
						.identityType(url)
						.ipAddress(url)
						.name(url)
						.build();

		return customer;
	}

	/**
	 * 
	 * @return
	 */
	private Payment generatePayment(RefundsDTO dto) {
		Payment payment = Payment.builder().build();
		return payment;
	}
	
	/**
	 * 
	 */
	public Object authenticate(Object dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
