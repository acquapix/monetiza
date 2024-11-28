package com.coleta.monetiza.service;

import org.springframework.stereotype.Service;

import com.coleta.monetiza.model.PessoaJuridica;
import com.coleta.monetiza.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService extends AbstractService<PessoaJuridica> {
	public PessoaJuridicaService(PessoaJuridicaRepository repository) {
		super(repository);
	}
}