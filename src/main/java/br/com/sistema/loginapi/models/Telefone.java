package br.com.sistema.loginapi.models;

import javax.persistence.Embeddable;

@Embeddable
public class Telefone {
	
	private long numero;
	private int ddd;
	
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	
	

}
