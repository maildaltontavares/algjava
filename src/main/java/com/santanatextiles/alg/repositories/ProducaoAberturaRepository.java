package com.santanatextiles.alg.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santanatextiles.alg.domain.ProducaoAbertura;
import com.santanatextiles.alg.domain.ProducaoAberturaId;
 

@Repository
public interface ProducaoAberturaRepository extends JpaRepository<ProducaoAbertura, ProducaoAberturaId>{
	 
	
		    @Query(value = "SELECT 	"+ 
			" IDFIL 	    , " +	
			" T3CODMAQ 	    , " +	
			" T3DTALT 	    , " +	
			" T3DTINC 	    , " +	
			" T3DTMOV 	    , " +	
			" T3HRINI 	    , " +	
			" T3IDAUTO 	    , " +	
			" T3LADO 	    , " +	
			" T3LF 	    , " +	
			" T3MIST 	    , " +	
			" T3OBS 	    , " +	
			" T3OPER 	    , " +	
			" T3SEQ 	    , " +	
			" T3TURNO 	    , " +	
			" T3USRALT 	    , " +	
			" T3USRINC 	     " 	+ 
			" FROM CPF.CPFT3_DBF T3  "  +
		    " where T3.idfil =  STL.FN_STL_IDFIL('CPFT3',?1)  "
			,nativeQuery = true)
    		List<ProducaoAbertura> buscaProducaoAberturaPorFilial(@Param("idfil") String idfil) ;  
    
    
		    @Transactional(readOnly=true)
		    List<ProducaoAbertura>  findByIdfil(String idfil);
		    
		    @Transactional(readOnly=true)
		    Double  deleteByIdfilAndIdAutomatico(String idfil,Double idAuto);     
		    
		     
		    @Query(value = "SELECT 	"+ 
			" IDFIL 	    , " +	
			" T3CODMAQ 	    , " +	
			" T3DTALT 	    , " +	
			" T3DTINC 	    , " +	
			" T3DTMOV 	    , " +	
			" T3HRINI 	    , " +	
			" T3IDAUTO 	    , " +	
			" T3LADO 	    , " +	
			" T3LF 	    , " +	
			" T3MIST 	    , " +	
			" T3OBS 	    , " +	
			" T3OPER 	    , " +	
			" T3SEQ 	    , " +	
			" T3TURNO 	    , " +	
			" T3USRALT 	    , " +	
			" T3USRINC 	     " 	+ 
			" FROM CPF.CPFT3_DBF T3  "  +
		    " where T3.idfil =  STL.FN_STL_IDFIL('CPFT3',?1) and  T3MIST = ?2 and trim(T3SEQ) = trim(?3) "
			,nativeQuery = true)
    		ProducaoAbertura buscaProducaoAberturaPorFilialMisturaSeq(
    				@Param("idfil") String idfil,
    				@Param("mistura") String mistura,
    				@Param("seq") String seq
    				)  ;  	
		     
		     
		    
		    
		    @Query(value = "SELECT 	"+ 
    		" IDFIL 	    , " +	
			" T3CODMAQ 	    , " +	
			" T3DTALT 	    , " +	
			" T3DTINC 	    , " +	
			" T3DTMOV 	    , " +	
			" T3HRINI 	    , " +	
			" T3IDAUTO 	    , " +	
			" T3LADO 	    , " +	
			" T3LF 	        , " +	
			" T3MIST 	    , " +	
			" T3OBS 	    , " +	
			" T3OPER 	    , " +	
			" T3SEQ 	    , " +	
			" T3TURNO 	    , " +	
			" T3USRALT 	    , " +	
			" T3USRINC 	     " 	+ 
		    " FROM CPF.CPFT3_DBF T3  "  +
		    " where T3.idfil =  STL.FN_STL_IDFIL('CPFT3',:idfil) and " + 
		    " (:dataInicial IS NULL     OR TO_CHAR(T3DTMOV,'YYYYMMDD') >= :dataInicial )   and " +
		    " (:dataFinal   IS NULL     OR TO_CHAR(T3DTMOV,'YYYYMMDD') <= :dataFinal )     and " +
		    " (:mistura     IS NULL     OR T3MIST = :mistura)     " + 
		    " order by T3MIST,T3SEQ"
		    
			,nativeQuery = true)
		    List<ProducaoAbertura> buscaProducaoAberturaPorParametros(
    				@Param("idfil") String idfil,
            		@Param("dataInicial") String dataInicial,
            		@Param("dataFinal") String dataFinal,    				
    				@Param("mistura") String mistura  
    				)  ;   
		    
		    
		    // Ultima mistura apontada
 
		    @Query(value = "SELECT 	MIN(T3SEQ) sq  " +	 
	    				    " FROM CPF.CPFT3_DBF T3  "  +
	    				    " where T3.idfil =  STL.FN_STL_IDFIL('CPFT3',:idfil) and " +  
	    				    " T3MIST = :mistura and t3codmaq is null and t3lf is null      "
	    				    ,nativeQuery = true)
		    String ultMisturasBaixadas(@Param("idfil") String idfil,@Param("mistura") String mistura ) ; 		    
		    
		    
		    
		    @Modifying
			@Query(value="UPDATE CPF.CPFT3_DBF T3 SET " 
				     	+ " T3CODMAQ = :maquina,   "
				     	+ " T3LF     = :localFisico,   "
				     	+ " T3DTMOV  = :dataMovimento,   " 
				     	+ " T3TURNO  = :turno,   "
				     	+ " T3OPER   = :operador,   " 
				     	+ " T3OBS    = :observacao,   " 
				     	+ " T3HRINI  = :horaMovimento,   "  
						+ " T3LADO   = :lado,   " 
						+ " T3DTINC  = :dataInclusao,   " 
						+ " T3USRINC = :usarioInclusao,   " 
						+ " T3DTALT  = :dataAlteracao,   " 
						+ " T3USRALT = :usarioAlteracao   "   
			            +  " WHERE IDFIL = :idfil  AND T3MIST = :mistura AND trim(T3SEQ) = trim(:seq)" 	 
			, nativeQuery = true)
			Integer gravaApontamento(@Param("idfil")   String idfil ,
					             @Param("mistura") String mistura  ,
					             @Param("seq") String seq  ,
					             @Param("maquina") String maquina  ,
					             @Param("localFisico") String localFisico  ,
					             @Param("turno") String turno  , 
					             @Param("operador") String operador  ,
					             @Param("dataMovimento") Date dataMovimento  ,
					             @Param("observacao") String observacao  ,
					             @Param("lado") String lado  ,  
					             @Param("horaMovimento") Double horaMovimento  ,
					             @Param("dataInclusao") Date dataInclusao  ,
					             @Param("usarioInclusao") String usarioInclusao  ,
					             @Param("dataAlteracao") Date dataAlteracao  ,
					             @Param("usarioAlteracao") String usarioAlteracao  
					             
					
				                 );	
		    
		    @Modifying
			@Query(value="UPDATE CPF.CPFT3_DBF T3 SET " 
				     	+ " T3CODMAQ = null,   "
				     	+ " T3LF     = null,   "
				     	+ " T3DTMOV  = null,   " 
				     	+ " T3TURNO  = null,   "
				     	+ " T3OPER   = null,   " 
				     	+ " T3OBS    = null,   " 
				     	+ " T3HRINI  = null,   "  
						+ " T3LADO   = null ,  " 
						+ " T3DTINC  = null ,  " 
						+ " T3USRINC = null,   " 
						+ " T3DTALT  = null,   " 
						+ " T3USRALT = null   "   
			            +  " WHERE IDFIL = :idfil  AND T3MIST = :mistura AND trim(T3SEQ) = trim(:seq)" 	 
			, nativeQuery = true)
			Integer excluirApontamento(
    				@Param("idfil") String idfil,
    				@Param("mistura") String mistura,
    				@Param("seq") String seq
    				)  ;  	
		    
		    
		    @Query(value = "SELECT 	"+ 
			" IDFIL 	    , " +	
			" T3CODMAQ 	    , " +	
			" T3DTALT 	    , " +	
			" T3DTINC 	    , " +	
			" T3DTMOV 	    , " +	
			" T3HRINI 	    , " +	
			" T3IDAUTO 	    , " +	
			" T3LADO 	    , " +	
			" T3LF 	    , " +	
			" T3MIST 	    , " +	
			" T3OBS 	    , " +	
			" T3OPER 	    , " +	
			" T3SEQ 	    , " +	
			" T3TURNO 	    , " +	
			" T3USRALT 	    , " +	
			" T3USRINC 	     " 	+ 
			" FROM CPF.CPFT3_DBF T3  "  +
		    " where T3.idfil =  STL.FN_STL_IDFIL('CPFT3',?1) and  T3MIST = ?2  "
			,nativeQuery = true)
    		List<ProducaoAbertura> buscaProducaoAberturaPorFilialMistura(
    				@Param("idfil") String idfil,
    				@Param("mistura") String mistura 
    				)  ;  		   		  
				    
		    
	 
  	
}