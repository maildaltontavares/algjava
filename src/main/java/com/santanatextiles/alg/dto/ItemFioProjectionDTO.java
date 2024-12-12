package com.santanatextiles.alg.dto;

import com.santanatextiles.alg.projections.FioProjection;

public class ItemFioProjectionDTO {
	
	String  idfil;
	String  codigo;
	Integer codMaterial;
	Integer localizacao;
	String  descricao;
	Float   titulo;
	Integer classeMaterial;
	String composicao; 
	
	
	public ItemFioProjectionDTO() {
	 
	}
 


	public ItemFioProjectionDTO(String idfil, String codigo, Integer codMaterial, Integer localizacao, String descricao,
			Float titulo, Integer classeMaterial, String composicao) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.codMaterial = codMaterial;
		this.localizacao = localizacao;
		this.descricao = descricao;
		this.titulo = titulo;
		this.classeMaterial = classeMaterial;
		this.composicao = composicao;
	}
	
	
	

	public ItemFioProjectionDTO(FioProjection projection ) { 
		
		this.idfil = projection.getIdfil();
		this.codigo = projection.getCodigo();
		this.codMaterial = projection.getCodMaterial();
		this.localizacao = projection.getLocalizacao();
		this.descricao = projection.getDescricao();
		this.titulo = projection.getTitulo();
		this.classeMaterial = projection.getClasseMaterial();
		this.composicao = projection.getComposicao();  
	
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



	public Integer getCodMaterial() {
		return codMaterial;
	}



	public void setCodMaterial(Integer codMaterial) {
		this.codMaterial = codMaterial;
	}



	public Integer getLocalizacao() {
		return localizacao;
	}



	public void setLocalizacao(Integer localizacao) {
		this.localizacao = localizacao;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public Float getTitulo() {
		return titulo;
	}



	public void setTitulo(Float titulo) {
		this.titulo = titulo;
	}



	public String getComposicao() {
		return composicao;
	}



	public void setComposicao(String composicao) {
		this.composicao = composicao;
	}



	public Integer getClasseMaterial() {
		return classeMaterial;
	}



	public void setClasseMaterial(Integer classeMaterial) {
		this.classeMaterial = classeMaterial;
	}
	
	
	
	
	

}
