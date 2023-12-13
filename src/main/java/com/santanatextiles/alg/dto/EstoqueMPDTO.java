package com.santanatextiles.alg.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santanatextiles.alg.domain.Fornecedor;
import com.santanatextiles.alg.domain.Procedencia;
import com.santanatextiles.alg.domain.Produtor;

public class EstoqueMPDTO implements Serializable {

	private static final long serialVersionUID = 1L;  
 
	private String idfil; 
	private String notaFiscal;
	private String fornecedor;
	private String item;	
	private String produtor; 
	private String procedencia;	
	private String lote;
	private String qualidade;
	private String tamanho;	
	private Double quantidade;	
	private Double peso;	   
	private Double id;	 
	private Double idCab;	 
	private String unidadeMedida;
	private String pilha;	
	private String descFio;		 
 	private Double valorEstoque; 	 
 	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date dataInclusao;  
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date dataAlteracao; 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date dataMovimentacao;
	private String usuarioInclusao;	
	private String usuarioAlteracao; 
	private Double pesoMedio;	  
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
	private Fornecedor fkFornecedo;	
	private Produtor fkProdutor;	
	private Procedencia fkProcedencia;
	
	public EstoqueMPDTO() {}

	public EstoqueMPDTO(String idfil, String notaFiscal, String fornecedor, String item, String produtor,
			String procedencia, String lote, String qualidade, String tamanho, Double quantidade, Double peso,
			Double id, Double idCab, String unidadeMedida, String pilha, String descFio, Double valorEstoque,
			Date dataInclusao, Date dataAlteracao, Date dataMovimentacao, String usuarioInclusao,
			String usuarioAlteracao, Double pesoMedio, Double sac, Double trid, Double pim, Double sc, Double mst,
			Double mic, Double mat, Double ui, Double sf, Double str, Double elg, Double tipo, Double sic, Double uhml,
			Double rs, Double b, Double trcnt, Double trar, Fornecedor fkFornecedo, Produtor fkProdutor,
			Procedencia fkProcedencia) {
		super();
		this.idfil = idfil;
		this.notaFiscal = notaFiscal;
		this.fornecedor = fornecedor;
		this.item = item;
		this.produtor = produtor;
		this.procedencia = procedencia;
		this.lote = lote;
		this.qualidade = qualidade;
		this.tamanho = tamanho;
		this.quantidade = quantidade;
		this.peso = peso;
		this.id = id;
		this.idCab = idCab;
		this.unidadeMedida = unidadeMedida;
		this.pilha = pilha;
		this.descFio = descFio;
		this.valorEstoque = valorEstoque;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
		this.dataMovimentacao = dataMovimentacao;
		this.usuarioInclusao = usuarioInclusao;
		this.usuarioAlteracao = usuarioAlteracao;
		this.pesoMedio = pesoMedio;
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
		this.fkFornecedo = fkFornecedo;
		this.fkProdutor = fkProdutor;
		this.fkProcedencia = fkProcedencia;
	}

	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getProdutor() {
		return produtor;
	}

	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
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

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getId() {
		return id;
	}

	public void setId(Double id) {
		this.id = id;
	}

	public Double getIdCab() {
		return idCab;
	}

	public void setIdCab(Double idCab) {
		this.idCab = idCab;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String getPilha() {
		return pilha;
	}

	public void setPilha(String pilha) {
		this.pilha = pilha;
	}

	public String getDescFio() {
		return descFio;
	}

	public void setDescFio(String descFio) {
		this.descFio = descFio;
	}

	public Double getValorEstoque() {
		return valorEstoque;
	}

	public void setValorEstoque(Double valorEstoque) {
		this.valorEstoque = valorEstoque;
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

	public Double getPesoMedio() {
		return pesoMedio;
	}

	public void setPesoMedio(Double pesoMedio) {
		this.pesoMedio = pesoMedio;
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

	public Fornecedor getFkFornecedo() {
		return fkFornecedo;
	}

	public void setFkFornecedo(Fornecedor fkFornecedo) {
		this.fkFornecedo = fkFornecedo;
	}

	public Produtor getFkProdutor() {
		return fkProdutor;
	}

	public void setFkProdutor(Produtor fkProdutor) {
		this.fkProdutor = fkProdutor;
	}

	public Procedencia getFkProcedencia() {
		return fkProcedencia;
	}

	public void setFkProcedencia(Procedencia fkProcedencia) {
		this.fkProcedencia = fkProcedencia;
	}
 
	

}
