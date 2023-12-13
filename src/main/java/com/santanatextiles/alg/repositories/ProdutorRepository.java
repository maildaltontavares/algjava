package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.santanatextiles.alg.domain.Produtor;
import com.santanatextiles.alg.domain.ProdutorId;

 
	
public interface ProdutorRepository extends JpaRepository<Produtor, ProdutorId>{
		 
	    @Query(value = "SELECT 	" + 
				" IDFIL 	,  " +
				" M6COD 	,  " + 	
				" M6DESC 	   " + 	
				" FROM CPFM6_DBF M6 "  +
				" where m6.idfil =  STL.FN_STL_IDFIL('CPFM6',?1) order by M6DESC"
				,nativeQuery = true)
        List<Produtor> buscaProdutorPorParametros(@Param("idfil") String idfil) ;  	

}
