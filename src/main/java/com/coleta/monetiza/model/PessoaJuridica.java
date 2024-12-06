package com.coleta.monetiza.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_pessoa_juridica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaJuridica extends Cliente {
	
    private static final long serialVersionUID = 1L;

    @Column(name="cd_cnpj", length=14)
    private String cnpj;

    @Column(name="nm_ramo_atividade", length=20)
    private String ramoAtividade;

}
