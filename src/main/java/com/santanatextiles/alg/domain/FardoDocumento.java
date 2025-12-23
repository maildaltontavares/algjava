package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CPFT5_DBF",schema="CPF")
 
public class FardoDocumento  implements Serializable {	 
	
	private static final long serialVersionUID = 1L;
	
	@Id	
	@Column(name="T5IDMOV")
	private Double idMov;		
	
	@Column(name="T5ID")
	private Double id;	
	 
	@Column(name="IDFIL")
	private String  idfil;
	
	@Column(name="T5ARQIMP")
	private String  arquivoImportado;

	@Column(name="T5OBS")
	private String  obs;
	
	@Column(name="T5DTINC")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataInclusao;
		
	@Column(name="T5USRINC")
    private String usuarioInclusao;	 
	
	@Column(name="T5DTALT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataAlteracao;
		
	@Column(name="T5USRALT")
    private String usuarioAlteracao;	
	

	
	@Column(name="T5ORIG")
    private String produtor;	
	
	@Column(name="T5LOTE")
    private String lote;	
	
	@Column(name="T5DOC")
    private String nf; 
	
	@OneToMany(mappedBy="fardoDocumento")
	private Set<FardoDocumentoItem> fardoDocumentoItem = new HashSet<>();	 	
	

	public FardoDocumento() {
		 
	}

	 

	public FardoDocumento(Double id, String idfil, String arquivoImportado, String obs, Date dataInclusao,
			String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao, Double idMov, String produtor,
			String lote, String nf, Set<FardoDocumentoItem> fardoDocumentoItem) {
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
		this.fardoDocumentoItem = fardoDocumentoItem;
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

	
	
	
	
	public Set<FardoDocumentoItem> getFardoDocumentoItem() {
		return fardoDocumentoItem;
	}



	public void setFardoDocumentoItem(Set<FardoDocumentoItem> fardoDocumentoItem) {
		this.fardoDocumentoItem = fardoDocumentoItem;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FardoDocumento other = (FardoDocumento) obj;
		return Objects.equals(id, other.id);
	}	  
	
	
	
	 
	
	
	
	
	

}
