package br.com.testenetshoes.model.service;

import java.util.List;

import br.com.testenetshoes.model.dao.EnderecoDAO;
import br.com.testenetshoes.model.entity.Endereco;



public class EnderecoService extends AbstractService{

	public void save(Endereco endereco) throws Exception{
		try{
			open();
			begin();
			EnderecoDAO eDAO = new EnderecoDAO(em);
			eDAO.save(endereco);
			commit();
		}catch(Exception e){
			//rollBack();
			e.printStackTrace();
			throw e;
		}finally{
			//close();
		}
	}
	
	public void update(Endereco endereco) throws Exception{
		try{
			open();
			begin();
			EnderecoDAO eDAO = new EnderecoDAO(em);
			eDAO.update(endereco);
			commit();
		}catch(Exception e){
			rollBack();
			throw e;
		}finally{
			close();
		}
	}
	
	public void delete(Integer id) throws Exception{
		try{
			open();
			EnderecoDAO eDAO = new EnderecoDAO(em);
			Endereco endereco = eDAO.findById(id);
			begin();
			eDAO.delete(endereco);
			commit();
		}catch(Exception e){
			rollBack();
			throw e;
		}finally{
			close();
		}
	}
	
	public List<Endereco> listAll() throws Exception{
		
		List<Endereco> listaEndereco = null;
		
		try{
			open();
			EnderecoDAO eDAO = new EnderecoDAO(em);
			listaEndereco = eDAO.list();
		}catch(Exception e){
			throw e;
		}finally{
			close();
		}
		
		return listaEndereco;
	}
	
	public Endereco find(Endereco endereco) throws Exception{
		Endereco end = null;
		try{
			open();
			EnderecoDAO eDAO = new EnderecoDAO(em);
			end = eDAO.find(endereco);
		}catch(Exception e){
			throw e;
		}finally{
			close();
		}
		
		return end;
	}
	
	public Endereco findById(Integer id) throws Exception{
		Endereco end = null;
		try{
			open();
			EnderecoDAO eDAO = new EnderecoDAO(em);
			end = eDAO.findById(id);
		}catch(Exception e){
			throw e;
		}finally{
			close();
		}
		
		return end;
	}
}
