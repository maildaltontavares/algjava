package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.MovimentoItem;
import com.santanatextiles.alg.domain.MovimentoItemId;
import com.santanatextiles.alg.dto.SaldoPesquisaIdDTO;
import com.santanatextiles.alg.projections.IdLoteDocumentoProjection;
import com.santanatextiles.alg.projections.SaldoPesquisaIdProjection;

 
@Repository	
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
			" M3TRAR 	    , " + 
			" M3TPQ 	    , " +
			" M3CLASQ 	    , " +
			" M3COLOR 	    , " +
			" M3IDFARD 	    , " +
			" M3TPMIC 	    , " +
			" M3DEST 	    , " +
			" M3TRAR, 	      " + 
			" M3CORTEZ	      " + 
			" FROM CPF.CPFM3_DBF M3  "  +
		    " where m3.idfil =  STL.FN_STL_IDFIL('CPFM3',?1)  "
			,nativeQuery = true)
    		List<MovimentoItem> buscaMovimentoItemPorParametros(@Param("idfil") String idfil) ;  
    
    
			@Query(value="SELECT COUNT(*) NUM_REG  FROM CPF.CPFM3_DBF M3 WHERE IDFIL = ?1 AND M3IDMOV = ?2", nativeQuery = true)
			Double contarMovimentoItem(String idfil,Double idItem);  
    
		    @Transactional(readOnly=true)
		    List<MovimentoItem>  findByIdfil(String idfil);       
	     
    		@Query(value="SELECT CPF.CPFM3_ID_SQ.NEXTVAL FROM DUAL", nativeQuery = true)
    		Double codigoNovoMovimentoItem(); 	  
    		
    		@Transactional
    		Double deleteByIdItem(Double idItem ); 	    		
		    
	
		    @Transactional(readOnly=true)
		    List<MovimentoItem>  findByIdCab(Double idCab);    
    		
		    @Modifying
			@Query(value="UPDATE CPF.CPFM3_DBF M3 SET  M3PESO = M3QTDE * :pesoMedio   ,  M3PSMDNF = :pesoMedio  " +
				"	WHERE  IDFIL = :idfil  AND M3IDMOV = :idMovto" 	 
			, nativeQuery = true)
			int atualizaPesoMedMovtos(@Param("idfil") String idfil ,@Param("idMovto") Double idMovto ,    @Param("pesoMedio") Double pesoMedio  );
		    
		    
		    @Query(value =  
		    	    "SELECT   " +   
		    	    " M4.M4ID idmov,             " +    
		    	    " TRIM(M6desc) PRODUTOR,  " +    
		    	    "  M4PILHA PILHA,          " +
		    	    " substr(M4LOTE,1,10) LOTE,  " +  
		    	    " TRIM(TO_CHAR(M4QTDE)) QTDE,     " +
		    	    " DECODE(TRIM(B2NOMREDUZ),'',TRIM(SUBSTR(B2NOME,1,15))  ,B2NOMREDUZ) NMFORN,  " +   
		    	    " m4item ITEM,                                                                " +    
		    	    " m4descf nomeItem,                                                          " +  
		    	    " M4UM UM,                                                                    " +   
		    	    " TRIM(M4.M4PROCED) PROCEDENCIA,                                                   " +        
		    	    " M4NF NF,  " +   
		    	    " M4FORN FORNECEDOR,  " +   
		    	    " M4PESO PESO,  " +   
		    	    " NVL(M4VLEST,0) VLEST ,  " +    
		    	    " M4PESMED PESOMEDIO,  " +
		    	    " M4TAM TAMANHO  ," +	 
		    		" M4TPQ tipoQualidade   ," +
		    		" M4CLASQ classifQualidade ," +
		    		" M4COLOR coloracao ," +
		    		" M4LTADIC loteAdicional, " +
		    		" M4IDFARD idVolume," +
		    		" M4TPMIC tipoMic," +
		    		" M4DEST destino,  " +
		    		 "M4CORTEZ corteza" +
		    	    " FROM CPF.CPFM4_DBF M4  " +       
		    	    " LEFT join CCP.CCPB2_DBF b2 on b2.idfil = STL.FN_STL_IDFIL('CCPB2', m4.IDFIL) and trim(m4.M4FORN) = b2.B2COD  " +   
		    	    " LEFT JOIN CPF.CPFM6_DBF M6 ON M6.IDFIL = STL.FN_STL_IDFIL('CPFM6', m4.IDFIL)  AND M6COD = m4.M4ORIG  " +    
		    	    " WHERE M4.IDFIL = :filial  AND " +
		    	    " trim(M4.M4ITEM) = :item   AND " + 
		            " (:produtor IS NULL  OR   M6COD  = :produtor)  AND " +
		            " (:lote     IS NULL  OR   trim(M4LOTE) =:lote    )  AND " +        
		    	    "  M4QTDE >= 0  " +   
		    	    " ORDER BY M6desc, M4.M4LOTE  "  
		    	    ,nativeQuery = true)
		    	    List<SaldoPesquisaIdProjection> pesquisaSaldoId(  
		    			@Param("filial") String filial ,
		    		    @Param("produtor") String produtor  ,
		    		    @Param("lote") String lote   ,
		    		    @Param("item") String item     
		    			
		    		) ;	    
		    
		    
		   
		    @Query(value =  
		    	   "Select " + 
		    	    " M3.IDFIL idfil,  " + 
				    " round(M3IDMOV,0) idMov, " +
				    " round(T5ID,0) id, " +		    	    
				    " trim(M2NF) nf, " +   
				    " (TRIM(M6DESC) || ' (' || M6COD || ')')   produtor, " + 
				    " trim(M3LOTE) loteForn, " + 
				    " DECODE(TRIM(B2NOMREDUZ),'',TRIM(SUBSTR(B2NOME,1,30))  ,trim(B2NOMREDUZ)) nmForn, " + 
				    " M2DTEMI dtEmissao,  " + 
				    " M2DTBASE dtMovimento, " + 
				    " M2TPMOV tipoMovimento, " +
				    " trim(m3item) item, " + 
				    " trim(m3descf) descItem,  " + 
				    " M3QTDE qtde," + 
				    " M3PESO peso,   " +
				    " M6COD codProdutor   ," + 	
				    " b2cod codFornecedor ,  " + 
				    " b2nome nomeFornecedor, " +
				    " B2NOMREDUZ nomeRedFornecedor " +
				    " FROM CPF.CPFM3_DBF M3 " + 
				    " LEFT JOIN CPF.CPFM2_DBF M2 ON M2.IDFIL = M3.IDFIL AND M2.M2ID = M3.M3IDCAB " + 
				    " LEFT join CCP.CCPB2_DBF b2 on b2.idfil = STL.FN_STL_IDFIL('CCPB2', m2.IDFIL) and trim(m2.M2FORN) = b2.B2COD " + 
				    " LEFT JOIN CPF.CPFM4_DBF M4 ON M4.IDFIL = M3.IDFIL AND M3.M3IDMOV = M4.M4ID " + 
				    " LEFT JOIN CPF.CPFT5_DBF T5 ON T5.IDFIL = M3.IDFIL AND M3.M3IDMOV = T5.T5IDMOV " +
				    " LEFT JOIN CPF.CPFM6_DBF M6 ON M6.IDFIL =  STL.FN_STL_IDFIL('CPFM6', m4.IDFIL) AND M6COD = M4.M4ORIG " + 
				    " WHERE M3.IDFIL = :filial  AND " +
				    " ( :tipoMovto  IS NULL  OR trim(M2TPMOV) = :tipoMovto ) AND  " + 
				    " (:id  IS NULL  OR M3IDMOV = :id    )  AND " +
				    " (:id  IS NULL  OR M3IDMOV = M3ID    )  AND " +  
				    " (:fornecedor  IS NULL  OR B2NOME like %:fornecedor%    )  AND " +
				    " (:documento   IS NULL  OR trim(M2NF) =trim(:documento)    )  AND " + 
				    " (:item     IS NULL  OR   trim(m3item) =:item    )  AND " +  
				    " (:lote     IS NULL  OR   trim(M3LOTE) =trim(:lote)    )  AND " +  
				    " (:produtor IS NULL  OR   M6COD  = :produtor) " +
				    " order by M2DTBASE desc, M6DESC,M3LOTE "
		    	    ,nativeQuery = true)
		    	    List<IdLoteDocumentoProjection> pesquisaIdLoteDoc(  
		    			@Param("filial") String filial ,
		    			@Param("tipoMovto") String tipoMovto ,
		    		    @Param("fornecedor") String fornecedor  ,
		    		    @Param("documento") String documento  ,
		    		    @Param("produtor") String produtor  ,
		    		    @Param("lote") String lote   ,
		    		    @Param("item") String item ,
		    		    @Param("id") Double id  
		    
		    
		            ) ; 
		    
		    

		    
		     
		    
}
