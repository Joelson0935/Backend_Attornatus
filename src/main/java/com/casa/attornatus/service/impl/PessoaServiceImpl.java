package com.casa.attornatus.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casa.attornatus.exceptions.ObjetoNaoEncontrado;
import com.casa.attornatus.model.Pessoa;
import com.casa.attornatus.model.dto.PessoaDto;
import com.casa.attornatus.repository.PessoaRepository;
import com.casa.attornatus.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	// - Criar uma pessoa
	@Override
	public Pessoa criar(Pessoa pessoa) {
		pessoa = pessoaRepository.save(pessoa);
		return pessoa;
	}

	// - Editar uma pessoa
	@Override
	public Pessoa editar(Pessoa pessoa, Long id) {
		@SuppressWarnings("unused")
		Pessoa pessoaEncontrada = consultar(id);
		pessoa.setId(id);
		pessoaEncontrada = pessoa;
		return pessoaRepository.save(pessoa);
	}

	// - Consultar uma pessoa - Listar endereços da pessoa - Pode informar qual
	// endereço é o principal da pessoa
	@Override
	public Pessoa consultar(Long id) {
		Pessoa pessoaEncontrada = pessoaRepository.findById(id)
				.orElseThrow(() -> new ObjetoNaoEncontrado("Pessoa Não encontrada " + id));
		return pessoaEncontrada;
	}

// - Listar pessoas
	@Override
	public List<PessoaDto> listar() {
		List<Pessoa> pessoas = pessoaRepository.findAll();
		List<PessoaDto> pessoasDto = pessoas.stream().map(pessoa -> new PessoaDto(pessoa)).collect(Collectors.toList());
		return pessoasDto;
	}

}
