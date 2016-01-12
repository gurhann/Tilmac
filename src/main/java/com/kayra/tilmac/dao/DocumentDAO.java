package com.kayra.tilmac.dao;

import com.kayra.tilmac.model.Document;
import com.kayra.tilmac.model.Word;

public interface DocumentDAO extends BaseDAO<Document<Word>>{
	public Document<Word> findByName(String documentName);
}
