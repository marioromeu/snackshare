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
public class Address {

	/**
	 * 
	 */
	private String streetAdress;
	
	/**
	 * 
	 */
	private String neighborhood;
	
	/**
	 * 
	 */
	private String zipCode;
	
	/**
	 * 
	 */
	private String city;
	
	/**
	 * 
	 */
	private String state;  
	
}
