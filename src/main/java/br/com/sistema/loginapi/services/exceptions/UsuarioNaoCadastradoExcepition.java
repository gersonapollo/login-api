package br.com.sistema.loginapi.services.exceptions;

public class UsuarioNaoCadastradoExcepition extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1045997316082381274L;

	public UsuarioNaoCadastradoExcepition(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioNaoCadastradoExcepition(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
