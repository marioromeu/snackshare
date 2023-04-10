package br.com.itads.snackshare.model;

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
public class Item {

	/**
	 * 
	 */
	private String name;
	
	/**
	 * 
	 */
	private Double value;
	
	/**
	 * 
	 */
	private String ownerEmail;
	
	/**
	 * 
	 */
	private Integer signal;
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		
		StringBuffer sbf = new StringBuffer();
		
		sbf.append("  |");		
		sbf.append(this.name);
		sbf.append(" : ");
		sbf.append(this.value);		
		sbf.append("|  ");
		
		return sbf.toString();
	}
	
}
