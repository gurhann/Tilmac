package com.kayra.tilmac.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.kayra.tilmac.dao.WordDAO;
import com.kayra.tilmac.enums.PersistenceManager;
import com.kayra.tilmac.model.Word;

public abstract class WordDAOImpl<T extends Word>extends BaseDAOImpl<T> implements WordDAO<T>{

	@Override
	public abstract List<T> findAll();

	@Override
	public abstract T findByText(String text);

}
