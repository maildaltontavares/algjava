package com.santanatextiles.alg.resources;

import java.sql.SQLException;
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

import com.santanatextiles.alg.domain.MisturaPadrao;
import com.santanatextiles.alg.dto.MisturaPadraoCabecDTO;
import com.santanatextiles.alg.dto.MisturaPadraoDTO;
import com.santanatextiles.alg.services.MisturaPadraoService;

import jakarta.validation.Valid;

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
 	@RequestMapping(value="/abertas/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaMisturasAbertas (@PathVariable String filial){ 
 		try {
	 		List<MisturaPadrao> misturaPadrao = service.buscaMisturasAbertas(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(misturaPadrao);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 
 	
 	@CrossOrigin
 	@RequestMapping(value="/calc/{filial}/{mistura}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaMisturaCalculada (@PathVariable String filial , @PathVariable String mistura){ 
 		try {
	 		 MisturaPadraoCabecDTO  misturaPadrao = service.buscaMisturaCalculada(filial, mistura);
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
 	
	@RequestMapping(value="/nova/{filial}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaNovoIdMistura(@PathVariable String filial  ){  
		try {
			String loteFiacao = service.buscaNovoIdMistura(filial);
			return ResponseEntity.status(HttpStatus.OK).body(loteFiacao); 
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	} 	
	
 	@CrossOrigin 
 	@RequestMapping(value="/incluir", method=RequestMethod.POST)
 	public  ResponseEntity< ? > incluirMistura (@Valid @RequestBody  MisturaPadraoDTO misturaDTO){ 
 		try {
	 		String mistura = service.incluirMistura(misturaDTO,"I") ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(mistura);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}
 	
 	@CrossOrigin 
 	@RequestMapping(value="/alterar", method=RequestMethod.PUT)
 	public  ResponseEntity< ? > alterarMistura (@Valid @RequestBody  MisturaPadraoDTO misturaDTO){ 
 		try {
	 		String mistura = service.alterarMistura(misturaDTO,"A") ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(mistura);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 
 	
	@CrossOrigin
	@RequestMapping(value="/excluir/{idfil}/{mistura}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deletaMistura(@PathVariable  String idfil, @PathVariable  String mistura) throws SQLException{
		try {
			
			service.deletaMistura(idfil,mistura); 
			
			return ResponseEntity.status(HttpStatus.OK).body(mistura);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	} 	
	
	
	
}
