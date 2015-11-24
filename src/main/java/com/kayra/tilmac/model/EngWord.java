package com.kayra.tilmac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ENG_WORDS")
@NamedQueries({ @NamedQuery(name = EngWord.FIND_BY_TEXT, query = "select ew from EngWord ew where ew.text=:"+EngWord.PARAM_ENG_TEXT),
		@NamedQuery(name = EngWord.FIND_ALL, query = "select ew from EngWord ew") })
public class EngWord extends Word {
	public static final String FIND_BY_TEXT = "engWord.findByText";
	public static final String FIND_ALL = "engWord.findAll";
	public static final String PARAM_ENG_TEXT = "engtext";

	public enum Queries {
		FIND_BY_TEXT("engWord.findByText");

		private String query;

		private Queries(String query) {
			this.query = query;
		}

		public String getValue() {
			return query;
		}
	}
}
