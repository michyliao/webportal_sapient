package com.interfaces;
import java.util.List;
import java.util.UUID;

public interface MyDAO<T> {
	
	public int create(T t);
	public int update(T t);
	public int delete(T t);
	public T find(UUID s);
	public List<T> findAll();
	
}
