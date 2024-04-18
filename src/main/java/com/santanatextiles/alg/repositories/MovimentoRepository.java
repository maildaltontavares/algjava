package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.Movimento;
import com.santanatextiles.alg.domain.MovimentoId;

public interface MovimentoRepository extends JpaRepository<Movimento, MovimentoId>{
 
    @Query(value = "SELECT 	" + 
			" IDFIL 	,  " + 
			" M2NF 	    ,  " + 
			" M2DTBASE 	,  " + 
			" M2FORN	,  " + 	
			" M2DTEMI 	,  " + 
			" M2DTINC 	,  " + 
			" M2DTALT 	,  " + 
			" M2USRINC 	,  " + 
			" M2USRALT 	,  " + 
			" M2ID 	    ,  " + 
			" M2TPMOV 	,  " + 
			" M2ENTSAI 	,  " + 
			" M2LOTFIA 	,  " + 
			" M2PESMED 	,  " + 
			" M2ORIG 	,  " + 
			" M2PROCED 	,  " + 
			" M2LINABR 	,  " + 
			" M2TPMP 	,  " + 
			" M2PESTOT 	,  " + 
			" M2NUMVOL 	,  " + 
			" M2MOVAUT 	,  " + 
			" M2MOVPIL 	,  " + 
			" M2IDAUTO 	,  " + 
			" M2MIST 	,  " + 
			" M2SEQMST,	  "  +
			" M2Q1C,	  "  +
			" M2Q2C 	  "  +   
			" FROM CPF.CPFM2_DBF M2  "    +
			" where M2.idfil =  STL.FN_STL_IDFIL('CPFM2',?1) "
			,nativeQuery = true)
          List<Movimento> buscaMovimentoPorParametros(@Param("idfil") String idfil) ;  
    
    
    @Query(value = "SELECT 	" + 
			" M2.IDFIL 	,  " + 
			" M2NF 	    ,  " + 
			" M2DTBASE 	,  " + 
			" M2FORN	,  " + 	
			" M2DTEMI 	,  " + 
			" M2DTINC 	,  " + 
			" M2DTALT 	,  " + 
			" M2USRINC 	,  " + 
			" M2USRALT 	,  " + 
			" M2ID 	    ,  " + 
			" M2TPMOV 	,  " + 
			" M2ENTSAI 	,  " + 
			" M2LOTFIA 	,  " + 
			" M2PESMED 	,  " + 
			" decode(nvl(M2ORIG,0),0,'' , M2ORIG) M2ORIG 	,  " + 
			" M2PROCED 	,  " + 
			" M2LINABR 	,  " + 
			" M2TPMP 	,  " + 
			" M2PESTOT 	,  " + 
			" M2NUMVOL 	,  " + 
			" M2MOVAUT 	,  " + 
			" M2MOVPIL 	,  " + 
			" M2IDAUTO 	,  " + 
			" M2MIST 	,  " + 
			" M2SEQMST,	  "  +
			" M2Q1C,	  "  +
			" M2Q2C 	  "  +   
			" FROM CPF.CPFM2_DBF M2  "    +   
			" where M2.idfil =  STL.FN_STL_IDFIL('CPFM2',:idfil) AND " +
		    "(:dataInicial IS NULL   OR TO_CHAR(M2DTBASE,'YYYYMMDD') >= :dataInicial )   and " +
		    "(:dataFinal IS NULL     OR TO_CHAR(M2DTBASE,'YYYYMMDD') <= :dataFinal )   and " + 	 
		    "(:tipoMovimento IS NULL OR m2tpmov = :tipoMovimento )   and " +
		    "(:tipoMP IS NULL        OR M2TPMP = :tipoMP )   and " + 
		    "(:codFornecedor IS NULL OR m2forn = :codFornecedor )   and " +
		    "(:notaFiscal IS NULL    OR M2NF = :notaFiscal )    and " +
		    "(:produtor IS NULL      OR M2ORIG = :produtor )    "+
		    " order by M2.idfil,M2NF"
			,nativeQuery = true)
          List<Movimento> pesquisaMovimentoPorParametros(
        		  @Param("idfil")         String idfil, 
        		  @Param("tipoMovimento") String tipoMovimento,
        		  @Param("tipoMP")        String tipoMP,
        		  @Param("codFornecedor") String codFornecedor,
        		  @Param("notaFiscal")    String notaFiscal,
        		  @Param("produtor")      String produtor ,
        		  @Param("dataInicial")   String dataInicial ,
        		  @Param("dataFinal")     String dataFinal  
        		  
        		  ) ;      
    
    
    
	@Transactional(readOnly=true)
	List<Movimento>  findByIdfil(String idfil);      
	
	@Transactional(readOnly=true)
	Movimento  findByIdfilAndFornecedorAndNotaFiscal(String idfil,String fornecedor,String notaFiscal);
	
	@Query(value="SELECT CPF.CPFM3_ID_SQ.NEXTVAL FROM DUAL", nativeQuery = true)  
	Double codigoNovoMovimento();   
	
	@Transactional
	Double deleteById(Double id ); 	 
    
    
/*
 * 
 *  
 *     
 *     
 *     cSql += "  LEFT JOIN CPF.CPFM2_DBF M2 ON M2.IDFIL = M3.IDFIL AND M2.M2ID = M3.M3IDCAB  "
cSql += "  LEFT join CCP.CCPB2_DBF b2 on b2.idfil = STL.FN_STL_IDFIL('CCPB2', m3.IDFIL) and trim(m3.M3FORN) = b2.B2COD  "
cSql += "  LEFT join CCP.CCPB2_DBF b2a on b2a.idfil = STL.FN_STL_IDFIL('CCPB2', m2.IDFIL) and trim(m2.M2FORN) = b2a.B2COD  "
cSQL +="   LEFT JOIN CPF.CPFM6_DBF M6 ON M6.IDFIL = '"  + fIDFIL('CPFM6') + "'  AND M6COD = m3.M3ORIG  "
cSQL +="   LEFT JOIN CPF.CPFM7_DBF M7 ON M7.IDFIL = '"  + fIDFIL('CPFM7') + "'  AND M7COD = m3.M3PROCED  "
///cSql += "  LEFT JOIN CPF.CPFM4_DBF M4 ON M3.IDFIL = M4.IDFIL AND M3.M3IDMOV = M4.M3ID    "
cSql += "  WHERE M3.IDFIL = '"+STRZERO(nIDFIL,2)+"' AND M2.M2DTBASE BETWEEN  " + SR_CDBVALUE(dDATAI) + " AND " + SR_CDBVALUE(dDATAF)    
 *     
 *     
 *     */
    
    
 
    
    
           // @Query("SELECT nf FROM NotaFiscal nf JOIN nf.itens nfi WHERE nf.numeroNotaFiscal = :numeroNotaFiscal ORDER BY nfi.idItem")
            //List<NotaFiscal> findAllOrderByItemIdByNumeroNotaFiscal(@Param("numeroNotaFiscal") String numeroNotaFiscal);
    
    
            //@Query("SELECT mv FROM Movimento mv JOIN mv.itemMovimento mvi " + 
            //" WHERE mv.idfil = ?1 and mv.fornecedor = ?2 and mv.notaFiscal = ?3 ORDER BY mvi.idItem")
            //Movimento findByIdfilAndFornecedorAndNotaFiscalOrderByIdByIdItem(String idfil,String fornecedor,String notaFiscal);    
    
  		
    

}
