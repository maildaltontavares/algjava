package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.TesteQualidadeFio;
import com.santanatextiles.alg.domain.TesteQualidadeFioId;
import com.santanatextiles.alg.projections.TesteQualidadeFioProjection;

@Repository
public interface TesteQualidadeFioRepository extends JpaRepository<TesteQualidadeFio, TesteQualidadeFioId>{
 
	  
	    @Transactional(readOnly=true)
	    List<TesteQualidadeFio>  findByIdfil(String idfil);  
	    
	    @Transactional(readOnly=true)
	    TesteQualidadeFio  findById(Double id);  	    
	    
    
	    @Query(value = 
	    		"SELECT 	" + 
		        " J1.IDFIL idfil , 	" + 
		        " J1DTTEST dataTeste,	" + 
		        " J1TURNO turno, 	" + 
		        " B2DESC descTipoMaquina,  	" + 
		        " J1LOCAL maquina,	" + 
		        " J1LADO lado, 	" + 
		        " J1ITEM item,	" + 
		        " J1LOTFIA loteFiacao,	" + 
		        " j3desc descTipoTeste,	" + 
		        " J1ID id,         	" + 
		        " J1DTINC dataInclusao ,	" + 
		        " substr(J1CODMAQ,3,2) tipoMaquina 	" + 
		        " from	" + 
		        " cpf.cpfj1_dbf j1 	" + 
		        " left join cpf.cpfb2_dbf b2 on b2.idfil = '01' and b2.b2cod = SUBSTR(J1CODMAQ,3,2)	" + 
		        " left join cpf.cpfj3_dbf j3 on  j1.idfil = j3.idfil and J1TPTEST = j3.J3COD	" + 
		        "  where	" + 
		        " j1.idfil =  STL.FN_STL_IDFIL('CPFJ1',:idfil)    and     	" + 
		  	    " (:dataInicial  IS NULL     OR TO_CHAR(J1DTINC,'YYYYMMDD') >= :dataInicial )   and " +
			    " (:dataFinal    IS NULL     OR TO_CHAR(J1DTINC,'YYYYMMDD') <= :dataFinal )   and " + 	
			    " (:tipoMaquina  IS NULL     OR substr(J1CODMAQ,3,2) = :tipoMaquina) and  " + 
			    " (:lote         IS NULL     OR J1LOTFIA  =  :lote  )    and " +
			    " (:turno        IS NULL     OR J1TURNO = :turno  )    and " +
			    " (:item         IS NULL     OR TRIM(J1ITEM) = TRIM(:item)  )    and " +
			    " (:localFisico  IS NULL     OR TRIM(J1LOCAL) = :localFisico  )  "  +
		        " order by J1DTINC, J1TURNO,descTipoMaquina,J1LOCAL  "
				,nativeQuery = true)	
	             List<TesteQualidadeFioProjection> pesquisaTesteQualidadeFioPorParametros(
		        		@Param("idfil") String idfil,
		        		@Param("dataInicial") String dataInicial,
		        		@Param("dataFinal") String dataFinal,
		        		@Param("tipoMaquina") String tipoMaquina,
		        		@Param("turno") String turno,
		        		@Param("localFisico") String localFisico,         
		        		@Param("lote") String lote ,
		        		@Param("item") String item
		        		) ; 	 
	  
	     
	    
	    
	    
	    
	     
	    
	    
	    @Query(value = "SELECT 	" + 
	    		" IDFIL ," +
	    		" J1TPTEST," +
	    		" J1DOBRA," +
	    		" J1DTTEST," +
	    		" J1TURNO," +
	    		" J1OPER," +
	    		" J1LOCAL," +
	    		" J1LADO," +
	    		" J1CODMAQ," +
	    		" J1ITEM," +
	    		" J1LOTFIA," +
	    		" J1ID," +
	    		" J1ESTIRA," + 
	    		" J1OBS, " + 
	    		" J1USRINC," +
	    		" J1DTINC," +
	    		" J1USRALT," +
	    		" J1DTALT " +
				" from cpf.cpfj1_dbf j1" + 
	    		" where " +
	    		" j1.idfil =  STL.FN_STL_IDFIL('CPFJ1',:idfil)     and " + 
	    		" substr(J1CODMAQ,1,2)         = :idfil            and      " +
	    		" substr(J1CODMAQ,3,2)         =  :tipoMaquina     and    " +
	    		" TO_CHAR(J1DTTEST,'YYYYMMDD') =  :dataTeste       and " + 
				" TRIM(J1LOCAL) = TRIM(:localFisico)               and  " +
				 " J1TURNO       = :turno                          and " + 
				 " TRIM(J1ITEM)  = TRIM(:item)                     and " +
				 " J1TPTEST      = :tipoTeste                      and " +
			     " J1LADO        = :lado      " 
	    		
			,nativeQuery = true)	
            TesteQualidadeFio   buscaTesteQualidadeFioPorChave(
            		@Param("idfil") String idfil,
            		@Param("tipoMaquina") String tipoMaquina,
            		@Param("dataTeste") String dataTeste,
            		@Param("localFisico") String localFisico,
            		@Param("lado") String lado,
            		@Param("turno") String turno,
            		@Param("item") String item,
            		@Param("tipoTeste") String tipoTeste  
            		
            		) ;	    
	    
	    
	    
	    @Query(value = "SELECT 	" + 
	    		" IDFIL ," +
	    		" J1TPTEST," +
	    		" J1DOBRA," +
	    		" J1DTTEST," +
	    		" J1TURNO," +
	    		" J1OPER," +
	    		" J1LOCAL," +
	    		" J1LADO," +
	    		" J1CODMAQ," +
	    		" J1ITEM," +
	    		" J1LOTFIA," +
	    		" J1ID," +
	    		" J1ESTIRA," + 
	    		" J1OBS, " + 
	    		" J1USRINC," +
	    		" J1DTINC," +
	    		" J1USRALT," +
	    		" J1DTALT " +
				" from cpf.cpfj1_dbf j1" + 
	    		" where j1.idfil =  STL.FN_STL_IDFIL('CPFJ1',?1)"
				,nativeQuery = true)
        List<TesteQualidadeFio> buscaTesteQualidadeFioPorParametros(@Param("idfil") String idfil) ;	    
	    
	    
		@Query(value="SELECT CPF.CPFJ1_ID_SQ.NEXTVAL FROM DUAL", nativeQuery = true)  
		Double codigoNovoTeste();   	
		
		@Modifying
		@Query(value="DELETE FROM CPF.CPFJ1_DBF WHERE J1ID = ?1", nativeQuery = true)  
		void deletaTeste(@Param("id") Double id); 
		
		@Modifying
		@Query(value="DELETE FROM CPF.CPFJ2_DBF WHERE J2IDPAI = ?1", nativeQuery = true)  
		void deletaDetalheTeste(@Param("id") Double id); 		


 

}
