package br.com.sistema.loginapi.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Usuario {
	
	
	private String id;
	private String nome;
	private String email;
	private String senha;
	private String token;
	private List<Telefone> telefones;
	LocalDateTime dataCriacao;
	LocalDateTime dataAtualizacao;
	LocalDateTime ultimoLogin;
	
	
	@Id @GeneratedValue(generator="usuario-uuid")
	@GenericGenerator(name="usuario-uuid", strategy="uuid2")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@JsonProperty(access = Access.WRITE_ONLY)
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	@ElementCollection
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	@JsonFormat(pattern="dd/MM/yyyy - HH:mm")
	@JsonInclude(Include.NON_NULL)
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@JsonFormat(pattern="dd/MM/yyyy - HH:mm")
	@JsonInclude(Include.NON_NULL)
	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	@JsonFormat(pattern="dd/MM/yyyy - HH:mm")
	@JsonInclude(Include.NON_NULL)
	public LocalDateTime getUltimoLogin() {
		return ultimoLogin;
	}
	public void setUltimoLogin(LocalDateTime ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}

}
