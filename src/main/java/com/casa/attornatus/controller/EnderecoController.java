package com.casa.attornatus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casa.attornatus.model.Endereco;
import com.casa.attornatus.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService servico;

	@PostMapping("/criar")
	public ResponseEntity<Endereco> criar(@Valid @RequestBody Endereco endereco) {
		endereco = servico.criar(endereco);
		return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
	}
}
