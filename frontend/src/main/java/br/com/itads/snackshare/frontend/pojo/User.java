package br.com.itads.snackshare.frontend.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1l;

	/**
	 * 
	 */
	@JsonProperty("username")
	private String username;
	
	/**
	 * 
	 */
	@JsonProperty("password")
	private String password;

}
