package br.com.sistema.loginapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sistema.loginapi.models.Usuario;
import br.com.sistema.loginapi.services.UsuarioService;

@RestController
@RequestMapping(value="/login")
public class LoginResources {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> efetuarLogin() {
		List<Usuario> list = usuarioService.buscarTodos();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<?> buscarUsuario(@PathVariable("id") Long id) {
		Usuario usuario = usuarioService.consultar(id);
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> cadastrarUsuario(@RequestBody Usuario usuario) {
		usuario = usuarioService.cadastrar(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> removerUsuario(@PathVariable("id") Long id) {
		usuarioService.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Void> alterarUsuario(@RequestBody Usuario usuario, @PathVariable("id") Long id) {
		usuario.setId(id);
		usuarioService.alterar(usuario);
		return ResponseEntity.noContent().build();
	}
}
