package com.santanatextiles.alg.dto;

import java.io.Serializable;

import jakarta.persistence.Column;

public class PilhaDTO  implements Serializable {

	private static final long serialVersionUID = 1L;  
 
	private String idfil;  
	private String codigo;	  
	private String desricao;
	
	
	public PilhaDTO() {}	
	
	public PilhaDTO(String idfil, String codigo, String desricao) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.desricao = desricao;
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

	public String getDesricao() {
		return desricao;
	}

	public void setDesricao(String desricao) {
		this.desricao = desricao;
	}
	
	
	
	
	
	

}
