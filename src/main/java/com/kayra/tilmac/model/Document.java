package com.kayra.tilmac.model;

import java.util.List;

import com.kayra.tilmac.enums.Languages;

public class Document {
	private String name;
	private String type;
	private int[][] pages;
	private List<Word> wordList;
	private Languages languages;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int[][] getPages() {
		return pages;
	}
	public void setPages(int[][] pages) {
		this.pages = pages;
	}
	public List<Word> getWordList() {
		return wordList;
	}
	public void setWordList(List<Word> wordList) {
		this.wordList = wordList;
	}
	public Languages getLanguages() {
		return languages;
	}
	public void setLanguages(Languages languages) {
		this.languages = languages;
	}

}
