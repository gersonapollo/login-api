package br.com.sistema.loginapi.models;


public class LoginErro {
	
	private Long statusHttp;
	private String mensagem;
	
	public LoginErro() {
	}
	
	public LoginErro(Long statusHttp, String mensagem) {
		this.statusHttp = statusHttp;
		this.mensagem = mensagem;
	}
	
	public Long getStatusHttp() {
		return statusHttp;
	}
	public void setStatusHttp(Long statusHttp) {
		this.statusHttp = statusHttp;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	

}
