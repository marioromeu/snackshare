package br.com.itads.snackshare.gateway.boleto.dto;

import br.com.itads.snackshare.model.Owner;
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
public class BoletoDTO {

	private Owner owner;

	private Double valueByOwner;
	
}
