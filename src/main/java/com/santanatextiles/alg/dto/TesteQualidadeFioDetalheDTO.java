package com.santanatextiles.alg.dto;

import java.io.Serializable;

public class TesteQualidadeFioDetalheDTO  implements Serializable {

	private static final long serialVersionUID = 1L;   
	
	private Double id;	 
	private String idfil;   
	private Double idPai;	 
	private String seqProva; 
	private Integer numeroFusos; 
	private Double peso; 
	private Double titulo;
	
	
	public TesteQualidadeFioDetalheDTO() {
 
	}


	public TesteQualidadeFioDetalheDTO(Double id, String idfil, Double idPai, String seqProva, Integer numeroFusos,
			Double peso, Double titulo) {
		super();
		this.id = id;
		this.idfil = idfil;
		this.idPai = idPai;
		this.seqProva = seqProva;
		this.numeroFusos = numeroFusos;
		this.peso = peso;
		this.titulo = titulo;
	}


	public Double getId() {
		return id;
	}


	public void setId(Double id) {
		this.id = id;
	}


	public String getIdfil() {
		return idfil;
	}


	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}


	public Double getIdPai() {
		return idPai;
	}


	public void setIdPai(Double idPai) {
		this.idPai = idPai;
	}


	public String getSeqProva() {
		return seqProva;
	}


	public void setSeqProva(String seqProva) {
		this.seqProva = seqProva;
	}


	public Integer getNumeroFusos() {
		return numeroFusos;
	}


	public void setNumeroFusos(Integer numeroFusos) {
		this.numeroFusos = numeroFusos;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public Double getTitulo() {
		return titulo;
	}


	public void setTitulo(Double titulo) {
		this.titulo = titulo;
	}
	
	
	
	
	
	
	
	

}
