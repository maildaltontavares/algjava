package com.santanatextiles.alg.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.alg.domain.Pilha;
import com.santanatextiles.alg.services.PilhaService;

@RestController
@RequestMapping(value="/pilha")
public class PilhaResource {
	
	
	@Autowired
	private PilhaService service;  
	
 	@CrossOrigin
 	@RequestMapping(value="/pesquisa/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaPilhaPorParametros (@PathVariable String filial){ 
 		try {
	 		List<Pilha> pilha = service.buscaPilhaPorParametros(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(pilha);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 
 	
 	@CrossOrigin
 	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaPilhaPorFilial (@PathVariable String filial){ 
 		try {
	 		List<Pilha> pilha = service.buscaPilhaByFilial(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(pilha);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	
	
	

}
