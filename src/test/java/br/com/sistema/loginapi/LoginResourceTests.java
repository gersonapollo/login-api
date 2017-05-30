package br.com.sistema.loginapi;

import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.com.sistema.loginapi.models.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginResourceTests {
	
	private URI uri;
	private String url;
	private String urn;
	RestTemplate restTemplate;

	@Before
	public void prepararDadosParaTestes() {
		url = "http://localhost:8080";
		urn = "/login";
		uri = URI.create(url+urn);
		restTemplate  = new RestTemplate();
	}

	@Test
	public void cadastrarUsuarioTest() {
		Usuario usuario = new Usuario();
		usuario.setNome("Gerson Reis");
		usuario.setEmail("gerson.gerson@gerson.com");
		usuario.setSenha("SenhaSecreta");
		
		RequestEntity<Usuario> request = RequestEntity.post(uri).body(usuario);
		
		ResponseEntity<Usuario> response = restTemplate.exchange(request, Usuario.class);
		
		Usuario usuarioCadastrado = response.getBody();
		
		Assert.assertEquals("Gerson Reis", usuarioCadastrado.getNome());
		Assert.assertTrue(!usuarioCadastrado.getId().isEmpty());
	}
	
	@Test
	public void efetuarLogin() {
		String email = "gerson.gerson@gerson.com";
		String senha = "SenhaSecreta";
		String parametroSeguranca = Base64.getEncoder().encodeToString((email+":"+senha).getBytes()); 
		RequestEntity<Void> request = RequestEntity.get(uri).header("Authorization", "Basic "+parametroSeguranca).build();
		
		ResponseEntity<Usuario> response = restTemplate.exchange(request, Usuario.class);
		
		Usuario usuario = response.getBody();
		
		Assert.assertEquals("Gerson Reis", usuario.getNome());
	}
	

}
