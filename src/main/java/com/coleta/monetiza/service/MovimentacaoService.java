package com.coleta.monetiza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coleta.monetiza.model.Movimentacao;
import com.coleta.monetiza.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService extends AbstractService<Movimentacao> {
	private MovimentacaoRepository repository;

	public MovimentacaoService(MovimentacaoRepository repository) {
		super(repository);
	}
	
	@Autowired
	public void setRepository(MovimentacaoRepository repository) {
		this.repository = repository;
	}
	
	public MovimentacaoRepository getRepository() {
		return repository;
	}
	
	public List<Movimentacao> findByConta(Integer idConta){
		return repository.findByConta(idConta);
	}
	
	public void saveWithConta(Movimentacao movimentacao, Integer idConta) {
		repository.saveWithConta(movimentacao, idConta);
	}
	
}
