package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.TesteQualidade;
import com.santanatextiles.alg.domain.TesteQualidadeId; 

public interface TesteQualidadeRepository extends JpaRepository<TesteQualidade, TesteQualidadeId>{
		 
	    @Query(value = "SELECT 	" + 
				" IDFIL 	 ,  " +
				" M9ORIG	 ,  " +
				" M9LOTE	 ,  " +
				" M9DTTEST	 ,  " +
				" M9NUMVOL	 ,  " +
				" M9SAC	     ,  " +
				" M9MST	     ,  " +
				" M9MIC	     ,  " +
				" M9MAT	     ,  " +
				" M9UI	     ,  " +
				" M9SF	     ,  " +
				" M9STR	     ,  " +
				" M9ELG	     ,  " +
				" M9TIPO	 ,  " +
				" M9TRID	 ,  " +
				" M9SC	     ,  " +
				" M9PIM	     ,  " +
				" M9HVI	     ,  " +
				" M9BENEF	 ,  " +
				" M9OBS	     ,  " +
				" M9DTINC	 ,  " +
				" M9USRINC	 ,  " +
				" M9DTALT	 ,  " +
				" M9USRALT 	 ,  " +
				" M9SIC	     ,  " +
				" M9UHML	 ,  " +
				" M9RS	     ,  " +
				" M9B	     ,  " +
				" M9TRCNT	 ,  " +
				" M9TRAR	 ,  " +
				" M9PRDINT	 ,  " +
				" M9ARQ	     ,  " +
				" M9PSELO	 ,  " +
				" M9TPSELO	 ,  " +
				" M9NSELO	 ,  " +
				" M9TPMIC	    " + 
				" FROM CPFM9_DBF M9 "  	+
				" where m9.idfil =  STL.FN_STL_IDFIL('CPFM9',?1) "
				,nativeQuery = true)	
        List<TesteQualidade> buscaTesteQualidadePorParametros(@Param("idfil") String idfil) ;  

	    
	    @Transactional(readOnly=true)
	    List<TesteQualidade>  findByIdfil(String idfil);    
	
	    @Transactional(readOnly=true)
	    TesteQualidade  findByIdfilAndProdutorAndLote(String idfil,String produtor, String lote);  	   
	    
	    
	    @Query(value = "SELECT 	" + 
				" IDFIL 	 ,  " +
				" M9ORIG	 ,  " +
				" M9LOTE	 ,  " +
				" M9DTTEST	 ,  " +
				" M9NUMVOL	 ,  " +
				" M9SAC	     ,  " +
				" M9MST	     ,  " +
				" M9MIC	     ,  " +
				" M9MAT	     ,  " +
				" M9UI	     ,  " +
				" M9SF	     ,  " +
				" M9STR	     ,  " +
				" M9ELG	     ,  " +
				" M9TIPO	 ,  " +
				" M9TRID	 ,  " +
				" M9SC	     ,  " +
				" M9PIM	     ,  " +
				" M9HVI	     ,  " +
				" M9BENEF	 ,  " +
				" M9OBS	     ,  " +
				" M9DTINC	 ,  " +
				" M9USRINC	 ,  " +
				" M9DTALT	 ,  " +
				" M9USRALT 	 ,  " +
				" M9SIC	     ,  " +
				" M9UHML	 ,  " +
				" M9RS	     ,  " +
				" M9B	     ,  " +
				" M9TRCNT	 ,  " +
				" M9TRAR	 ,  " +
				" M9PRDINT	 ,  " +
				" M9ARQ	     ,  " +
				" M9PSELO	 ,  " +
				" M9TPSELO	 ,  " +
				" M9NSELO	 ,  " +
				" M9TPMIC	    " + 
				" FROM CPFM9_DBF M9 "  	+
				" where m9.idfil =  STL.FN_STL_IDFIL('CPFM9',?1) and trim(M9ORIG) = ?2 and trim(M9LOTE) =  trim( ?3 )"
				,nativeQuery = true)	
                 TesteQualidade  buscaTesteQualidadePorProdutorLote(@Param("idfil") String idfil,@Param("produtor") String produtor,@Param("lote") String lote) ; 	 
/*	    
	    @Query(value = "SELECT 	" +  
	    	 " M2.idfil ,   	" + 
	    	 " M2.M2NF notaFiscal,   	" +  
			 " M2.M2DTBASE dataBase, 	" +  
			 " M2.M2FORN fornecedor, 	" +  
			 " B2.B2NOMREDUZ nomeFornecedor, 	" +  
			 " M2.M2tpmov 	tipoMovimento, " +
			 " M9.M9DTTEST 	dataTeste, " +
			 " M3.M3qtde quantidade" +
			 " FROM CPF.CPFM3_DBF M3  	" +  
			 " LEFT JOIN CPF.CPFM2_DBF M2 ON M2.IDFIL = M3.IDFIL AND M2.M2ID = M3.M3IDCAB 	" +   
			 " LEFT join CCP.CCPB2_DBF b2 on b2.idfil = STL.FN_STL_IDFIL('CCPB2', m2.IDFIL) and trim(m2.M2FORN) = b2.B2COD  	" +   
			 " LEFT JOIN CPF.CPFM9_DBF M9 ON M3.IDFIL = M9.IDFIL AND M3.M3ORIG = M9.M9ORIG AND TRIM(M3.M3LOTE) = TRIM(M9.M9LOTE) 	" +  
			 " WHERE M2.IDFIL =  STL.FN_STL_IDFIL('CPFM2', ?1)  	" +  
			 " AND   M2.M2TPMOV IN ('NFE','EST+') 	" +  
			 " AND   M2.M2ORIG = ?2 	" +  
			 " AND   TRIM(M3.M3LOTE )  = ?3	" +  
			 " AND   TRIM(M3.M3ITEM) = ?4		" +      
			 " order by M2.M2DTBASE, 	M2.M2NF"	  
			 ,nativeQuery = true)	 
     	     List<LotesProjection>  buscaExistenciaLote(@Param("idfil") String idfil,@Param("produtor") String produtor,@Param("lote") String lote,@Param("item") String item) ;
	    
	*/    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
