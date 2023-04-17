package br.com.itads.snackshare.services.impl;

import br.com.itads.snackshare.model.Address;
import br.com.itads.snackshare.model.Owner;
import br.com.itads.snackshare.services.interfaces.UserServiceInterface;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public class UserService implements UserServiceInterface {

	/**
	 * 
	 */
	@Override
	public Owner getOwnerByKey(String key) {
		
		/**
		 * TODO em fases futuras criar um modelo de dados
		 * para cadastro dos usuários.
		 * 
		 * Para o cenário do desafio técnico isto deve
		 * ser desconsierado
		 */
		
		Address home = Address.builder()
				.city(key)
				.neighborhood(key)
				.state(key)
				.streetAdress(key)
				.zipCode(key)
				.build();
		
		Owner ownerMock = 
				Owner.builder()
					 .name(key)
					 .document(key)
					 .email(key)
					 .homeAddress(home)
				.build();
		
		return ownerMock;
	}

}
