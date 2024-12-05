package com.coleta.monetiza.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_conta")
public class Conta extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nr_agencia", nullable = false)
	private Integer agencia;

	@Column(name = "nm_numero", nullable = false, length = 10)
	private String numero;

	@Column(name = "vl_saldo", nullable = false)
	private Double saldo;

	@OneToMany(mappedBy = "conta")
	private List<Movimentacao> movimentacoes;

	@OneToMany(mappedBy = "conta")
	private List<Token> tokens;

	public Conta() {
	}

	public Conta(Long id) {
		super.setId(id);
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
