package br.com.sistema.loginapi.services;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.loginapi.models.Usuario;
import br.com.sistema.loginapi.repository.UsuarioRepository;
import br.com.sistema.loginapi.services.exceptions.SessaoInvalidaException;
import br.com.sistema.loginapi.services.exceptions.TokenUsuarioInvalidoException;
import br.com.sistema.loginapi.services.exceptions.UsuarioSenhaIncorretaException;

@Service
public class LoginService {

	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public Usuario validarUsuarioSenha(String autorization) {
		System.out.println(autorization);
		
		String[] auth = autorization.split(" ");
		Arrays.asList(auth).forEach(System.out::println);
		String[] dados = new String(Base64.getDecoder().decode(auth[1])).split(":");
		String email = dados[0];
		String senha = dados[1];
		
		Usuario usuario = consultar(email);
		validarSenha(usuario, senha);
		
		usuario.setUltimoLogin(LocalDateTime.now());
		usuarioService.atualizar(usuario);
		
		return usuario;
	}
	
	public Usuario consultar(String email) {
		Usuario usuario = repository.findByEmail(email);
		if(usuario == null) {
			throw new UsuarioSenhaIncorretaException("Email nao Cadastrado!");
		}
		
		return usuario;
	}
	
	public Usuario obterPerfilUsuario(String id, String token) {
		
		Usuario usuario = usuarioService.consultar(id);
		validarTokenUsuario(usuario, token);
		return usuario;
	}
	
	private void validarSenha(Usuario usuario, String senha) {
		if(!senha.equals(usuario.getSenha())) {
			throw new UsuarioSenhaIncorretaException("Senha Inválida!");
		}
	}
	
	private void validarTokenUsuario(Usuario usuario, String token) {
		String tokenCadastrado = usuario.getToken();
		if (token.trim().isEmpty() || !tokenCadastrado.equals(token)) {
			throw new TokenUsuarioInvalidoException("Token inválido!");
		}
		LocalDateTime trintaMinutosAtras = LocalDateTime.now().minusMinutes(30l);
		System.out.println(trintaMinutosAtras);
		System.out.println(usuario.getUltimoLogin());
		int comparacao = usuario.getUltimoLogin().compareTo(trintaMinutosAtras);
		System.out.println(comparacao);
		if(comparacao < 0) {
			 throw new SessaoInvalidaException("Sessao Inválida");
		}
		
	}
	

	
}
