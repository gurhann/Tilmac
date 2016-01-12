package com.kayra.tilmac.dao;

import java.util.List;

public interface BaseDAO <T>{
	public void create(T t);
	public void delete(T t);
	public void deleteAll();
	public List<T> findAll();
	public void close();
}
