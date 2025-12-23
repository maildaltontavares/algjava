package com.santanatextiles.alg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.Produtor;
import com.santanatextiles.alg.repositories.ProdutorRepository; 
	
@Service
public class ProdutorService {
			
		@Autowired
		private ProdutorRepository repo;		
		
		@Value("${spring.datasource.url}")  
		private String JDBC_URL;
		
		@Value("${spring.datasource.username}")
		private String JDBC_USER;

		@Value("${spring.datasource.password}") 
		private String JDBC_PASSWORD;			
		
		public List<Produtor> buscaProdutorPorParametros(String filial ){	   
			 List<Produtor> obj = repo.buscaProdutorPorParametros(filial ) ;	  
			 return obj;
		}		
				

}
