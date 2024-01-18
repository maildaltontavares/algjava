package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.EstoqueMP;
import com.santanatextiles.alg.domain.EstoqueMPId;
import com.santanatextiles.alg.projections.SaldoIdMovtoProjection;
import com.santanatextiles.alg.projections.SaldoPesquisaIdProjection;

import jakarta.persistence.Column;

@Repository
public interface EstoqueMPRepository extends JpaRepository<EstoqueMP, EstoqueMPId>{
	
    @Query(value = "SELECT 	" +  
	    " IDFIL,    " + 
		" M4NF,     " +
		" M4FORN,   " +  
		" M4ITEM,   " +
		" M4UM,     " +
		" M4LOTE,   " +
		" M4QTDE,   " +
		" M4PESO,   " +
		" M4DESCF,  " +
		" M4ID,     " +
		" M4QUAL,   " +
		" M4IDCAB,  " +
		" M4VLEST,  " +
		" M4DTINC,  " +
		" M4USRINC, " +
		" M4DTALT,  " +
		" M4USRALT, " +
		" M4PESMED, " +
		" M4ORIG,   " +
		" M4PROCED, " +
		" M4DTMOV,  " +
		" M4TAM,    " +
		" M4SAC,    " +
		" M4TRID,   " +
		" M4PIM,    " +
		" M4SC,     " +
		" M4PILHA,  " +
		" M4MST,    " +
		" M4MIC,    " +
		" M4MAT,    " +
		" M4UI,     " +
		" M4SF,     " +
		" M4STR,    " +
		" M4ELG,    " +
		" M4TIPO,   " +
		" M4SIC,    " +
		" M4UHML,   " +
		" M4RS,     " +
		" M4B,      " +
		" M4TRCNT,  " +
		" M4TRAR    " +
		" FROM CPF.CPFM4_DBF M4    "  +
        " where m4.idfil =  STL.FN_STL_IDFIL('CPFM4',?1) and M4QTDE > 0  order by M4ID"
		,nativeQuery = true)
	    List<EstoqueMP> buscaEstoqueMPPorParametros(@Param("idfil") String idfil ) ;   
    
	    @Transactional(readOnly=true)
	    List<EstoqueMP>  findByIdfil(String idfil);   
	    
	    @Modifying
		@Query(value="UPDATE CPF.CPFM4_DBF M4 SET M4QTDE = :quantidade  ,  M4PESO = :peso  ,  M4VLEST = :vlEstoque  " +
			"	WHERE IDFIL = :idfil  AND M4ID = :idMovto" 	 
		, nativeQuery = true)
		int atualizaEstoque(@Param("idfil") String idfil , @Param("idMovto") Double idMovto , @Param("quantidade") Double quantidade ,  @Param("peso") Double peso ,   @Param("vlEstoque") Double vlEstoque );	    
    	 
	    @Query(value =  
	    "SELECT IDMOV,SUM(QTDE) QTDE,SUM(PESO) PESO,SUM(VLEST) VLEST " +
	    " FROM " +
	    " ( " +
	    "        SELECT   " +
	    "        M3IDMOV IDMOV,  " +
	    "        SUM(M3QTDE*-1) QTDE,  " +
	    "        SUM(M3PESO*-1) PESO,  " +
	    "        SUM(M3PESO*M3VLUNIT*-1) VLEST  " +
	    "        FROM CPF.CPFM3_DBF M3  "  +
	    "        LEFT JOIN cpf.cpfm2_dbf m2  on m2.idfil = m3.idfil and M2ID = M3.M3IDCAB   " +
	    "        LEFT JOIN CPF.CPFM5_DBF M5 ON M5.idfil = STL.FN_STL_IDFIL('CPFM5', m3.IDFIL) AND TRIM(M5.M5CDMOV) = TRIM(M2.M2TPMOV)  " +
	    "        WHERE m3.IDFIL = ?1  AND M5.M5ATLEST = 'S' AND M2ENTSAI = 'S' AND M3IDMOV = ?2  "   +
	    "        GROUP BY M3IDMOV " + 
	    "        UNION ALL " + 
	    "        SELECT  " +
	    "        M3IDMOV IDMOV,  " +
	    "        SUM(M3QTDE) QTDE,  "  +
	    "        SUM(M3PESO) PESO,  " +
	    "        SUM(M3PESO*M3VLUNIT) VLEST  " +
	    "        FROM CPF.CPFM3_DBF M3 "   +
	    "        LEFT JOIN cpf.cpfm2_dbf m2  on m2.idfil = m3.idfil and M2ID = M3.M3IDCAB   " +
	    "        LEFT JOIN CPF.CPFM5_DBF M5 ON M5.idfil = STL.FN_STL_IDFIL('CPFM5', m3.IDFIL) AND TRIM(M5.M5CDMOV) = TRIM(M2.M2TPMOV)   " +
	    "        WHERE m3.IDFIL = ?1 AND M5.M5ATLEST = 'S'  AND M2ENTSAI = 'E' AND M3IDMOV = ?2  "    + 
	    "        GROUP BY M3IDMOV " +
	    " )  " +
	    " GROUP BY IDMOV  "	 
	     ,nativeQuery = true)
	    List<SaldoIdMovtoProjection> buscaSaldoIdMovto(String filial, Double idMovto) ;
	    
	     
	     
	    
	    
	     	    
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
	    " M4TAM TAMANHO  " +	    
	    " FROM CPF.CPFM4_DBF M4  " +       
	    " LEFT join CCP.CCPB2_DBF b2 on b2.idfil = STL.FN_STL_IDFIL('CCPB2', m4.IDFIL) and trim(m4.M4FORN) = b2.B2COD  " +   
	    " LEFT JOIN CPF.CPFM6_DBF M6 ON M6.IDFIL = STL.FN_STL_IDFIL('CPFM6', m4.IDFIL)  AND M6COD = m4.M4ORIG  " +    
	    " WHERE M4.IDFIL = :filial   AND " +
	    " trim(M4.M4ITEM) = :item   AND " + 
        " (:produtor IS NULL  OR   M6COD  = :produtor)  AND " +
        " (:lote     IS NULL  OR   M4LOTE like %:lote%    )  AND " + 
	    "  M4QTDE <> 0  " +   
	    " ORDER BY M6desc, M4.M4LOTE  "  
	    ,nativeQuery = true)
	    List<SaldoPesquisaIdProjection> pesquisaSaldoId(  
			@Param("filial") String filial ,
		    @Param("produtor") String produtor  ,
		    @Param("lote") String lote   ,
		    @Param("item") String item     
			
		) ;
	    
	 // " (:produtor IS NULL  OR  UPPER(TRIM(M6DESC)) like %:produtor% )  " +
	    

	    
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
	    " M4TAM TAMANHO  " +	    
	    " FROM CPF.CPFM4_DBF M4  " +       
	    " LEFT join CCP.CCPB2_DBF b2 on b2.idfil = STL.FN_STL_IDFIL('CCPB2', m4.IDFIL) and trim(m4.M4FORN) = b2.B2COD  " +   
	    " LEFT JOIN CPF.CPFM6_DBF M6 ON M6.IDFIL = STL.FN_STL_IDFIL('CPFM6', m4.IDFIL)  AND M6COD = m4.M4ORIG  " +    
	    " WHERE M4.M4ID = :id  "  
	    ,nativeQuery = true)
	    List<SaldoPesquisaIdProjection> buscaEstoqueMPPorId(  
		 
		    @Param("id") Double id    
			
		) ;
	    	    
	    
		@Transactional
		Double deleteById(Double id ); 	    
	    
	    
	    
	    
	    
	    
	     


}
