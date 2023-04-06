package com.casa.attornatus.exceptions;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleExceptionsClass {

	@ExceptionHandler(ObjetoNaoEncontrado.class)
	public ResponseEntity<Erro> objetoNaoEncontrado(ObjetoNaoEncontrado e) {
		Erro erro = new Erro(e.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDate.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Erro> argumentoInvalido(MethodArgumentNotValidException e) {
		Erro erro = new Erro("Argumento inválido", HttpStatus.BAD_REQUEST.value(), LocalDate.now());
		for (FieldError field : e.getBindingResult().getFieldErrors()) {
			erro.toCampos(field.getField(), field.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

}
