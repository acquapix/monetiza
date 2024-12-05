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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_tipo_coleta")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoColeta extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "seco")
	private boolean seco;

	@Column(name = "umido")
	private boolean umido;

	@Column(name = "eletro_eletronico")
	private boolean eletroEletronico;

    @OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "fk_conta_id", nullable = false)
	private Movimentacao movimentacao;

}