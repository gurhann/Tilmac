package com.kayra.tilmac;

import org.junit.Assert;
import org.junit.Test;

import com.kayra.tilmac.dao.WordDAO;
import com.kayra.tilmac.enums.Languages;
import com.kayra.tilmac.exceptions.NoSuchDaoException;
import com.kayra.tilmac.factory.WordFactory;

public class WordTest  {

	private static WordFactory wf;

	@Test
	public void TrWordsMustReturnNull() {
		WordDAO dao;
		try {
			dao = WordFactory.getInstance().getWordDAO(Languages.TR);
			Assert.assertEquals(0, dao.findAll().size());
		} catch (NoSuchDaoException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void EngWordsMustReturn() {
		WordDAO dao;
		try {
			dao = WordFactory.getInstance().getWordDAO(Languages.ENG);
			Assert.assertEquals(0, dao.findAll().size());
		} catch (NoSuchDaoException e) {
			Assert.fail(e.getMessage());
		}
	}

	public void addedWordsMustReturnCollectValue() {

	}
}
