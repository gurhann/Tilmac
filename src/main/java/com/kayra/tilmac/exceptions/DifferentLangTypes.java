package com.kayra.tilmac.exceptions;

public class DifferentLangTypes extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DifferentLangTypes() {
		super("Farklı dilde kelimeler olamaz.");
	}
}
