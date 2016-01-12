package com.kayra.tilmac.factory;

import com.kayra.tilmac.dao.WordConnectionDAO;
import com.kayra.tilmac.dao.impl.WordConnectionDAOImpl;

public class WordConnectionDAOFactory {
	private static WordConnectionDAOFactory instance;
	private static WordConnectionDAO wordConnectionDAO;
	
	private WordConnectionDAOFactory() {
		
	}
	
	public static WordConnectionDAOFactory getInstance() {
		if (instance == null) {
			instance = new WordConnectionDAOFactory();
		}
		return instance;
	}
	
	public WordConnectionDAO getWordConnectionDAO() {
		if (wordConnectionDAO == null) {
			wordConnectionDAO = new WordConnectionDAOImpl();
		}
		return wordConnectionDAO;
	}
}
