package com.coleta.monetiza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coleta.monetiza.model.Movimentacao;

public interface MovimentacaoRepository extends
		JpaRepository<Movimentacao, Long> {
}