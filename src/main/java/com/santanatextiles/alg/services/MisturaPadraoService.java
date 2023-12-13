package com.santanatextiles.alg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.MisturaPadrao;
import com.santanatextiles.alg.repositories.MisturaPadraoRepository; 
	
@Service
public class MisturaPadraoService {
		
		@Autowired
		private MisturaPadraoRepository repo;		
		
		@Value("${spring.datasource.url}")
		private String JDBC_URL;
		
		@Value("${spring.datasource.username}")
		private String JDBC_USER;

		@Value("${spring.datasource.password}") 
		private String JDBC_PASSWORD;			
		
		public List<MisturaPadrao> buscaMisturaPadraoPorParametros(String filial ){	   
			 List<MisturaPadrao> obj = repo.buscaMisturaPadraoPorParametros(filial)  ;	  
			 return obj;
		}		
		
		public List<MisturaPadrao> buscaMisturaPadraoByFilial(String filial) {  
			 List<MisturaPadrao> obj = repo.findByIdfil(filial);
			return obj ;
		}		
				

}
