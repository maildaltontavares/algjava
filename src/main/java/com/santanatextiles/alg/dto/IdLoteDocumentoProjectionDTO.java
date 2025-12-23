package com.santanatextiles.alg.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santanatextiles.alg.projections.IdLoteDocumentoProjection;

public class IdLoteDocumentoProjectionDTO {

	
	String idfil;
	Double id;
	Double idMov;
	String nf;
	String produtor;
	String loteForn;
	String nmForn;	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	Date   dtEmissao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	Date   dtMovimento;
	String tipoMovimento;
	String item;
	String descItem;	
	Double qtde;
	Double peso;
	String codProdutor;
	String codFornecedor;
	String nomeFornecedor;
	String nomeRedFornecedor; 
	
	
	public IdLoteDocumentoProjectionDTO() {
	 
	} 



 
	



	public IdLoteDocumentoProjectionDTO(String idfil, Double id, Double idMov, String nf, String produtor,
			String loteForn, String nmForn, Date dtEmissao, Date dtMovimento, String tipoMovimento, String item,
			String descItem, Double qtde, Double peso, String codProdutor, String codFornecedor, String nomeFornecedor,
			String nomeRedFornecedor) {
		super();
		this.idfil = idfil;
		this.id = id;
		this.idMov = idMov;
		this.nf = nf;
		this.produtor = produtor;
		this.loteForn = loteForn;
		this.nmForn = nmForn;
		this.dtEmissao = dtEmissao;
		this.dtMovimento = dtMovimento;
		this.tipoMovimento = tipoMovimento;
		this.item = item;
		this.descItem = descItem;
		this.qtde = qtde;
		this.peso = peso;
		this.codProdutor = codProdutor;
		this.codFornecedor = codFornecedor;
		this.nomeFornecedor = nomeFornecedor;
		this.nomeRedFornecedor = nomeRedFornecedor;
	}







 

	public IdLoteDocumentoProjectionDTO(String idfil, Double id, Double idMov, String nf, String produtor,
			String loteForn, String nmForn, Date dtEmissao, Date dtMovimento, String tipoMovimento, String item,
			String descItem, Double qtde, Double peso) {
		super();
		this.idfil = idfil;
		this.id = id;
		this.idMov = idMov;
		this.nf = nf;
		this.produtor = produtor;
		this.loteForn = loteForn;
		this.nmForn = nmForn;
		this.dtEmissao = dtEmissao;
		this.dtMovimento = dtMovimento;
		this.tipoMovimento = tipoMovimento;
		this.item = item;
		this.descItem = descItem;
		this.qtde = qtde;
		this.peso = peso;
	}








	public IdLoteDocumentoProjectionDTO(String idfil, Double id) {
		super();
		this.idfil = idfil;
		this.id = id;
	}




	public IdLoteDocumentoProjectionDTO(IdLoteDocumentoProjection projection ) { 
		
		this.idfil = projection.getIdfil();
		
	 
		this.id = projection.getId();
		this.idMov = projection.getIdMov();
		this.nf = projection.getNf();
		this.produtor = projection.getProdutor();
		this.loteForn = projection.getLoteForn();
		this.nmForn = projection.getNmForn();	
		this.dtEmissao = projection.getDtEmissao();
		this.dtMovimento = projection.getDtMovimento();
		this.tipoMovimento = projection.getTipoMovimento();
		this.item = projection.getItem();
		this.descItem = projection.getDescItem();	
		this.qtde = projection.getQtde();
		this.peso = projection.getPeso();		
		this.codProdutor = projection.getCodProdutor();
		this.codFornecedor = projection.getCodFornecedor();
		this.nomeFornecedor = projection.getNomeFornecedor();
		this.nomeRedFornecedor = projection.getNomeRedFornecedor();
		
		
		 
	}	
	

	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public Double getId() {
		return id;
	}

	public void setId(Double id) {
		this.id = id;
	}

	public String getNf() {
		return nf;
	}

	public void setNf(String nf) {
		this.nf = nf;
	}

	public String getProdutor() {
		return produtor;
	}

	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}

	public String getLoteForn() {
		return loteForn;
	}

	public void setLoteForn(String loteForn) {
		this.loteForn = loteForn;
	}

	public String getNmForn() {
		return nmForn;
	}

	public void setNmForn(String nmForn) {
		this.nmForn = nmForn;
	}

	public Date getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public Date getDtMovimento() {
		return dtMovimento;
	}

	public void setDtMovimento(Date dtMovimento) {
		this.dtMovimento = dtMovimento;
	}

	public String getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDescItem() {
		return descItem;
	}

	public void setDescItem(String descItem) {
		this.descItem = descItem;
	}

	public Double getQtde() {
		return qtde;
	}

	public void setQtde(Double qtde) {
		this.qtde = qtde;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}




	public String getCodProdutor() {
		return codProdutor;
	}




	public void setCodProdutor(String codProdutor) {
		this.codProdutor = codProdutor;
	}




	public String getCodFornecedor() {
		return codFornecedor;
	}




	public void setCodFornecedor(String codFornecedor) {
		this.codFornecedor = codFornecedor;
	}




	public String getNomeFornecedor() {
		return nomeFornecedor;
	}




	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}




	public String getNomeRedFornecedor() {
		return nomeRedFornecedor;
	}




	public void setNomeRedFornecedor(String nomeRedFornecedor) {
		this.nomeRedFornecedor = nomeRedFornecedor;
	}








	public Double getIdMov() {
		return idMov;
	}








	public void setIdMov(Double idMov) {
		this.idMov = idMov;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
