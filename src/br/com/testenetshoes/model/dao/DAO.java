package br.com.testenetshoes.model.dao;

import java.util.List;

public interface DAO<T> {

	/**
	 * 
	 * @param object
	 */
	public void save(T object);

	/**
	 * 
	 * @param object
	 */
	public void update(T object);

	/**
	 * 
	 * @param object
	 */
	public void delete(T object);

	public List<T> list();

	/**
	 * 
	 * @param object
	 */
	public T find(Object object);

}