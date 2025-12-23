package com.santanatextiles.alg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.Maquina;
import com.santanatextiles.alg.repositories.MaquinaRepository;
 

@Service
public class MaquinaService {
	
	
	@Autowired
	private MaquinaRepository repostitory;	  
  
	
    public Maquina buscaMaquinaPorCodigoLado(String filial, String maquina, String lado)      {  
	 	 Maquina  obj = repostitory.buscaMaquinaPorCodigoLado( filial,maquina,lado)  ;  
	 	 return obj;
     }	 
    
     
	
	
	

}



