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
import com.santanatextiles.alg.projections.MisturaPadraoProjection;
import com.santanatextiles.alg.projections.SaldoIdMovtoProjection;
import com.santanatextiles.alg.projections.SaldoPesquisaIdProjection;

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
		" M4TRAR  , " +
		" M4TPQ    ," +
		" M4CLASQ  ," +
		" M4COLOR  ," +
		" M4LTADIC, " +
		" M4IDFARD," +
		" M4TPMIC ," +
		" M4TPMIC,  " +		
		" M4CORTEZ  " +
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
    	 
	    
	  
	    @Modifying
		@Query(value="UPDATE CPF.CPFM4_DBF M4 SET M4QTDE = :quantidade  ,  M4PESO = :peso  ,  M4VLEST = :vlEstoque , M4PESMED = :pesoMedio  " +
			"	WHERE IDFIL = :idfil  AND M4ID = :idMovto" 	 
		, nativeQuery = true)
		int atualizaEstoqueEPesoMedio(@Param("idfil") String idfil , @Param("idMovto") Double idMovto , @Param("quantidade") Double quantidade ,  @Param("peso") Double peso ,   @Param("vlEstoque") Double vlEstoque ,   @Param("pesoMedio") Double pesoMedio  );	    
	   
	    
	    @Modifying
		@Query(value="UPDATE CPF.CPFM4_DBF M4 SET M4PILHA = :pilha   " +
		             " WHERE IDFIL = :idfil  AND M4ID = :idMovto" 	 
		, nativeQuery = true)
		int atualizaPilha(@Param("idfil") String idfil , @Param("idMovto") Double idMovto  , @Param("pilha") String  pilha );	 
	    
	    
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
	    	     "Select count(*) qtdDest from " +
	    	     " ( " +
	    	     "    Select m4dest from cpf.cpft2_dbf t2  " +
	    	     "    inner join cpf.cpfm4_dbf m4 on t2.t2id = m4.m4id " +
	    	     "    where t2.idfil = ?1  and trim(t2mist) =  ?2 "    +
	    	     "    group by m4dest " +
	    	     " )  ",nativeQuery = true)
	  Integer quantidadeDestinos(String filial,String mistura) ;  	    
	    

	    
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
	    " M4TAM TAMANHO  ,"  +
	    " M4TPQ tipoQualidade   ," +
		" M4CLASQ classifQualidade ," +
		" M4COLOR coloracao ," +
		" M4LTADIC loteAdicional, " +
		" M4IDFARD idVolume," +
		" M4TPMIC tipoMic," +
		" M4DEST destino," +
		" M4QUAL qualidade,  " +
	    " M4CORTEZ corteza " +
	    " FROM CPF.CPFM4_DBF M4  " +       
	    " LEFT join CCP.CCPB2_DBF b2 on b2.idfil = STL.FN_STL_IDFIL('CCPB2', m4.IDFIL) and trim(m4.M4FORN) = b2.B2COD  " +   
	    " LEFT JOIN CPF.CPFM6_DBF M6 ON M6.IDFIL = STL.FN_STL_IDFIL('CPFM6', m4.IDFIL)  AND M6COD = m4.M4ORIG  " +    
	    " WHERE M4.M4ID = :id  "  
	    ,nativeQuery = true)
	    List<SaldoPesquisaIdProjection> buscaEstoqueMPPorId( @Param("id") Double id  ) ;
	    	    
	    
		@Transactional
		Double deleteById(Double id ); 	    
		
		
		@Transactional
		EstoqueMP findById(Double id ); 	  
		
		
		
	    @Query(value = 
		"SELECT DECODE(TRIM(B2NOMREDUZ),'',TRIM(SUBSTR(B2NOME,1,30))  ,B2NOMREDUZ) FORN, " +  
		" M6.M6DESC PRODUT,M6.M6COD COD_PROD,M4LOTE LOTE, M4PILHA PI,   " +
		" ROUND(M4QTDE,0) ESTOQUE,   "+ 
		" reserv.frd_reserv , qtde_mist QTDE, (M4QTDE  - nvl(reserv.frd_reserv,0) ) Disponivel, "+  
		" nvl(mis_util.total_mist_util,0)  total_mist_util ,  " +
		" M4ID ,   " +
		" M4NF,    " +
		" M4DESCF,  "  +
		" M4ITEM,   "  +   
		" M4UM ,  " +
		" M4PESMED , " +   
		" M4PROCED , " +    
		" M4TAM  , "  +    
		" M4QUAL, " +     
		" M4FORN, " +     
		" M4ELG ELG,M4MAT MAT,M4MIC MIC,M4MST MST,M4SF SF,M4SIC SIC,M4STR STR,M4TIPO TIPO, M4UI UI, " +              
		" M4SAC SAC,M4TRID TRID,M4PIM PIM,M4SC SC, " +    
	    " M4B, " +    
	    " M4RS, "  +    
		" M4TRAR, " +    
		" M4TRCNT, " +    
		" M4UHML , " + 
		" Mistura , M4COLOR, DECODE(M4TPMIC,null,' ','-' || M4TPMIC) M4TPMIC ,M4DEST, M4CORTEZ " + 
		" from  " +
		" (  " +
		"     select '' tipo, ?2 mistura ,0 qtde_mist ,m4.* from cpf.CPFM4_DBF m4 " +  
		"     where   " +
		"     m4.idfil = ?1 " +   
		"     and m4id not in   " +
		"         (  " + 
		"         Select t2id from cpf.cpft2_dbf t2 " +  
		"         where t2.idfil = ?1  and T2MIST = ?2   " +
		"          )  " +
		"     and m4qtde > 0 AND M4ORIG IS NOT NULL" +      
		"     union all " +  
		"     select 'M' tipo ,t2mist mistura, t2qtde qtde_mist ,m4.* from cpf.CPFM4_DBF m4 "  +  
		"     inner join cpf.cpft2_dbf t2 on t2.idfil = m4.idfil and t2.t2id = m4.m4id " +   
		"     where   " +
		"     t2.idfil = ?1  and T2MIST = ?2   " +  
		" ) Est_mist " +  
		" left join   " +
     	"   (  " +
			"         Select  idfil, t2id ,sum(fardos_reserv) frd_reserv " +  
			"         from  " +
			"         (  " +
			"                 select " +   
			"                 t2.idfil, t2id , t2mist, " +  
			"                 sum(nvl(mist_utiliz.total,0)) mist_utilizadas, " +  
			"                 sum( t1qtde) total_misturas ,  " +
			"                 (sum( t1qtde) - sum(nvl(mist_utiliz.total,0))) saldo_misturas , " +  
			"                 sum( t2qtde) num_fardos  ,  " +
			"                 ((sum( t1qtde) - sum(nvl(mist_utiliz.total,0))) * sum( t2qtde) ) fardos_reserv " +   
			"                 from cpft2_dbf t2  " +
			"                 inner join cpf.cpft1_dbf t1 on t1.idfil = t2.idfil and t1.t1mist = t2.t2mist " +  
			"                 left  join (  " +
			"                             select count(*) total, t1.t1mist,t1.idfil " +   
			"                             from   " +
			"                             cpft1_dbf t1 " +   
			"                             inner join cpf.cpfm2_dbf m2 on m2.idfil = t1.idfil and t1.t1mist = m2.m2mist " +  
			"                             where   " +
			"                             t1.idfil = ?1  and " +  
			"                             t1.t1status    in ('E','L') " +    
			"                             group by t1.t1mist,t1.idfil  " +		
			"                            ) mist_utiliz on mist_utiliz.t1mist = t1.t1mist and mist_utiliz.idfil = t1.idfil " +    
			"                 where T2.IDFIL = ?1  AND T2MIST <> ?2    " +
			"                 and t1.t1status   in ('E','L')  " +
			"                 group by t2id , t2mist, t2.idfil  " +
			"         )  " +
			"         group by  idfil, t2id " +        
	     "  ) reserv on est_mist.idfil = reserv.idfil and est_mist.m4id = reserv.t2id " +  
		" LEFT join CCP.CCPB2_DBF B2 on b2.idfil = STL.FN_STL_IDFIL('CCPB2', est_mist.IDFIL) and trim(est_mist.M4FORN) = b2.B2COD " +   
		" LEFT JOIN CPF.CPFM6_DBF M6 ON M6.IDFIL = STL.FN_STL_IDFIL('CPFM6', est_mist.IDFIL)  AND M6COD = est_mist.M4ORIG  " +
		" LEFT JOIN ( " +
			"            select count(*) total_mist_util, t1.t1mist,t1.idfil " +
				"        from  " +
				"        cpf.cpft1_dbf t1 " +
				"        inner join cpf.cpfm2_dbf m2 on m2.idfil = t1.idfil and t1.t1mist = m2.m2mist " +     
				"        where " +
				"        t1.idfil = ?1  and m2.m2mist = ?2 " +   
				"        group by t1.t1mist,t1.idfil " +                 
		"           ) mis_util on Est_mist.idfil = mis_util.idfil  and mis_util.t1mist  = Est_mist.mistura " + 
				"    where  est_mist.idfil = ?1 AND " + 
		        "   (?3  IS NULL  OR TRIM(est_mist.M4DEST) = ?3 )   " + 				
		"  ORDER BY M6.M6DESC,M4LOTE,1 	" 
		,nativeQuery = true)
 		List<MisturaPadraoProjection> buscaEstoqueMPMistura( String idfil , String mistura   ,String tipoFardo    ) ;
	    
	    
	    @Query(value = 
		"SELECT DECODE(TRIM(B2NOMREDUZ),'',TRIM(SUBSTR(B2NOME,1,30))  ,B2NOMREDUZ) FORN, " +  
		" M6.M6DESC PRODUT,M6.M6COD COD_PROD,M4LOTE LOTE, M4PILHA PI,   " +
		" ROUND(M4QTDE,0) ESTOQUE,   "+ 
		" 0 frd_reserv , 0 QTDE, 0 Disponivel, 0 total_mist_util , " +
		" M4ID ,   " +
		" M4NF,    " +
		" M4DESCF,  "  +
		" M4ITEM,   "  +   
		" M4UM ,  " +
		" M4PESMED , " +   
		" M4PROCED , " +    
		" M4TAM  , "  +    
		" M4QUAL, " +     
		" M4FORN, " +     
		" M4ELG ELG,M4MAT MAT,M4MIC MIC,M4MST MST,M4SF SF,M4SIC SIC,M4STR STR,M4TIPO TIPO, M4UI UI, " +              
		" M4SAC SAC,M4TRID TRID,M4PIM PIM,M4SC SC, " +    
	    " M4B, " +    
	    " M4RS, "  +    
		" M4TRAR, " +    
		" M4TRCNT, " +    
		" M4UHML , " + 
		" ' ' Mistura , M4COLOR, DECODE(M4TPMIC,null,' ','-' || M4TPMIC) M4TPMIC ,M4DEST,M7DESC ,M4TPQ, " +
		" M4CLASQ, M4CORTEZ  " + 
		" from cpf.CPFM4_DBF m4  " +		  
		" LEFT join CCP.CCPB2_DBF B2 on b2.idfil = STL.FN_STL_IDFIL('CCPB2', m4.IDFIL) and trim(m4.M4FORN) = b2.B2COD " +   
		" LEFT JOIN CPF.CPFM6_DBF M6 ON M6.IDFIL = STL.FN_STL_IDFIL('CPFM6', m4.IDFIL)  AND M6COD = m4.M4ORIG  " +
		" LEFT JOIN CPF.CPFM7_DBF M7 ON M7.IDFIL = STL.FN_STL_IDFIL('CPFM7', m4.IDFIL)  AND M7COD = m4.M4PROCED  " +
		" WHERE M4.IDFIL = :filial  AND " +
	    " trim(M4.M4ITEM) = :item   AND " + 
        " (:produtor IS NULL  OR   M6COD  = :produtor)  AND " +
        " (:lote     IS NULL  OR   M4LOTE like %:lote%    )  AND " +        
	    "  M4QTDE <> 0  " +   
		" ORDER BY M6.M6DESC,M4LOTE,1 	" 
		,nativeQuery = true)
 		List<MisturaPadraoProjection> buscaEstoqueQualidade( 
 				@Param("filial") String filial ,
 			    @Param("produtor") String produtor  ,
 			    @Param("lote") String lote   ,
 			    @Param("item") String item     
 				)  ;
	    
     
	    
	    @Query(value = 
	    		"SELECT DECODE(TRIM(B2NOMREDUZ),'',TRIM(SUBSTR(B2NOME,1,30))  ,B2NOMREDUZ) FORN, " +  
	    		" M6.M6DESC PRODUT,M6.M6COD COD_PROD,M4LOTE LOTE, M4PILHA PI,   " +
	    		" ROUND(M4QTDE,0) ESTOQUE,   "+ 
	    		" 0 frd_reserv , 0 QTDE, 0 Disponivel, 0 total_mist_util , " +
	    		" M4ID ,   " +
	    		" M4NF,    " +
	    		" M4DESCF,  "  +
	    		" M4ITEM,   "  +   
	    		" M4UM ,  " +
	    		" M4PESMED , " +   
	    		" M4PROCED , " +    
	    		" M4TAM  , "  +    
	    		" M4QUAL, " +     
	    		" M4FORN, " +     
	    		" M4ELG ELG,M4MAT MAT,M4MIC MIC,M4MST MST,M4SF SF,M4SIC SIC,M4STR STR,M4TIPO TIPO, M4UI UI, " +              
	    		" M4SAC SAC,M4TRID TRID,M4PIM PIM,M4SC SC, " +    
	    	    " M4B, " +    
	    	    " M4RS, "  +    
	    		" M4TRAR, " +    
	    		" M4TRCNT, " +    
	    		" M4UHML , " + 
	    		" ' ' Mistura , M4COLOR, DECODE(M4TPMIC,null,' ','-' || M4TPMIC) M4TPMIC ,M4DEST,M7DESC ,M4TPQ,"
	    		+ "M4CLASQ, M4CORTEZ   " + 
	    		" from cpf.CPFM4_DBF m4  " +		  
	    		" LEFT join CCP.CCPB2_DBF B2 on b2.idfil = STL.FN_STL_IDFIL('CCPB2', m4.IDFIL) and trim(m4.M4FORN) = b2.B2COD " +   
	    		" LEFT JOIN CPF.CPFM6_DBF M6 ON M6.IDFIL = STL.FN_STL_IDFIL('CPFM6', m4.IDFIL)  AND M6COD = m4.M4ORIG  " +
	    		" LEFT JOIN CPF.CPFM7_DBF M7 ON M7.IDFIL = STL.FN_STL_IDFIL('CPFM7', m4.IDFIL)  AND M7COD = m4.M4PROCED  " +
	    		" WHERE M4.IDFIL = :filial  AND " + 
	    	    " (:item IS NULL  OR  trim(M4.M4ITEM)  = :item)  AND " +
	    	    " (:produtor IS NULL  OR   M6COD  = :produtor)  AND " + 
				" (:fornecedor IS NULL  OR   M4FORN  = :fornecedor)  AND " + 
				" (:procedencia IS NULL  OR   M4PROCED  = :procedencia)  AND " +
				" (:coloracao IS NULL    OR   trim(M4COLOR)  = :coloracao)  AND " +
				" (:destino IS NULL      OR   trim(M4DEST)   = :destino)  AND " + 
				" (:qual1 IS NULL      OR   trim(M4TPQ)     = :qual1)  AND " +
				" (:qual2 IS NULL      OR   trim(M4CLASQ)   = :qual2)  AND " +
				" (:tamanho IS NULL      OR   trim(M4TAM)   = :tamanho)  AND " +
				" (:pilha IS NULL      OR   trim(M4PILHA)   = :pilha)  AND " +
				" (:corteza IS NULL      OR   trim(M4CORTEZ)   = :corteza)  AND " +	 
	            " (:lote     IS NULL  OR   M4LOTE like %:lote%    )  AND " +        
	    	    "  M4QTDE <> 0  " +   
	    		" ORDER BY M6.M6DESC,M4LOTE,M4PILHA,1 	" 
	    		,nativeQuery = true)
	     		List<MisturaPadraoProjection> buscaEstoque( 
	     				@Param("filial") String filial ,
	     			    @Param("produtor") String produtor  ,
	     			    @Param("lote") String lote   ,
	     			    @Param("item") String item    ,	     		 
	     			    @Param("fornecedor") String fornecedor,
	     			    @Param("procedencia") String procedencia, 
	     		  	    @Param("coloracao") String coloracao, 
	     			    @Param("destino") String destino, 
	     			    @Param("qual1") String qual1, 
	     			    @Param("qual2") String qual2, 
	     			    @Param("tamanho") String tamanho,     
	     			    @Param("pilha") String pilha,
	     			    @Param("corteza") String corteza
	     				)  ;	    
	    
	    
	    
	    
	    
	    
	    @Query(value = 
	    		
		"SELECT ' ' FORN, " +  
		" M6.M6DESC PRODUT,M4ORIG COD_PROD,M4LOTE LOTE, M4PILHA PI,   " +
		" ROUND(M4QTDE,0) ESTOQUE,   "+ 
		" 0 frd_reserv , 0 QTDE, 0 Disponivel, 0 total_mist_util , " +
		" t2id M4ID ,   " +
		" M4NF,    " +
		" M4DESCF,  "  +
		" M4ITEM,   "  +   
		" M4UM ,  " +
		" M4PESMED , " +   
		" M4PROCED , " +    
		" M4TAM  , "  +    
		" M4QUAL, " +     
		" M4FORN, " +     
		" M4ELG ELG,M4MAT MAT,M4MIC MIC,M4MST MST,M4SF SF,M4SIC SIC,M4STR STR,M4TIPO TIPO, M4UI UI, " +              
		" M4SAC SAC,M4TRID TRID,M4PIM PIM,M4SC SC, " +    
	    " M4B, " +    
	    " M4RS, "  +    
		" M4TRAR, " +    
		" M4TRCNT, " +    
		" M4UHML , " + 
		" t2mist Mistura , M4COLOR, DECODE(M4TPMIC,null,' ','-' || M4TPMIC) M4TPMIC ,M4DEST, ' ' M7DESC , M4CORTEZ  " +
		" FROM "+
	       "(" +
	       "  select " +
	       "  t2.idfil, ('*' || to_char(t2id) || '*')  t2idTmp , t2id , t2mist," +
	       "  sum(nvl(mist_utiliz.total,0)) mist_utilizadas," +
	       "  sum( t1qtde) total_misturas ,"+
	       "  (sum( t1qtde) - sum(nvl(mist_utiliz.total,0)) ) saldo_misturas ,"+
	       "  sum( t2qtde) num_fardos  ,"+
	       "  ((sum( t1qtde) - sum(nvl(mist_utiliz.total,0)) ) * sum( t2qtde) ) fardos_reserv "+
	       "  from cpft2_dbf t2"+
	       "  inner join cpf.cpft1_dbf t1 on t1.idfil = t2.idfil and t1.t1mist = t2.t2mist"+
	       "  left join ("        +
	       "              select count(*) total, t1.t1mist,t1.idfil"+
	       "              from "+
	       "              cpft1_dbf t1 "+
	       "              inner join cpf.cpfm2_dbf m2 on m2.idfil = t1.idfil and t1.t1mist = m2.m2mist"+
	       "              where "+
	       "              t1.idfil = :filial  "  +
	       "              group by t1.t1mist,t1.idfil" + 
	       "              ) mist_utiliz on mist_utiliz.t1mist = t1.t1mist and mist_utiliz.idfil = t1.idfil" + 
	       "  where T2.IDFIL = :filial " + 
	       "  group by t2id , t2mist, t2.idfil"  +
	       "  ) PRINC " +
	       "  left join cpfm4_dbf m4 on m4.m4id = PRINC.t2id " +
	       "  LEFT JOIN CPF.CPFM6_DBF M6 ON M6.IDFIL = STL.FN_STL_IDFIL('CPFM6', m4.IDFIL)  AND M6COD = m4.M4ORIG  " +
	       "  where  trim(t2idTmp) in  :idFardosSelecionados  " + 
	       "  and fardos_reserv >  0 " ,nativeQuery = true)
	       List<MisturaPadraoProjection> buscaEstoqueEmMistura( 
	 				@Param("filial") String filial ,
	 				@Param("idFardosSelecionados") List<String>  idFardosSelecionados 
	 				 
	       )  ;      
 

}
