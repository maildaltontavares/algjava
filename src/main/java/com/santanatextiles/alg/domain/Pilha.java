package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="CPFS1_DBF",schema="CPF")
@IdClass(PilhaId.class)
public class Pilha implements Serializable {	

	private static final long serialVersionUID = 1L;  
	
	@Id
	@Column(name="IDFIL")
	private String  idfil;
	
	@Id
	@Column(name="S1COD")
	private String codigo;	
	
	
	@Column(name="S1DESC")
	private String desricao;

	
	public Pilha() {
		
	}

	public Pilha(String idfil, String codigo, String desricao) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.desricao = desricao;
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
		Pilha other = (Pilha) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(idfil, other.idfil);
	} 
	
	 
	

}
