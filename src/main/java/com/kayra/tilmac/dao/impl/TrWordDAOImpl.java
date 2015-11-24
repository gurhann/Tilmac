package com.kayra.tilmac.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.omg.CORBA.TRANSACTION_MODE;

import com.kayra.tilmac.model.TrWord;

public class TrWordDAOImpl extends WordDAOImpl<TrWord>{

	@SuppressWarnings("unchecked")
	@Override
	public List<TrWord> findAll() {
		Query query = em.createNamedQuery(TrWord.FIND_ALL);
		return (List<TrWord>)query.getResultList();
	}

	@Override
	public TrWord findByText(String text) {
		Query query = em.createNamedQuery(TrWord.FIND_BY_TEXT);
		query.setParameter(TrWord.PARAM_TR_TEXT, text);
		return (TrWord) query.getSingleResult();
	}

}
