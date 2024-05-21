package com.santanatextiles.alg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.Pilha;
import com.santanatextiles.alg.repositories.PilhaRepository;
 
	
@Service
public class PilhaService {
			
		@Autowired
		private PilhaRepository repo;		
		
		@Value("${spring.datasource.url}")
		private String JDBC_URL;
		
		@Value("${spring.datasource.username}")
		private String JDBC_USER;

		@Value("${spring.datasource.password}") 
		private String JDBC_PASSWORD;			
		
		public List<Pilha> buscaPilhaPorParametros(String filial ){	   
			 List<Pilha> obj = repo.buscaPilhaPorParametros(filial);	  
			 return obj;
		} 
		
		
		public List<Pilha> buscaPilhaByFilial(String filial ){	 
			 List<Pilha> obj = repo.findByIdfil(filial ) ;	  
			 return obj;
		}		
		
		public Integer totalFardosPilha(String filial, String pilha ){	 
			Integer obj = repo.totalFardosPilha(filial,	pilha);   
			 return obj;
		}			
		 

}
