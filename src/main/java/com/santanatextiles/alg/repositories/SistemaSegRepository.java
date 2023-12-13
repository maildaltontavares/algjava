package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.santanatextiles.alg.domain.SistemaSeg;

@Repository
public interface SistemaSegRepository  extends JpaRepository<SistemaSeg,Long>{ 
 
	 
    @Query(value = 
    	      "Select id,sigla,descricao,tipo_login,senha_codificacao    " +
    	      " from seg.sistema order by sigla "  ,nativeQuery = true)
    		List<SistemaSeg> buscaSistema() ; 
	

}
