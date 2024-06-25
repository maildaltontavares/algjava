package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.MovimentoItem;
import com.santanatextiles.alg.domain.TesteQualidade;
import com.santanatextiles.alg.domain.TesteQualidadeId; 

public interface TesteQualidadeRepository extends JpaRepository<TesteQualidade, TesteQualidadeId>{
		 
	    @Query(value = "SELECT 	" + 
				" IDFIL 	 ,  " +
				" M9ORIG	 ,  " +
				" M9LOTE	 ,  " +
				" M9DTTEST	 ,  " +
				" M9NUMVOL	 ,  " +
				" M9SAC	     ,  " +
				" M9MST	     ,  " +
				" M9MIC	     ,  " +
				" M9MAT	     ,  " +
				" M9UI	     ,  " +
				" M9SF	     ,  " +
				" M9STR	     ,  " +
				" M9ELG	     ,  " +
				" M9TIPO	 ,  " +
				" M9TRID	 ,  " +
				" M9SC	     ,  " +
				" M9PIM	     ,  " +
				" M9HVI	     ,  " +
				" M9BENEF	 ,  " +
				" M9OBS	     ,  " +
				" M9DTINC	 ,  " +
				" M9USRINC	 ,  " +
				" M9DTALT	 ,  " +
				" M9USRALT 	 ,  " +
				" M9SIC	     ,  " +
				" M9UHML	 ,  " +
				" M9RS	     ,  " +
				" M9B	     ,  " +
				" M9TRCNT	 ,  " +
				" M9TRAR	 ,  " +
				" M9PRDINT	 ,  " +
				" M9ARQ	     ,  " +
				" M9PSELO	 ,  " +
				" M9TPSELO	 ,  " +
				" M9NSELO	 ,  " +
				" M9TPMIC ,	    " +
				" M9ITEM	    " +
				" FROM CPFM9_DBF M9 "  	+
				" where m9.idfil =  STL.FN_STL_IDFIL('CPFM9',?1) "
				,nativeQuery = true)	
        List<TesteQualidade> buscaTesteQualidadePorParametros(@Param("idfil") String idfil) ;  

	    
	    @Transactional(readOnly=true)
	    List<TesteQualidade>  findByIdfil(String idfil);    
	
	    @Transactional(readOnly=true)
	    TesteQualidade  findByIdfilAndProdutorAndLote(String idfil,String produtor, String lote);  	   
	    
	    
	    @Query(value = "SELECT 	" + 
				" IDFIL 	 ,  " +
				" M9ORIG	 ,  " +
				" M9LOTE	 ,  " +
				" M9DTTEST	 ,  " +
				" M9NUMVOL	 ,  " +
				" M9SAC	     ,  " +
				" M9MST	     ,  " +
				" M9MIC	     ,  " +
				" M9MAT	     ,  " +
				" M9UI	     ,  " +
				" M9SF	     ,  " +
				" M9STR	     ,  " +
				" M9ELG	     ,  " +
				" M9TIPO	 ,  " +
				" M9TRID	 ,  " +
				" M9SC	     ,  " +
				" M9PIM	     ,  " +
				" M9HVI	     ,  " +
				" M9BENEF	 ,  " +
				" M9OBS	     ,  " +
				" M9DTINC	 ,  " +
				" M9USRINC	 ,  " +
				" M9DTALT	 ,  " +
				" M9USRALT 	 ,  " +
				" M9SIC	     ,  " +
				" M9UHML	 ,  " +
				" M9RS	     ,  " +
				" M9B	     ,  " +
				" M9TRCNT	 ,  " +
				" M9TRAR	 ,  " +
				" M9PRDINT	 ,  " +
				" M9ARQ	     ,  " +
				" M9PSELO	 ,  " +
				" M9TPSELO	 ,  " +
				" M9NSELO	 ,  " +
				" M9TPMIC	 ,  " + 
				" M9ITEM	    " + 
				" FROM CPFM9_DBF M9 "  	+
				" where m9.idfil =  STL.FN_STL_IDFIL('CPFM9',?1) and trim(M9ORIG) = ?2 and trim(M9LOTE) =  trim( ?3 )"
				,nativeQuery = true)	
                 TesteQualidade  buscaTesteQualidadePorProdutorLote(@Param("idfil") String idfil,@Param("produtor") String produtor,@Param("lote") String lote) ; 	 

	    @Query(value = "SELECT 	" + 
				" IDFIL 	 ,  " +
				" M9ORIG	 ,  " +
				" M9LOTE	 ,  " +
				" M9DTTEST	 ,  " +
				" M9NUMVOL	 ,  " +
				" M9SAC	     ,  " +
				" M9MST	     ,  " +
				" M9MIC	     ,  " +
				" M9MAT	     ,  " +
				" M9UI	     ,  " +
				" M9SF	     ,  " +
				" M9STR	     ,  " +
				" M9ELG	     ,  " +
				" M9TIPO	 ,  " +
				" M9TRID	 ,  " +
				" M9SC	     ,  " +
				" M9PIM	     ,  " +
				" M9HVI	     ,  " +
				" M9BENEF	 ,  " +
				" M9OBS	     ,  " +
				" M9DTINC	 ,  " +
				" M9USRINC	 ,  " +
				" M9DTALT	 ,  " +
				" M9USRALT 	 ,  " +
				" M9SIC	     ,  " +
				" M9UHML	 ,  " +
				" M9RS	     ,  " +
				" M9B	     ,  " +
				" M9TRCNT	 ,  " +
				" M9TRAR	 ,  " +
				" M9PRDINT	 ,  " +
				" M9ARQ	     ,  " +
				" M9PSELO	 ,  " +
				" M9TPSELO	 ,  " +
				" M9NSELO	 ,  " +
				" M9TPMIC,	    " + 
				" M9ITEM	    " + 
				" FROM CPFM9_DBF M9 "  	+
				" where m9.idfil =  STL.FN_STL_IDFIL('CPFM9',?1) and trim(M9ORIG) = ?2 and trim(M9LOTE) =  trim( ?3 )  and trim(M9ITEM) =  trim( ?4 )"
				,nativeQuery = true)	
                 TesteQualidade  buscaTesteQualidadePorProdutorLoteItem(@Param("idfil") String idfil,@Param("produtor") String produtor,@Param("lote") String lote,@Param("item") String item) ;	    
	    
	    
	    
	    
	    
	    
	    @Query(value = "SELECT 	" + 
				" IDFIL 	 ,  " +
				" M9ORIG	 ,  " +
				" M9LOTE	 ,  " +
				" M9DTTEST	 ,  " +
				" M9NUMVOL	 ,  " +
				" M9SAC	     ,  " +
				" M9MST	     ,  " +
				" M9MIC	     ,  " +
				" M9MAT	     ,  " +
				" M9UI	     ,  " +
				" M9SF	     ,  " +
				" M9STR	     ,  " +
				" M9ELG	     ,  " +
				" M9TIPO	 ,  " +
				" M9TRID	 ,  " +
				" M9SC	     ,  " +
				" M9PIM	     ,  " +
				" M9HVI	     ,  " +
				" M9BENEF	 ,  " +
				" M9OBS	     ,  " +
				" M9DTINC	 ,  " +
				" M9USRINC	 ,  " +
				" M9DTALT	 ,  " +
				" M9USRALT 	 ,  " +
				" M9SIC	     ,  " +
				" M9UHML	 ,  " +
				" M9RS	     ,  " +
				" M9B	     ,  " +
				" M9TRCNT	 ,  " +
				" M9TRAR	 ,  " +
				" M9PRDINT	 ,  " +
				" M9ARQ	     ,  " +
				" M9PSELO	 ,  " +
				" M9TPSELO	 ,  " +
				" M9NSELO	 ,  " +
				" M9TPMIC,	    " +
				" M9ITEM	    " + 
				" FROM CPFM9_DBF M9 "  	+
				" where m9.idfil =  STL.FN_STL_IDFIL('CPFM9',:idfil) and " +
		  	    "(:dataInicial IS NULL     OR TO_CHAR(M9DTINC,'YYYYMMDD') >= :dataInicial )   and " +
			    "(:dataFinal   IS NULL     OR TO_CHAR(M9DTINC,'YYYYMMDD') <= :dataFinal )   and " + 	  
				"(:lote        IS NULL     OR TRIM(M9LOTE) = TRIM(:lote)  )    and " +
				"(:item        IS NULL     OR TRIM(M9ITEM) = TRIM(:item)  )    and " +
				"(:produtor IS NULL        OR M9ORIG = :produtor )    " 
				,nativeQuery = true)	
	            List<TesteQualidade>  pesquisarTeste(@Param("idfil") String idfil,
	            		@Param("dataInicial") String dataInicial,
	            		@Param("dataFinal") String dataFinal,
	            		@Param("produtor") String produtor,
	            		@Param("lote") String lote ,
	            		@Param("item") String item
	            		) ; 	
	    
	    
	    
	    @Query(value = "SELECT 	"+    
				" count(M3LOTE) 	      " +	 
				" FROM CPF.CPFM3_DBF M3  "  +
			    " where m3.idfil =  STL.FN_STL_IDFIL('CPFM3',?1) and m3movpil = 'S'   " +
			    " and trim(M3ORIG) = ?2 and trim(M3LOTE) =  trim( ?3 )  and trim(M3ITEM) =  trim( ?4 )"
				,nativeQuery = true)
	    		Integer buscaMovimentoDePilha(@Param("idfil") String idfil,@Param("produtor") String produtor,@Param("lote") String lote,@Param("item") String item) ;		
	            	 
	    
	    @Modifying
		@Query(value="UPDATE CPF.CPFM4_DBF M4 SET " +
					 " M4SAC =    :sac, " +
					 " M4SC =     :sc ," +
					 " M4PIM =    :pim, " +
					 " M4TRID =   :trid, " +  
					 " M4MIC =    :mic ," +
					 " M4MAT =    :mat, " +        
					 " M4UI =     :ui, " +        
					 " M4SF =     :sf ," +
					 " M4STR =    :str, " +
					 " M4ELG =    :elg, " +        
					 " M4MST =    :mst, " +
					 " M4TIPO=    :tipo, " +
					 " M4SIC =    :sic, " +   
					 " M4UHML =   :uhml, " +
					 " M4RS   =   :rs, " +        
					 " M4B    =   :b, " +
					 " M4TRCNT=   :trcnt, " +  
					 " M4TRAR =   :trar ," +  
					 " M4TPMIC =  trim(:tpmic) " + 
				     " WHERE IDFIL = :idfil  AND TRIM(M4ORIG) =  TRIM(:produtor)   AND TRIM(M4LOTE) =  TRIM(:lote)  AND TRIM(M4ITEM) =  TRIM( :item )  " 	 
	         	, nativeQuery = true)
		int atualizaQualidade( 
				@Param("idfil") String idfil,
				@Param("produtor") String produtor,
				@Param("lote") String lote,
				@Param("item") String item,				
				@Param("sac")   Double sac ,
				@Param("pim")   Double pim,
				@Param("trid")  Double trid,
				@Param("mic")   Double mic,
				@Param("mat")   Double mat,
				@Param("ui")    Double ui,
				@Param("sf")    Double sf,
				@Param("elg")   Double elg,
				@Param("mst")   Double mst,
				@Param("tipo")  Double tipo,
				@Param("sic")   Double sic,
				@Param("uhml")  Double uhml,
				@Param("rs")    Double rs,
				@Param("b")     Double b,
				@Param("trcnt") Double trcnt ,
				@Param("trar")  Double trar,
				@Param("tpmic") String tpmic,
				@Param("str") Double str ,
				@Param("sc") Double sc     
				
				);
	    
	    
 	    @Modifying
 		@Query(value="UPDATE CPF.CPFM3_DBF M3 SET " +
 					 " M3SAC =    :sac, " +
 					 " M3SC =     :sc ," +
 					 " M3PIM =    :pim, " +
 					 " M3TRID =   :trid, " +  
 					 " M3MIC =    :mic ," +
 					 " M3MAT =    :mat, " +        
 					 " M3UI =     :ui, " +        
 					 " M3SF =     :sf ," +
 					 " M3STR =    :str, " +
 					 " M3ELG =    :elg, " +        
 					 " M3MST =    :mst, " +
 					 " M3TIPO=    :tipo, " +
 					 " M3SIC =    :sic, " +   
 					 " M3UHML =   :uhml, " +
 					 " M3RS   =   :rs, " +        
 					 " M3B    =   :b, " +
 					 " M3TRCNT=   :trcnt, " +  
 					 " M3TRAR =   :trar ," +  
 					 " M3TPMIC =  trim(:tpmic) " + 
 				     " WHERE IDFIL = :idfil  AND TRIM(M3ORIG) =  TRIM(:produtor)   AND TRIM(M3LOTE) =  TRIM(:lote)  AND TRIM(M3ITEM) =  TRIM( :item )  " 	 
 	         	, nativeQuery = true)
 		int atualizaMovimentos( 
 				@Param("idfil") String idfil,
 				@Param("produtor") String produtor,
 				@Param("lote") String lote,
 				@Param("item") String item,				
 				@Param("sac")   Double sac ,				
 				@Param("pim")   Double pim,
 				@Param("trid")  Double trid,
 				@Param("mic")   Double mic,
 				@Param("mat")   Double mat,
 				@Param("ui")    Double ui,
 				@Param("sf")    Double sf,
 				@Param("elg")   Double elg,
 				@Param("mst")   Double mst,
 				@Param("tipo")  Double tipo,
 				@Param("sic")   Double sic,
 				@Param("uhml")  Double uhml,
 				@Param("rs")    Double rs,
 				@Param("b")     Double b,
 				@Param("trcnt") Double trcnt ,
 				@Param("trar")  Double trar,
 				@Param("tpmic") String tpmic,
 				@Param("str") Double str  ,
				@Param("sc") Double sc        
 				
				);    
	     
 	    
 	   @Modifying
		@Query(value="UPDATE CPF.CPFM4_DBF M4 SET " +
					 " M4SAC =    null, " +
					 " M4SC =     null ," +
					 " M4PIM =    null, " +
					 " M4TRID =   null, " +  
					 " M4MIC =    null ," +
					 " M4MAT =    null, " +        
					 " M4UI =     null, " +        
					 " M4SF =     null ," +
					 " M4STR =    null, " +
					 " M4ELG =    null, " +        
					 " M4MST =    null, " +
					 " M4TIPO=    null, " +
					 " M4SIC =    null, " +   
					 " M4UHML =   null, " +
					 " M4RS   =   null, " +        
					 " M4B    =   null, " +
					 " M4TRCNT=   null, " +  
					 " M4TRAR =   null ," +  
					 " M4TPMIC =  null " + 
				     " WHERE IDFIL = :idfil  AND TRIM(M4ORIG) =  TRIM(:produtor)   AND TRIM(M4LOTE) =  TRIM(:lote)  AND TRIM(M4ITEM) =  TRIM( :item )  " 	 
	         	, nativeQuery = true)
		int atualizaExclusaoQualidade( 
				@Param("idfil") String idfil,
				@Param("produtor") String produtor,
				@Param("lote") String lote,
				@Param("item") String item 				
				 
				
				); 	  
 	   
 	   
 	   
	    @Modifying
		@Query(value="UPDATE CPF.CPFM3_DBF M3 SET " +
					 " M3SAC =    null , " +
					 " M3SC =     null ," +
					 " M3PIM =    null , " +
					 " M3TRID =   null , " +  
					 " M3MIC =    null ," +
					 " M3MAT =    null , " +        
					 " M3UI =     null , " +        
					 " M3SF =     null ," +
					 " M3STR =    null , " +
					 " M3ELG =    null , " +        
					 " M3MST =    null , " +
					 " M3TIPO=    null , " +
					 " M3SIC =    null , " +   
					 " M3UHML =   null , " +
					 " M3RS   =   null , " +        
					 " M3B    =   null , " +
					 " M3TRCNT=   null , " +  
					 " M3TRAR =   null ," +  
					 " M3TPMIC =  null  " + 
				     " WHERE IDFIL = :idfil  AND TRIM(M3ORIG) =  TRIM(:produtor)   AND TRIM(M3LOTE) =  TRIM(:lote)  AND TRIM(M3ITEM) =  TRIM( :item )  " 	 
	         	, nativeQuery = true)
		int atualizaExclusaoMovimentos( 
				@Param("idfil") String idfil,
				@Param("produtor") String produtor,
				@Param("lote") String lote,
				@Param("item") String item 
				
				);   
	    
	    
	 	   
		    @Modifying
			@Query(value="DELETE FROM CPF.CPFM9_DBF M9 " +
					     " WHERE IDFIL = :idfil  AND TRIM(M9ORIG) =  TRIM(:produtor)   AND TRIM(M9LOTE) =  TRIM(:lote)  AND TRIM(M9ITEM) =  TRIM( :item )  " 	 
		         	, nativeQuery = true)
			int excluirTeste( 
					@Param("idfil") String idfil,
					@Param("produtor") String produtor,
					@Param("lote") String lote,
					@Param("item") String item 
					
					);	    
 	    
 	    
 	    
 	    
	    
	    	    
/*
	    cQ1:="UPDATE CPF.CPFM4_DBF M4 SET "
	    		cQ1+=" M4SAC = '" + STR(M9_SAC) + "'," 
	    		cQ1+=" M4SC = '" + STR(M9_SC) + "'," 
	    		cQ1+=" M4PIM = '" + STR(M9_PIM) + "'," 
	    		cQ1+=" M4TRID = '" + STR(M9_TRID) + "',"   
	    		cQ1+=" M4MIC = '" + STR(M9_MIC) + "'," 
	    		cQ1+=" M4MAT = '" + STR(M9_MAT) + "',"         
	    		cQ1+=" M4UI =  '" + STR(M9_UI) + "',"         
	    		cQ1+=" M4SF =  '" + STR(M9_SF) + "'," 
	    		cQ1+=" M4STR = '" + STR(M9_STR) + "'," 
	    		
	    		cQ1+=" M4ELG = '" + STR(M9_ELG) + "',"         
	    		cQ1+=" M4MST = '" + STR(M9_MST) + "'," 
	    		cQ1+=" M4TIPO= '" + STR(M9_TIPO) + "'," 
	    		cQ1+=" M4SIC = '" + STR(M9_SIC) + "',"    
	    		cQ1+=" M4UHML = '" + STR(M9_UHML) + "'," 
	    		cQ1+=" M4RS   = '" + STR(M9_RS) + "',"         
	    		cQ1+=" M4B    = '" + STR(M9_B) + "'," 
	    		cQ1+=" M4TRCNT= '" + STR(M9_TRCNT) + "',"
	    		   cQ1+=" M4TRAR = '" + STR(M9_TRAR) + "',"   
	    		   cQ1+=" M4TPMIC = '" + fCLSMIC(M9_MIC) + "'"
	    		cQ1+=" WHERE IDFIL = '"+fIDFIL('CPFM4')+"'  AND TRIM(M4ORIG) = '" + ALLTRIM(M9_ORIG)   +"'  AND TRIM(M4LOTE) = '" + ALLTRIM(M9_LOTE)   +"'"      

	    		clinha := cQ1
	    		//fimp()

	    		oSql := SR_GetConnection()
	    		oSQL:exec(cQ1,,.f.)    

	    		cQ1:="UPDATE CPF.CPFM3_DBF M3 SET "
	    		cQ1+=" M3SAC = '" + STR(M9_SAC)   + "'," 
	    		cQ1+=" M3SC = '" + STR(M9_SC)     + "'," 
	    		cQ1+=" M3PIM = '" + STR(M9_PIM)   + "'," 
	    		cQ1+=" M3TRID = '" + STR(M9_TRID) + "',"         
	    		cQ1+=" M3MIC = '" + STR(M9_MIC)   + "'," 
	    		cQ1+=" M3MAT = '" + STR(M9_MAT)   + "',"         
	    		cQ1+=" M3UI =  '" + STR(M9_UI)    + "',"         
	    		cQ1+=" M3SF =  '" + STR(M9_SF)    + "',"    
	    		cQ1+=" M3STR = '" + STR(M9_STR)   + "'," 
	    		cQ1+=" M3ELG = '" + STR(M9_ELG)   + "',"         
	    		cQ1+=" M3MST = '" + STR(M9_MST)   + "'," 
	    		cQ1+=" M3TIPO= '" + STR(M9_TIPO)  + "',"  
	    		cQ1+=" M3SIC = '" + STR(M9_SIC)   + "',"      
	    		cQ1+=" M3UHML = '" + STR(M9_UHML) + "'," 
	    		cQ1+=" M3RS   = '" + STR(M9_RS)   + "',"         
	    		cQ1+=" M3B    = '" + STR(M9_B)    + "',"   
	    		cQ1+=" M3TRCNT= '" + STR(M9_TRCNT) + "'," 
	    		
	    		IF EMPCOD = 'STC'
	    		   cQ1+=" M3TRAR = '" + STR(M9_TRAR)  + "',"   		
	    		   cQ1+=" M3TPMIC = '" + fCLSMIC(M9_MIC) + "'"           
	    		ELSE
	    		   cQ1+=" M3TRAR = '" + STR(M9_TRAR)  + "'"   	
	    		ENDIF
	    		
	    		cQ1+=" WHERE IDFIL = '"+fIDFIL('CPFM4')+"'  AND TRIM(M3ORIG) = '" + ALLTRIM(M9_ORIG)   +"'  AND TRIM(M3LOTE) = '" + ALLTRIM(M9_LOTE)   +"'"   
	    
	    
	    
	    	    
	 */
	    
	    	    
	     
	    
	    
	    
	    
	    
	    
	    
	    
}
