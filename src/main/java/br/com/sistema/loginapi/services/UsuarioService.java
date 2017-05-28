package br.com.sistema.loginapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.sistema.loginapi.models.Usuario;
import br.com.sistema.loginapi.repository.UsuarioRepository;
import br.com.sistema.loginapi.services.exceptions.UsuarioNaoCadastradoExcepition;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> buscarTodos(){
		return repository.findAll();
	}
	
	public Usuario cadastrar(Usuario usuario) {
		usuario.setId(null);
		return repository.save(usuario);
	}
	
	public Usuario alterar(Usuario usuario) {
		consultar(usuario.getId());
		return repository.save(usuario);
		
	}
	
	public Usuario consultar(Long id) {
		Usuario usuario = repository.findOne(id);
		if(usuario == null) {
			throw new UsuarioNaoCadastradoExcepition("Usuario nao cadastrado");
		}
		
		return usuario;
	}
	
	public void remover(Long id) {
		try {
			repository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new UsuarioNaoCadastradoExcepition("Usuario nao Cadastrado");
		}
	}
	

}
