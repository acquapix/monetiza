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

import com.coleta.monetiza.model.PessoaFisica;
import com.coleta.monetiza.service.PessoaFisicaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/pessoaFisica")
@Tag(name = "Pessoa Física", description = "Gerenciar pessoa física")
public class PessoaFisicaController implements IController<PessoaFisica> {

	@Autowired
	private PessoaFisicaService service;

	@Override
	@GetMapping(produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Resultado com sucesso", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = {
					@Content(mediaType = "application/json") })
	})
	@Operation(summary = "Retorna a lista de pessoas física")
	public ResponseEntity<List<PessoaFisica>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@Operation(summary = "Retorna a lista de pessoas físicas, de forma paginada", description = "Obtém uma lista de pessoas físicas com todos os seus dados, de forma paginada")
	@GetMapping(value = "/page")
	public ResponseEntity<Page<PessoaFisica>> getAll(Pageable pageable) {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@Override
	@GetMapping(value = "/{id}", produces = "application/json")
	@Operation(summary = "Obtém uma pessoa física", description = "Dado um id, retorna a pessoa física associada.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Resultado com sucesso", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "Cliente não encontrado", content = {
					@Content(mediaType = "application/json") })
	})
	public ResponseEntity<PessoaFisica> get(@PathVariable("id") Long id) {
		Optional<PessoaFisica> pessoaFisica = service.findById(id);
		if (pessoaFisica.isPresent()) {
			return ResponseEntity.ok(pessoaFisica.get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@PostMapping
	@Operation(summary = "Cria uma pessoa física")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Cliente criado com sucesso", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = {
					@Content(mediaType = "application/json") })
	})
	public ResponseEntity<PessoaFisica> post(@RequestBody PessoaFisica pessoaFisica) {
		service.create(pessoaFisica);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(pessoaFisica.getId())
				.toUri();
		return ResponseEntity.created(location).body(pessoaFisica);
	}

	@Override
	@PutMapping
	@Operation(summary = "Atualiza uma pessoa física", description = "Atualização por completo de uma pessoa física.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Resultado com sucesso", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "Cliente não encontrado", content = {
					@Content(mediaType = "application/json") })
	})
	public ResponseEntity<PessoaFisica> put(@RequestBody PessoaFisica pessoaFisica) {
		if (service.update(pessoaFisica)) {
			return ResponseEntity.ok(pessoaFisica);
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@PatchMapping
	@Operation(summary = "Atualiza uma pessoa física", description = "Atualização parcial de uma pessoa física.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Resultado com sucesso", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "Cliente não encontrado", content = {
					@Content(mediaType = "application/json") })
	})
	public ResponseEntity<PessoaFisica> patch(@RequestBody PessoaFisica pessoaFisica) {
		if (service.update(pessoaFisica)) {
			return ResponseEntity.ok(pessoaFisica);
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Exclui uma pessoa física")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Resultado com sucesso", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "Cliente não encontrado", content = {
					@Content(mediaType = "application/json") })
	})
	public ResponseEntity<PessoaFisica> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}