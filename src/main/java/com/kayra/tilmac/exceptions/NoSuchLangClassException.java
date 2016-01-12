package com.kayra.tilmac.exceptions;

public class NoSuchLangClassException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchLangClassException() {
		super("Belirtilen Dil İçin Oluşturulmuş Bir Sınıf Bulunamadı");
	}
}
