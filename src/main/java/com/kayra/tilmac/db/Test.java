package com.kayra.tilmac.db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.kayra.tilmac.enums.PersistenceManager;
import com.kayra.tilmac.model.EngWord;
import com.kayra.tilmac.model.TrWord;
import com.kayra.tilmac.model.Word;
import com.kayra.tilmac.model.WordConnection;
import com.kayra.tilmac.translator.YandexTranslator;

public class Test {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query q4 = em.createNamedQuery("engWord.findAll");
		List<EngWord> wordsList = q4.getResultList();
		Query q5 = em.createNamedQuery("word_connection.findByResourceWord");
		ArrayList<String> newlist = new ArrayList<>();
		
		
		
		for (EngWord words : wordsList) {
			try {
				q5.setParameter("word", words);
				List<WordConnection> cc = q5.getResultList();
				if (q5.getFirstResult() == 0) {
					newlist.add(words.getText());
					System.out.println(words.getText());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// go -> gitmek
		// swim-> yüzmek, çimmek
		YandexTranslator trs = new YandexTranslator();
		trs.setNewWords(newlist);
		try {
			HashMap<String, String> news = trs.translateNewWords();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String, String> news = new HashMap<String, String>();
		// BufferedReader br = new BufferedReader(new FileReader("myfile.txt"));
		// try {
		// StringBuilder sb = new StringBuilder();
		// String line = br.readLine();
		//
		// while (line != null) {
		// String[] params = line.split("->");
		// news.put(params[1], params[2]);
		// line = br.readLine();
		// }
		// String everything = sb.toString();
		// } finally {
		// br.close();
		// }
		//
		// for (String a : news.keySet()) {
		// System.out.println(a + "->" + news.get(a));
		// }
		// int counter = 0;
		System.out.println("Geri geldi" + news.size());
		for (String key : news.keySet()) { // go,swim
			// if (counter > 17327) {
			if (news.get(key).contains(",")) {
				String wl[] = news.get(key).split(", ");
				List<Word> ll = new ArrayList<>();
				Query query3 = em.createNamedQuery("engWord.findByText");
				query3.setParameter("engtext", key);
				EngWord engWord = (EngWord) query3.getSingleResult();
				WordConnection wcon = new WordConnection();

				wcon.setResourceWord(engWord);

				for (String word : wl) {
					Query query2 = em.createNamedQuery("trWord.findByText");
					query2.setParameter("trtext", word);
					TrWord trWord;
					if (query2.getFirstResult() == 0) {

						trWord = new TrWord();
						trWord.setText(word);
						em.persist(trWord);
						em.getTransaction().begin();
						em.getTransaction().commit();
					} else {
						trWord = (TrWord) query2.getSingleResult();
					}

					ll.add(trWord);

				}
				wcon.setTargetWords(ll);
				em.getTransaction().begin();
				em.persist(wcon);
				em.getTransaction().commit();
			} else {
				// go - gitmek
				// türkçe kelime veri tabanında varmı
				Query query2 = em.createNamedQuery("trWord.findByText");
				query2.setParameter("trtext", news.get(key));
				TrWord trWord;
				if (query2.getFirstResult() == 0) {
					// eğer türkçe kelime yoksa yeni bi trword
					trWord = new TrWord();
					// textine gitmek iver
					trWord.setText(news.get(key));

					// veritabanına kaydet
					em.persist(trWord);
					em.getTransaction().begin();
					em.getTransaction().commit();
				} else {
					// varsada onu getir
					trWord = (TrWord) query2.getSingleResult();
				}

				WordConnection wcon = new WordConnection();
				Query query3 = em.createNamedQuery("engWord.findByText");
				query3.setParameter("engtext", key);
				EngWord engWord = (EngWord) query3.getSingleResult();
				//
				wcon.setResourceWord(engWord);
				List<Word> ll = new ArrayList<>();
				ll.add(trWord);
				wcon.setTargetWords(ll);
				em.getTransaction().begin();
				em.persist(wcon);
				em.getTransaction().commit();
			}
			// }
			// counter++;
		}

		em.close();
		PersistenceManager.INSTANCE.close();
	}

	private static void ddd(String tr) {

	}
}
