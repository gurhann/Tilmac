package com.kayra.tilmac.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.kayra.tilmac.dao.BaseDAO;
import com.kayra.tilmac.enums.PersistenceManager;

public abstract class BaseDAOImpl<T> implements BaseDAO<T> {

	protected EntityManager em;
	protected EntityTransaction tx;

	public BaseDAOImpl() {
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
	public void close() {
		PersistenceManager.INSTANCE.close();
	}

}
