package com.coleta.monetiza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.coleta.monetiza.model.Conta;
import com.coleta.monetiza.repository.ContaRepository;

@Service
public class ContaService implements IService<Conta> {
	@Autowired
	private ContaRepository repository;

	public ContaService() {
	}

	@Override
	public Conta findById(Long id) {
		Optional<Conta> obj = repository.findById(id);
		return obj.orElse(null);
	}

	
	public Page<Conta> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Conta create(Conta conta) {
		repository.save(conta);
		return conta;
	}

	@Override
	public boolean update(Conta conta) {
		if (repository.existsById(conta.getId())) {
			repository.save(conta);
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

	@Override
	public List<Conta> findAll() {
		return null;
	}
}
