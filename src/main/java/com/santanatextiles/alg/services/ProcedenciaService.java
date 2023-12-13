package com.santanatextiles.alg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.Procedencia;
import com.santanatextiles.alg.repositories.ProcedenciaRepository; 
	
@Service
public class ProcedenciaService {
			
		@Autowired
		private ProcedenciaRepository repo;		
		
		@Value("${spring.datasource.url}")
		private String JDBC_URL;
		
		@Value("${spring.datasource.username}")
		private String JDBC_USER;

		@Value("${spring.datasource.password}") 
		private String JDBC_PASSWORD;			
		
		public List<Procedencia> buscaProcedenciaPorParametros(String filial ){	 
			 List<Procedencia> obj = repo.buscaProcedenciaPorParametros(filial)  ;	  
			 return obj;
		}		
		
		public List<Procedencia> buscaProcedenciaByFilial(String filial ){	 
			 List<Procedencia> obj = repo.findByIdfil(filial ) ;	  
			 return obj;
		}			
			
			
	
}
