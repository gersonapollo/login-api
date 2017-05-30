package br.com.sistema.loginapi.services.exceptions;

public class UsuarioSenhaIncorretaException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6264062298783951515L;

	public UsuarioSenhaIncorretaException(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioSenhaIncorretaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
