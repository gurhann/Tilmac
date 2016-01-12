package com.kayra.tilmac.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.kayra.tilmac.dao.WordConnectionDAO;
import com.kayra.tilmac.enums.PersistenceManager;
import com.kayra.tilmac.model.EngWord;
import com.kayra.tilmac.model.Word;
import com.kayra.tilmac.model.WordConnection;

public class WordConnectionDAOImpl extends BaseDAOImpl<WordConnection> implements WordConnectionDAO {

	@Override
	public List<WordConnection> findAll() {
		Query query = em.createNamedQuery(WordConnection.FIND_ALL);
		return query.getResultList();
	}

	@Override
	public WordConnection findByResourceWord(Word word) {
		Query query = em.createNamedQuery(WordConnection.FIND_BY_RESOURCE_WORD);
		query.setParameter("word", word);
		return (WordConnection) query.getSingleResult();
	}
	
	@Override
	public void deleteAll() {
		Query query = em.createNamedQuery(EngWord.DELETE_ALL);
		tx.begin();
		query.executeUpdate();
		tx.commit();
		
	}

}