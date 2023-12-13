package com.santanatextiles.alg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.MisturaPadraoItem;
import com.santanatextiles.alg.repositories.MisturaPadraoItemRepository;

 
	
@Service
public class MisturaPadraoItemService {
			
		@Autowired
		private MisturaPadraoItemRepository repo;		
		
		@Value("${spring.datasource.url}")
		private String JDBC_URL;
		
		@Value("${spring.datasource.username}")
		private String JDBC_USER;

		@Value("${spring.datasource.password}") 
		private String JDBC_PASSWORD;			
		
		public List<MisturaPadraoItem> buscaMisturaPadraoItemPorParametros(String filial ){	 
			 List<MisturaPadraoItem> obj = repo.buscaMisturaPadraoItemPorParametros(filial ) ;	  
			 return obj;
		}		 
	

}
