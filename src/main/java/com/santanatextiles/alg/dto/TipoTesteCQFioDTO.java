package com.santanatextiles.alg.dto;

import java.io.Serializable;

public class TipoTesteCQFioDTO implements Serializable {

	private static final long serialVersionUID = 1L;  
 
	
	private String  idfil; 
	private String codigo;	 
	private String descricao;
	
	
	public TipoTesteCQFioDTO() { 
		
		
	}


	public TipoTesteCQFioDTO(String idfil, String codigo, String descricao) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.descricao = descricao;
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

 
	
	
}
