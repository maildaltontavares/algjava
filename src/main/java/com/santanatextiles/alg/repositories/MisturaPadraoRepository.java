package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.MisturaPadrao;
import com.santanatextiles.alg.domain.MisturaPadraoId;
import com.santanatextiles.alg.projections.MisturaPadraoCabecProjection;

@Repository
public interface MisturaPadraoRepository extends JpaRepository<MisturaPadrao, MisturaPadraoId>{
 
	 
	
    @Query(value = "SELECT 	" + 	 
	    " IDFIL,  " +
		" T1MIST,  " +
		" T1STATUS,  " +
		" T1DTINI , " +
		" T1DTFIM  ," +
		" T1LOTE  ," +
		" T1QTDE  ," +
		" T1DTINC  ," +
		" T1USRINC  ," +
		" T1DTALT  ," +
		" T1USRALT  ," +		
		" T1OBS,  " +
		" T1QTDLIB,  " +
		" T1NUMFAR  "   +
		" FROM CPF.CPFT1_DBF T1    "   +
	    " where T1.idfil =  STL.FN_STL_IDFIL('CPFT1',?1) "
		,nativeQuery = true)
	    List<MisturaPadrao> buscaMisturaPadraoPorParametros(@Param("idfil") String idfil) ;  

    @Query(value = "SELECT 	" + 	 
    	    " T1.IDFIL,  " +
    		" T1.T1MIST,  " +
    		" T1STATUS,  " +
    		" T1DTINI , " +
    		" T1DTFIM  ," +
    		" T1LOTE  ," +
    		" T1QTDE  ," +
    		" T1DTINC  ," +
    		" T1USRINC  ," +
    		" T1DTALT  ," +
    		" T1USRALT  ," +		
    		" T1OBS,  " +
    		" T1QTDLIB,  " +
    		" T1NUMFAR  "   +
    		" FROM CPF.CPFT1_DBF T1    "   +
		    " LEFT JOIN " +
  			" (  " +
		    "    select count(*) total, t1.t1mist,t1.idfil " +   
		    "    from   " +
	    	"    cpft1_dbf t1 " +   
		    "    inner join cpf.cpfm2_dbf m2 on m2.idfil = t1.idfil and t1.t1mist = m2.m2mist " +  
		    "    where   " +
	    	"    t1.idfil = ?1    " +   
	     	"    group by t1.t1mist,t1.idfil  " +		 
		    "  ) mist_utiliz on mist_utiliz.t1mist = t1.t1mist and mist_utiliz.idfil = t1.idfil " +  
	        " where T1.idfil =  STL.FN_STL_IDFIL('CPFT1',?1)    " +
            " and ( "  + 
            "       (mist_utiliz.total < T1QTDE) and t1.t1status = 'E' and T1.idfil =  STL.FN_STL_IDFIL('CPFT1',?1)  ) or  " +
            "       ((t1.t1status    in ('A','L') or t1.t1status is null) and T1.idfil =  STL.FN_STL_IDFIL('CPFT1',?1)  "  +
            "     )   " +
            " ORDER BY T1.T1MIST DESC "
    		,nativeQuery = true)
    	    List<MisturaPadrao> buscaMisturasAbertas(@Param("idfil") String idfil) ;    
    

    @Query(value = "SELECT 	" + 	 
    	    " T1.IDFIL,  " +
    		" T1.T1MIST,  " +
    		" T1STATUS,  " +
    		" T1DTINI , " +
    		" T1DTFIM  ," +
    		" T1LOTE  ," +
    		" T1QTDE  ," +
    		" T1DTINC  ," +
    		" T1USRINC  ," +
    		" T1DTALT  ," +
    		" T1USRALT  ," +		
    		" T1OBS,  " +
    		" T1QTDLIB,  " +
    		" T1NUMFAR  "   +
    		" FROM CPF.CPFT1_DBF T1    "   +
		    " LEFT JOIN " +
  			" (  " +
		    "    select count(*) total, t1.t1mist,t1.idfil " +   
		    "    from   " +
	    	"    cpft1_dbf t1 " +   
		    "    inner join cpf.cpfm2_dbf m2 on m2.idfil = t1.idfil and t1.t1mist = m2.m2mist " +  
		    "    where   " +
	    	"    t1.idfil = ?1    " +   
	     	"    group by t1.t1mist,t1.idfil  " +		 
		    "  ) mist_utiliz on mist_utiliz.t1mist = t1.t1mist and mist_utiliz.idfil = t1.idfil " +  
	        " where T1.idfil =  STL.FN_STL_IDFIL('CPFT1',?1)    " +
            " and ( "  + 
            "       (nvl(mist_utiliz.total,0) < T1QTDE) and t1.t1status = 'E' and T1.idfil =  STL.FN_STL_IDFIL('CPFT1',?1)  ) or  " +
            "       (t1.t1status    in ('L') and T1.idfil =  STL.FN_STL_IDFIL('CPFT1',?1)  "  +
            "     )   " +
            " ORDER BY T1.T1MIST DESC "
    		,nativeQuery = true)
    	    List<MisturaPadrao> buscaMisturasABaixar(@Param("idfil") String idfil) ;     
    
    
    
    
    
    @Query(value = "SELECT 	" + 	 
    	    " T1.IDFIL,  " +
    		" T1.T1MIST,  " +
    		" T1STATUS,  " +
    		" T1DTINI , " +
    		" T1DTFIM  ," +
    		" T1LOTE  ," +
    		" T1QTDE  ," +
    		" T1DTINC  ," +
    		" T1USRINC  ," +
    		" T1DTALT  ," +
    		" T1USRALT  ," +		
    		" T1OBS,  " +
    		" T1QTDLIB,  " +
    		" T1NUMFAR  "   +
    		" FROM CPF.CPFT1_DBF T1    "   + 
 	        " where T1.idfil =  STL.FN_STL_IDFIL('CPFT1',?1)    " +
            " ORDER BY T1.T1MIST DESC "
    		,nativeQuery = true)
    	    List<MisturaPadrao> buscaMisturasFull(@Param("idfil") String idfil) ;  
    
    
    @Query(value =  
		"Select max(to_number(t1mist))+1 novaMistura from cpf.cpft1_dbf where idfil = STL.FN_STL_IDFIL('cpfJ0',?1)",nativeQuery = true)
	    String buscaNovoIdMistura(String filial) ; 
 
    @Query(value =  
    "    select max(M2SEQMST)   total " +   
    "    from   " +
	"    cpft1_dbf t1 " +   
    "    inner join cpf.cpfm2_dbf m2 on m2.idfil = t1.idfil and t1.t1mist = m2.m2mist " +  
    "    where   " +
	"    t1.idfil = ?1  and t1.t1mist = ?2  " +   
 	"    group by t1.t1mist,t1.idfil  " ,nativeQuery = true)
    Integer seqMisturasBaixadas(String filial,String mistura) ; 
    
    @Query(value =  
    "    select count(*)   total " +   
    "    from   " +
	"    cpft1_dbf t1 " +   
    "    inner join cpf.cpfm2_dbf m2 on m2.idfil = t1.idfil and t1.t1mist = m2.m2mist " +  
    "    where   " +
	"    t1.idfil = ?1  and t1.t1mist = ?2  " +   
 	"    group by t1.t1mist,t1.idfil  " ,nativeQuery = true)
    Integer numMisturasBaixadas(String filial,String mistura) ;       
    
    
    @Query(value = "SELECT 	" + 	 
    	    " T1.IDFIL idfil,  " +
    		" T1.T1MIST mistura,  " +
    		" T1STATUS status,  " +
    		" T1DTINI dataInicial, " +
    		" T1DTFIM dataFinal ," +
    		" T1LOTE loteFiacao ," +
    		" T1QTDE  quantidade," +
    		" T1DTINC dataInclusao ," +
    		" T1USRINC usuarioInclusao ," +
    		" T1DTALT dataAlteracao ," +
    		" T1USRALT usuarioAlteracao ," +		
    		" T1OBS observacao, " +
    		" T1QTDLIB numMisturasLiberadas, " +
    		" T1NUMFAR numFardos, "   +
    		" total totalUtilizadas "   +
    		" FROM CPF.CPFT1_DBF T1    "   +
		    " LEFT JOIN " +
  			" (  " +
		    "    select count(*) total, t1.t1mist,t1.idfil " +   
		    "    from   " +
	    	"    cpft1_dbf t1 " +   
		    "    inner join cpf.cpfm2_dbf m2 on m2.idfil = t1.idfil and t1.t1mist = m2.m2mist " +  
		    "    where   " +
	    	"    t1.idfil = ?1   and T1.T1MIST = ?2   " +   
	     	"    group by t1.t1mist,t1.idfil  " +		 
		    "  ) mist_utiliz on mist_utiliz.t1mist = t1.t1mist and mist_utiliz.idfil = t1.idfil " +  
	        " where T1.idfil =  STL.FN_STL_IDFIL('CPFT1',?1)    " +
            " and T1.T1MIST = ?2 " 
    		,nativeQuery = true)
    	    List<MisturaPadraoCabecProjection> buscaMisturaCalculada(@Param("idfil") String idfil,@Param("mistura") String mistura) ;  
    
    
            @Transactional(readOnly=true)
            List<MisturaPadrao>  findByIdfil(String idfil);       
	    
            
        	@Transactional
        	Double deleteByIdfilAndMistura(String idfil ,String mistura );    
        	
        	@Transactional
        	@Query(value="SELECT T1QTDE FROM CPF.CPFT1_DBF T1  WHERE idfil = :idfil AND T1MIST = :mistura", nativeQuery = true)
        	Integer qtdeMistura(@Param("idfil") String idfil,@Param("mistura") String mistura) ;         	
        	
        	
        	@Modifying
        	@Query(value="UPDATE CPF.CPFT1_DBF T1  SET T1STATUS = 'L', T1QTDLIB = :qtdeMistLiberadas WHERE idfil = :idfil AND T1MIST = :mistura", nativeQuery = true)
        	Double liberarMistura(@Param("idfil") String idfil,@Param("mistura") String mistura,@Param("qtdeMistLiberadas") String qtdeMistLiberadas) ;   
        	
        	@Modifying
        	@Query(value="UPDATE CPF.CPFT1_DBF T1  SET T1STATUS = 'E' WHERE idfil = :idfil AND T1MIST = :mistura", nativeQuery = true)
        	Integer encerrarMistura(@Param("idfil") String idfil,@Param("mistura") String mistura) ;           	
        	
        	@Modifying
        	@Query(value="UPDATE CPF.CPFT1_DBF T1  SET T1STATUS = 'A' , T1QTDLIB = 0 WHERE idfil = :idfil AND T1MIST = :mistura", nativeQuery = true)
        	Integer reabrirMistura(@Param("idfil") String idfil,@Param("mistura") String mistura) ; 
    
    

}
