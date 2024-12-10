package com.coleta.monetiza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coleta.monetiza.model.PessoaJuridica;
import com.coleta.monetiza.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService extends AbstractService<PessoaJuridica> {

	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;

	public PessoaJuridicaService(PessoaJuridicaRepository repository) {
		super(repository);
		this.pessoaJuridicaRepository = repository;
	}

	public List<PessoaJuridica> buscarPorRamoAtividade(String ramoAtividade) {
        return pessoaJuridicaRepository.findByRamoAtividadeContainingIgnoreCase(ramoAtividade);
    }
}