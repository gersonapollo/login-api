package br.com.sistema.loginapi.models;


public class LoginErro {
	
	private int statusHttp;
	private String mensagem;
	
	public LoginErro() {
	}
	
	public LoginErro(int statusHttp, String mensagem) {
		this.statusHttp = statusHttp;
		this.mensagem = mensagem;
	}
	
	public int getStatusHttp() {
		return statusHttp;
	}
	public void setStatusHttp(int statusHttp) {
		this.statusHttp = statusHttp;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	

}
