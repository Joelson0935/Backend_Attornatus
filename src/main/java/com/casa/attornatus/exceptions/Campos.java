package com.casa.attornatus.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Campos {
	private String fieldName;
	private String fieldError;
}
