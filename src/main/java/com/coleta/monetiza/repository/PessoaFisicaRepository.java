package com.coleta.monetiza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coleta.monetiza.model.PessoaFisica;

@Repository
public interface PessoaFisicaRepository extends
				JpaRepository<PessoaFisica, Long> {

}
