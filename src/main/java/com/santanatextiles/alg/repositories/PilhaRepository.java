package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.Pilha;
import com.santanatextiles.alg.domain.PilhaId;



public interface PilhaRepository extends JpaRepository<Pilha, PilhaId>{
		 
	    @Query(value = "SELECT 	" + 
				" IDFIL 	," +  
	    		" S1COD  	," +
	    		" S1DESC 	"   +
	    		" FROM CPF.CPFS1_DBF S1  "  +
	    		" where s1.idfil =  STL.FN_STL_IDFIL('CPFS1',?1) "
				,nativeQuery = true)
        	    List<Pilha> buscaPilhaPorParametros(@Param("idfil") String idfil) ;   
	    
	    
	    @Transactional(readOnly=true)
	    List<Pilha>  findByIdfil(String idfil);  	    
	    
}
