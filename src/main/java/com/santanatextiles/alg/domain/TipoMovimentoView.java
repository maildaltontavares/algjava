package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="V_CPFM5",schema="CPF")
@IdClass(TipoMovimentoId.class)

public class TipoMovimentoView implements Serializable {	

	private static final long serialVersionUID = 1L;  
	
	@Id
	@Column(name="IDFIL")
	private String  idfil;
	
	@Id
	@Column(name="M5CDMOV",length = 5)
	private String codigo;	

	@Column(name="M5NMMOV")
	private String desricao;	 
	
	@Column(name="M5ENTSAI")
	private String entradaSaida;		
 
	@Column(name="M5ATLEST")
	private String atualizaEstoque;	
	
	@Column(name="M5ATLLOT")
	private String loteInternObrigatorio;	
	
	@Column(name="M5PESATL")
	private String pesoCalculadoInformado;	
	
	@Column(name="M5ATLITE")
	private String atualizaItem;
	
	public TipoMovimentoView() {
		
		
	}

	public TipoMovimentoView(String idfil, String codigo, String desricao, String entradaSaida, String atualizaEstoque,
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

	@Override
	public int hashCode() {
		return Objects.hash(codigo, idfil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoMovimentoView other = (TipoMovimentoView) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(idfil, other.idfil);
	}  
	
	
}	
 
