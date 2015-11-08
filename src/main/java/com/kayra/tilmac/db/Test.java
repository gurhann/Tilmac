package com.kayra.tilmac.db;


import javax.persistence.EntityManager;

import com.kayra.tilmac.enums.Languages;
import com.kayra.tilmac.enums.PersistenceManager;
import com.kayra.tilmac.model.Word;

public class Test {
	public static void main(String args [] ) {
		Word word = new Word();
		word.setLang(Languages.TR);
		word.setText("ss");
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(word);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();
	}
}
