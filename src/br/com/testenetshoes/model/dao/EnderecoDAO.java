package br.com.testenetshoes.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.testenetshoes.model.entity.Endereco;


public class EnderecoDAO extends GenericDAO<Endereco>{

	public EnderecoDAO(EntityManager em) {
		super(em);
	}

	@Override
	public void save(Endereco object) {
		EntityManager em = getEntityManager();
		em.persist(object);
	}

	@Override
	public void update(Endereco object) {
		EntityManager em = getEntityManager();
		em.merge(object);
	}

	@Override
	public void delete(Endereco object) {
		EntityManager em = getEntityManager();
		em.remove(object);
	}

	@Override
	public List<Endereco> list() {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Endereco> cq = cb.createQuery(Endereco.class);
		cq.select(cq.from(Endereco.class));
		return em.createQuery(cq).getResultList();	
	}

	@Override
	public Endereco find(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Endereco findById(Integer id) {
		EntityManager em = getEntityManager();
		return em.find(Endereco.class, id);
	}

}
