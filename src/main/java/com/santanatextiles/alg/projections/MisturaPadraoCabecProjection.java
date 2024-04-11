package com.santanatextiles.alg.projections;

import java.util.Date;

public interface MisturaPadraoCabecProjection {
	 
	String getIdfil();
	String getMistura();
	String getLoteFiacao();
	String getStatus();
	Date   getDataInicial();
	Date   getDataFinal();
	Double getQuantidade();
	Date   getDataInclusao(); 
	String getUsuarioInclusao();
	Date   getDataAlteracao(); 	
	String getUsuarioAlteracao();
	Double getNumMisturasLiberadas();
	Double getNumFardos();
	Double getTotalUtilizadas();
	String getObservacao();  

}




