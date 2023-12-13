package com.santanatextiles.alg.dto;

import java.io.Serializable;

public class ProdutorDTO    implements Serializable {

	private static final long serialVersionUID = 1L;  
 
	private String idfil;  
	private String codigo;	  
	private String descricao;
	private String chave;
	
	public ProdutorDTO() {}	
	
	
	public ProdutorDTO(String idfil, String codigo, String descricao, String chave) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.descricao = descricao;
		this.chave = chave;
	}


	public String getIdfil() {
		return idfil;
	}


	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getdescricao() {
		return descricao;
	}


	public void setdescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getChave() {
		return chave;
	}


	public void setChave(String chave) {
		this.chave = chave;
	}	 
	
	
	
	

}
