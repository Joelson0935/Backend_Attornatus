package com.casa.attornatus.exceptions;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Erro implements Serializable {
	private static final long serialVersionUID = 1L;

	private String error;
	private Integer codigo;
	private LocalDate data;
	private List<Campos> campos = new ArrayList<>();

	public Erro(String error, Integer codigo, LocalDate data) {
		super();
		this.error = error;
		this.codigo = codigo;
		this.data = data;
	}

	public void toCampos(String nome, String erro) {
		campos.add(new Campos(nome, erro));
	}
}
