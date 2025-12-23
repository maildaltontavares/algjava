package com.santanatextiles.alg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.FardoDocumentoItem;

@Repository
public interface FardoDocumentoItemRepository extends JpaRepository<FardoDocumentoItem, Double>{
	
	
	@Query(value="SELECT CPF.SQ_CPF_FARDOS.NEXTVAL FROM DUAL", nativeQuery = true)  
	Double codigoNovoId();  
	
	@Transactional
	Double deleteByIdFardo(Double idFardo ); 		
	
    @Transactional(readOnly=true)
    FardoDocumentoItem findByIdFardo(Double idFardo);  
    
	@Query(value="SELECT COUNT(*) NUM_REG  FROM CPF.CPFT4_DBF T4 WHERE IDFIL = ?1 AND T4IDMOV = ?2", nativeQuery = true)
	Double contarMovimentoFardo(String idfil,Double idMov);     

}
