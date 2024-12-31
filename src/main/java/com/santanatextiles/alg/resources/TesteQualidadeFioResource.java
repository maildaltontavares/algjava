package com.santanatextiles.alg.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.alg.domain.TesteQualidadeFio;
import com.santanatextiles.alg.dto.MisturaPadraoDTO;
import com.santanatextiles.alg.dto.TesteQualidadeFioDTO;
import com.santanatextiles.alg.dto.TesteQualidadeFioProjectionDTO;
import com.santanatextiles.alg.services.TesteQualidadeFioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/tqf")
public class TesteQualidadeFioResource { 
	
	@Autowired
	private TesteQualidadeFioService service;  
	
 	@CrossOrigin
 	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaTesteQualidadeFioPorParametros (@PathVariable String filial){ 
 		try {
	 		List<TesteQualidadeFio> testeQualidadeFio = service.buscaTesteQualidadeFioPorParametros(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(testeQualidadeFio);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 
 	 	
 	
 	
 	@CrossOrigin  
 	@RequestMapping(value="/busca", method=RequestMethod.PUT)
 	public  ResponseEntity< ? > buscaTesteQualidadeFioPorChave (@Valid @RequestBody  TesteQualidadeFioDTO testeQualidadeFioDTO){ 
 		try {
	 		TesteQualidadeFio testeQualidadeFio = service.buscaTesteQualidadeFioPorChave(testeQualidadeFioDTO) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(testeQualidadeFio);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	 
 	
 	
 	@CrossOrigin  
 	@RequestMapping(value="/pesquisa", method=RequestMethod.PUT)
 	public  ResponseEntity< ? > pesquisaTesteQualidadeFioPorParametros (@Valid @RequestBody  TesteQualidadeFioDTO testeQualidadeFioDTO){ 
 		try {
 			List<TesteQualidadeFioProjectionDTO> testeQualidadeFio = service.pesquisaTesteQualidadeFioPorParametros(testeQualidadeFioDTO) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(testeQualidadeFio);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}  
 	
	 	
 	
 	@CrossOrigin  
 	@RequestMapping(value="/insert", method=RequestMethod.POST)
 	public  ResponseEntity< ? > insert (@Valid @RequestBody  TesteQualidadeFioDTO testeQualidadeFioDTO){ 
 		try {
 			Double testeQualidadeFio = service.insert(testeQualidadeFioDTO) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(testeQualidadeFio);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	
 	
 	@CrossOrigin  
 	@RequestMapping(value="/update", method=RequestMethod.PUT)
 	public  ResponseEntity< ? > update (@Valid @RequestBody  TesteQualidadeFioDTO testeQualidadeFioDTO){ 
 		try {
 			TesteQualidadeFio testeQualidadeFio = service.update(testeQualidadeFioDTO) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(testeQualidadeFio);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	 	
	
 	
 	@CrossOrigin
 	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
 	public  ResponseEntity< ? > delete (@PathVariable Double id){ 
 		try {
	 		service.delete(id); 
	 		return ResponseEntity.status(HttpStatus.OK).body(id);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}  	
 	
 	
	
}


 
