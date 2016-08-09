package com.interfaces;
import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.sqlConnection.MySQLConnection;

public interface MyDAO<T> {
	
	public int create(T t);
	public int update(T t);
	public int delete(T t);
	public T find(UUID id, String... value);
	public List<T> findAll();
	
}
