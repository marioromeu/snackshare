package br.com.itads.snackshare.gateway.braspag.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

	/**
	 * 
	 */
	private Address address;
	
	/**
	 * 
	 */
	private Address deliveryAddress;
	
	/**
	 * 
	 */
    private String name;
    
	/**
	 * 
	 */    
    private String identity;
    
	/**
	 * 
	 */    
    private String identityType;
    
	/**
	 * 
	 */    
    private String email;
    
	/**
	 * 
	 */    
    private Date birthdate;
    
	/**
	 * 
	 */    
    private String ipAddress;

}
