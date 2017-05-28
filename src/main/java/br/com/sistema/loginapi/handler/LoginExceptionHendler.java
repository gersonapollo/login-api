package br.com.sistema.loginapi.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.sistema.loginapi.models.LoginErro;
import br.com.sistema.loginapi.services.exceptions.UsuarioNaoCadastradoExcepition;

@ControllerAdvice
public class LoginExceptionHendler {
	
	
	@ExceptionHandler(UsuarioNaoCadastradoExcepition.class)
	public ResponseEntity<LoginErro> UsuarioNaoCadastradoException(UsuarioNaoCadastradoExcepition exception, HttpServletRequest request){
		
		LoginErro loginErro = new LoginErro(404l, "Usuário não Cadastrado");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(loginErro);	
	}

}
