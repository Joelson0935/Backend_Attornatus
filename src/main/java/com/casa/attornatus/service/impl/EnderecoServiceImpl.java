package com.casa.attornatus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casa.attornatus.exceptions.ObjetoNaoEncontrado;
import com.casa.attornatus.model.Endereco;
import com.casa.attornatus.model.Pessoa;
import com.casa.attornatus.model.enums.Perfil;
import com.casa.attornatus.repository.EnderecoRepository;
import com.casa.attornatus.repository.PessoaRepository;
import com.casa.attornatus.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	// - Criar endereço para pessoa
	@Override
	public Endereco criar(Endereco endereco) {
		Pessoa pessoa = pessoaRepository.findById(endereco.getPessoa().getId())
				.orElseThrow(() -> new ObjetoNaoEncontrado("Pessoa Não encontrada" + endereco.getPessoa().getId()));

		Endereco novoEndereco = new Endereco(endereco.getCep(), endereco.getLogradouro(), endereco.getNumero(),
				endereco.getCidade(), pessoa, Perfil.inserirPerfil(endereco.getPerfil().getNumero()));
		return enderecoRepository.save(novoEndereco);
	}

	@Override
	public Endereco editar(Endereco objeto, Long id) {
		return null;
	}

	@Override
	public Endereco consultar(Long id) {
		return null;
	}

}
