package br.com.itads.snackshare.services.interfaces;

import br.com.itads.snackshare.model.Owner;

/**
 * 
 * @author marioromeu
 * @email  mario.romeu@gmail.com
 *
 */
public interface UserServiceInterface {

	/**
	 * 
	 * @return
	 */
	public Owner getOwnerByKey(String key);
	
}
