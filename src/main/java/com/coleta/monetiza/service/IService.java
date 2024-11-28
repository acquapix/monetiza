package com.coleta.monetiza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService<T> {
	T create(T obj);

	Optional<T> findById(Long id);

	List<T> findAll();

	Page<T> findAll(Pageable pageable);

	boolean update(T obj);

	boolean delete(Long id);
}
