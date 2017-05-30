package br.com.sistema.loginapi;

import java.net.URI;

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
public class LoginResourceTests {
	
	private URI uri;
	private String url = "http://localhost:8080";
	private String urn = "/usuario";
	

	@Test
	public void obterTodosUsuariosTest() {
	
		RestTemplate restTemplate  = new RestTemplate();
		
		URI uri = URI.create(url+urn);
		RequestEntity<Void> request = RequestEntity.get(uri).header("Authorization", "").build();
		
		ResponseEntity<Usuario[]> response = restTemplate.exchange(request, Usuario[].class);
	}

}
