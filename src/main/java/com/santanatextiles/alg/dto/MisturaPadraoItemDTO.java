package com.santanatextiles.alg.dto;

import java.io.Serializable;
import java.util.Date;

public class MisturaPadraoItemDTO   implements Serializable {	

	private static final long serialVersionUID = 1L;  
	
 
	private String  idfil;
	private String mistura;	
	private Double idItem;	
	private Double quantidade;
 	private Date  dataInclusao; 
    private String usuarioInclusao;	   
	private Date  dataAlteracao; 
    private String usuarioAlteracao;
    
	public MisturaPadraoItemDTO() {}

	public MisturaPadraoItemDTO(String idfil, String mistura, Double idItem, Double quantidade, Date dataInclusao,
			String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
		super();
		this.idfil = idfil;
		this.mistura = mistura;
		this.idItem = idItem;
		this.quantidade = quantidade;
		this.dataInclusao = dataInclusao;
		this.usuarioInclusao = usuarioInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usuarioAlteracao = usuarioAlteracao;
	}

	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public String getMistura() {
		return mistura;
	}

	public void setMistura(String mistura) {
		this.mistura = mistura;
	}

	public Double getIdItem() {
		return idItem;
	}

	public void setIdItem(Double idItem) {
		this.idItem = idItem;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getUsuarioInclusao() {
		return usuarioInclusao;
	}

	public void setUsuarioInclusao(String usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(String usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}    
    
	 
	
    
    
    
    

}
