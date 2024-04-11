package com.santanatextiles.alg.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;

public class LoteFiacaoDTO  implements Serializable {

	private static final float serialVersionUID = 1L;
	
	private String  idfil;	
	private String  tipoMaquina;	 
	private String  item;		 
	private Integer idSSM;
	private String  lote;  
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date    dataAbertura;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date    dataEncerramento ;
	private Double   qtdeAProduzir;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")	
	private String  dataInicial;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")	
	private String  dataFinal; 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")	
	private Date  dataInsercao;	 
	private String usuarioInsercao; 
	private String codFornElastano; 
	private String codFornPoliester; 
	private String nfFornElastano; 
	private String nfFornPoliester;	 
	private String nomeFornElastano; 
	private String nomeFornPoliester;	 
	private String obs; 
	private String obs1;	 
	private String ob2;	 
	private Double rpm; 
	private String turnoInicial;	
	
	@Column(name="J0TURNOF")
	private String turnoFinal;	 
	
	

	public LoteFiacaoDTO() {
		
	} 


	public LoteFiacaoDTO(String idfil, String tipoMaquina, String item, Integer idSSM, String lote, Date dataAbertura,
			Date dataEncerramento, Double qtdeAProduzir, String dataInicial, String dataFinal, Date dataInsercao,
			String usuarioInsercao, String codFornElastano, String codFornPoliester, String nfFornElastano,
			String nfFornPoliester, String nomeFornElastano, String nomeFornPoliester, String obs, String obs1,
			String ob2, Double rpm, String turnoInicial, String turnoFinal) {
		super();
		this.idfil = idfil;
		this.tipoMaquina = tipoMaquina;
		this.item = item;
		this.idSSM = idSSM;
		this.lote = lote;
		this.dataAbertura = dataAbertura;
		this.dataEncerramento = dataEncerramento;
		this.qtdeAProduzir = qtdeAProduzir;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.dataInsercao = dataInsercao;
		this.usuarioInsercao = usuarioInsercao;
		this.codFornElastano = codFornElastano;
		this.codFornPoliester = codFornPoliester;
		this.nfFornElastano = nfFornElastano;
		this.nfFornPoliester = nfFornPoliester;
		this.nomeFornElastano = nomeFornElastano;
		this.nomeFornPoliester = nomeFornPoliester;
		this.obs = obs;
		this.obs1 = obs1;
		this.ob2 = ob2;
		this.rpm = rpm;
		this.turnoInicial = turnoInicial;
		this.turnoFinal = turnoFinal;
	} 

	public LoteFiacaoDTO(String idfil, String tipoMaquina, String item, Integer idSSM, String lote) {
		super();
		this.idfil = idfil;
		this.tipoMaquina = tipoMaquina;
		this.item = item;
		this.idSSM = idSSM;
		this.lote = lote;
	}
	
	
	 

	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public String getTipoMaquina() {
		return tipoMaquina;
	}

	public void setTipoMaquina(String tipoMaquina) {
		this.tipoMaquina = tipoMaquina;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getIdSSM() {
		return idSSM;
	}

	public void setIdSSM(Integer idSSM) {
		this.idSSM = idSSM;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public Double getQtdeAProduzir() {
		return qtdeAProduzir;
	}

	public void setQtdeAProduzir(Double qtdeAProduzir) {
		this.qtdeAProduzir = qtdeAProduzir;
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


	public Date getDataInsercao() {
		return dataInsercao;
	}


	public void setDataInsercao(Date dataInsercao) {
		this.dataInsercao = dataInsercao;
	}


	public String getUsuarioInsercao() {
		return usuarioInsercao;
	}


	public void setUsuarioInsercao(String usuarioInsercao) {
		this.usuarioInsercao = usuarioInsercao;
	}


	public String getCodFornElastano() {
		return codFornElastano;
	}


	public void setCodFornElastano(String codFornElastano) {
		this.codFornElastano = codFornElastano;
	}


	public String getCodFornPoliester() {
		return codFornPoliester;
	}


	public void setCodFornPoliester(String codFornPoliester) {
		this.codFornPoliester = codFornPoliester;
	}


	public String getNfFornElastano() {
		return nfFornElastano;
	}


	public void setNfFornElastano(String nfFornElastano) {
		this.nfFornElastano = nfFornElastano;
	}


	public String getNfFornPoliester() {
		return nfFornPoliester;
	}


	public void setNfFornPoliester(String nfFornPoliester) {
		this.nfFornPoliester = nfFornPoliester;
	}


	public String getNomeFornElastano() {
		return nomeFornElastano;
	}


	public void setNomeFornElastano(String nomeFornElastano) {
		this.nomeFornElastano = nomeFornElastano;
	}


	public String getNomeFornPoliester() {
		return nomeFornPoliester;
	}


	public void setNomeFornPoliester(String nomeFornPoliester) {
		this.nomeFornPoliester = nomeFornPoliester;
	}


	public String getObs() {
		return obs;
	}


	public void setObs(String obs) {
		this.obs = obs;
	}


	public String getObs1() {
		return obs1;
	}


	public void setObs1(String obs1) {
		this.obs1 = obs1;
	}


	public String getOb2() {
		return ob2;
	}


	public void setOb2(String ob2) {
		this.ob2 = ob2;
	}


	public Double getRpm() {
		return rpm;
	}


	public void setRpm(Double rpm) {
		this.rpm = rpm;
	}


	public String getTurnoInicial() {
		return turnoInicial;
	}


	public void setTurnoInicial(String turnoInicial) {
		this.turnoInicial = turnoInicial;
	}


	public String getTurnoFinal() {
		return turnoFinal;
	}


	public void setTurnoFinal(String turnoFinal) {
		this.turnoFinal = turnoFinal;
	}
	
	
	
	
	
	
	
	
	

}
