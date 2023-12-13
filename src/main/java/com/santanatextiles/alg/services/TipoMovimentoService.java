package com.santanatextiles.alg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.TipoMovimento;
import com.santanatextiles.alg.repositories.TipoMovimentoRepository;

@Service
public class TipoMovimentoService {
			
		@Autowired
		private TipoMovimentoRepository repo;
		
		@Value("${spring.datasource.url}")
		private String JDBC_URL;
		
		@Value("${spring.datasource.username}")
		private String JDBC_USER;

		@Value("${spring.datasource.password}") 
		private String JDBC_PASSWORD;			
		
		public List<TipoMovimento> buscaTipoMovimentoPorParametros(String filial ){ 
			 List<TipoMovimento> obj = repo.buscaTipoMovimentoPorParametros(filial ) ;	  
			 return obj;
		}	
		
		
		public List<TipoMovimento> buscaTipoMovimentoByFilial(String filial ){	 
			 List<TipoMovimento> obj = repo.findByIdfil(filial ) ;	  
			 return obj;
		}	
		
		public  TipoMovimento  buscaTipoMovimentoByCodigo(String filial,String codigo ){	 
		     TipoMovimento  obj = repo.findByIdfilAndCodigo(filial, codigo);  
			 return obj;
		}			
			

}

 
