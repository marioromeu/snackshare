package br.com.itads.snackshare.model;

import java.io.Serializable;

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
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7770736863897861389L;

	/**
	 * 
	 */
	private String id;	
	
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
