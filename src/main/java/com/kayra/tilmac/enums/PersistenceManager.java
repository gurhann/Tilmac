package com.kayra.tilmac.enums;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.engine.spi.PersistenceContext;
import org.hibernate.jpa.internal.EntityManagerImpl;
import org.hibernate.mapping.PersistentClass;

public enum PersistenceManager {
	INSTANCE;

	private EntityManagerFactory emf;
	private EntityManager em;

	private PersistenceManager() {
		emf = Persistence.createEntityManagerFactory("jpa-example");
	}

	public EntityManager getEntityManager() {
		if (em == null) {
			em = emf.createEntityManager();
		}
		return em;
	}

	public void close() {
		emf.close();
		if (em != null){
			em.close();
		}
	} 
}
