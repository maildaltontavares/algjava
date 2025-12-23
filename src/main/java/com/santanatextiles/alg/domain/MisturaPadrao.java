package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santanatextiles.alg.dto.MisturaPadraoItemDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="CPFT1_DBF",schema="CPF") 
@IdClass(MisturaPadraoId.class)

public class MisturaPadrao implements Serializable {	

	private static final long serialVersionUID = 1L;  
	
	@Id
	@Column(name="IDFIL")
	private String  idfil;
	
	@Id
	@Column(name="T1MIST")
	private String mistura;	

	@Column(name="T1LOTE")
	private String lote;	
 
	@Column(name="T1STATUS")
    private String status;		
	
	@Column(name="T1DTINI")
 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataInicial;	
 
	@Column(name="T1DTFIM")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataFinal;		
 
	@Column(name="T1QTDE")
    private Double totalMisturas;	
	 
	@Column(name="T1DTINC")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataInclusao;
		
	@Column(name="T1USRINC")
    private String usuarioInclusao;	 
	
	@Column(name="T1DTALT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataAlteracao;
		
	@Column(name="T1USRALT")
    private String usuarioAlteracao;		 
	
	@Column(name="T1QTDLIB")
    private String numMisturasLiberadas;		 	
 
	@Column(name="T1OBS")
    private String observacao;	 
 
	@Column(name="T1NUMFAR")
    private Double numFardos;   
	
	@OneToMany(mappedBy="misturaPadrao")
	private Set<MisturaPadraoItem> misturaPadraoItem = new HashSet<>();	  
	

	
	@Transient
	private Set<MisturaPadraoItemDTO> misturaPadraoItemDTO = new HashSet<>();		
	
	public MisturaPadrao() {}   
	 
	public MisturaPadrao(String idfil, String mistura, String lote, String status, Date dataInicial, Date dataFinal,
			Double totalMisturas, Date dataInclusao, String usuarioInclusao, Date dataAlteracao,
			String usuarioAlteracao, String numMisturasLiberadas, String observacao, Double numFardos,
			Set<MisturaPadraoItem> misturaPadraoItem, Set<MisturaPadraoItemDTO> misturaPadraoItemDTO) {
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
		this.misturaPadraoItem = misturaPadraoItem;
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

	public Set<MisturaPadraoItem> getMisturaPadraoItem() {
		return misturaPadraoItem;
	}

	public void setMisturaPadraoItem(Set<MisturaPadraoItem> misturaPadraoItem) {
		this.misturaPadraoItem = misturaPadraoItem;
	}

	public Set<MisturaPadraoItemDTO> getMisturaPadraoItemDTO() {
		return misturaPadraoItemDTO;
	}

	public void setMisturaPadraoItemDTO(Set<MisturaPadraoItemDTO> misturaPadraoItemDTO) {
		this.misturaPadraoItemDTO = misturaPadraoItemDTO;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idfil, mistura);
	} 

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MisturaPadrao other = (MisturaPadrao) obj;
		return Objects.equals(idfil, other.idfil) && Objects.equals(mistura, other.mistura);
	}	 
	
	

}
