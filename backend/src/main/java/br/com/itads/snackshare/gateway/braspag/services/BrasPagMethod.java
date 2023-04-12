package br.com.itads.snackshare.gateway.braspag.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.itads.snackshare.dto.RefundsDTO;
import br.com.itads.snackshare.gateway.PaymentsMethod;
import br.com.itads.snackshare.gateway.braspag.dto.BrasPagRequestDTO;
import br.com.itads.snackshare.gateway.braspag.dto.BrasPagResponseDTO;
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
	public String generatePaymentsLink() {
		return url;
	}

	/**
	 * 
	 */
	public Object sendPaymentsOrder(RefundsDTO dto) {
		
		Customer customer = generateCustomer(dto);
		
		Payment payment = generatePayment(dto);
		
		BrasPagRequestDTO brasPagRequestDTO =
				BrasPagRequestDTO.builder()
					.merchantOrderId(UUID.randomUUID().toString())
					.customer(customer)
					.payment(payment)
					.build();
		
		ResponseEntity<BrasPagResponseDTO> response = 
				template.postForEntity(url, brasPagRequestDTO, BrasPagResponseDTO.class);
		
		return response;
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
