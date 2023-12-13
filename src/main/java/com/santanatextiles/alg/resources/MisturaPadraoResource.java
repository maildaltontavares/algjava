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

import com.santanatextiles.alg.domain.MisturaPadrao;
import com.santanatextiles.alg.services.MisturaPadraoService;

@RestController
@RequestMapping(value="/mp")
public class MisturaPadraoResource {

	
	@Autowired
	private MisturaPadraoService service;  
	
 	@CrossOrigin
 	@RequestMapping(value="/pesquisa/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaMisturaPadraoPorParametros (@PathVariable String filial){ 
 		try {
	 		List<MisturaPadrao> misturaPadrao = service.buscaMisturaPadraoPorParametros(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(misturaPadrao);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	
 	
 	@CrossOrigin
 	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaMisturaPadraoPorFilial (@PathVariable String filial){ 
 		try {
	 		List<MisturaPadrao> misturaPadrao = service.buscaMisturaPadraoByFilial(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(misturaPadrao);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	 	
	
	
	
}
