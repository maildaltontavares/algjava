package com.santanatextiles.alg.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santanatextiles.alg.projections.TestesQualidadeProjection;

public class TesteQualidadeProjectionDTO {
	
	
	String  idfil;  
	String  produtor;	 
	String  lote; 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	Date    dataTeste; 
	Double  numVolumes; 
	Double  sac;		 
	Double  mst;	 
	Double  mic;	 
	Double  mat;	 
	Double  ui;	 
	Double  sf; 
	Double  str; 	
	Double  elg;	 
	Double  tipo; 
	Double  trid; 
	Double  sc; 	
	Double  pim;	 
	String  Hvi;	 
	String  benef; 
	String  obs; 	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	Date    dataInclusao; 
	String  usarioInclusao;	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	Date    dataAlteracao; 
	String  usarioAlteracao;		 
	Double  sic;	 
	Double  uhml; 
	Double  rs; 
	Double  b; 
	Double  trcnt; 
	Double  trar; 	
	String  prdint; 
	String  arqImportacao; 
	String  possuiSelo; 
	String  tipoSelo; 
	String  numeroSelo;
	String  tipoMic;
	String  Item; 
	String  nomeProdutor;
	
	
	public TesteQualidadeProjectionDTO() {
	 
	}
	
	public TesteQualidadeProjectionDTO(TestesQualidadeProjection projection ) {
		this.idfil         = projection.getIdfil();  
		this.produtor 	   = projection.getProdutor();	 
		this.lote          = projection.getLote(); 
		this.dataTeste     = projection.getDataTeste(); 
		this.numVolumes    = projection.getNumVolumes(); 
		this.sac 		   = projection.getSac();	
		this.mst 	   = projection.getMst();	 
		this.mic 	   = projection.getMic();	 
		this.mat 	   = projection.getMat();	 
		this.ui 	   = projection.getUi();	 
		this.sf        = projection.getSf(); 
		this.str  	   = projection.getStr(); 	
		this.elg 	   = projection.getElg();	 
		this.tipo          = projection.getTipo(); 
		this.trid          = projection.getTrid(); 
		this.sc  	   = projection.getSc(); 	
		this.pim 	   = projection.getPim();	 
		this.Hvi 	   = projection.getHvi();	 
		this.benef     = projection.getBenef(); 
		this.obs  	   = projection.getObs();  
		this.dataInclusao    = projection.getDataInclusao(); 
		this.usarioInclusao  = projection.getUsarioInclusao();	
		this.dataAlteracao   = projection.getDataAlteracao(); 
		this.usarioAlteracao = projection.getUsarioAlteracao();	
		this.sic 	         = projection.getSic();	 
		this.uhml            = projection.getUhml(); 
		this.rs              = projection.getRs(); 
		this.b               = projection.getB(); 
		this.trcnt           = projection.getTrcnt(); 
		this.trar  	         = projection.getTrar(); 	
		this.prdint          = projection.getPrdint(); 
		this.arqImportacao   = projection.getArqImportacao(); 
		this.possuiSelo      = projection.getPossuiSelo(); 
		this.tipoSelo        = projection.getTipoSelo(); 
		this.numeroSelo      = projection.getNumeroSelo();
		this.tipoMic         = projection.getTipoMic();
		this.Item            = projection.getItem(); 
		this.nomeProdutor    = projection.getNomeProdutor();


	}
	public TesteQualidadeProjectionDTO(String idfil, String produtor, String lote, Date dataTeste, Double numVolumes,
			Double sac, Double mst, Double mic, Double mat, Double ui, Double sf, Double str, Double elg, Double tipo,
			Double trid, Double sc, Double pim, String hvi, String benef, String obs, Date dataInclusao,
			String usarioInclusao, Date dataAlteracao, String usarioAlteracao, Double sic, Double uhml, Double rs,
			Double b, Double trcnt, Double trar, String prdint, String arqImportacao, String possuiSelo,
			String tipoSelo, String numeroSelo, String tipoMic, String item, String nomeProdutor) {
		super();
		this.idfil = idfil;
		this.produtor = produtor;
		this.lote = lote;
		this.dataTeste = dataTeste;
		this.numVolumes = numVolumes;
		this.sac = sac;
		this.mst = mst;
		this.mic = mic;
		this.mat = mat;
		this.ui = ui;
		this.sf = sf;
		this.str = str;
		this.elg = elg;
		this.tipo = tipo;
		this.trid = trid;
		this.sc = sc;
		this.pim = pim;
		Hvi = hvi;
		this.benef = benef;
		this.obs = obs;
		this.dataInclusao = dataInclusao;
		this.usarioInclusao = usarioInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usarioAlteracao = usarioAlteracao;
		this.sic = sic;
		this.uhml = uhml;
		this.rs = rs;
		this.b = b;
		this.trcnt = trcnt;
		this.trar = trar;
		this.prdint = prdint;
		this.arqImportacao = arqImportacao;
		this.possuiSelo = possuiSelo;
		this.tipoSelo = tipoSelo;
		this.numeroSelo = numeroSelo;
		this.tipoMic = tipoMic;
		Item = item;
		this.nomeProdutor = nomeProdutor;
	}


	public String getIdfil() {
		return idfil;
	}


	public void setIdfil(String idfil) {
		this.idfil = idfil;
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


	public Date getDataTeste() {
		return dataTeste;
	}


	public void setDataTeste(Date dataTeste) {
		this.dataTeste = dataTeste;
	}


	public Double getNumVolumes() {
		return numVolumes;
	}


	public void setNumVolumes(Double numVolumes) {
		this.numVolumes = numVolumes;
	}


	public Double getSac() {
		return sac;
	}


	public void setSac(Double sac) {
		this.sac = sac;
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


	public Double getTrid() {
		return trid;
	}


	public void setTrid(Double trid) {
		this.trid = trid;
	}


	public Double getSc() {
		return sc;
	}


	public void setSc(Double sc) {
		this.sc = sc;
	}


	public Double getPim() {
		return pim;
	}


	public void setPim(Double pim) {
		this.pim = pim;
	}


	public String getHvi() {
		return Hvi;
	}


	public void setHvi(String hvi) {
		Hvi = hvi;
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


	public String getPrdint() {
		return prdint;
	}


	public void setPrdint(String prdint) {
		this.prdint = prdint;
	}


	public String getArqImportacao() {
		return arqImportacao;
	}


	public void setArqImportacao(String arqImportacao) {
		this.arqImportacao = arqImportacao;
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


	public String getTipoMic() {
		return tipoMic;
	}


	public void setTipoMic(String tipoMic) {
		this.tipoMic = tipoMic;
	}


	public String getItem() {
		return Item;
	}


	public void setItem(String item) {
		Item = item;
	}


	public String getNomeProdutor() {
		return nomeProdutor;
	}


	public void setNomeProdutor(String nomeProdutor) {
		this.nomeProdutor = nomeProdutor;
	}  	
	
	
	
	
	
	

}
