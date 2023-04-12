package br.com.itads.snackshare.gateway.picpay.model;

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
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QRCode {

	/**
	 * 
	 */
	private String content;
	
	/**
	 * 
	 */
	private String base64;
	
}
