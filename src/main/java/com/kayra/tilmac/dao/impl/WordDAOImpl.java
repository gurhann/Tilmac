package com.kayra.tilmac.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.kayra.tilmac.dao.WordDAO;
import com.kayra.tilmac.enums.PersistenceManager;
import com.kayra.tilmac.model.Word;

public abstract class WordDAOImpl<T extends Word> implements WordDAO<T>{

	protected EntityManager em;
	protected EntityTransaction tx;
	
	 public WordDAOImpl() {
		 em = PersistenceManager.INSTANCE.getEntityManager();
		 tx = em.getTransaction();
	 }
	
	@Override
	public void create(T t) {
		tx.begin();
		em.persist(t);
		tx.commit();
	}
	
	@Override
	public void delete(T t) {
		tx.begin();
		em.remove(t);
		tx.commit();
	}
	
	@Override
	public abstract List<T> findAll();

	@Override
	public abstract T findByText(String text);

}
