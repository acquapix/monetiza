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
public class ContaService {
	@Autowired
	private ContaRepository repository;

	public ContaService() {
	}

	public Optional<Conta> findById(Long id) {
		return repository.findById(id);
	}

	public Page<Conta> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public List<Conta> findAll() {
		return null;
	}

	public Conta create(Conta conta) {
		repository.save(conta);
		return conta;
	}

	public boolean update(Conta conta) {
		if (repository.existsById(conta.getId())) {
			repository.save(conta);
			return true;
		}
		return false;
	}

	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	public void depositar(Conta conta, double valor) {
		double novoSaldo = conta.getSaldo() + valor;
		conta.setSaldo(novoSaldo);
		update(conta);
	}

	public void sacar(Conta conta, double valor) {
		double novoSaldo = conta.getSaldo() - valor;
		conta.setSaldo(novoSaldo);
		update(conta);
	}

}
