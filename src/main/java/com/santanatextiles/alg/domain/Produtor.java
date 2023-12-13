package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="CPFM6_DBF",schema="CPF")
@IdClass(ProdutorId.class)
public class Produtor implements Serializable {	

	private static final long serialVersionUID = 1L;  
	
	@Id
	@Column(name="IDFIL")
	private String  idfil;
	
	@Id
	@Column(name="M6COD")
	private String codigo;	
	
	
	@Column(name="M6DESC")
	private String descricao;		
 

	public Produtor() {
		
	} 
	
	
	public Produtor(String idfil, String codigo, String descricao) {
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


	public String getdescricao() {
		return descricao;
	}


	public void setdescricao(String descricao) {
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
		Produtor other = (Produtor) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(idfil, other.idfil);
	} 
	
  
	

}
