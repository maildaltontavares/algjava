package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="CPFN4_DBF",schema="CPF")
@IdClass(ColoracaoId.class)
public class Coloracao implements Serializable {	 
	
	private static final long serialVersionUID = 1L;  
	
	@Id
	@Column(name="IDFIL")
	private String  idfil;
	
	@Id
	@Column(name="N4COD")
	private String codigo;	
	
	
	@Column(name="N4DESC")
	private String desricao;

	@Column(name="N4CHAVE")
	private String chave;
	
	public Coloracao() {
		
	}

	public Coloracao(String idfil, String codigo, String desricao, String chave) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.desricao = desricao;
		this.chave = chave;
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

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
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
		Coloracao other = (Coloracao) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(idfil, other.idfil);
	}	
	
	
	
	
	
	
	

}
