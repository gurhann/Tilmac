package com.kayra.tilmac.dao;

import com.kayra.tilmac.model.Word;

public interface WordDAO<T extends Word> extends BaseDAO<T> {
	public T findByText(String text);
}
