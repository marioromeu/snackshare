package br.com.itads.snackshare.frontend.services.impl;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import br.com.itads.snackshare.frontend.pojo.User;
import br.com.itads.snackshare.frontend.services.interfaces.AccessControlServiceInterface;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@Service
public class AccessControlServiceImpl implements AccessControlServiceInterface {

	/**
	 * 
	 */
	@Override
	public User saveOrUpdate(User t) {
		throw new NotImplementedException();
	}

	/**
	 * 
	 */
	@Override
	public User update(User t) {
		throw new NotImplementedException();
	}

	/**
	 * 
	 */
	@Override
	public User delete(User t) {
		throw new NotImplementedException();
	}

	/**
	 * 
	 */
	@Override
	public List<User> listAll(User t) {
		throw new NotImplementedException();
	}

	/**
	 * 
	 */
	@Override
	public User get(User t) {
		throw new NotImplementedException();
	}

	/**
	 * 
	 */
	@Override
	public User getByID(long id) {
		throw new NotImplementedException();
	}

	/**
	 * 
	 */
	@Override
	public User login(User user) {
		
		if (user.getUsername() != null && user.getUsername().equals("username")) {
			if (user.getPassword() != null && user.getPassword().equals("password")) {
				User loggedUser = new User();
				loggedUser.setUsername("username");
				loggedUser.setPassword(null);
				return loggedUser;
			}	
		} else {
			System.out.println("User not found");
		}
		
		return null;
		
	}

	/**
	 * 
	 */
	@Override
	public void logoff(User user) {
		throw new NotImplementedException();		
	}

}
