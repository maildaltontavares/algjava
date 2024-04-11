package com.santanatextiles.alg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.Coloracao;
import com.santanatextiles.alg.repositories.ColoracaoRepository;

@Service
public class ColoracaoService {
			
		@Autowired
		private ColoracaoRepository repo;	 
		
		public List<Coloracao> buscaColoracaoByFilial(String filial ){	   
			 List<Coloracao> obj = repo.buscaColoracaoByFilial(filial);  
			 return obj;
		}  
		
		public List<Coloracao> buscaColoracaoByFilialAndCodigo(String filial , String codigo){	   
			 List<Coloracao> obj = repo.buscaColoracaoByFilialAndCodigo(filial,codigo);  
			 return obj;
		} 		
		

} 
 

 
