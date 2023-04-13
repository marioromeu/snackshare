package br.com.itads.snackshare.frontend.controller.impl;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public abstract class GenericController {

	/**
	 * 
	 */
	private String errorMessage;

	/**
	 * 
	 */
	public GenericController() {
	}

	/**
	 * 
	 * @return
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * 
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
