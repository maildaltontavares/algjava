package com.santanatextiles.alg.dto;

import java.io.Serializable;

public class TipoMateriaPrimaDTO   implements Serializable {

	private static final long serialVersionUID = 1L;  
 
	private String idfil;  
	private String codigo;	  
	private String desricao;
    private String especieMP;
    
    
    public TipoMateriaPrimaDTO() {}
    
    
	public TipoMateriaPrimaDTO(String idfil, String codigo, String desricao, String especieMP) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.desricao = desricao;
		this.especieMP = especieMP;
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


	public String getEspecieMP() {
		return especieMP;
	}


	public void setEspecieMP(String especieMP) {
		this.especieMP = especieMP;
	}
	
	
	
	
    
    

}
