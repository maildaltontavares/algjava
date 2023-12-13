package com.santanatextiles.alg.dto;

import java.io.Serializable;
import java.util.Date;

public class MisturaPadraoItemDTO   implements Serializable {	

	private static final long serialVersionUID = 1L;  
	
 
	private String  idfil;
	private String mistura;	
	private String idItem;	
	private Double quantidade;
 	private Date  dataInclusao; 
    private String usarioInclusao;	   
	private Date  dataAlteracao; 
    private String usarioAlteracao;
    
	public MisturaPadraoItemDTO() {}    
    
	public MisturaPadraoItemDTO(String idfil, String mistura, String idItem, Double quantidade, Date dataInclusao,
			String usarioInclusao, Date dataAlteracao, String usarioAlteracao) {
		super();
		this.idfil = idfil;
		this.mistura = mistura;
		this.idItem = idItem;
		this.quantidade = quantidade;
		this.dataInclusao = dataInclusao;
		this.usarioInclusao = usarioInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usarioAlteracao = usarioAlteracao;
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

	public String getIdItem() {
		return idItem;
	}

	public void setIdItem(String idItem) {
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

	public String getUsarioInclusao() {
		return usarioInclusao;
	}

	public void setUsarioInclusao(String usarioInclusao) {
		this.usarioInclusao = usarioInclusao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getUsarioAlteracao() {
		return usarioAlteracao;
	}

	public void setUsarioAlteracao(String usarioAlteracao) {
		this.usarioAlteracao = usarioAlteracao;
	}
	
	
    
    
    
    

}
