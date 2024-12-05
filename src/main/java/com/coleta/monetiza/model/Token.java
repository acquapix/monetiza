package com.coleta.monetiza.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "tb_token")
@Entity
public class Token extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "tk_token")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String token;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "fk_conta_id", nullable = false)
    private Conta conta;

    public Token() {
        this.token = UUID.randomUUID().toString();
    }

    public Token(Conta conta) {
        this.conta = conta;
        this.token = UUID.randomUUID().toString();
    }

    public String getToken() {
        return token;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
