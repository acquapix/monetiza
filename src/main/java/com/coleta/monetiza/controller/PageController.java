package com.coleta.monetiza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coleta.monetiza.model.PessoaFisica;
import com.coleta.monetiza.service.PessoaFisicaService;

@Controller
public class PageController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/principal")
    public String principal() {
        return "principal";
    }

    @GetMapping("/cadastrocliente")
    public String cadastroCliente(Model model) {
        model.addAttribute("cliente", new PessoaFisica());
        return "cadastrocliente";
    }

    @PostMapping("/cadastrocliente")
    public String cadastrar(Model model, @ModelAttribute PessoaFisica cliente) {
        pessoaFisicaService.create(cliente);
        return "sucesso";
    }
}
