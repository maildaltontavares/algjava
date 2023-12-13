package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="CPFT3_DBF",schema="CPF")
@IdClass(ProducaoAberturaId.class)


public class ProducaoAbertura  implements Serializable {	

	private static final long serialVersionUID = 1L;  
	
	@Id
	@Column(name="IDFIL")
	private String  idfil;
	
	@Id
	@Column(name="T3MIST")
	private String mistura;	

	@Id
	@Column(name="T3SEQ")
	private String seq;	
	
	@Column(name="T3IDAUTO")
	private Double idAutomatico;			
	
	@Column(name="T3CODMAQ")
	private String maquina;	 
		
	@Column(name="T3LF")
	private String localFisico;	
	
	@Column(name="T3TURNO")
	private String turno;	
	
	@Column(name="T3OPER")
	private String operador;	
	
	@Column(name="T3DTMOV")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataMovimento;	 
	
	@Column(name="T3OBS")
	private String observacao;		
	
	@Column(name="T3LADO")
	private String lado;	 
	 
	@Column(name="T3HRINI")
	private Double horaMovimento;	 
		
	@Column(name="T3DTINC")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataInclusao;
		
	@Column(name="T3USRINC")
    private String usarioInclusao;	 
	
	@Column(name="T3DTALT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataAlteracao;
		
	@Column(name="T3USRALT")
    private String usarioAlteracao;
	
 
	@ManyToOne 
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column=@JoinColumn(name="T3CODMAQ", referencedColumnName="C3COD", insertable = false, updatable = false)),
		@JoinColumnOrFormula(formula=@JoinFormula(value="idfil", referencedColumnName="idfil"))	
	})		 
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Maquina fkMaquina	;		
	 	
	
	
	@ManyToOne 
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column=@JoinColumn(name="T3TURNO", referencedColumnName="K1CDTURN", insertable = false, updatable = false)),
		@JoinColumnOrFormula(formula=@JoinFormula(value="idfil", referencedColumnName="idfil"))	
	})		 
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Turno fkTurno	;		
	
	public ProducaoAbertura() {} 

	public ProducaoAbertura(String idfil, String mistura, String seq, Double idAutomatico, String maquina,
			String localFisico, String turno, String operador, Date dataMovimento, String observacao, String lado,
			Double horaMovimento, Date dataInclusao, String usarioInclusao, Date dataAlteracao, String usarioAlteracao,
			Maquina fkMaquina, Turno fkTurno) {
		super();
		this.idfil = idfil;
		this.mistura = mistura;
		this.seq = seq;
		this.idAutomatico = idAutomatico;
		this.maquina = maquina;
		this.localFisico = localFisico;
		this.turno = turno;
		this.operador = operador;
		this.dataMovimento = dataMovimento;
		this.observacao = observacao;
		this.lado = lado;
		this.horaMovimento = horaMovimento;
		this.dataInclusao = dataInclusao;
		this.usarioInclusao = usarioInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usarioAlteracao = usarioAlteracao;
		this.fkMaquina = fkMaquina;
		this.fkTurno = fkTurno;
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

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public Double getIdAutomatico() {
		return idAutomatico;
	}

	public void setIdAutomatico(Double idAutomatico) {
		this.idAutomatico = idAutomatico;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public String getLocalFisico() {
		return localFisico;
	}

	public void setLocalFisico(String localFisico) {
		this.localFisico = localFisico;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public Date getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getLado() {
		return lado;
	}

	public void setLado(String lado) {
		this.lado = lado;
	}

	public Double getHoraMovimento() {
		return horaMovimento;
	}

	public void setHoraMovimento(Double horaMovimento) {
		this.horaMovimento = horaMovimento;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getUsarioInclusao() {
		return usarioInclusao;
	}

	public void setUsarioInclusao(String usarioInclusao) {
		this.usarioInclusao = usarioInclusao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getUsarioAlteracao() {
		return usarioAlteracao;
	}

	public void setUsarioAlteracao(String usarioAlteracao) {
		this.usarioAlteracao = usarioAlteracao;
	}

	public Maquina getFkMaquina() {
		return fkMaquina;
	}

	public void setFkMaquina(Maquina fkMaquina) {
		this.fkMaquina = fkMaquina;
	}

	public Turno getFkTurno() {
		return fkTurno;
	}

	public void setFkTurno(Turno fkTurno) {
		this.fkTurno = fkTurno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idfil, mistura, seq);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProducaoAbertura other = (ProducaoAbertura) obj;
		return Objects.equals(idfil, other.idfil) && Objects.equals(mistura, other.mistura)
				&& Objects.equals(seq, other.seq);
	}			
	
	
	
	
	
	
	
	
			
	
	
	 

}
