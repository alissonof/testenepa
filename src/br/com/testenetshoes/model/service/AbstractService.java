package br.com.testenetshoes.model.service;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import br.com.testenetshoes.controller.utils.JPAUtil;


public abstract class AbstractService {

	protected EntityManager em;

	/**
	 * Abre a conexão para os demais métodos e instância o objeto DAO.<br><br>
	 */
	public void open() {
		em = JPAUtil.getEntityManager();
		
		//conn = new ConnectionFactory().getConnection();
	}

	/**
	 * Método utilitário que fecha a conexão com o banco de dados.<br><br>
	 * @throws SQLException 
	 */
	public void close() throws SQLException {
		try {
			if(em.isOpen()){	    
				em.close();
			}
		} catch(Exception e) {
			throw new SQLException("Não foi possível fechar a conexão.");
		}
	}

	
	/**
	 * Inicia a transação.
	 * @throws SQLException 
	 * 
	 */
	public void begin() throws SQLException {
		try {
			em.getTransaction().begin();
		} catch (Exception e) {
			throw new SQLException("Falha ao Iniciar a transação.");
		}
	}
	
	/**
	 * Método responsável por efetuar o flush dos dados.
	 * @throws SQLException 
	 * 
	 */
	public void flush() throws SQLException{
		try{
			em.flush();
			em.clear();
		}catch(Exception e){
			throw new SQLException("Falha ao efetuar o flush na transação.");
		}
		
	}
	
	/**
	 * Efetua o commit na transação.
	 * 
	 * @throws SQLException 
	 */
	public void commit() throws SQLException {
		try {
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new SQLException("Falha ao efetuar o commit na transação.");
		}
	}
	
	
	/**
	 * Desfaz as alterações realizadas no banco de dados.
	 * @throws ResseguroException 
	 * 
	 */
	public void rollBack() throws SQLException {
		try {
			em.getTransaction().rollback();
		} catch (Exception e) {
			throw new SQLException("Falha ao desfazer a operação.");
		}
	}
	
	
	
}
