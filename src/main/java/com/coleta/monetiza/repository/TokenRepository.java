package com.coleta.monetiza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coleta.monetiza.model.Token;

public interface TokenRepository extends
		JpaRepository<Token, Long> {
}
