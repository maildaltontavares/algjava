package com.santanatextiles.alg.projections;

import java.util.Date;

public interface TesteQualidadeFioProjection { 
	String getIdfil();  
	String getLoteFiacao(); 
	String getTurno(); 
	String getDescTipoMaquina(); 
	String getMaquina(); 
	String getLado(); 
	String getItem(); 
	String getDescTipoTeste(); 
	Double getId(); 
	Date getDataTeste(); 
	Date getDataInclusao(); 
	String getTipoMaquina();
	Integer getHora(); 
	String getPosicaoMaquina() ; 
	
}
