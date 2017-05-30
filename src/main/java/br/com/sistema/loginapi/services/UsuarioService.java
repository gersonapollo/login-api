package br.com.sistema.loginapi.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.sistema.loginapi.models.Usuario;
import br.com.sistema.loginapi.repository.UsuarioRepository;
import br.com.sistema.loginapi.services.exceptions.UsuarioJaCadastradoExcepition;
import br.com.sistema.loginapi.services.exceptions.UsuarioNaoCadastradoExcepition;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> buscarTodos(){
		return repository.findAll();
	}
	
	public Usuario cadastrar(Usuario usuario) {
		verificaEmailCadastrado(usuario);
		usuario.setId(null);
		usuario.setDataCriacao(LocalDateTime.now());
		usuario.setDataAtualizacao(LocalDateTime.now());
		usuario.setUltimoLogin(LocalDateTime.now());
		usuario.setToken(UUID.randomUUID().toString());
		
		return repository.save(usuario);
	}
	
	
	public Usuario consultar(String id) {
		Usuario usuario = repository.findOne(id);
		if(usuario == null) {
			throw new UsuarioNaoCadastradoExcepition("Usuario nao cadastrado");
		}
		
		return usuario;
	}

	public Usuario alterar(Usuario usuario) {
		Usuario usuarioCadastrado = consultar(usuario.getId());
		
		usuario.setToken(usuarioCadastrado.getToken());
		usuario.setDataAtualizacao(LocalDateTime.now());
		usuario.setDataCriacao(usuarioCadastrado.getDataCriacao());
		usuario.setUltimoLogin(usuarioCadastrado.getUltimoLogin());

		return repository.save(usuario);
	}
	
	public void remover(String id) {
		try {
			repository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new UsuarioNaoCadastradoExcepition("Usuario nao Cadastrado");
		}
	}
	
	private void verificaEmailCadastrado(Usuario usuario) {
		Usuario usuarioCadastrado = repository.findByEmail(usuario.getEmail());
		if(usuarioCadastrado != null) {
				throw new UsuarioJaCadastradoExcepition("Email ja cadastrado");
		}
	}

}
