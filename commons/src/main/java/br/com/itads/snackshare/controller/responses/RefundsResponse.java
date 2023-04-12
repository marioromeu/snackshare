package br.com.itads.snackshare.controller.responses;

import java.io.Serializable;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@Getter
@Setter
@Builder
public class RefundsResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7802938266022110750L;
	
	/**
	 * 
	 */
	private Map<String, Object> qrCodeMap;  	
	
}
