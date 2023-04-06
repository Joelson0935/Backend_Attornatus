package com.casa.attornatus.service;

import java.util.List;

import com.casa.attornatus.model.Pessoa;
import com.casa.attornatus.model.dto.PessoaDto;

public interface PessoaService {

	Pessoa criar(Pessoa pessoa);
	
	Pessoa editar(Pessoa pessoa, Long id);
	
	Pessoa consultar(Long id);
	
	List<PessoaDto> listar();
	
}
