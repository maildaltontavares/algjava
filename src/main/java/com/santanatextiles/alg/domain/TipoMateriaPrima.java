package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table; 
	
@Entity
@Table(name="CPFM8_DBF",schema="CPF")
@IdClass(TipoMateriaPrimaId.class)

public class TipoMateriaPrima implements Serializable {	

	private static final long serialVersionUID = 1L;  
	
	@Id
	@Column(name="IDFIL")
	private String  idfil;
	
	@Id
	@Column(name="M8COD")
	private String codigo;	

	@Column(name="M8DESC")
    private String desricao;	 	
	
	
	@Column(name="M8TPITE")
    private String especieMP;


	public TipoMateriaPrima() {
		
	}
	
	public TipoMateriaPrima(String idfil, String codigo, String desricao, String especieMP) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.desricao = desricao;
		this.especieMP = especieMP;
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

	public String getEspecieMP() {
		return especieMP;
	}

	public void setEspecieMP(String especieMP) {
		this.especieMP = especieMP;
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
		TipoMateriaPrima other = (TipoMateriaPrima) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(idfil, other.idfil);
	}	
	
	
	 
	
	
	
	

}
