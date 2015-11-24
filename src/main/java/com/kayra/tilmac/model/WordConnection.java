package com.kayra.tilmac.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "WORD_CONNECTION")
@NamedQueries({
	@NamedQuery(name="word_connection.findByResourceWord",
			query = "select wc from WordConnection wc where wc.resourceWord=:word")
})
public class WordConnection {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "RESOURCE_WORD")
	@JoinColumn(name="WORD_ID")
	private Word resourceWord;
	@Column(name = "TARGET_WORDS")
	@OneToMany
	private List<Word> targetWords;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Word getResourceWord() {
		return resourceWord;
	}

	public void setResourceWord(Word resourseWord) {
		this.resourceWord = resourseWord;
	}

	public List<Word> getTargetWords() {
		return targetWords;
	}

	public void setTargetWords(List<Word> targetWords) {
		this.targetWords = targetWords;
	}

}
