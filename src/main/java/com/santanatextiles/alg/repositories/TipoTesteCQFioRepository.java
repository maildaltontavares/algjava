package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.TipoTesteCQFio;
import com.santanatextiles.alg.domain.TipoTesteCQFioId;

@Repository
public interface TipoTesteCQFioRepository extends JpaRepository<TipoTesteCQFio, TipoTesteCQFioId>{
		 
	    @Query(value = "SELECT 	" + 
	    		" IDFIL ," +
	    		" J3COD ," +
	    		" J3DESC " + 
				" from cpf.cpfj3_dbf j3 " + 
	    		" where j3.idfil =  STL.FN_STL_IDFIL('CPFJ3',?1)"
				,nativeQuery = true)
        List<TipoTesteCQFio> buscaTipoTesteCQFioPorParametros(@Param("idfil") String idfil) ;
	   
	    @Transactional(readOnly=true)
	    List<TipoTesteCQFio>  findByIdfil(String idfil);    	

 

}
