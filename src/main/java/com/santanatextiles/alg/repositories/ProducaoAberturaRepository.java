package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.ProducaoAbertura;
import com.santanatextiles.alg.domain.ProducaoAberturaId;
 

public interface ProducaoAberturaRepository extends JpaRepository<ProducaoAbertura, ProducaoAberturaId>{
	 
	
		    @Query(value = "SELECT 	"+ 
			" IDFIL 	    , " +	
			" T3CODMAQ 	    , " +	
			" T3DTALT 	    , " +	
			" T3DTINC 	    , " +	
			" T3DTMOV 	    , " +	
			" T3HRINI 	    , " +	
			" T3IDAUTO 	    , " +	
			" T3LADO 	    , " +	
			" T3LF 	    , " +	
			" T3MIST 	    , " +	
			" T3OBS 	    , " +	
			" T3OPER 	    , " +	
			" T3SEQ 	    , " +	
			" T3TURNO 	    , " +	
			" T3USRALT 	    , " +	
			" T3USRINC 	     " 	+ 
			" FROM CPF.CPFT3_DBF T3  "  +
		    " where T3.idfil =  STL.FN_STL_IDFIL('CPFT3',?1)  "
			,nativeQuery = true)
    		List<ProducaoAbertura> buscaProducaoAberturaPorFilial(@Param("idfil") String idfil) ;  
    
    
		    @Transactional(readOnly=true)
		    List<ProducaoAbertura>  findByIdfil(String idfil);
		    
		    @Transactional(readOnly=true)
		    Double  deleteByIdfilAndIdAutomatico(String idfil,Double idAuto);     
	    
	
  	
}