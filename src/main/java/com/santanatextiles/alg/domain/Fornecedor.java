package com.santanatextiles.alg.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="CCPB2_DBF",schema="CCP")
@IdClass(FornecedorId.class)
public class Fornecedor implements Serializable{ 
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDFIL")
	private String idfil;
	@Id
	@Column(name="B2COD")
	private String codigo;
	@Column(name="B2NOME")
	private String descricao;
	@Column(name="B2TIPO")
	private String tipo;
	@Column(name="B2CGCCPF")
	private String cnpj;
	@Column(name="B2TPENTIDA")
	private String tipoEntidade;

	public Fornecedor() {
		
	}
	
	public Fornecedor(String idfil, String codigo, String descricao, String tipo, String cnpj, String tipoEntidade) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipo = tipo;
		this.cnpj = cnpj;
		this.tipoEntidade = tipoEntidade;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getTipoEntidade() {
		return tipoEntidade;
	}

	public void setTipoEntidade(String tipoEntidade) {
		this.tipoEntidade = tipoEntidade;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((idfil == null) ? 0 : idfil.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (idfil == null) {
			if (other.idfil != null)
				return false;
		} else if (!idfil.equals(other.idfil))
			return false;
		return true;
	}
	
	
	
	


}
