package br.com.itads.snackshare.frontend.pojo;

import br.com.itads.snackshare.controller.responses.RefundsResponse;
import br.com.itads.snackshare.controller.responses.SnackResponse;
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
public class FrontendDTO {

	/**
	 * 
	 */
	private SnackResponse snackResponse;
	
	/**
	 * 
	 */
	private RefundsResponse refundsResponse;
	
}
