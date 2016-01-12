package com.kayra.tilmac.factory;

import com.kayra.tilmac.enums.Languages;
import com.kayra.tilmac.exceptions.NoSuchLangClassException;
import com.kayra.tilmac.model.Document;
import com.kayra.tilmac.model.EngWord;
import com.kayra.tilmac.model.TrWord;
import com.kayra.tilmac.model.Word;

public class DocumentFactory {
	private DocumentFactory instance;
	private DocumentFactory() {
		
	}
	
	public DocumentFactory getInstance() {
		if (instance == null) {
			instance = new DocumentFactory();
		}
		return instance;
	}
	
	public Document<?> getDocument(Languages docLanguage) throws NoSuchLangClassException {
		if (Languages.TR == docLanguage) {
			return new Document<TrWord>();
		} else if (Languages.ENG == docLanguage) {
			return new Document<EngWord>();
		} 
		throw new NoSuchLangClassException();
	}
}
