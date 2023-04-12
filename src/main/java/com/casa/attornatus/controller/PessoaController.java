package com.casa.attornatus.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casa.attornatus.model.Pessoa;
import com.casa.attornatus.model.dto.PessoaDto;
import com.casa.attornatus.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService servico;

	@PostMapping("/criar")
	public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa) {
		pessoa = servico.criar(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<Pessoa> editar(@Valid @RequestBody Pessoa pessoa, @PathVariable Long id) {
		Pessoa pessoaEncontrada = servico.consultar(id);
		if (pessoaEncontrada == null) {
			return ResponseEntity.notFound().build();
		}
		pessoa = servico.editar(pessoa, id);
		return ResponseEntity.ok(pessoa);
	}

	@GetMapping("/consultar/{id}")
	public ResponseEntity<Pessoa> consultar(@PathVariable Long id) {
		Pessoa pessoa = servico.consultar(id);
		if (pessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoa);
	}

	@GetMapping("/listar")
	public ResponseEntity<List<PessoaDto>> listar() {
		List<PessoaDto> pessoas = servico.listar();
		return ResponseEntity.ok(pessoas);
	}
}
