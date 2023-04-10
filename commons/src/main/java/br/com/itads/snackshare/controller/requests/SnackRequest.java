package br.com.itads.snackshare.controller.requests;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

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
 *
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SnackRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6221044934852930472L;

	/**
	 * 
	 */
	@JsonProperty("order")
	private Order order;
	
}
