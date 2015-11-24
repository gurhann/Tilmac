package com.kayra.tilmac.model;

import java.util.List;

public class Document<T extends Word> {
	private String name;
	private String type;
	private int[][] pages;
	private List<T> wordList;
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
	public List<T> getWordList() {
		return wordList;
	}
	public void setWordList(List<T> wordList) {
		this.wordList = wordList;
	}

}
