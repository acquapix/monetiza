package com.coleta.monetiza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coleta.monetiza.model.Conta;

@Repository
public interface ContaRepository extends
                       JpaRepository<Conta, Long> {
}
