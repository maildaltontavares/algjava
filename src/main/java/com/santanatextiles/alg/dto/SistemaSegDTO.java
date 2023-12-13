package com.santanatextiles.alg.dto;

import jakarta.persistence.Column;

public class SistemaSegDTO { 
	
    private Long id; 
	private String sigla; 
	private String nome; 
	private String tipoLogin;	 
	private String tipoCodificacaoSenha; 
	
	public SistemaSegDTO() {
		 
	} 
 
	public SistemaSegDTO(Long id, String sigla, String nome, String tipoLogin, String tipoCodificacaoSenha) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
		this.tipoLogin = tipoLogin;
		this.tipoCodificacaoSenha = tipoCodificacaoSenha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoLogin() {
		return tipoLogin;
	}

	public void setTipoLogin(String tipoLogin) {
		this.tipoLogin = tipoLogin;
	}

	public String getTipoCodificacaoSenha() {
		return tipoCodificacaoSenha;
	}

	public void setTipoCodificacaoSenha(String tipoCodificacaoSenha) {
		this.tipoCodificacaoSenha = tipoCodificacaoSenha;
	}
	
	

	

}
