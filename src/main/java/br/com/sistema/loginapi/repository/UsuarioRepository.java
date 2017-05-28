package br.com.sistema.loginapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.loginapi.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	

}
