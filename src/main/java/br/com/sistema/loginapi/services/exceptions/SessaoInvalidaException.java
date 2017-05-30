package br.com.sistema.loginapi.services.exceptions;

public class SessaoInvalidaException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5427883289498127325L;

	public SessaoInvalidaException(String mensagem) {
		super(mensagem);
	}
	
	public SessaoInvalidaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
