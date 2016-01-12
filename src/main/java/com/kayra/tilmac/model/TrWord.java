package com.kayra.tilmac.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TR_WORD")
@NamedQueries({ 
	@NamedQuery(name = TrWord.FIND_BY_TEXT, query = "select tw from TrWord tw where tw.text=:"+TrWord.PARAM_TR_TEXT) 
	,@NamedQuery(name = TrWord.FIND_ALL, query = "select tw from TrWord tw"),
	@NamedQuery(name = TrWord.DELETE_ALL, query = "delete from TrWord")})
public class TrWord extends Word {

	public static final String FIND_BY_TEXT = "trWord.findByText";
	public static final String FIND_ALL = "trWord.findAll";
	public static final String PARAM_TR_TEXT = "trtext";
	public static final String DELETE_ALL = "trWord.deleteAll";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
