package com.coleta.monetiza.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coleta.monetiza.model.Conta;
import com.coleta.monetiza.model.Movimentacao;
import com.coleta.monetiza.model.TipoMovimentacao;
import com.coleta.monetiza.service.ContaService;
import com.coleta.monetiza.service.MovimentacaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/movimentacao")
@Tag(name = "Movimentações", description = "Movimentações de uma movimentacao corrente")
public class MovimentacaoController implements IController<Movimentacao> {

	@Autowired
	private MovimentacaoService service;

	@Autowired
	private ContaService contaService;

	@Override
	@GetMapping
	public ResponseEntity<List<Movimentacao>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@Operation(summary = "Retorna a lista de movimentacoes, de forma paginada", description = "Obtém uma lista de movimentacoes com todos os seus dados, de forma paginada")
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Movimentacao>> getAll(Pageable pageable) {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@Override
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Movimentacao> get(@PathVariable("id") Long id) {
		Optional<Movimentacao> movimentacao = service.findById(id);
		if (movimentacao.isPresent()) {
			return ResponseEntity.ok(movimentacao.get());
			// HTTP 200 OK
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@PostMapping
	@Operation(summary = "Cria uma movimentacao")
	public ResponseEntity<Movimentacao> post(@RequestBody Movimentacao movimentacao) {
		Optional<Conta> conta = contaService.findById(movimentacao.getConta().getId());

		if (conta.isPresent()) {
			if (movimentacao.getTipo() == TipoMovimentacao.ENTRADA) {
				contaService.depositar(conta.get(), movimentacao.getValor());
			} else if (movimentacao.getTipo() == TipoMovimentacao.SAIDA) {
				contaService.sacar(conta.get(), movimentacao.getValor());
			}
			
			service.create(movimentacao);
			return ResponseEntity.status(HttpStatus.CREATED).body(movimentacao);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	public ResponseEntity<Movimentacao> put(@RequestBody Movimentacao movimentacao) {
		throw new UnsupportedOperationException("Operação não suportada");
	}

	@Override
	public ResponseEntity<Movimentacao> patch(@RequestBody Movimentacao movimentacao) {
		throw new UnsupportedOperationException("Operação não suportada");
	}

	@Override
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Exclui uma movimentacao")
	public ResponseEntity<Movimentacao> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
