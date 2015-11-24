package com.kayra.tilmac.factory;

import com.kayra.tilmac.dao.WordDAO;
import com.kayra.tilmac.dao.impl.EngWordDAOImpl;
import com.kayra.tilmac.dao.impl.TrWordDAOImpl;
import com.kayra.tilmac.dao.impl.WordDAOImpl;
import com.kayra.tilmac.enums.Languages;
import com.kayra.tilmac.exceptions.NoSuchDaoException;

public class WordFactory {
	
	private static WordFactory instance;
	private WordFactory() {
	}
	public static WordFactory getInstance() {
		if (instance == null) {
			instance = new WordFactory();
		}
		return instance;
	}
	public WordDAO getWordDAO(Languages lang) throws NoSuchDaoException {
		if (Languages.ENG == lang) {
			return new EngWordDAOImpl();
		} else if (Languages.TR == lang) {
			return new TrWordDAOImpl();
		}else {
			throw new NoSuchDaoException();
		}
		
	}
}
