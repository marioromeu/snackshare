package br.com.itads.snackshare.frontend.services;

import java.util.List;

/**
 * 
 * @author mario.s.junior
 *
 * @param <T>
 */
public interface GenericServiceInterface<T> {

	/**
	 * 
	 * @param T
	 */
	public T saveOrUpdate(T t);

	/**
	 * 
	 * @param T
	 */
	public T update(T t);

	/**
	 * 
	 * @param T
	 */
	public T delete(T t);

	/**
	 * 
	 * @param T
	 */
	public List<T> listAll(T t);

	/**
	 * 
	 * @param T
	 */
	public T get(T t);

	/**
	 * 
	 * @param T
	 */
	public T getByID(long id);

}
