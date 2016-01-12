package com.kayra.tilmac.factory;

import com.kayra.tilmac.dao.WordDAO;
import com.kayra.tilmac.dao.impl.EngWordDAOImpl;
import com.kayra.tilmac.dao.impl.TrWordDAOImpl;
import com.kayra.tilmac.enums.Languages;
import com.kayra.tilmac.exceptions.NoSuchDaoException;
import com.kayra.tilmac.model.EngWord;
import com.kayra.tilmac.model.TrWord;
import com.kayra.tilmac.model.Word;

public class WordDAOFactory {

	private static WordDAOFactory instance;
	private static WordDAO<TrWord> trWordDao;
	private static WordDAO<EngWord> engWordDao;

	private WordDAOFactory() {
	}

	public static WordDAOFactory getInstance() {
		if (instance == null) {
			instance = new WordDAOFactory();
		}
		return instance;
	}

	@SuppressWarnings("rawtypes")
	public WordDAO getWordDAO(Languages lang) throws NoSuchDaoException {
		if (Languages.ENG == lang) {
			if (engWordDao == null) {
				engWordDao = new EngWordDAOImpl();
			}
			return engWordDao;
		} else if (Languages.TR == lang) {
			if (trWordDao == null) {
				trWordDao = new TrWordDAOImpl();
			}
			return trWordDao;
		} else {
			throw new NoSuchDaoException();
		}
	}
}
