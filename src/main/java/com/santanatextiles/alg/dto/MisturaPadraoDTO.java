package com.santanatextiles.alg.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MisturaPadraoDTO  implements Serializable {

	private static final long serialVersionUID = 1L;  
 
	private String idfil; 	
	private String mistura;
	private String lote;	
    private String status;	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date   dataInicial;	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date   dataFinal;		
    private Double totalMisturas;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date   dataInclusao;
    private String usuarioInclusao;	 
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date   dataAlteracao;
    private String usuarioAlteracao;		 
    private String numMisturasLiberadas;		 	
    private String observacao;	 
    private Double numFardos;
    private Double pesoTotal; 
    
    private Set<MisturaPadraoItemDTO> misturaPadraoItemDTO = new HashSet<>();	
    
	public MisturaPadraoDTO() {}

	 
	
	
	
	public MisturaPadraoDTO(String idfil, String mistura, String lote, String status, Date dataInicial, Date dataFinal,
			Double totalMisturas, Date dataInclusao, String usuarioInclusao, Date dataAlteracao,
			String usuarioAlteracao, String numMisturasLiberadas, String observacao, Double numFardos, Double pesoTotal,
			Set<MisturaPadraoItemDTO> misturaPadraoItemDTO) {
		super();
		this.idfil = idfil;
		this.mistura = mistura;
		this.lote = lote;
		this.status = status;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.totalMisturas = totalMisturas;
		this.dataInclusao = dataInclusao;
		this.usuarioInclusao = usuarioInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usuarioAlteracao = usuarioAlteracao;
		this.numMisturasLiberadas = numMisturasLiberadas;
		this.observacao = observacao;
		this.numFardos = numFardos;
		this.pesoTotal = pesoTotal;
		this.misturaPadraoItemDTO = misturaPadraoItemDTO;
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

	public Set<MisturaPadraoItemDTO> getMisturaPadraoItemDTO() {
		return misturaPadraoItemDTO;
	}

	public void setMisturaPadraoItemDTO(Set<MisturaPadraoItemDTO> misturaPadraoItemDTO) {
		this.misturaPadraoItemDTO = misturaPadraoItemDTO;
	} 

	public Double getPesoTotal() {
		return pesoTotal;
	} 


	public void setPesoTotal(Double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}   
	
	

}
