package com.kayra.tilmac.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TR_WORD")
@NamedQueries({ 
	@NamedQuery(name = TrWord.FIND_BY_TEXT, query = "select tw from TrWord tw where tw.text=:"+TrWord.PARAM_TR_TEXT) 
	,@NamedQuery(name = TrWord.FIND_ALL, query = "select tw from TrWord tw")})
public class TrWord extends Word {

	public static final String FIND_BY_TEXT = "trWord.findByText";
	public static final String FIND_ALL = "trWord.findAll";
	public static final String PARAM_TR_TEXT = "trtext";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
