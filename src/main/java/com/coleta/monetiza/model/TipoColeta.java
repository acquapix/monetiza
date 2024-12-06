package com.coleta.monetiza.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
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
	
	@Column(name = "subTipo")
	private String subTipo;
	
}