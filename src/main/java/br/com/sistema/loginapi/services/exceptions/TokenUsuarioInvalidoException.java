package br.com.sistema.loginapi.services.exceptions;

public class TokenUsuarioInvalidoException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4260438177637030928L;

	public TokenUsuarioInvalidoException(String mensagem) {
		super(mensagem);
	}
	
	public TokenUsuarioInvalidoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
