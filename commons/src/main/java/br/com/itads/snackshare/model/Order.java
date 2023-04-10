package br.com.itads.snackshare.model;

import java.util.List;

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
public class Order {

	/**
	 * 
	 */
	private List<Item> itemList;
		
}
