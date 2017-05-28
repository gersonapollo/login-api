package br.com.sistema.loginapi.services.exceptions;

public class UsuarioJaCadastradoExcepition extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7074734288493312887L;

	public UsuarioJaCadastradoExcepition(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioJaCadastradoExcepition(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
