package com.coleta.monetiza.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
	T create(T obj);

	Optional<T> findById(Long id);

	List<T> findAll();

	boolean update(T obj);

	boolean delete(Long id);
}
