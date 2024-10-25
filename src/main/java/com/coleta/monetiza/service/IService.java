package com.coleta.monetiza.service;

import java.util.List;

public interface IService<T> {
	T create(T obj);

	T findById(Long id);

	List<T> findAll();

	boolean update(T obj);

	boolean delete(Long id);
}
