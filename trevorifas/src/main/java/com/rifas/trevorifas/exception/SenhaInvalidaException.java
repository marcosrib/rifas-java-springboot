package com.rifas.trevorifas.exception;

public class SenhaInvalidaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3762409099542140609L;

	public SenhaInvalidaException() {
		super("Senha inválida");
	}
  
}
