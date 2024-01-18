package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.MovimentoItem;
import com.santanatextiles.alg.domain.MovimentoItemId;

 
	
public interface MovimentoItemRepository extends JpaRepository<MovimentoItem, MovimentoItemId>{
		 
    @Query(value = "SELECT 	"+ 
			" IDFIL 	    , " +	
			" M3NF 	   	    , " +	
			" M3FORN   	    , " +
			" M3QTDE 	    , " +	
			" M3PESO 	    , " +	
			" M3ID 	   		, " +	
			" M3IDCAB 	    , " +	
			" M3VLUNIT 	    , " +	
			" M3IDMOV 	    , " +	
			" M3DTINC 	    , " +	
			" M3USRINC 	    , " +	
			" M3DTALT 	    , " +	
			" M3USRALT 	    , " +	
			" M3PSCALC 	    , " +	
			" M3PSMDNF 	    , " +	
			" M3OBS 	    , " +	
			" M3TAM 	    , " +	
			" M3SAC 	    , " +	
			" M3TRID 	    , " +	
			" M3PIM 	    , " +	
			" M3SC 	        , " +	
			" M3ITEM 	    , " +	
			" M3UM 	        , " +	
			" M3LOTE 	    , " +	
			" M3DESCF 	    , " +	
			" M3QUAL 	    , " +	
			" M3ORIG 	    , " +	
			" M3PROCED 	    , " +	
			" M3PILHA 	    , " +	
			" M3MST 	    , " +	
			" M3MIC 	    , " +	
			" M3MAT 	    , " +	
			" M3UI 	 	    , " +	
			" M3SF 	   		, " +	
			" M3STR 	    , " +	
			" M3ELG 	    , " +	
			" M3TIPO 	    , " +	
			" M3SIC 	    , " +	
			" M3MOVAUT 	    , " +	
			" M3MOVPIL 	    , " +	
			" M3IDAUTO 	    , " +	
			" M3UHML 	    , " +	
			" M3RS 	   		, " +	
			" M3B 	   		, " +	
			" M3TRCNT 	    , " +	
			" M3TRAR 	      " +
			" FROM CPF.CPFM3_DBF M3  "  +
		    " where m3.idfil =  STL.FN_STL_IDFIL('CPFM3',?1)  "
			,nativeQuery = true)
    		List<MovimentoItem> buscaMovimentoItemPorParametros(@Param("idfil") String idfil) ;  
    
    
		    @Transactional(readOnly=true)
		    List<MovimentoItem>  findByIdfil(String idfil);       
	    
    		@Query(value="SELECT CPF.CPFM3_ID_SQ.NEXTVAL FROM DUAL", nativeQuery = true)
    		Double codigoNovoMovimentoItem(); 	
    		
    		@Transactional
    		Double deleteByIdItem(Double idItem ); 	    		
		    
	
		    @Transactional(readOnly=true)
		    List<MovimentoItem>  findByIdCab(Double idCab);    
    		
  	
}
