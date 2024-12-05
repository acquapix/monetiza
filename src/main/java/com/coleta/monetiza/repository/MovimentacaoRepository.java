package com.coleta.monetiza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coleta.monetiza.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
	List<Movimentacao> findAllByContaId(Integer contaId);
}