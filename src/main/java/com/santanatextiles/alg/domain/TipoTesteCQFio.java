package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="CPFJ3_DBF",schema="CPF")
@IdClass(TipoTesteCQFioId.class)
public class TipoTesteCQFio implements Serializable {	 
	
	private static final long serialVersionUID = 1L;  
	
	@Id
	@Column(name="IDFIL")
	private String  idfil;
	
	@Id
	@Column(name="J3COD")
	private String codigo;	
	
	
	@Column(name="J3DESC")
	private String descricao;
 
	
	public TipoTesteCQFio() {
		
	}

 

	public TipoTesteCQFio(String idfil, String codigo, String descricao) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.descricao = descricao;
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
		TipoTesteCQFio other = (TipoTesteCQFio) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(idfil, other.idfil);
	}

 
	
	
	
	

}
