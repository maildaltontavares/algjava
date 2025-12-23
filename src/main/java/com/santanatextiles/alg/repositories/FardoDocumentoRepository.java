package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.EstoqueMP;
import com.santanatextiles.alg.domain.FardoDocumento;

@Repository
public interface FardoDocumentoRepository  extends JpaRepository<FardoDocumento, Double>{
	
	
	@Query(value="SELECT CPF.SQ_CPF_FARDOS.NEXTVAL FROM DUAL", nativeQuery = true)  
	Double codigoNovoId();   
	
	
	
    @Transactional(readOnly=true)
    FardoDocumento findByIdMov(Double idMov); 
    
	@Transactional
	Double deleteByIdMov(Double idMov ); 
	
	

}
