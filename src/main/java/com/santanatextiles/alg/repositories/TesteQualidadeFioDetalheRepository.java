package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.TesteQualidadeFioDetalhe;
import com.santanatextiles.alg.domain.TesteQualidadeFioDetalheId;

public interface TesteQualidadeFioDetalheRepository extends JpaRepository<TesteQualidadeFioDetalhe, TesteQualidadeFioDetalheId>{
	 
    @Query(value = "SELECT 	" + 
    		" IDFIL ," +  
    		" J2ID," +
    		" J2IDPAI," +
    		" J2NUMPRV," +
    		" J2NUMFUS," +
    		" J2PESO," +
    		" J2TIT " + 
			" from cpf.cpfj2_dbf j1" + 
    		" where j2.idfil =  STL.FN_STL_IDFIL('CPFJ2',?1)"
			,nativeQuery = true)
    List<TesteQualidadeFioDetalhe> buscaTesteQualidadeFioDetalhePorParametros(@Param("idfil") String idfil) ;
   
    @Transactional(readOnly=true)
    List<TesteQualidadeFioDetalhe>  findByIdfil(String idfil);    	
    
	@Query(value="SELECT CPF.CPFJ2_ID_SQ.NEXTVAL FROM DUAL", nativeQuery = true)  
	Double codigoNovoTesteDetalhe();   
	
	
	@Modifying
	@Query(value="DELETE FROM CPF.CPFJ2_DBF J2  " +
		"	WHERE  IDFIL = :idfil  AND J2IDPAI = :idPai" 	 
	, nativeQuery = true)
	int deletaResultado(@Param("idfil") String idfil ,@Param("idPai") Double idPai  );

}
