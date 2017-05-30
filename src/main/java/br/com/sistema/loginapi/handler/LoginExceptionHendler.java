package br.com.sistema.loginapi.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.sistema.loginapi.models.LoginErro;
import br.com.sistema.loginapi.services.exceptions.UsuarioJaCadastradoExcepition;
import br.com.sistema.loginapi.services.exceptions.UsuarioNaoCadastradoExcepition;
import br.com.sistema.loginapi.services.exceptions.UsuarioSenhaIncorretaException;

@ControllerAdvice
public class LoginExceptionHendler {
	
	
	@ExceptionHandler(UsuarioNaoCadastradoExcepition.class)
	public ResponseEntity<LoginErro> UsuarioNaoCadastradoException(UsuarioNaoCadastradoExcepition exception, HttpServletRequest request){
		
		LoginErro loginErro = new LoginErro(HttpStatus.NOT_FOUND.value(), "Usuário não Cadastrado");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(loginErro);	
	}
	
	@ExceptionHandler(UsuarioJaCadastradoExcepition.class)
	public ResponseEntity<LoginErro> UsuarioJaCadastradoException(UsuarioJaCadastradoExcepition exception, HttpServletRequest request){
		
		LoginErro loginErro = new LoginErro(HttpStatus.CONFLICT.value(), "E-mail já existente");
		return ResponseEntity.status(HttpStatus.CONFLICT).body(loginErro);	
	}
	
	@ExceptionHandler(UsuarioSenhaIncorretaException.class)
	public ResponseEntity<LoginErro> UsuarioSenhaIncorretaException(UsuarioSenhaIncorretaException exception, HttpServletRequest request){
		
		LoginErro loginErro = new LoginErro(HttpStatus.UNAUTHORIZED.value(), "Usuário e/ou senha inválidos");
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginErro);	
	}

}
