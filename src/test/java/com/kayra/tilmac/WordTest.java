package com.kayra.tilmac;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.kayra.tilmac.dao.WordConnectionDAO;
import com.kayra.tilmac.dao.WordDAO;
import com.kayra.tilmac.dao.impl.TrWordDAOImpl;
import com.kayra.tilmac.dao.impl.WordDAOImpl;
import com.kayra.tilmac.enums.Languages;
import com.kayra.tilmac.exceptions.DifferentLangTypes;
import com.kayra.tilmac.exceptions.NoSuchDaoException;
import com.kayra.tilmac.exceptions.NoSuchWordClassException;
import com.kayra.tilmac.factory.WordConnectionDAOFactory;
import com.kayra.tilmac.factory.WordConnectionFactory;
import com.kayra.tilmac.factory.WordDAOFactory;
import com.kayra.tilmac.factory.WordFactory;
import com.kayra.tilmac.model.TrWord;
import com.kayra.tilmac.model.Word;
import com.kayra.tilmac.model.WordConnection;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WordTest {

	@SuppressWarnings("rawtypes")
	@Test
	public void TrWordsMustReturnNull() {
		WordDAO dao;
		try {
			dao = WordDAOFactory.getInstance().getWordDAO(Languages.TR);
			Assert.assertEquals(0, dao.findAll().size());
			// dao.close();
		} catch (NoSuchDaoException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void EngWordsMustReturn() {
		WordDAO<?> dao;
		try {
			dao = WordDAOFactory.getInstance().getWordDAO(Languages.ENG);
			Assert.assertEquals(0, dao.findAll().size());
			// dao.close();

		} catch (NoSuchDaoException e) {
			Assert.fail(e.getMessage());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test(expected = javax.persistence.NoResultException.class)
	public void addedWordsMustCollectDb() {
		WordDAO dao;
		try {
			dao = WordDAOFactory.getInstance().getWordDAO(Languages.TR);
			Word trWord = WordFactory.getInstance().getWord(Languages.TR);
			trWord.setText("gitmek");
			dao.create(trWord);
			System.out.println("asserten öncesi çalıstı");
			Assert.assertNotNull(trWord.getId());
			System.out.println("asserten sonrassı calıstı");
			dao.delete(trWord);
			trWord = dao.findByText("text");
		} catch (NoSuchDaoException e) {
			Assert.fail();
		} catch (NoSuchWordClassException e) {
			Assert.fail();
		}

	}

	@Test
	public void addedWordConnection() {
		Word tr1;
		try {
			tr1 = WordFactory.getInstance().getWord(Languages.TR);
			Word tr2 = WordFactory.getInstance().getWord(Languages.TR);
			Word eng = WordFactory.getInstance().getWord(Languages.ENG);

			tr1.setText("gitmek");
			tr2.setText("varmak");
			eng.setText("goo");

			List<Word> targetWords = new ArrayList<>();

			WordDAO<Word> trWordDAO = WordDAOFactory.getInstance().getWordDAO(Languages.TR);
			WordDAO<Word> engWordDAO = WordDAOFactory.getInstance().getWordDAO(Languages.ENG);

			trWordDAO.create(tr1);
			trWordDAO.create(tr2);
			engWordDAO.create(eng);

			targetWords.add(tr1);
			targetWords.add(tr2);

			WordConnectionDAO wcDao = WordConnectionDAOFactory.getInstance().getWordConnectionDAO();

			WordConnection wc = WordConnectionFactory.getInstance().getWordConnection();
			wc.setResourceWord(eng);
			wc.setTargetWords(targetWords);
			wcDao.create(wc);

			WordConnection resultWordConnection = wcDao.findByResourceWord(eng);

			WordConnection findByResourceWord = wcDao.findByResourceWord(eng);
			Assert.assertEquals(true, resultWordConnection.getTargetWords().contains(tr1)
					&& resultWordConnection.getTargetWords().contains(tr2));
			clearAllTable();
			// trWordDAO.close();
			// engWordDAO.close();
		} catch (NoSuchWordClassException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void clearAllTable() {
		try {
			WordDAO<Word> trWordDAO = WordDAOFactory.getInstance().getWordDAO(Languages.TR);
			WordDAO<Word> engWordDAO = WordDAOFactory.getInstance().getWordDAO(Languages.ENG);
			WordConnectionDAO wcDao = WordConnectionDAOFactory.getInstance().getWordConnectionDAO();
			trWordDAO.deleteAll();
			engWordDAO.deleteAll();
			wcDao.deleteAll();
		} catch (Exception e) {
			Assert.fail();
		}

	}
}
