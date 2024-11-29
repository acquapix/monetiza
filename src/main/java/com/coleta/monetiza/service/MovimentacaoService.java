package com.coleta.monetiza.service;

import org.springframework.stereotype.Service;

import com.coleta.monetiza.model.Movimentacao;
import com.coleta.monetiza.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService extends AbstractService<Movimentacao> {
	public MovimentacaoService(MovimentacaoRepository repository, ContaService contaService) {
		super(repository);
	}
}
