package br.com.itads.snackshare.gateway.picpay.dto;

import org.springframework.beans.factory.annotation.Value;

import br.com.itads.snackshare.gateway.picpay.model.Notification;
import br.com.itads.snackshare.model.Owner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author marioromeu
 * @email  mario.romeu@gmail.com
 
   {
	  "referenceId": "102030",
	  "callbackUrl": "http://www.sualoja.com.br/callback",
	  "returnUrl": "http://www.sualoja.com.br/cliente/pedido/102030",
	  "value": 20.51,
	  "expiresAt": "2022-05-01T16:00:00-03:00",
	  "channel": "my-channel",
	  "purchaseMode": "in-store",
	  "buyer": {
	    "firstName": "João",
	    "lastName": "Da Silva",
	    "document": "123.456.789-10",
	    "email": "teste@picpay.com",
	    "phone": "+55 27 12345-6789"
	  },
	  "notification": {
	    "disablePush": true,
	    "disableEmail": true
	  },
	  "softDescriptor": "description"
	}

 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PicPayRequestDTO {

	/**
	 * 
	 */
	@Value("${snackshare.payments.picpay.x-picpay-token}")
	private String xPicpayToken;
	
	/**
	 * 
	 */
	@Value("${snackshare.payments.picpay.x-seller-token}")
	private String xSellerToken;
		
	/**
	 * 
	 */
	private String referenceId;
	
	/**
	 * 
	 */
	private String callbackUrl;
	
	/**
	 * 
	 */
	private String returnUrl;
	
	/**
	 * 
	 */
	private String value;
	
	/**
	 * 
	 */
	private String expiresAt;
	
	/**
	 * 
	 */
	private String channel;
	
	/**
	 * 
	 */
	private String purchaseMode;
	
	/**
	 * 
	 */
	private Owner buyer;
	
	/**
	 * 
	 */
	private Notification notification;
	
	/**
	 * 
	 */
	private String softDescriptor;
	
}
