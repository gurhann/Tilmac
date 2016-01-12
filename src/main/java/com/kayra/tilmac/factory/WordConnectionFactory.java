package com.kayra.tilmac.factory;

import com.kayra.tilmac.model.WordConnection;

public class WordConnectionFactory {
	private static WordConnectionFactory instance;

	private WordConnectionFactory() {

	}

	public static WordConnectionFactory getInstance() {
		if (instance == null) {
			instance = new WordConnectionFactory();
		}

		return instance;
	}

	public WordConnection getWordConnection() {
		return new WordConnection();
	}
}
