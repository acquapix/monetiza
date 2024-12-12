package com.coleta.monetiza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coleta.monetiza.model.Conta;
import com.coleta.monetiza.model.Movimentacao;
import com.coleta.monetiza.model.PessoaFisica;
import com.coleta.monetiza.model.PessoaJuridica;
import com.coleta.monetiza.model.TipoColeta;
import com.coleta.monetiza.model.TipoMovimentacao;
import com.coleta.monetiza.service.ContaService;
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

    @Autowired
    private ContaService contaService;

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
        return "perfilusuario";
    }

    @GetMapping("/buscar")
    public String buscarPorRamoAtividade(@RequestParam("ramoAtividade") String ramoAtividade, Model model) {
        // Busca as pessoas jurídicas pelo ramo de atividade
        List<PessoaJuridica> resultados = pessoaJuridicaService.buscarPorRamoAtividade(ramoAtividade);
        model.addAttribute("resultados", resultados);
        return "resultados"; // Nome do template HTML para exibir os resultados
    }

    
    @GetMapping("/cadastrarcoleta")
    public String cadastroColeta(Model model, @RequestParam Long cooperativaId) {
        PessoaJuridica cooperativa = pessoaJuridicaService.findById(cooperativaId).get();
        model.addAttribute("cooperativa", cooperativa);
        model.addAttribute("movimentacao", new Movimentacao());
        return "cadastrarcoleta";
    }

    @PostMapping("/cadastrarcoleta")
    public String cadastrar(@ModelAttribute Movimentacao movimentacao, @RequestParam Long cooperativaId) {
        Conta conta = pessoaJuridicaService.findById(cooperativaId).get().getConta();
        movimentacao.setTipo(TipoMovimentacao.ENTRADA);
        movimentacao.setConta(conta);
        movimentacaoService.create(movimentacao);
        contaService.depositar(conta, movimentacao.getValor());
        return "redirect:/feed";
    }
}
