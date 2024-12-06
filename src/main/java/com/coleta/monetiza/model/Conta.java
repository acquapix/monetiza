package com.coleta.monetiza.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_conta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Conta extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nr_agencia", nullable = false)
	private Integer agencia;

	@Column(name = "nm_numero", nullable = false, length = 10)
	private String numero;

	@Column(name = "vl_saldo", nullable = false)
	private Double saldo;

}
