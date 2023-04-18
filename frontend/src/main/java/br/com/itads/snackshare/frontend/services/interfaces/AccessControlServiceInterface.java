package br.com.itads.snackshare.frontend.services.interfaces;

import br.com.itads.snackshare.frontend.pojo.User;
import br.com.itads.snackshare.frontend.services.GenericServiceInterface;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public interface AccessControlServiceInterface extends GenericServiceInterface<User> {
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public User login(User user);

	/**
	 * 
	 * @param t
	 * @return
	 */
	public void logoff(User user);	
	
}
