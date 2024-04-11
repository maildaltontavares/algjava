package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.santanatextiles.alg.domain.Coloracao;
import com.santanatextiles.alg.domain.ColoracaoId;

public interface ColoracaoRepository extends JpaRepository<Coloracao, ColoracaoId>{
	 
    @Query(value = "SELECT 	" + 
			" IDFIL 	," +  
    		" N4COD  	," +
    		" N4DESC, 	"   +
    		" N4CHAVE 	"   +
    		" FROM CPF.CPFN4_DBF N4  "  +
    		" where n4.idfil =  STL.FN_STL_IDFIL('CPFN4',?1) "
			,nativeQuery = true)
    	    List<Coloracao> buscaColoracaoByFilial(@Param("idfil") String idfil) ;   
    
 	    
    @Query(value = "SELECT 	" + 
			" IDFIL 	," +  
    		" N4COD  	," +
    		" N4DESC, 	"   +
    		" N4CHAVE 	"   +
    		" FROM CPF.CPFN4_DBF N4  "  +
    		" where n4.idfil =  STL.FN_STL_IDFIL('CPFN4',?1)  and trim(N4COD) = trim(?2)"
			,nativeQuery = true)
    	    List<Coloracao> buscaColoracaoByFilialAndCodigo(@Param("idfil") String idfil,@Param("codigo") String codigo) ;      
    
    
} 
 

 
