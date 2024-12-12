package com.santanatextiles.alg.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santanatextiles.alg.projections.TesteQualidadeFioProjection;

public class TesteQualidadeFioProjectionDTO {

	
	String  idfil;   
	String  loteFiacao;
	String  turno;
	String  descTipoMaquina;
	String  maquina;
	String  lado;
	String  item;
	String  descTipoTeste;
	Double  id; 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	Date    dataTeste;  
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	Date    dataInclusao; 
	String tipoMaquina;
	
	
	public TesteQualidadeFioProjectionDTO() {
 
	} 
	
	
	public TesteQualidadeFioProjectionDTO(TesteQualidadeFioProjection projection ) { 
		
		this.idfil   = projection.getIdfil();  
		this.loteFiacao = projection.getLoteFiacao(); 
		this.turno = projection.getTurno(); 
		this.descTipoMaquina = projection.getDescTipoMaquina(); 
		this.maquina = projection.getMaquina(); 
		this.lado = projection.getLado(); 
		this.item = projection.getItem(); 
		this.descTipoTeste =  projection.getDescTipoTeste(); 
		this.id =  projection.getId(); 
		this.dataTeste =  projection.getDataTeste(); 
		this.dataInclusao =  projection.getDataInclusao(); 		
		this.tipoMaquina =  projection.getTipoMaquina(); 	


	}	
 

	 


	public TesteQualidadeFioProjectionDTO(String idfil, String loteFiacao, String turno, String descTipoMaquina,
			String maquina, String lado, String item, String descTipoTeste, Double id, Date dataTeste,
			Date dataInclusao, String tipoMaquina) {
		super();
		this.idfil = idfil;
		this.loteFiacao = loteFiacao;
		this.turno = turno;
		this.descTipoMaquina = descTipoMaquina;
		this.maquina = maquina;
		this.lado = lado;
		this.item = item;
		this.descTipoTeste = descTipoTeste;
		this.id = id;
		this.dataTeste = dataTeste;
		this.dataInclusao = dataInclusao;
		this.tipoMaquina = tipoMaquina;
	}


	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public String getLoteFiacao() {
		return loteFiacao;
	}

	public void setLoteFiacao(String loteFiacao) {
		this.loteFiacao = loteFiacao;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getDescTipoMaquina() {
		return descTipoMaquina;
	}

	public void setDescTipoMaquina(String descTipoMaquina) {
		this.descTipoMaquina = descTipoMaquina;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public String getLado() {
		return lado;
	}

	public void setLado(String lado) {
		this.lado = lado;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDescTipoTeste() {
		return descTipoTeste;
	}

	public void setDescTipoTeste(String descTipoTeste) {
		this.descTipoTeste = descTipoTeste;
	}

	public Double getId() {
		return id;
	}

	public void setId(Double id) {
		this.id = id;
	}

	public Date getDataTeste() {
		return dataTeste;
	}

	public void setDataTeste(Date dataTeste) {
		this.dataTeste = dataTeste;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}


	public String getTipoMaquina() {
		return tipoMaquina;
	}


	public void setTipoMaquina(String tipoMaquina) {
		this.tipoMaquina = tipoMaquina;
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
