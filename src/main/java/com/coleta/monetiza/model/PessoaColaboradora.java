package com.coleta.monetiza.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_pessoa_colaboradora")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaColaboradora extends Cliente {

    private static final long serialVersionUID = 1L;

    @Column(name="cd_cpf", length = 11)
    private String cpf;

    @Column(name="nm_profissao", length = 30)
    private String profissao; 

}