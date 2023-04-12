package br.com.itads.snackshare.gateway.braspag.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.itads.snackshare.gateway.braspag.model.Customer;
import br.com.itads.snackshare.gateway.braspag.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author marioromeu
 * @email  mario.romeu@gmail.com
 * 
 
	{ 
	   "MerchantOrderId":"2020102601",
	   "Customer":{
	      "Name":"Nome do Pagador",
	      "Identity":"12345678909",
	      "IdentityType":"CPF"
	   },
	   "Payment":{ 
	      "Type":"Pix",
	      "Provider":"Bradesco2",
	      "Amount":100,
	      "QrCodeExpiration":36000
	   }    
	}
 
 *
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrasPagRequestDTO {

	/**
	 * 
	 */
	private String merchantOrderId;

	/**
	 * 
	 */
	private Customer customer;
	
	/**
	 * 
	 */
	private Payment payment;
	
	
}
