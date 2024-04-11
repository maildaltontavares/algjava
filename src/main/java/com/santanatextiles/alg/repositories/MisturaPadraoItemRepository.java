package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.MisturaPadraoItem;
import com.santanatextiles.alg.domain.MisturaPadraoItemId;

@Repository
public interface MisturaPadraoItemRepository extends JpaRepository<MisturaPadraoItem, MisturaPadraoItemId>{
 
    @Query(value = "SELECT 	" +
	" IDFIL	 , " +
	" T2MIST,	  " +
	" T2ID	,  " +
	" T2QTDE,	  " +
	" T2DTINC	,  " +
	" T2USRINC,	  " +
	" T2DTALT,	  " +
	" T2USRALT	  "  +
	" FROM CPF.CPFT2_DBF T2    "  +
    " where t2.idfil =  STL.FN_STL_IDFIL('CPFT2',?1) "
	,nativeQuery = true)
    List<MisturaPadraoItem> buscaMisturaPadraoItemPorParametros(@Param("idfil") String idfil ) ;    
	
	
    @Query(value = "SELECT 	" +
	" IDFIL	 , " +
	" T2MIST,	  " +
	" T2ID	,  " +
	" T2QTDE,	  " +
	" T2DTINC	,  " +
	" T2USRINC,	  " +
	" T2DTALT,	  " +
	" T2USRALT	  "  +
	" FROM CPF.CPFT2_DBF T2    "  +
    " where T2ID =  ?1  "
	,nativeQuery = true)
    List<MisturaPadraoItem> buscaMisturaPorId(@Param("id") Double id ) ;        
    
	@Transactional
	Double deleteByIdfilAndMistura(String idfil ,String mistura ); 	    


}	
