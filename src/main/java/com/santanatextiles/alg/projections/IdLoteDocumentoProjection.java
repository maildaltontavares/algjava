package com.santanatextiles.alg.projections;

import java.util.Date;

public interface IdLoteDocumentoProjection {
	
	String getIdfil();
	Double getId();
	Double getIdMov();
	String getNf();
	String getProdutor();
	String getLoteForn();
	String getNmForn();	
	Date   getDtEmissao();
	Date   getDtMovimento();
	String getTipoMovimento();
	String getItem();
	String getDescItem();	
    Double getQtde();
    Double getPeso();
	String getCodProdutor();
	String getCodFornecedor();
	String getNomeFornecedor();
	String getNomeRedFornecedor(); 
        

}
