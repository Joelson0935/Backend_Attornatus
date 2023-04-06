package com.casa.attornatus.model.enums;

public enum Perfil {

	PRINCIPAL(1), SECUNDARIO(2);

	private int numero;

	private Perfil(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	/**
	 * Varre todos os elementos do enumerador até achar um valor compatível ao número informado
	 * @author JOELSON
	 * @param inteiro
	 * @return um enumerador do tipo Perfil
	 * @throws IllegalArgumentException em caso do número informado não estiver enumerado.
	 */
	public static Perfil inserirPerfil(Integer inteiro) {
		for (Perfil perfil : Perfil.values()) {
			if (inteiro.equals(perfil.getNumero())) {
				return perfil;
			}
		}
		throw new IllegalArgumentException("Número inválido. " + inteiro);
	}

}
