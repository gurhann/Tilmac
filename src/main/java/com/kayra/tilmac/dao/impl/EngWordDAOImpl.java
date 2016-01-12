package com.kayra.tilmac.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.kayra.tilmac.model.EngWord;
import com.kayra.tilmac.model.TrWord;

public class EngWordDAOImpl extends WordDAOImpl<EngWord>{

	@SuppressWarnings("unchecked")
	@Override
	public List<EngWord> findAll() {
		Query query = em.createNamedQuery(EngWord.FIND_ALL);
		return (List<EngWord>) query.getResultList();
	}

	@Override
	public EngWord findByText(String text) {
		Query query = em.createNamedQuery(EngWord.FIND_BY_TEXT);
		query.setParameter(EngWord.PARAM_ENG_TEXT, text);
		return (EngWord) query.getSingleResult();
	}
	
	@Override
	public void deleteAll() {
		Query query = em.createNamedQuery(EngWord.DELETE_ALL);
		tx.begin();
		query.executeUpdate();
		tx.commit();
	}
}
