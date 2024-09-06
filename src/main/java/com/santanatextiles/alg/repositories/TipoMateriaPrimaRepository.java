package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.TipoMateriaPrima;
import com.santanatextiles.alg.domain.TipoMateriaPrimaId; 

@Repository
public interface TipoMateriaPrimaRepository extends JpaRepository<TipoMateriaPrima, TipoMateriaPrimaId>{
		 
	    @Query(value = "SELECT 	" + 
				" IDFIL 	,  " +
				" M8COD 	,  " + 	
				" M8DESC 	,  " + 	
			    " M8TPITE " +  
				" FROM CPFM8_DBF M8 "  +
				" where m8.idfil =  STL.FN_STL_IDFIL('CPFM8',?1) order by M8COD"
				,nativeQuery = true)
        List<TipoMateriaPrima> buscaTipoMateriaPrimaPorParametros(@Param("idfil") String idfil) ;
	   
	    @Transactional(readOnly=true)
	    List<TipoMateriaPrima>  findByIdfil(String idfil);    	 
	    
	    
	    
	    
	    @Query(value = "SELECT 	" + 
				" IDFIL 	,  " +
				" M8COD 	,  " + 	
				" M8DESC 	,  " + 	
			    " M8TPITE " +  
				" FROM CPFM8_DBF M8 "  +
				" where m8.idfil =  STL.FN_STL_IDFIL('CPFM8',?1)  and  trim(M8COD) = trim(?2) order by M8COD"
				,nativeQuery = true)
	    TipoMateriaPrima  findByIdfilAndCodigo(String idfil,String codigo) ; 		    
	
}
