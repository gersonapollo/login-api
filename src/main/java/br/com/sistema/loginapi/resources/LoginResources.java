package br.com.sistema.loginapi.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sistema.loginapi.models.Usuario;
import br.com.sistema.loginapi.services.LoginService;
import br.com.sistema.loginapi.services.UsuarioService;

@RestController
@RequestMapping(value="/login")
public class LoginResources {
	
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Usuario> efetuaLogin(@RequestHeader(value="Authorization") String autorization) {
		Usuario usuario = loginService.validarUsuarioSenha(autorization);
		
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<Usuario> perfilUsuario(@PathVariable ("id") String id, @RequestHeader(value="Token") String token){
		Usuario usuario = loginService.obterPerfilUsuario(id, token);
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
		usuario = usuarioService.cadastrar(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).body(usuario);
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Usuario> alterarUsuario(@RequestBody Usuario usuario, @PathVariable("id") String id) {
		usuario.setId(id);
		usuario = usuarioService.alterar(usuario);
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}

}
