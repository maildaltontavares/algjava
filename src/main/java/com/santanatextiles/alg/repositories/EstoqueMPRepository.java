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
	    
	    
	     


}
