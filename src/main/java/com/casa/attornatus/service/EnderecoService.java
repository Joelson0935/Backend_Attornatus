package com.casa.attornatus.service;

import com.casa.attornatus.model.Endereco;

public interface EnderecoService {

	Endereco criar(Endereco endereco);

	Endereco editar(Endereco endereco, Long id);

	Endereco consultar(Long id);

}
