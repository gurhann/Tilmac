package com.kayra.tilmac.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.kayra.tilmac.dao.DocumentDAO;
import com.kayra.tilmac.model.Document;
import com.kayra.tilmac.model.Word;

public class DocumentDAOImpl extends BaseDAOImpl<Document<Word>> implements DocumentDAO{


	@Override
	public void deleteAll() {
		Query query = em.createNamedQuery(Document.DELETE_ALL);
		tx.begin();
		query.executeUpdate();
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Document<Word>> findAll() {
		Query query = em.createNamedQuery(Document.FIND_BY_NAME);
		return query.getResultList();
	}

	@Override
	public Document<Word> findByName(String documentName) {
		Query query = em.createNamedQuery(Document.FIND_BY_NAME);
		query.setParameter(Document.PARAM_DOC_NAME, documentName);
		return (Document<Word>) query.getResultList();
	}

}
