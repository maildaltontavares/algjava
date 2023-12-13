package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="CPFC3_DBF",schema="CPF")
@IdClass(MaquinaId.class)

public class Maquina implements Serializable {	

	private static final long serialVersionUID = 1L;	

	@Id
	@Column(name="IDFIL")
	private String  idfil;
	
	@Id
	@Column(name="C3COD")
	private String  codigo;
	
	@Column(name="C3DESC")
	private String  nome;
	
	@Column(name="C3EMP")
	private String  empresa;

	@Column(name="C3NUMFUS")
	private Integer numFusos;
	
	@Column(name="C3RPM")
	private Integer rpm;
	
	@Column(name="C3CDABER")
	private String  codigoAbertura;
	
	@Column(name="C3NUMSER")
	private String  numSerie;
	
	@Column(name="C3LOCAL")
	private String  localFisico;
	
	@Column(name="C3MQSSM")
	private String  mqSSM;
	
	@Column(name="C3LADO")
	private String  lado;
	
	@Column(name="C3TIT")
	private Double  titulo;
	
	@Column(name="C3HRDIA")
	private String  hrTrabDia;

	public Maquina() {
		
	}
	
	public Maquina(String idfil, String codigo, String nome, String empresa, Integer numFusos, Integer rpm,
			String codigoAbertura, String numSerie, String localFisico, String mqSSM, String lado, Double titulo,
			String hrTrabDia) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.nome = nome;
		this.empresa = empresa;
		this.numFusos = numFusos;
		this.rpm = rpm;
		this.codigoAbertura = codigoAbertura;
		this.numSerie = numSerie;
		this.localFisico = localFisico;
		this.mqSSM = mqSSM;
		this.lado = lado;
		this.titulo = titulo;
		this.hrTrabDia = hrTrabDia;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Integer getNumFusos() {
		return numFusos;
	}

	public void setNumFusos(Integer numFusos) {
		this.numFusos = numFusos;
	}

	public Integer getRpm() {
		return rpm;
	}

	public void setRpm(Integer rpm) {
		this.rpm = rpm;
	}

	public String getCodigoAbertura() {
		return codigoAbertura;
	}

	public void setCodigoAbertura(String codigoAbertura) {
		this.codigoAbertura = codigoAbertura;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getLocalFisico() {
		return localFisico;
	}

	public void setLocalFisico(String localFisico) {
		this.localFisico = localFisico;
	}

	public String getMqSSM() {
		return mqSSM;
	}

	public void setMqSSM(String mqSSM) {
		this.mqSSM = mqSSM;
	}

	public String getLado() {
		return lado;
	}

	public void setLado(String lado) {
		this.lado = lado;
	}

	public Double getTitulo() {
		return titulo;
	}

	public void setTitulo(Double titulo) {
		this.titulo = titulo;
	}

	public String getHrTrabDia() {
		return hrTrabDia;
	}

	public void setHrTrabDia(String hrTrabDia) {
		this.hrTrabDia = hrTrabDia;
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
		Maquina other = (Maquina) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(idfil, other.idfil);
	}	
	
	
	

}
