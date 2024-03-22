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
				" M9NSELO	    " +
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
				" M9NSELO	    " +
				" FROM CPFM9_DBF M9 "  	+
				" where m9.idfil =  STL.FN_STL_IDFIL('CPFM9',?1) and trim(M9ORIG) = ?2 and trim(M9LOTE) =  trim( ?3 )"
				,nativeQuery = true)	
                 TesteQualidade  buscaTesteQualidadePorProdutorLote(@Param("idfil") String idfil,@Param("produtor") String produtor,@Param("lote") String lote) ; 	    
	    
	    
}
