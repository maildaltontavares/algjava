package com.santanatextiles.alg.projections;

import java.util.Date;

public interface LotesProjection { 
	
	String getIdfil();
	String getNotaFiscal();
	Date   getDataBase();
	String getFornecedor();
	String getNomeFornecedor();	
	Date getDataTeste();	 

}
