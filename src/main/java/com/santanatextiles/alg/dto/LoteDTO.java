package com.santanatextiles.alg.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santanatextiles.alg.projections.LotesProjection;

public class LoteDTO {
	  
	String idfil;
    String notaFiscal;	 
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
    Date   dataBase;	
    
    String fornecedor;
    String nomeFornecedor;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
    Date   dataTeste;

    
    public LoteDTO() {
    	
    } 
    
    
	public LoteDTO(String idfil, String notaFiscal, Date dataBase, String fornecedor, String nomeFornecedor,
			Date dataTeste) {
		super();
		this.idfil = idfil;
		this.notaFiscal = notaFiscal;
		this.dataBase = dataBase;
		this.fornecedor = fornecedor;
		this.nomeFornecedor = nomeFornecedor;
		this.dataTeste = dataTeste;
	} 
	
	public LoteDTO(LotesProjection  projection ) {
		
		this.idfil          = projection.getIdfil();	
		this.notaFiscal     = projection.getNotaFiscal();	
		this.dataBase       = projection.getDataBase(); 
		this.fornecedor     = projection.getFornecedor();	
		this.nomeFornecedor = projection.getNomeFornecedor();	 
	    this.dataTeste      = projection.getDataTeste();	 
		
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

	public Date getDataBase() {
		return dataBase;
	}

	public void setDataBase(Date dataBase) {
		this.dataBase = dataBase;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public Date getDataTeste() {
		return dataTeste;
	}

	public void setDataTeste(Date dataTeste) {
		this.dataTeste = dataTeste;
	}
	
	
	
	
	
    
    
    
    
    
    

}
