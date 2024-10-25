package com.coleta.monetiza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coleta.monetiza.model.AbstractEntity;

public class AbstractService<T> implements IService<T> {
	
	private JpaRepository<T, Long> repository;

	public AbstractService(JpaRepository<T, Long> repository) {
		this.repository = repository;
	}

	@Override
	public T findById(Long id) {
		Optional<T> obj = repository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public T create(T entity) {
		repository.save(entity);
		return entity;
	}

	@Override
	public boolean update(T entity) {
		if (repository.existsById(((AbstractEntity) entity).getId())) {
			repository.save(entity);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}
