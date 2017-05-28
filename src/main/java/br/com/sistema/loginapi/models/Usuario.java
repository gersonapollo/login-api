package br.com.sistema.loginapi.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Usuario {
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	String nome;
	String Email;
	String Senha;
	
	@JsonInclude(Include.NON_NULL)
	LocalDateTime dataCracao;
	@JsonInclude(Include.NON_NULL)
	LocalDateTime dataAtualizacao;
	@JsonInclude(Include.NON_NULL)
	LocalDateTime ultimologin;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public LocalDateTime getDataCracao() {
		return dataCracao;
	}
	public void setDataCracao(LocalDateTime dataCracao) {
		this.dataCracao = dataCracao;
	}
	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public LocalDateTime getUltimologin() {
		return ultimologin;
	}
	public void setUltimologin(LocalDateTime ultimologin) {
		this.ultimologin = ultimologin;
	}
	
	
	

}
