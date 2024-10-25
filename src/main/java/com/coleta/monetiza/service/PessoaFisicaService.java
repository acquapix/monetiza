package com.coleta.monetiza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coleta.monetiza.model.PessoaFisica;
import com.coleta.monetiza.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService extends AbstractService<PessoaFisica> {
	private PessoaFisicaRepository repository;

	public PessoaFisicaService(PessoaFisicaRepository repository) {
		super(repository);
	}
	
	@Autowired
	public void setRepository(PessoaFisicaRepository repository) {
		this.repository = repository;
	}
	
	public PessoaFisicaRepository getRepository() {
		return repository;
	}
	
}

