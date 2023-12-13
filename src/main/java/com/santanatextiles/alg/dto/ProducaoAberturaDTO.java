package com.santanatextiles.alg.dto;

import java.io.Serializable;
import java.util.Date;

public class ProducaoAberturaDTO    implements Serializable {

	private static final long serialVersionUID = 1L;  
 
	private String idfil;  
	private String mistura;	 
	private String seq;	 
	private Double idAutomatico; 
	private String maquina;	 
	private String localFisico;	 
	private String turno; 
	private String operador;		 
	private Date  dataMovimento; 
	private String observacao; 
	private String lado; 
	private Double horaMovimento; 
	private Date  dataInclusao; 
	private String usarioInclusao;	 
	private Date  dataAlteracao; 
    private String usarioAlteracao;
    
	public ProducaoAberturaDTO() {}    
    
	public ProducaoAberturaDTO(String idfil, String mistura, String seq, Double idAutomatico, String maquina,
			String localFisico, String turno, String operador, Date dataMovimento, String observacao, String lado,
			Double horaMovimento, Date dataInclusao, String usarioInclusao, Date dataAlteracao,
			String usarioAlteracao) {
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

	
	
	
    
    
    
    
    
}
