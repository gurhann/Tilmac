package com.kayra.tilmac.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DOCUMENT")
@NamedQueries({ @NamedQuery(name = Document.FIND_BY_NAME, query = "select doc from Document doc where doc.name=:"+Document.PARAM_DOC_NAME),
	@NamedQuery(name = Document.FIND_ALL, query = "select doc from Document doc"),
	@NamedQuery(name = Document.DELETE_ALL, query = "delete  from Document" )})
public class Document<T extends Word> {
	
	public static final String FIND_BY_NAME = "document.findByText";
	public static final String FIND_ALL = "document.findAll";
	public static final String PARAM_DOC_NAME = "documentName";
	public static final String DELETE_ALL = "document.deleteAll";
	
	@Id
	@Column(name = "DOCUMENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "NAME")
	private String name;

	@OneToMany
	@Column(name = "WORDS")
	private List<T> wordList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<T> getWordList() {
		return wordList;
	}

	public void setWordList(List<T> wordList) {
		this.wordList = wordList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
