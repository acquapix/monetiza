package com.coleta.monetiza.service;

import org.springframework.stereotype.Service;

import com.coleta.monetiza.model.Conta;
import com.coleta.monetiza.model.Token;
import com.coleta.monetiza.repository.ContaRepository;

@Service
public class ContaService extends AbstractService<Conta> {

	private TokenService tokenService;
	
	public ContaService(ContaRepository repository, TokenService tokenService) {
		super(repository);
		this.tokenService = tokenService;
	}

	public void depositar(Conta conta, double valor) {
		double novoSaldo = conta.getSaldo() + valor;
		conta.setSaldo(novoSaldo);
		update(conta);
	}

	public void sacar(Conta conta, double valor) {
		double novoSaldo = conta.getSaldo() - valor;
		conta.setSaldo(novoSaldo);
		update(conta);
	}
}
