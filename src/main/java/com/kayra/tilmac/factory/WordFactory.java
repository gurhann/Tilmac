package com.kayra.tilmac.factory;

import com.kayra.tilmac.enums.Languages;
import com.kayra.tilmac.exceptions.NoSuchWordClassException;
import com.kayra.tilmac.model.EngWord;
import com.kayra.tilmac.model.TrWord;
import com.kayra.tilmac.model.Word;

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
	
	public Word getWord(Languages lang) throws NoSuchWordClassException {
		if (lang == Languages.TR) {
			return new TrWord();
		} else if (lang == Languages.ENG) {
			return new EngWord();
		}else {
			throw new NoSuchWordClassException();
		}
	}
}
