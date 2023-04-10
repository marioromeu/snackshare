package br.com.itads.snackshare.dto;

import br.com.itads.snackshare.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

	/**
	 * 
	 */
	private Order order;
	
}
