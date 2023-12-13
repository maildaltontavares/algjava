package com.santanatextiles.alg.dto;

import java.io.Serializable;

import jakarta.persistence.Column;

public class TipoMovimentoDTO    implements Serializable {

	private static final long serialVersionUID = 1L;  
 
	private String idfil;  
	private String codigo;	  
	private String desricao; 
	private String entradaSaida;	 
	private String atualizaEstoque;	 
	private String loteInternObrigatorio; 
	private String pesoCalculadoInformado; 
	private String atualizaItem;
	
	public TipoMovimentoDTO() {}	
	
	public TipoMovimentoDTO(String idfil, String codigo, String desricao, String entradaSaida, String atualizaEstoque,
			String loteInternObrigatorio, String pesoCalculadoInformado, String atualizaItem) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.desricao = desricao;
		this.entradaSaida = entradaSaida;
		this.atualizaEstoque = atualizaEstoque;
		this.loteInternObrigatorio = loteInternObrigatorio;
		this.pesoCalculadoInformado = pesoCalculadoInformado;
		this.atualizaItem = atualizaItem;
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

	public String getEntradaSaida() {
		return entradaSaida;
	}

	public void setEntradaSaida(String entradaSaida) {
		this.entradaSaida = entradaSaida;
	}

	public String getAtualizaEstoque() {
		return atualizaEstoque;
	}

	public void setAtualizaEstoque(String atualizaEstoque) {
		this.atualizaEstoque = atualizaEstoque;
	}

	public String getLoteInternObrigatorio() {
		return loteInternObrigatorio;
	}

	public void setLoteInternObrigatorio(String loteInternObrigatorio) {
		this.loteInternObrigatorio = loteInternObrigatorio;
	}

	public String getPesoCalculadoInformado() {
		return pesoCalculadoInformado;
	}

	public void setPesoCalculadoInformado(String pesoCalculadoInformado) {
		this.pesoCalculadoInformado = pesoCalculadoInformado;
	}

	public String getAtualizaItem() {
		return atualizaItem;
	}

	public void setAtualizaItem(String atualizaItem) {
		this.atualizaItem = atualizaItem;
	}	
	
	
	
	
	
	
	
	
	
	
	

}
