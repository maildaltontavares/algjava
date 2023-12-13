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

import com.santanatextiles.alg.domain.EstoqueMP;
import com.santanatextiles.alg.services.EstoqueMPService;

@RestController
@RequestMapping(value="/estoquemp")
public class EstoqueMPResource {
	
	@Autowired
	private EstoqueMPService service;  
	
 	@CrossOrigin
 	@RequestMapping(value="/pesquisa/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaEstoqueMPPorParametros (@PathVariable String filial){ 
 		try {
	 		List<EstoqueMP> estoqueMP = service.buscaEstoqueMPPorParametros(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(estoqueMP);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	
 	
 	
 	@CrossOrigin
 	@RequestMapping(value="/all", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaEstoqueMP (){ 
 		try {
	 		List<EstoqueMP> estoqueMP = service.buscaEstoqueMP() ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(estoqueMP);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	 
 	
 	@CrossOrigin
 	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaEstoqueMPPorFilial (@PathVariable String filial){ 
 		try {
	 		List<EstoqueMP> estoqueMP = service.buscaEstoqueMPByFilial(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(estoqueMP);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	 	 	
 		 	
 		

}
