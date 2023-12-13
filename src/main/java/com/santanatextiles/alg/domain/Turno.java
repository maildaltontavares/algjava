package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="PRDK1_DBF",schema="PRD")
@IdClass(TurnoId.class)
public class Turno implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDFIL")
	private String idfil;
	
	@Id
	@Column(name="K1CDTURN")
	private String codigo;
	
	@Column(name="K1HSINI")
	private Integer horaInicial;
	
	@Column(name="K1HSFIM")
	private Integer horaFinal; 
	
	public Turno() {
		
	}
	


	public Turno(String idfil, String codigo, Integer horaInicial, Integer horaFinal) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
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

	public Integer getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Integer horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Integer getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Integer horaFinal) {
		this.horaFinal = horaFinal;
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
		Turno other = (Turno) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(idfil, other.idfil);
	}

	
	

}
