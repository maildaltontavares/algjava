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

import com.santanatextiles.alg.domain.Produtor;
import com.santanatextiles.alg.services.ProdutorService;

@RestController
@RequestMapping(value="/produtor")
public class ProdutorResource { 
	
	@Autowired
	private ProdutorService service;  
	
 	@CrossOrigin
 	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaProdutorPorParametros (@PathVariable String filial){ 
 		try {
	 		List<Produtor> produtor = service.buscaProdutorPorParametros(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(produtor);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	 
	
	
}
