package com.santanatextiles.alg.dto;

import java.io.Serializable;
import java.util.Date;

public class MisturaPadraoDTO  implements Serializable {

	private static final long serialVersionUID = 1L;  
 
	private String idfil; 	
	private String mistura;
	private String lote;	
    private String status;		
	private Date   dataInicial;	
	private Date   dataFinal;		
    private Double totalMisturas;	
	private Date   dataInclusao;
    private String usarioInclusao;	 
	private Date   dataAlteracao;
    private String usarioAlteracao;		 
    private String numMisturasLiberadas;		 	
    private String observacao;	 
    private Double numFardos;
    
	public MisturaPadraoDTO() {}    
    
	public MisturaPadraoDTO(String idfil, String mistura, String lote, String status, Date dataInicial, Date dataFinal,
			Double totalMisturas, Date dataInclusao, String usarioInclusao, Date dataAlteracao, String usarioAlteracao,
			String numMisturasLiberadas, String observacao, Double numFardos) {
		super();
		this.idfil = idfil;
		this.mistura = mistura;
		this.lote = lote;
		this.status = status;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.totalMisturas = totalMisturas;
		this.dataInclusao = dataInclusao;
		this.usarioInclusao = usarioInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usarioAlteracao = usarioAlteracao;
		this.numMisturasLiberadas = numMisturasLiberadas;
		this.observacao = observacao;
		this.numFardos = numFardos;
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

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
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

	public Double getTotalMisturas() {
		return totalMisturas;
	}

	public void setTotalMisturas(Double totalMisturas) {
		this.totalMisturas = totalMisturas;
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

	public String getNumMisturasLiberadas() {
		return numMisturasLiberadas;
	}

	public void setNumMisturasLiberadas(String numMisturasLiberadas) {
		this.numMisturasLiberadas = numMisturasLiberadas;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Double getNumFardos() {
		return numFardos;
	}

	public void setNumFardos(Double numFardos) {
		this.numFardos = numFardos;
	}	 
	

}
