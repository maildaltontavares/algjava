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
	    
	    @Query(value =  
	    	    "select  DECODE(NVL(QTDE,0),0,'0', TRIM(TO_CHAR(QTDE)) )    " +
	    	    " FROM CPF.CPFS1_DBF S1 " +
	    	    " LEFT JOIN " +
	    	    "     ( " +
	    	    "      SELECT IDFIL,SUM(M4QTDE) QTDE , M4PILHA  " +
	    	    "      FROM CPFM4_DBF M4 " +
	    	    "      WHERE  IDFIL =  ?1 AND M4QTDE > 0 " + 
	    	    "      GROUP BY IDFIL,M4PILHA " +
	    	    "      ) EST  ON EST.IDFIL = ?1 AND S1.IDFIL = '01' AND  EST.M4PILHA = S1.S1COD " +
	    	    " WHERE S1.IDFIL = '01'  AND S1COD = ?2"  ,nativeQuery = true)
	    Integer totalFardosPilha(String filial,String pilha) ; 	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
