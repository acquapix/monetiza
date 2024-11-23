package com.coleta.monetiza.service;

import org.springframework.stereotype.Service;

import com.coleta.monetiza.model.PessoaFisica;
import com.coleta.monetiza.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService extends AbstractService<PessoaFisica> {
	public PessoaFisicaService(PessoaFisicaRepository repository) {
		super(repository);
	}
}
