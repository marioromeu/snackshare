package br.com.itads.snackshare.dto;

import java.util.List;

import br.com.itads.snackshare.model.Item;
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
public class ResponseDTO {
	
	/**
	 * 
	 */
	private List<Item> itensList;	
	
	/**
	 * 
	 */
	private Double sharedValueByOwner;
	
}
