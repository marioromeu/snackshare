package br.com.itads.snackshare.controller.responses;

import java.io.Serializable;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
public class RefundsResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7802938266022110750L;
	
	/**
	 * 
	 */
	private Map<String, Object> qrCodeMap;
	
	/**
	 * 
	 */
	private Map<String, Object> barCodeMap;	
	
}
