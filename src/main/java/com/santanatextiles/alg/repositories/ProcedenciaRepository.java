package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.Procedencia;
import com.santanatextiles.alg.domain.ProcedenciaId; 
	
@Repository
public interface ProcedenciaRepository extends JpaRepository<Procedencia, ProcedenciaId>{
		 
	    @Query(value = "SELECT 	" + 
				" IDFIL 	,  " +
				" M7COD 	,  " + 	
				" M7DESC 	   " + 	
				" FROM CPFM7_DBF M7 "  +
				" where m7.idfil =  STL.FN_STL_IDFIL('CPFM7',?1) order by  M7DESC"
				,nativeQuery = true)
        List<Procedencia> buscaProcedenciaPorParametros(@Param("idfil") String idfil) ;    
	    
		@Transactional(readOnly=true)
		List<Procedencia>  findByIdfil(String idfil);  	    

}
