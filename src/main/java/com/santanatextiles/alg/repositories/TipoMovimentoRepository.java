package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.TipoMovimento;
import com.santanatextiles.alg.domain.TipoMovimentoId;

 
	
public interface TipoMovimentoRepository extends JpaRepository<TipoMovimento, TipoMovimentoId>{
		 
	    @Query(value = "SELECT 	" +  
					" IDFIL 	,   " +
					" M5CDMOV 	,   " +
					" M5NMMOV 	,   " +
					" M5ENTSAI 	,   " +
					" M5ATLEST 	,   " +
					" M5ATLLOT 	,   " +
					" M5ATLITE 	,   " +
					" M5PESATL	    " +	 
				    " FROM CPFM5_DBF M5 "  +
				    " where m5.idfil =  STL.FN_STL_IDFIL('CPFM5',?1)  order by M5CDMOV"
				,nativeQuery = true)
        List<TipoMovimento> buscaTipoMovimentoPorParametros(@Param("idfil") String idfil) ; 	

	    @Transactional(readOnly=true)
	    List<TipoMovimento>  findByIdfil(String idfil);    	    
	     
	    
		
	    @Query(value = "SELECT 	" +  
					" IDFIL 	,   " +
					" M5CDMOV 	,   " +
					" M5NMMOV 	,   " +
					" M5ENTSAI 	,   " +
					" M5ATLEST 	,   " +
					" M5ATLLOT 	,   " +
					" M5ATLITE 	,   " +
					" M5PESATL	    " +	 
				    " FROM CPFM5_DBF M5 "  +
				    " where m5.idfil =  STL.FN_STL_IDFIL('CPFM5',?1) and  trim(M5CDMOV) = trim(?2)"
				,nativeQuery = true)
         TipoMovimento  findByIdfilAndCodigo(String idfil,String codigo) ; 			
	    
}
