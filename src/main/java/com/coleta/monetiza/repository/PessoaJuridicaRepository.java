package com.coleta.monetiza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coleta.monetiza.model.PessoaJuridica;

@Repository
public interface PessoaJuridicaRepository extends
			JpaRepository<PessoaJuridica, Long>{
				List<PessoaJuridica> findByRamoAtividadeContainingIgnoreCase(String ramoAtividade);
}
