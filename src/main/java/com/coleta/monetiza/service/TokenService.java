package com.coleta.monetiza.service;

import org.springframework.stereotype.Service;

import com.coleta.monetiza.model.Token;
import com.coleta.monetiza.repository.TokenRepository;

@Service
public class TokenService extends AbstractService<Token> {
    public TokenService(TokenRepository repository) {
        super(repository);
    }
}
