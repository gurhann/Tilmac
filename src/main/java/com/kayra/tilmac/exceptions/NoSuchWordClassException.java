package com.kayra.tilmac.exceptions;

public class NoSuchWordClassException extends Exception{
	public NoSuchWordClassException() {
		super("Belirtilen Word Sınıfı Bulunamadı.");
	}
}
