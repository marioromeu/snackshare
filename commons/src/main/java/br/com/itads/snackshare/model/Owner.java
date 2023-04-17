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
public class Owner {

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String document;	
	
	/**
	 * 
	 */
	private String email;

	
	/**
	 * 
	 */
	private Address homeAddress;	
	
	/**
	 * 
	 */
	private Object payMethod;
	
	/**
	 * 
	 */
	private Object refundsMethod;
	
}
