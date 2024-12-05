package com.coleta.monetiza.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coleta.monetiza.model.Movimentacao;
import com.coleta.monetiza.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService extends AbstractService<Movimentacao> {
	private final MovimentacaoRepository repository;

	public MovimentacaoService(MovimentacaoRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public List<Movimentacao> listarMovimentacaoByContaId(Integer contaId) {
        return (List<Movimentacao>) repository.findAllByContaId(contaId);
    }
}
