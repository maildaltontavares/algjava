package com.santanatextiles.alg.dto;

import com.santanatextiles.alg.projections.SaldoPesquisaIdProjection;

public class SaldoPesquisaIdDTO { 
	
	Double idMov;
	String produtor;
	String pilha;
	String lote;
	Double qtde;
	String nmForn;
	String item;
	String nomeItem;
	String um;
	String procedencia;
	String nf;
	String fornecedor;
	Double peso;
	Double vlEst;
	Double pesoMedio;
	String tamanho;
	String tipoQualidade; 
	String classifQualidade;
	String coloracao;
	String loteAdicional;
	String idVolume; 
	String tipoMic;	 
	String destino;
	String qualidade;	
	String corteza;
	
	
	public SaldoPesquisaIdDTO() {};
	
	public SaldoPesquisaIdDTO(SaldoPesquisaIdProjection  projection ) { 
		
		this.idMov = projection.getIdMov();
		this.produtor = projection.getProdutor();
		this.pilha = projection.getPilha();
		this.lote = projection.getLote();
		this.qtde = projection.getQtde();
		this.nmForn = projection.getNmForn();
		this.item = projection.getItem();
		this.nomeItem = projection.getNomeItem();
		this.um = projection.getUM();
		this.procedencia = projection.getProcedencia();
		this.nf = projection.getNF();
		this.fornecedor = projection.getFornecedor();
		this.peso = projection.getPeso();
		this.vlEst = projection.getVlEst();
		this.pesoMedio = projection.getPesoMedio();
		this.tamanho = projection.getTamanho();  
		this.tipoQualidade = projection.getTipoQualidade();
		this.classifQualidade = projection.getClassifQualidade();
		this.coloracao = projection.getColoracao();
		this.loteAdicional = projection.getLoteAdicional();
		this.idVolume = projection.getIdVolume();
		this.tipoMic = projection.getTipoMic();
		this.destino = projection.getDestino();
		this.qualidade = projection.getQualidade();
		this.corteza = projection.getCorteza();		
		
	}	 
	 

	public SaldoPesquisaIdDTO(Double idMov, String produtor, String pilha, String lote, Double qtde, String nmForn,
			String item, String nomeItem, String um, String procedencia, String nf, String fornecedor, Double peso,
			Double vlEst, Double pesoMedio, String tamanho, String tipoQualidade, String classifQualidade,
			String coloracao, String loteAdicional, String idVolume, String tipoMic, String destino, String qualidade,
			String corteza) {
		super();
		this.idMov = idMov;
		this.produtor = produtor;
		this.pilha = pilha;
		this.lote = lote;
		this.qtde = qtde;
		this.nmForn = nmForn;
		this.item = item;
		this.nomeItem = nomeItem;
		this.um = um;
		this.procedencia = procedencia;
		this.nf = nf;
		this.fornecedor = fornecedor;
		this.peso = peso;
		this.vlEst = vlEst;
		this.pesoMedio = pesoMedio;
		this.tamanho = tamanho;
		this.tipoQualidade = tipoQualidade;
		this.classifQualidade = classifQualidade;
		this.coloracao = coloracao;
		this.loteAdicional = loteAdicional;
		this.idVolume = idVolume;
		this.tipoMic = tipoMic;
		this.destino = destino;
		this.qualidade = qualidade;
		this.corteza = corteza;
	}

	public Double getIdMov() {
		return idMov;
	}


	public void setIdMov(Double idMov) {
		this.idMov = idMov;
	}


	public String getProdutor() {
		return produtor;
	}


	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}


	public String getPilha() {
		return pilha;
	}


	public void setPilha(String pilha) {
		this.pilha = pilha;
	}


	public String getLote() {
		return lote;
	}


	public void setLote(String lote) {
		this.lote = lote;
	}


	public Double getQtde() {
		return qtde;
	}


	public void setQtde(Double qtde) {
		this.qtde = qtde;
	}


	public String getNmForn() {
		return nmForn;
	}


	public void setNmForn(String nmForn) {
		this.nmForn = nmForn;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public String getNomeItem() {
		return nomeItem;
	}


	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}


	public String getUm() {
		return um;
	}


	public void setUm(String um) {
		this.um = um;
	}


	public String getProcedencia() {
		return procedencia;
	}


	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}


	public String getNf() {
		return nf;
	}


	public void setNf(String nf) {
		this.nf = nf;
	}


	public String getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public Double getVlEst() {
		return vlEst;
	}


	public void setVlEst(Double vlEst) {
		this.vlEst = vlEst;
	}


	public Double getPesoMedio() {
		return pesoMedio;
	}


	public void setPesoMedio(Double pesoMedio) {
		this.pesoMedio = pesoMedio;
	}  
	
	
	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
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

	public String getIdVolume() {
		return idVolume;
	}

	public void setIdVolume(String idVolume) {
		this.idVolume = idVolume;
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

	public String getQualidade() {
		return qualidade;
	}

	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}

	public String getCorteza() {
		return corteza;
	}

	public void setCorteza(String corteza) {
		this.corteza = corteza;
	}	
	
	
	
	
	
	
	
	
	

}
