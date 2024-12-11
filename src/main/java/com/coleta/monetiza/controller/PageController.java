package com.coleta.monetiza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coleta.monetiza.model.Movimentacao;
import com.coleta.monetiza.model.PessoaFisica;
import com.coleta.monetiza.model.PessoaJuridica;
import com.coleta.monetiza.service.MovimentacaoService;
import com.coleta.monetiza.service.PessoaFisicaService;
import com.coleta.monetiza.service.PessoaJuridicaService;

@Controller
public class PageController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/principal")
    public String principal() {
        return "principal";
    }

    @GetMapping("/feed")
    public String feed() {
        return "feed";
    }

    @GetMapping("/cadastroclientepf")
    public String cadastroCliente(Model model) {
        model.addAttribute("cliente", new PessoaFisica());
        return "cadastroclientepf";
    }

    @PostMapping("/cadastroclientepf")
    public String cadastrar(Model model, @ModelAttribute PessoaFisica cliente) {
        pessoaFisicaService.create(cliente);
        model.addAttribute("cliente", cliente);
        return "sucesso";
    }

    @GetMapping("/cadastroclientepj")
    public String cadastroPessoaJuridica(Model model) {
        model.addAttribute("cliente", new PessoaJuridica());
        return "cadastroclientepj";
    }

    @PostMapping("/cadastroclientepj")
    public String cadastrar(Model model, @ModelAttribute PessoaJuridica cliente) {
        pessoaJuridicaService.create(cliente);
        model.addAttribute("cliente", cliente);
        return "sucessopj";
    }

    
    @GetMapping("/cadastrocolabora")
    public String cadastroColabora(Model model) {
        model.addAttribute("cliente", new PessoaJuridica());
        return "cadastrocolabora";
    }

    @GetMapping("/perfil")
    public String perfilUsuario() {
        return "perfilUsuario";
    }

    @GetMapping("/buscar")
    public String buscarPorRamoAtividade(@RequestParam("ramoAtividade") String ramoAtividade, Model model) {
        // Busca as pessoas jurídicas pelo ramo de atividade
        List<PessoaJuridica> resultados = pessoaJuridicaService.buscarPorRamoAtividade(ramoAtividade);
        model.addAttribute("resultados", resultados);
        return "resultados"; // Nome do template HTML para exibir os resultados
    }

    
    @GetMapping("/cadastrarcoleta")
    public String cadastroColeta(Model model) {
        var pessoaFisica = pessoaFisicaService.findById((long) 1);
        List<PessoaJuridica> cooperativas = pessoaJuridicaService.findAll();
        model.addAttribute("cliente", pessoaFisica);
        model.addAttribute("cooperativas", cooperativas);
        return "cadastrarcoleta";
    }

    @PostMapping("/registrodaColeta")
    public String cadastrar(Model model, @ModelAttribute Movimentacao movimentacao) {
        movimentacaoService.create(movimentacao);
        model.addAttribute("movimentacao", movimentacao);
        return "registrodaColeta";
    }
}
