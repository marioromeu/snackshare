package br.com.itads.snackshare.frontend.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.itads.snackshare.frontend.pojo.User;
import br.com.itads.snackshare.frontend.services.interfaces.AccessControlServiceInterface;

/**
 * 
 * @author mario.s.junior
 *
 */
@Service
public class AccessControlServiceImpl implements AccessControlServiceInterface {

	/**
	 * 
	 */
	@Override
	public User saveOrUpdate(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public User delete(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public List<User> listAll(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public User get(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public User getByID(long id) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}

}
