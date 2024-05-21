package com.santanatextiles.alg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.ProducaoAbertura;
import com.santanatextiles.alg.dto.ProducaoAberturaDTO;
import com.santanatextiles.alg.repositories.ProducaoAberturaRepository;

@Service
public class ProducaoAberturaService {
	
	
	@Autowired
	private ProducaoAberturaRepository repo;		
	
	@Value("${spring.datasource.url}")
	private String JDBC_URL;
	
	@Value("${spring.datasource.username}")
	private String JDBC_USER;

	@Value("${spring.datasource.password}") 
	private String JDBC_PASSWORD;			
	
	public  ProducaoAbertura  gravaBaixaMistura(ProducaoAbertura producaoAbertura ){	   
		 ProducaoAbertura pa = repo.save(producaoAbertura ) ;	  
		 return pa;
	}	
	
	public Double deleteByIdfilAndIdAutomatico(String filial , Double idAuto){	 
		 Double obj = repo.deleteByIdfilAndIdAutomatico(filial ,idAuto) ;	  
		 return obj;
	}			
				

}
