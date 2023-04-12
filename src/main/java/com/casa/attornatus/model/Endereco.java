package com.casa.attornatus.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.casa.attornatus.model.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cep;

	private String logradouro;

	private String numero;

	private String cidade;
	
	@NotNull(message = "Perfil nulo!")
	@Enumerated(EnumType.ORDINAL)
	private Perfil perfil;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	private Pessoa pessoa;

	public Endereco(String cep, String logradouro, String numero, String cidade, Pessoa pessoa, Perfil perfil) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.pessoa = pessoa;
		this.perfil = perfil;
	}

}
