package com.casa.attornatus.model.dto;

import java.time.LocalDate;

import com.casa.attornatus.model.Pessoa;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PessoaDto {

	@NotNull
	private String nome;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_De_Nascimento;

	public PessoaDto(Pessoa pessoa) {
		this.nome = pessoa.getNome();
		this.data_De_Nascimento = pessoa.getData_De_Nascimento();
	}

}
