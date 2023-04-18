package br.com.itads.snackshare.services.interfaces;

import br.com.itads.snackshare.controller.responses.SnackResponse;
import br.com.itads.snackshare.dto.OrderDTO;
import br.com.itads.snackshare.exception.EmptyOrderException;

/**
 * 
 * @author marioromeu
 * @email  mario.romeu@gmail.com
 *
 */
public interface OrderServiceInterface {

	/**
	 * 
	 * @param dto
	 * @return
	 */
	public SnackResponse calculateSharedValueByOwner(OrderDTO dto) throws EmptyOrderException;
	
}
