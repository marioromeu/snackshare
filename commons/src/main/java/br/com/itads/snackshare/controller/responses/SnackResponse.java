package br.com.itads.snackshare.controller.responses;

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
public class SnackResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2263278166916576562L;

	/**
	 * 
	 */
	private Map<String, ResponseDTO> sharedValue;  	
	
}
