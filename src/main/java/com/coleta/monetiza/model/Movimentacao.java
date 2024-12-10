package com.coleta.monetiza.model;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_movimentacao")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movimentacao extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "vl_valor", nullable = false)
	private double valor;

	@Enumerated(EnumType.STRING)
	@Column(name = "nm_tipo_movimentacao", nullable = false)
	private TipoMovimentacao tipo;

	@Enumerated(EnumType.STRING)
	@Column(name = "nm_tipo_coleta", nullable = false)
	private TipoColeta tipoColeta;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "fk_conta_id", nullable = false)
	private Conta conta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_data")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Calendar data;

}