package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="CPFJ0_DBF",schema="CPF")
@IdClass(LoteFiacaoId.class)

public class LoteFiacao   implements Serializable {	

	private static final float serialVersionUID = 1L;
	
	@Id
	@Column(name="IDFIL")
	private String  idfil;
		
	@Id
	@Column(name="J0TPMAQ")
	private String tipoMaquina;
	
	@Id
	@Column(name="J0ITEM")
	private String item;
	
	@Id
	@Column(name="J0ID")
	private Integer idSSM;
	
	@Id
	@Column(name="J0LOTE")
	private String lote;
	
	@Column(name="J0DTABER")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataAbertura;
	
	@Column(name="J0DTENC")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataEncerramento;
	
	@Column(name="J0QTDPRD")
	private Double qtdeAProduzir; 
	  
	@Column(name="J0DTCRIA")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataInsercao;	
		 
	@Column(name="J0USRCRI")
	private String usuarioInsercao;
	 
	@Column(name="J0FORELAST")
	private String codFornElastano;
	
	@Column(name="J0FORPOLIE")
	private String codFornPoliester;	 
	
	@Column(name="J0NFELAS")
	private String nfFornElastano;
	
	@Column(name="J0NFPOLI")
	private String nfFornPoliester;	
	
	@Column(name="J0NMFORE")
	private String nomeFornElastano;
	
	@Column(name="J0NMFORP")
	private String nomeFornPoliester;	
	
	@Column(name="J0OBS")
	private String obs;
	
	@Column(name="J0OBS1")
	private String obs1;		
	
	@Column(name="J0OBS2")
	private String ob2;	
		
	@Column(name="J0RPM")
	private Double rpm;	
	
	@Column(name="J0TURNOI")
	private String turnoInicial;	
	
	@Column(name="J0TURNOF")
	private String turnoFinal;		 

	public LoteFiacao() {
		
	}
	
	 

	public LoteFiacao(String idfil, String tipoMaquina, String item, Integer idSSM, String lote, Date dataAbertura,
			Date dataEncerramento, Double qtdeAProduzir, Date dataInsercao, String usuarioInsercao,
			String codFornElastano, String codFornPoliester, String nfFornElastano, String nfFornPoliester,
			String nomeFornElastano, String nomeFornPoliester, String obs, String obs1, String ob2, Double rpm,
			String turnoInicial, String turnoFinal) {
		super();
		this.idfil = idfil;
		this.tipoMaquina = tipoMaquina;
		this.item = item;
		this.idSSM = idSSM;
		this.lote = lote;
		this.dataAbertura = dataAbertura;
		this.dataEncerramento = dataEncerramento;
		this.qtdeAProduzir = qtdeAProduzir;
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



	@Override
	public int hashCode() {
		return Objects.hash(idSSM, idfil, item, lote, tipoMaquina);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoteFiacao other = (LoteFiacao) obj;
		return Objects.equals(idSSM, other.idSSM) && Objects.equals(idfil, other.idfil)
				&& Objects.equals(item, other.item) && Objects.equals(lote, other.lote)
				&& Objects.equals(tipoMaquina, other.tipoMaquina);
	} 
	
	

}
