package br.com.sistema.loginapi;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.com.sistema.loginapi.models.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioResourceTests {
	
	private URI uri;
	private String url;
	private String urn;
	RestTemplate restTemplate;

	@Before
	public void prepararDadosParaTestes() {
		url = "http://localhost:8080";
		urn = "/usuario";
		uri = URI.create(url+urn);
	}

	@Test
	public void obterTodosUsuariosTest() {
		restTemplate  = new RestTemplate();
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<Usuario[]> response = restTemplate.exchange(request, Usuario[].class);
		List<Usuario> listaUsuarios = Arrays.asList(response.getBody());
		Assert.assertTrue(listaUsuarios.isEmpty());
	}
	
	@Test
	public void cadastrarUsuarioTest() {
		restTemplate  = new RestTemplate();
		Usuario usuario = new Usuario();
		usuario.setNome("Gerson Reis");
		usuario.setEmail("gerson.gerson@gerson.com");
		usuario.setSenha("SenhaSecreta");
		
		RequestEntity<Usuario> request = RequestEntity.post(uri).body(usuario);
		
		ResponseEntity<Usuario> response = restTemplate.exchange(request, Usuario.class);
		
		Usuario usuarioCadastrado = response.getBody();
		
		Assert.assertEquals("Gerson Reis", usuarioCadastrado.getNome());
		
		
	}

}
