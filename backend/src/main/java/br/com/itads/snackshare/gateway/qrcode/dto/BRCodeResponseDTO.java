package br.com.itads.snackshare.gateway.brcode.dto;

import lombok.Builder;
import lombok.Getter;
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
public class BRCodeResponseDTO {

	/**
	 * 
	 */
	private Object qrCode; 
	
}
