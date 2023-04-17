package br.com.itads.snackshare.services.impl;

import org.springframework.stereotype.Service;

import br.com.itads.snackshare.model.Address;
import br.com.itads.snackshare.model.Owner;
import br.com.itads.snackshare.services.interfaces.UserServiceInterface;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@Service
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
				.city("Salvador")
				.neighborhood("Bomfim")
				.state("BA")
				.streetAdress("Avenida Beira Mar")
				.zipCode("30320230")
				.build();
		
		Owner ownerMock = 
				Owner.builder()
					 .name(key)
					 .document("111.222.333-12")
					 .email(key)
					 .homeAddress(home)
				.build();
		
		return ownerMock;
	}

}
