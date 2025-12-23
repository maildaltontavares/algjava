package com.santanatextiles.alg.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FardoDocumentoDTO  implements Serializable {

	private static final long serialVersionUID = 1L; 
	 
	private Double id;
	private String  idfil;
	private String  arquivoImportado; 
	private String  obs;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataInclusao; 
    private String usuarioInclusao;	  
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataAlteracao; 
    private String usuarioAlteracao;	 
	private Double idMov;	 
    private String produtor; 
    private String lote;	 
    private String nf;  
	private Set<FardoDocumentoItemDTO> fardoDocumentoItemDTO = new HashSet<>();
	
	public FardoDocumentoDTO() {
	 
	}

	public FardoDocumentoDTO(Double id, String idfil, String arquivoImportado, String obs, Date dataInclusao,
			String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao, Double idMov, String produtor,
			String lote, String nf, Set<FardoDocumentoItemDTO> fardoDocumentoItemDTO) {
		super();
		this.id = id;
		this.idfil = idfil;
		this.arquivoImportado = arquivoImportado;
		this.obs = obs;
		this.dataInclusao = dataInclusao;
		this.usuarioInclusao = usuarioInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usuarioAlteracao = usuarioAlteracao;
		this.idMov = idMov;
		this.produtor = produtor;
		this.lote = lote;
		this.nf = nf;
		this.fardoDocumentoItemDTO = fardoDocumentoItemDTO;
	} 

	public FardoDocumentoDTO(Double id, String idfil, String arquivoImportado, String obs, Date dataInclusao,
			String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao, Double idMov, String produtor,
			String lote, String nf) {
		super();
		this.id = id;
		this.idfil = idfil;
		this.arquivoImportado = arquivoImportado;
		this.obs = obs;
		this.dataInclusao = dataInclusao;
		this.usuarioInclusao = usuarioInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usuarioAlteracao = usuarioAlteracao;
		this.idMov = idMov;
		this.produtor = produtor;
		this.lote = lote;
		this.nf = nf;
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

	public String getArquivoImportado() {
		return arquivoImportado;
	}

	public void setArquivoImportado(String arquivoImportado) {
		this.arquivoImportado = arquivoImportado;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
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

	public Double getIdMov() {
		return idMov;
	}

	public void setIdMov(Double idMov) {
		this.idMov = idMov;
	}

	public String getProdutor() {
		return produtor;
	}

	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getNf() {
		return nf;
	}

	public void setNf(String nf) {
		this.nf = nf;
	}

	public Set<FardoDocumentoItemDTO> getFardoDocumentoItemDTO() {
		return fardoDocumentoItemDTO;
	}

	public void setFardoDocumentoItemDTO(Set<FardoDocumentoItemDTO> fardoDocumentoItemDTO) {
		this.fardoDocumentoItemDTO = fardoDocumentoItemDTO;
	}	 
	
	
	
	

	
	
	
	
	
	
	
	
}








