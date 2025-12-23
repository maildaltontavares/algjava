package com.santanatextiles.alg.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;

public class FardoDocumentoItemDTO implements Serializable {	 
	
	private static final long serialVersionUID = 1L;  
	
	 
	private Double id;	 	 
	private Double idPai;	 
	private String  idfil; 
	private Double idMov; 
	private Double idFardo;
	private String numeroFardo;    
	private String produtor;  
	private String lote; 
	private String qualidade;	 
	private String tamanho;	 
	private Double peso;	 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date dataInclusao; 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date dataAlteracao;	  
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date dataMovimentacao;	  
	private String usuarioInclusao;	 
	private String usuarioAlteracao;   
	private Double sac;	  
	private Double trid;	 
	private Double pim;	  
	private Double sc;	  
	private Double mst;	 
	private Double mic;	  
	private Double mat;	 
	private Double ui;	 
	private Double sf;	 
	private Double str;	 
	private Double elg;	 
	private Double tipo; 
	private Double sic;	 
	private Double uhml; 
	private Double rs;	 
	private Double b; 
	private Double trcnt; 
	private Double trar; 
	private String tipoQualidade; 
	private String classifQualidade; 
	private String coloracao;	 
	private String loteAdicional;	 
	private String tipoMic;	 
	private String destino;	   
	private String corteza;	 
	private String hvi;	 
	private String benef;	 
	private String obs;	 
	private String mistura;	 
	private String sequencia;
	private String possuiSelo;
	private String tipoSelo;
	private String numeroSelo;
	private String statusItem;
	private String statusItemOriginal; 	
	
	
	public FardoDocumentoItemDTO() {
		 
	} 

	   
	public FardoDocumentoItemDTO(Double id, Double idPai, String idfil, Double idMov, Double idFardo,
			String numeroFardo, String produtor, String lote, String qualidade, String tamanho, Double peso,
			Date dataInclusao, Date dataAlteracao, Date dataMovimentacao, String usuarioInclusao,
			String usuarioAlteracao, Double sac, Double trid, Double pim, Double sc, Double mst, Double mic, Double mat,
			Double ui, Double sf, Double str, Double elg, Double tipo, Double sic, Double uhml, Double rs, Double b,
			Double trcnt, Double trar, String tipoQualidade, String classifQualidade, String coloracao,
			String loteAdicional, String tipoMic, String destino, String corteza, String hvi, String benef, String obs,
			String mistura, String sequencia, String possuiSelo, String tipoSelo, String numeroSelo, String statusItem,
			String statusItemOriginal) {
		super();
		this.id = id;
		this.idPai = idPai;
		this.idfil = idfil;
		this.idMov = idMov;
		this.idFardo = idFardo;
		this.numeroFardo = numeroFardo;
		this.produtor = produtor;
		this.lote = lote;
		this.qualidade = qualidade;
		this.tamanho = tamanho;
		this.peso = peso;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
		this.dataMovimentacao = dataMovimentacao;
		this.usuarioInclusao = usuarioInclusao;
		this.usuarioAlteracao = usuarioAlteracao;
		this.sac = sac;
		this.trid = trid;
		this.pim = pim;
		this.sc = sc;
		this.mst = mst;
		this.mic = mic;
		this.mat = mat;
		this.ui = ui;
		this.sf = sf;
		this.str = str;
		this.elg = elg;
		this.tipo = tipo;
		this.sic = sic;
		this.uhml = uhml;
		this.rs = rs;
		this.b = b;
		this.trcnt = trcnt;
		this.trar = trar;
		this.tipoQualidade = tipoQualidade;
		this.classifQualidade = classifQualidade;
		this.coloracao = coloracao;
		this.loteAdicional = loteAdicional;
		this.tipoMic = tipoMic;
		this.destino = destino;
		this.corteza = corteza;
		this.hvi = hvi;
		this.benef = benef;
		this.obs = obs;
		this.mistura = mistura;
		this.sequencia = sequencia;
		this.possuiSelo = possuiSelo;
		this.tipoSelo = tipoSelo;
		this.numeroSelo = numeroSelo;
		this.statusItem = statusItem;
		this.statusItemOriginal = statusItemOriginal;
	}


	public Double getId() {
		return id;
	}


	public void setId(Double id) {
		this.id = id;
	}


	public Double getIdPai() {
		return idPai;
	}


	public void setIdPai(Double idPai) {
		this.idPai = idPai;
	}


	public String getIdfil() {
		return idfil;
	}


	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}


	public Double getIdMov() {
		return idMov;
	}


	public void setIdMov(Double idMov) {
		this.idMov = idMov;
	}


	public Double getIdFardo() {
		return idFardo;
	}


	public void setIdFardo(Double idFardo) {
		this.idFardo = idFardo;
	}


	public String getNumeroFardo() {
		return numeroFardo;
	}


	public void setNumeroFardo(String numeroFardo) {
		this.numeroFardo = numeroFardo;
	}


	public String getProdutor() {
		return produtor;
	}


	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}


	public String getLote() {
		return lote;
	}


	public void setLote(String lote) {
		this.lote = lote;
	}


	public String getQualidade() {
		return qualidade;
	}


	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}


	public String getTamanho() {
		return tamanho;
	}


	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
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


	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}


	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
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


	public Double getSac() {
		return sac;
	}


	public void setSac(Double sac) {
		this.sac = sac;
	}


	public Double getTrid() {
		return trid;
	}


	public void setTrid(Double trid) {
		this.trid = trid;
	}


	public Double getPim() {
		return pim;
	}


	public void setPim(Double pim) {
		this.pim = pim;
	}


	public Double getSc() {
		return sc;
	}


	public void setSc(Double sc) {
		this.sc = sc;
	}


	public Double getMst() {
		return mst;
	}


	public void setMst(Double mst) {
		this.mst = mst;
	}


	public Double getMic() {
		return mic;
	}


	public void setMic(Double mic) {
		this.mic = mic;
	}


	public Double getMat() {
		return mat;
	}


	public void setMat(Double mat) {
		this.mat = mat;
	}


	public Double getUi() {
		return ui;
	}


	public void setUi(Double ui) {
		this.ui = ui;
	}


	public Double getSf() {
		return sf;
	}


	public void setSf(Double sf) {
		this.sf = sf;
	}


	public Double getStr() {
		return str;
	}


	public void setStr(Double str) {
		this.str = str;
	}


	public Double getElg() {
		return elg;
	}


	public void setElg(Double elg) {
		this.elg = elg;
	}


	public Double getTipo() {
		return tipo;
	}


	public void setTipo(Double tipo) {
		this.tipo = tipo;
	}


	public Double getSic() {
		return sic;
	}


	public void setSic(Double sic) {
		this.sic = sic;
	}


	public Double getUhml() {
		return uhml;
	}


	public void setUhml(Double uhml) {
		this.uhml = uhml;
	}


	public Double getRs() {
		return rs;
	}


	public void setRs(Double rs) {
		this.rs = rs;
	}


	public Double getB() {
		return b;
	}


	public void setB(Double b) {
		this.b = b;
	}


	public Double getTrcnt() {
		return trcnt;
	}


	public void setTrcnt(Double trcnt) {
		this.trcnt = trcnt;
	}


	public Double getTrar() {
		return trar;
	}


	public void setTrar(Double trar) {
		this.trar = trar;
	}


	public String getTipoQualidade() {
		return tipoQualidade;
	}


	public void setTipoQualidade(String tipoQualidade) {
		this.tipoQualidade = tipoQualidade;
	}


	public String getClassifQualidade() {
		return classifQualidade;
	}


	public void setClassifQualidade(String classifQualidade) {
		this.classifQualidade = classifQualidade;
	}


	public String getColoracao() {
		return coloracao;
	}


	public void setColoracao(String coloracao) {
		this.coloracao = coloracao;
	}


	public String getLoteAdicional() {
		return loteAdicional;
	}


	public void setLoteAdicional(String loteAdicional) {
		this.loteAdicional = loteAdicional;
	}


	public String getTipoMic() {
		return tipoMic;
	}


	public void setTipoMic(String tipoMic) {
		this.tipoMic = tipoMic;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getCorteza() {
		return corteza;
	}


	public void setCorteza(String corteza) {
		this.corteza = corteza;
	}


	public String getHvi() {
		return hvi;
	}


	public void setHvi(String hvi) {
		this.hvi = hvi;
	}


	public String getBenef() {
		return benef;
	}


	public void setBenef(String benef) {
		this.benef = benef;
	}


	public String getObs() {
		return obs;
	}


	public void setObs(String obs) {
		this.obs = obs;
	}


	public String getMistura() {
		return mistura;
	}


	public void setMistura(String mistura) {
		this.mistura = mistura;
	}


	public String getSequencia() {
		return sequencia;
	}


	public void setSequencia(String sequencia) {
		this.sequencia = sequencia;
	}


	public String getPossuiSelo() {
		return possuiSelo;
	}


	public void setPossuiSelo(String possuiSelo) {
		this.possuiSelo = possuiSelo;
	}


	public String getTipoSelo() {
		return tipoSelo;
	}


	public void setTipoSelo(String tipoSelo) {
		this.tipoSelo = tipoSelo;
	}


	public String getNumeroSelo() {
		return numeroSelo;
	}


	public void setNumeroSelo(String numeroSelo) {
		this.numeroSelo = numeroSelo;
	}


	public String getStatusItem() {
		return statusItem;
	}


	public void setStatusItem(String statusItem) {
		this.statusItem = statusItem;
	}


	public String getStatusItemOriginal() {
		return statusItemOriginal;
	}


	public void setStatusItemOriginal(String statusItemOriginal) {
		this.statusItemOriginal = statusItemOriginal;
	}




 
	
	
	
	
	
	
	
	
	
	
	


}
