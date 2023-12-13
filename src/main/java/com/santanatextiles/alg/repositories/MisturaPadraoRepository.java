package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.EstoqueMP;
import com.santanatextiles.alg.domain.MisturaPadrao;
import com.santanatextiles.alg.domain.MisturaPadraoId;

@Repository
public interface MisturaPadraoRepository extends JpaRepository<MisturaPadrao, MisturaPadraoId>{
 
    @Query(value = "SELECT 	" + 	 
	    " IDFIL,  " +
		" T1MIST,  " +
		" T1STATUS,  " +
		" T1DTINI , " +
		" T1DTFIM  ," +
		" T1LOTE  ," +
		" T1QTDE  ," +
		" T1DTINC  ," +
		" T1USRINC  ," +
		" T1DTALT  ," +
		" T1USRALT  ," +		
		" T1OBS,  " +
		" T1QTDLIB,  " +
		" T1NUMFAR  "   +
		" FROM CPF.CPFT1_DBF T1    "   +
	    " where T1.idfil =  STL.FN_STL_IDFIL('CPFT1',?1) "
		,nativeQuery = true)
	    List<MisturaPadrao> buscaMisturaPadraoPorParametros(@Param("idfil") String idfil) ;  

        @Transactional(readOnly=true)
        List<MisturaPadrao>  findByIdfil(String idfil);       
	    
    
    

}
