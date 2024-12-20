package com.coleta.monetiza.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.coleta.monetiza.model.Conta;
import com.coleta.monetiza.service.ContaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/conta")
@Tag(name = "Conta corrente", description = "Gerenciar conta corrente")
public class ContaController implements IController<Conta> {

	@Autowired
	private ContaService service;

	@Override
	@GetMapping(produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Resultado com sucesso", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = {
					@Content(mediaType = "application/json") })
	})
	@Operation(summary = "Retorna a lista de contas", description = "Obtém uma lista de contas com todos os seus dados")
	public ResponseEntity<List<Conta>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@Operation(summary = "Retorna a lista de contas, de forma paginada", description = "Obtém uma lista de contas com todos os seus dados, de forma paginada")
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Conta>> getAll(Pageable pageable) {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@Override
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Conta> get(@PathVariable("id") Long id) {
		Optional<Conta> conta = service.findById(id);
		if (conta.isPresent()) {
			return ResponseEntity.ok(conta.get());
			// HTTP 200 OK
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@PostMapping
	@Operation(summary = "Cria uma conta")
	public ResponseEntity<Conta> post(@RequestBody Conta conta) {
		service.create(conta);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(conta.getId())
				.toUri();
		return ResponseEntity.created(location).body(conta);
	}

	@Override
	@PutMapping
	@Operation(summary = "Atualiza uma conta")
	public ResponseEntity<Conta> put(@RequestBody Conta conta) {
		if (service.update(conta)) {
			return ResponseEntity.ok(conta);
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@PatchMapping
	@Operation(summary = "Atualiza uma conta")
	public ResponseEntity<Conta> patch(@RequestBody Conta conta) {
		if (service.update(conta)) {
			return ResponseEntity.ok(conta);
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Exclui uma conta")
	public ResponseEntity<Conta> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
