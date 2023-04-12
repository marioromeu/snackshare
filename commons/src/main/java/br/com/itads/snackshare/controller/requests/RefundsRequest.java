package br.com.itads.snackshare.controller.requests;

import java.io.Serializable;
import java.util.Map;

import br.com.itads.snackshare.dto.ResponseDTO;
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
public class RefundsRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3152936790936036036L;

	/**
	 * 
	 */
	private Map<String, ResponseDTO> sharedValue;  	
	
}
