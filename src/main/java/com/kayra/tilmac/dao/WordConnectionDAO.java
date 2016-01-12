package com.kayra.tilmac.dao;

import com.kayra.tilmac.model.Word;
import com.kayra.tilmac.model.WordConnection;

public interface WordConnectionDAO  extends BaseDAO<WordConnection>{
	public WordConnection findByResourceWord(Word word);
}
