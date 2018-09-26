package com.training.entity;

import java.util.List;

public interface DAO<T> {
	
	
	public int add(T t) throws Exception;
	
	public List<T> findAll() throws Exception;
	
	public int remove(long movieId) throws Exception;
	
	public T findByPrimaryKey(long movieId) throws Exception;
}
