package com.santanatextiles.alg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.TipoMateriaPrima;
import com.santanatextiles.alg.domain.TipoMovimento;
import com.santanatextiles.alg.repositories.TipoMateriaPrimaRepository;

@Service
public class TipoMateriaPrimaService {
			
		@Autowired
		private TipoMateriaPrimaRepository repo;
		
		@Value("${spring.datasource.url}")
		private String JDBC_URL;
		
		@Value("${spring.datasource.username}")
		private String JDBC_USER;

		@Value("${spring.datasource.password}") 
		private String JDBC_PASSWORD;			
		
		public List<TipoMateriaPrima> buscaTipoMateriaPrimaPorParametros(String filial ){ 
			 List<TipoMateriaPrima> obj = repo.buscaTipoMateriaPrimaPorParametros(filial ) ;	  
			 return obj;
		}			
		
		
		public List<TipoMateriaPrima> buscaTipoMateriaPrimaByFilial(String filial ){	 
			 List<TipoMateriaPrima> obj = repo.findByIdfil(filial ) ;	  
			 return obj;
		}			
			
		public  TipoMateriaPrima  buscaTipoMPByCodigo(String filial,String codigo ){	 
			TipoMateriaPrima  obj = repo.findByIdfilAndCodigo(filial, codigo);  
			 return obj;
		}			
		
		

}
