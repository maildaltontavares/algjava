package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="CPFT2_DBF",schema="CPF")
@IdClass(MisturaPadraoItemId.class)
public class MisturaPadraoItem   implements Serializable {	

	private static final long serialVersionUID = 1L;  
	
	@Id
	@Column(name="IDFIL")
	private String  idfil;
	
	@Id
	@Column(name="T2MIST")
	private String mistura;	

	@Id
	@Column(name="T2ID")
	private Double idItem;	
	
	@Column(name="T2QTDE")  
	private Double quantidade;	 

	@Column(name="T2DTINC")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataInclusao;
		
	@Column(name="T2USRINC")
    private String usuarioInclusao;	 
	
	@Column(name="T2DTALT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataAlteracao;
		
	@Column(name="T2USRALT")
    private String usuarioAlteracao;
	
	 
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({	   
	    @JoinColumn(name="IDFIL", referencedColumnName="IDFIL", insertable = false, updatable = false),
	    @JoinColumn(name="T2MIST", referencedColumnName="T1MIST", insertable = false, updatable = false) 
	})
	private MisturaPadrao misturaPadrao;	      
 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({	    
	    @JoinColumn(name="T2ID", referencedColumnName="M4ID", insertable = false, updatable = false) 
	})
	private EstoqueMP fkItemMistura	;		
	 
	
	public MisturaPadraoItem() {}	 
	

	public MisturaPadraoItem(String idfil, String mistura, Double idItem, Double quantidade, Date dataInclusao,
			String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao, MisturaPadrao misturaPadrao,
			EstoqueMP fkItemMistura) {
		super();
		this.idfil = idfil;
		this.mistura = mistura;
		this.idItem = idItem;
		this.quantidade = quantidade;
		this.dataInclusao = dataInclusao;
		this.usuarioInclusao = usuarioInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usuarioAlteracao = usuarioAlteracao;
		this.misturaPadrao = misturaPadrao;
		this.fkItemMistura = fkItemMistura;
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


	public MisturaPadrao getMisturaPadrao() {
		return misturaPadrao;
	}


	public void setMisturaPadrao(MisturaPadrao misturaPadrao) {
		this.misturaPadrao = misturaPadrao;
	}


	public EstoqueMP getFkItemMistura() {
		return fkItemMistura;
	}


	public void setFkItemMistura(EstoqueMP fkItemMistura) {
		this.fkItemMistura = fkItemMistura;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idItem, idfil, mistura);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MisturaPadraoItem other = (MisturaPadraoItem) obj;
		return Objects.equals(idItem, other.idItem) && Objects.equals(idfil, other.idfil)
				&& Objects.equals(mistura, other.mistura);
	}	 
	
	
}	
 
