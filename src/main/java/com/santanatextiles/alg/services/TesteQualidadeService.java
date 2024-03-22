package com.santanatextiles.alg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.TesteQualidade;
import com.santanatextiles.alg.repositories.TesteQualidadeRepository; 
	
@Service
public class TesteQualidadeService {
			
		@Autowired
		private TesteQualidadeRepository repo;		
		
		@Value("${spring.datasource.url}")
		private String JDBC_URL;
		
		@Value("${spring.datasource.username}")
		private String JDBC_USER;

		@Value("${spring.datasource.password}") 
		private String JDBC_PASSWORD;			
		
		public List<TesteQualidade> buscaTesteQualidadePorParametros(String filial ){ 
			 List<TesteQualidade> obj = repo.buscaTesteQualidadePorParametros(filial ) ;	  
			 return obj;
		}		
				
		public List<TesteQualidade> buscaTesteQualidadeByFilial(String filial ){	 
			 List<TesteQualidade> obj = repo.findByIdfil(filial ) ;	  
			 return obj;
		}			
		
	
		public TesteQualidade buscaTesteQualidadeByLote(String filial, String produtor, String pLote ){	
			
			 //String lote = String.format("%-35s", pLote); 
			 TesteQualidade obj = repo.buscaTesteQualidadePorProdutorLote(filial, produtor, pLote ) ;	  
			 return obj;
		}			
		
		

}
