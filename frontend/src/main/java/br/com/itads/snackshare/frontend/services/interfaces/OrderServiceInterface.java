package br.com.itads.snackshare.frontend.services.interfaces;

import br.com.itads.snackshare.controller.responses.RefundsResponse;
import br.com.itads.snackshare.controller.responses.SnackResponse;
import br.com.itads.snackshare.frontend.services.GenericServiceInterface;
import br.com.itads.snackshare.model.Order;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public interface OrderServiceInterface extends GenericServiceInterface<Order> {
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public RefundsResponse getRefundMethod(SnackResponse snackResponse);

	/**
	 * 
	 * @param t
	 * @return
	 */
	public SnackResponse processOrder(Order order);	
	
}
