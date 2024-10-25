package com.coleta.monetiza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coleta.monetiza.model.PessoaJuridica;

@Repository
public interface PessoaJuridicaRepository extends
			JpaRepository<PessoaJuridica, Long>{

}
