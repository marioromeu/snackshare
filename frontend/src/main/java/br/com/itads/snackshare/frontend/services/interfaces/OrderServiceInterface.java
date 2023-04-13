package br.com.itads.snackshare.frontend.services.interfaces;

import br.com.itads.snackshare.frontend.services.GenericServiceInterface;
import br.com.itads.snackshare.model.Order;

/**
 * 
 * @author mario.s.junior
 *
 */
public interface OrderServiceInterface extends GenericServiceInterface<Order> {
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public Order newOrder(Order order);

	/**
	 * 
	 * @param t
	 * @return
	 */
	public Order processOrder(Order order);	
	
}
