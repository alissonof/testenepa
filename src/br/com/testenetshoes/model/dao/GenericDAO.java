package br.com.testenetshoes.model.dao;


import javax.persistence.EntityManager;


public abstract class GenericDAO<T> implements DAO<T> {

	private EntityManager em;

	/**
	 * 
	 * @param em
	 */
	public GenericDAO(EntityManager em){
		this.em = em;
	}
	
	public EntityManager getEntityManager(){
		return em;
	}

}