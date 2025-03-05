package com.santanatextiles.alg.repositories; 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.santanatextiles.alg.domain.Maquina;
import com.santanatextiles.alg.domain.MaquinaId;

 

@Repository 
public interface MaquinaRepository extends JpaRepository<Maquina, MaquinaId>   {  

	
    @Query(value = "Select 	IDFIL,C3COD,C3DESC,C3EMP,C3NUMFUS,C3RPM,C3CDABER,C3NUMSER,C3LOCAL,C3MQSSM,C3LADO,C3TIT,C3HRDIA " +
    	      " from cpf.cpfc3_dbf c3 "+
    	      " where c3.idfil =  STL.FN_STL_IDFIL('CPFC3',?1)  order by substr(C3COD,3,2),C3LOCAL",nativeQuery = true)
    List<Maquina> buscaMaquina(String filial) ;    
   
	
    @Query(value = "Select 	IDFIL,C3COD,C3DESC,C3EMP,C3NUMFUS,C3RPM,C3CDABER,C3NUMSER,C3LOCAL,C3MQSSM,C3LADO,C3TIT,C3HRDIA " +
  	      " from cpf.cpfc3_dbf c3 "+
  	      " where c3.idfil =  STL.FN_STL_IDFIL('CPFC3',?1) and c3local = ?2 and substr(c3cod,3,2) = ?3",nativeQuery = true)
  Maquina buscaMaquinaPorLocal(String filial, String Local,String tiopoMaquina) ;   	
	
	
    
    @Query(value = "Select 	IDFIL,C3COD,C3DESC,C3EMP,C3NUMFUS,C3RPM,C3CDABER,C3NUMSER,C3LOCAL,C3MQSSM,C3LADO,C3TIT,C3HRDIA " +
    	      " from cpf.cpfc3_dbf c3 "+
    	      " where c3.idfil =  STL.FN_STL_IDFIL('CPFC3',?1) and c3cod = ?2 and  c3lado = ?3",nativeQuery = true)
    Maquina buscaMaquinaPorCodigoLado(String filial, String codigo, String lado) ;      
    

}
