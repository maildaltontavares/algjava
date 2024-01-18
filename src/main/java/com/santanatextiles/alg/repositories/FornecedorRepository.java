package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.santanatextiles.alg.domain.Fornecedor;
import com.santanatextiles.alg.domain.FornecedorId;
@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, FornecedorId>{
	
	   @Query(value =  
	      "Select IDFIL,B2COD ,B2NOME,B2TIPO ,B2CGCCPF,B2TPENTIDA   " +
	      " from ccp.ccpb2_dbf b2 " +
	      " where b2.idfil =  STL.FN_STL_IDFIL('CCPB2',?1)",nativeQuery = true)
	    List<Fornecedor> buscaFornecedor(String filial) ; 
	     
	   
	
	   @Query(value =  
			      "Select IDFIL,B2COD ,B2NOME,B2TIPO ,B2CGCCPF,B2TPENTIDA   " +
			      " from ccp.ccpb2_dbf b2 " +
			      " where b2.idfil =  STL.FN_STL_IDFIL('CCPB2',?1)" + 		
			      " AND UPPER(B2NOME) LIKE  %?2% " +
			      " AND B2NOMREDUZ IS NOT NULL   " +			      
				  " ORDER BY B2NOME"  
			      
			      ,nativeQuery = true)
			    List<Fornecedor> buscaFornecedorPorNomeReduzido(String filial, String nome) ;  
	   
	   
	   @Query(value =  
			      "Select IDFIL,B2COD ,B2NOME,B2TIPO ,B2CGCCPF,B2TPENTIDA   " +
			      " from ccp.ccpb2_dbf b2 " +
			      " where b2.idfil =  STL.FN_STL_IDFIL('CCPB2',?1)" + 		
			      " AND  B2COD = ?2 " +
			      " AND B2NOMREDUZ IS NOT NULL   " +			      
				  " ORDER BY B2NOME"  
			      
			      ,nativeQuery = true)
			    List<Fornecedor> buscaFornecedorPorCodigo(String filial, String codigo) ;  	   

}
