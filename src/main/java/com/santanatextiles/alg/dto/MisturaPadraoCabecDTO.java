package com.santanatextiles.alg.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santanatextiles.alg.projections.MisturaPadraoCabecProjection;

public class MisturaPadraoCabecDTO {
	
    String idfil;
    String mistura;	
    String loteFiacao;
    String status;  
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
    Date   dataInicial;	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
    Date   dataFinal;		
    Double quantidade;	 
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
    Date   dataInclusao;
    String usuarioInclusao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
    Date   dataAlteracao; 
    String usuarioAlteracao; 
    Double numMisturasLiberadas;	 
    Double numFardos;    
    Double totalUtilizadas; 
    String observacao;
    
    public MisturaPadraoCabecDTO() {
    	
    }  
    
	public MisturaPadraoCabecDTO(MisturaPadraoCabecProjection  projection ) {
		
		this.idfil      = projection.getIdfil();
		this.mistura    = projection.getMistura();
		this.loteFiacao = projection.getLoteFiacao();
		this.status     = projection.getStatus(); 
		this.dataInicial   = projection.getDataInicial();  
		this.dataFinal     = projection.getDataFinal(); 
		this.quantidade            = projection.getQuantidade(); 
		this.dataInclusao          = projection.getDataInclusao(); 
		this.usuarioInclusao        = projection.getUsuarioInclusao(); 
		this.dataAlteracao         = projection.getDataAlteracao(); 
		this.usuarioAlteracao       = projection.getUsuarioAlteracao(); 
		this.numMisturasLiberadas  = projection.getNumMisturasLiberadas(); 
		this.numFardos              = projection.getNumFardos(); 
		this.totalUtilizadas        = projection.getTotalUtilizadas(); 
		this.observacao             = projection.getObservacao(); 
		
		
		
	}

	public MisturaPadraoCabecDTO(String idfil, String mistura, String loteFiacao, String status, Date dataInicial,
			Date dataFinal, Double quantidade, Date dataInclusao, String usuarioInclusao, Date dataAlteracao,
			String usuarioAlteracao, Double numMisturasLiberadas, Double numFardos, Double totalUtilizadas,
			String observacao) {
		super();
		this.idfil = idfil;
		this.mistura = mistura;
		this.loteFiacao = loteFiacao;
		this.status = status;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.quantidade = quantidade;
		this.dataInclusao = dataInclusao;
		this.usuarioInclusao = usuarioInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usuarioAlteracao = usuarioAlteracao;
		this.numMisturasLiberadas = numMisturasLiberadas;
		this.numFardos = numFardos;
		this.totalUtilizadas = totalUtilizadas;
		this.observacao = observacao;
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

	public String getLoteFiacao() {
		return loteFiacao;
	}

	public void setLoteFiacao(String loteFiacao) {
		this.loteFiacao = loteFiacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
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

	public Double getNumMisturasLiberadas() {
		return numMisturasLiberadas;
	}

	public void setNumMisturasLiberadas(Double numMisturasLiberadas) {
		this.numMisturasLiberadas = numMisturasLiberadas;
	}

	public Double getNumFardos() {
		return numFardos;
	}

	public void setNumFardos(Double numFardos) {
		this.numFardos = numFardos;
	}

	public Double getTotalUtilizadas() {
		return totalUtilizadas;
	}

	public void setTotalUtilizadas(Double totalUtilizadas) {
		this.totalUtilizadas = totalUtilizadas;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}    

	 
	
	
	
	
	

}
