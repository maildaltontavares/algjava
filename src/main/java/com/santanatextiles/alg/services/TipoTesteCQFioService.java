package com.santanatextiles.alg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.TipoTesteCQFio;
import com.santanatextiles.alg.repositories.TipoTesteCQFioRepository;

@Service
public class TipoTesteCQFioService { 
	
		@Autowired
		private TipoTesteCQFioRepository repo;	  
		 
		public List<TipoTesteCQFio> buscaTipoTesteCQFioPorParametros(String filial ){ 
			 List<TipoTesteCQFio> obj = repo.buscaTipoTesteCQFioPorParametros(filial ) ;	  
			 return obj;
		}	 
	
	
	

}
 
