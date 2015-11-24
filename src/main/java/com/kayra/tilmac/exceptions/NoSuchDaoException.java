package com.kayra.tilmac.exceptions;

public class NoSuchDaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSuchDaoException(){
		super("Belirtilen Dilde DAO Oluşturulmamış.");
	}

}
