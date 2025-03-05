package com.santanatextiles.alg.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TesteQualidadeFioDTO implements Serializable {

	private static final long serialVersionUID = 1L;   
	
	private Double id;	 
	private String idfil;  
	private String tipoTesteFiacao; 
	private String dobradora; 	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date dataTeste;	 
	private String turno;	 
	private String operador; 
	private String localFisico;	 
	private String ladoMaquina;	 
	private String codigoMaquina; 
	private String item;	 
	private String loteFiacao; 
	private Double estiragem; 
	private String usuarioInclusao;	 
	private String usuarioAlteracao; 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataInclusao;	 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataAlteracao; 
	private Set<TesteQualidadeFioDetalheDTO> testeQualidadeFioDetalheDTO = new HashSet<>();
	private String observacao;		
	private String dataTesteParam;
	private String dataInicial;	
	private String dataFinal;
	private String tipoMaquina;	 
	private Integer hora;	 
	private String posicaoMaquina;	
	
	
	public TesteQualidadeFioDTO() { 
		
		
	}
 



	public TesteQualidadeFioDTO(Double id, String idfil, String turno, String localFisico, String item,
			String loteFiacao, String dataInicial, String dataFinal, String tipoMaquina) {
		super();
		this.id = id;
		this.idfil = idfil;
		this.turno = turno;
		this.localFisico = localFisico;
		this.item = item;
		this.loteFiacao = loteFiacao;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.tipoMaquina = tipoMaquina;
	} 



/*
	public TesteQualidadeFioDTO(Double id, String idfil, String tipoTesteFiacao, String dobradora, Date dataTeste,
			String turno, String operador, String localFisico, String ladoMaquina, String codigoMaquina, String item,
			String loteFiacao, Double estiragem, String usuarioInclusao, String usuarioAlteracao, Date dataInclusao,
			Date dataAlteracao, Set<TesteQualidadeFioDetalheDTO> testeQualidadeFioDetalheDTO, String observacao,
			String dataTesteParam, String dataInicial, String dataFinal, String tipoMaquina) {
		super();
		this.id = id;
		this.idfil = idfil;
		this.tipoTesteFiacao = tipoTesteFiacao;
		this.dobradora = dobradora;
		this.dataTeste = dataTeste;
		this.turno = turno;
		this.operador = operador;
		this.localFisico = localFisico;
		this.ladoMaquina = ladoMaquina;
		this.codigoMaquina = codigoMaquina;
		this.item = item;
		this.loteFiacao = loteFiacao;
		this.estiragem = estiragem;
		this.usuarioInclusao = usuarioInclusao;
		this.usuarioAlteracao = usuarioAlteracao;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
		this.testeQualidadeFioDetalheDTO = testeQualidadeFioDetalheDTO;
		this.observacao = observacao;
		this.dataTesteParam = dataTesteParam;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.tipoMaquina = tipoMaquina;
	}


*/ 






	public TesteQualidadeFioDTO(Double id, String idfil, String tipoTesteFiacao, String dobradora, Date dataTeste,
		String turno, String operador, String localFisico, String ladoMaquina, String codigoMaquina, String item,
		String loteFiacao, Double estiragem, String usuarioInclusao, String usuarioAlteracao, Date dataInclusao,
		Date dataAlteracao, Set<TesteQualidadeFioDetalheDTO> testeQualidadeFioDetalheDTO, String observacao,
		String dataTesteParam, String dataInicial, String dataFinal, String tipoMaquina, Integer hora,
		String posicaoMaquina) {
	super();
	this.id = id;
	this.idfil = idfil;
	this.tipoTesteFiacao = tipoTesteFiacao;
	this.dobradora = dobradora;
	this.dataTeste = dataTeste;
	this.turno = turno;
	this.operador = operador;
	this.localFisico = localFisico;
	this.ladoMaquina = ladoMaquina;
	this.codigoMaquina = codigoMaquina;
	this.item = item;
	this.loteFiacao = loteFiacao;
	this.estiragem = estiragem;
	this.usuarioInclusao = usuarioInclusao;
	this.usuarioAlteracao = usuarioAlteracao;
	this.dataInclusao = dataInclusao;
	this.dataAlteracao = dataAlteracao;
	this.testeQualidadeFioDetalheDTO = testeQualidadeFioDetalheDTO;
	this.observacao = observacao;
	this.dataTesteParam = dataTesteParam;
	this.dataInicial = dataInicial;
	this.dataFinal = dataFinal;
	this.tipoMaquina = tipoMaquina;
	this.hora = hora;
	this.posicaoMaquina = posicaoMaquina;
}



	public Double getId() {
		return id;
	}
	
	public Integer getHora() {
		return hora;
	}




	public void setHora(Integer hora) {
		this.hora = hora;
	}




	public String getPosicaoMaquina() {
		return posicaoMaquina;
	}




	public void setPosicaoMaquina(String posicaoMaquina) {
		this.posicaoMaquina = posicaoMaquina;
	}




	public void setId(Double id) {
		this.id = id;
	}


	public String getIdfil() {
		return idfil;
	}


	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}


	public String getTipoTesteFiacao() {
		return tipoTesteFiacao;
	}


	public void setTipoTesteFiacao(String tipoTesteFiacao) {
		this.tipoTesteFiacao = tipoTesteFiacao;
	}


	public String getDobradora() {
		return dobradora;
	}


	public void setDobradora(String dobradora) {
		this.dobradora = dobradora;
	}


	public Date getDataTeste() {
		return dataTeste;
	}


	public void setDataTeste(Date dataTeste) {
		this.dataTeste = dataTeste;
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


	public String getLocalFisico() {
		return localFisico;
	}


	public void setLocalFisico(String localFisico) {
		this.localFisico = localFisico;
	}


	public String getLadoMaquina() {
		return ladoMaquina;
	}


	public void setLadoMaquina(String ladoMaquina) {
		this.ladoMaquina = ladoMaquina;
	}


	public String getCodigoMaquina() {
		return codigoMaquina;
	}


	public void setCodigoMaquina(String codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public String getLoteFiacao() {
		return loteFiacao;
	}


	public void setLoteFiacao(String loteFiacao) {
		this.loteFiacao = loteFiacao;
	}


	public Double getEstiragem() {
		return estiragem;
	}


	public void setEstiragem(Double estiragem) {
		this.estiragem = estiragem;
	}


	public String getUsuarioInclusao() {
		return usuarioInclusao;
	}


	public void setUsuarioInclusao(String usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}


	public String getUsuarioAlteracao() {
		return usuarioAlteracao;
	}


	public void setUsuarioAlteracao(String usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}


	public Date getDataInclusao() {
		return dataInclusao;
	}


	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}


	public Date getDataAlteracao() {
		return dataAlteracao;
	}


	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}


	public Set<TesteQualidadeFioDetalheDTO> getTesteQualidadeFioDetalheDTO() {
		return testeQualidadeFioDetalheDTO;
	}


	public void setTesteQualidadeFioDetalheDTO(Set<TesteQualidadeFioDetalheDTO> testeQualidadeFioDetalheDTO) {
		this.testeQualidadeFioDetalheDTO = testeQualidadeFioDetalheDTO;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}




	public String getDataTesteParam() {
		return dataTesteParam;
	}




	public void setDataTesteParam(String dataTesteParam) {
		this.dataTesteParam = dataTesteParam;
	}







	public String getDataInicial() {
		return dataInicial;
	}







	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}







	public String getDataFinal() {
		return dataFinal;
	}







	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}







	public String getTipoMaquina() {
		return tipoMaquina;
	}







	public void setTipoMaquina(String tipoMaquina) {
		this.tipoMaquina = tipoMaquina;
	}

	
	
	
	
	
	
	
 
	 
	
	
	
	
	

}
