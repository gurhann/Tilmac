package com.kayra.tilmac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.kayra.tilmac.enums.Languages;

@Entity
@Table(name = "WORD")
public class Word {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TEXT")
	private String text;
	
	private Languages lang;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Languages getLang() {
		return lang;
	}
	public void setLang(Languages lang) {
		this.lang = lang;
	}
	
}
