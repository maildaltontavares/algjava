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

import com.santanatextiles.alg.domain.TipoMovimento;
import com.santanatextiles.alg.services.TipoMovimentoService;

@RestController
@RequestMapping(value="/tipomovto")
public class TipoMovimentoResource {
	
	
	@Autowired
	private TipoMovimentoService service;  
	
 	@CrossOrigin
 	@RequestMapping(value="/pesquisa/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaTipoMovimentoPorParametros (@PathVariable String filial){ 
 		try {
	 		List<TipoMovimento> tipoMovimento = service.buscaTipoMovimentoPorParametros(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(tipoMovimento);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 
 	
 	@CrossOrigin
 	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaTipoMovimentoPorFilial (@PathVariable String filial){ 
 		try {
	 		List<TipoMovimento> tipoMovimento = service.buscaTipoMovimentoByFilial(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(tipoMovimento);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	  	
		
	
 	@CrossOrigin
 	@RequestMapping(value="/{filial}/{codigo}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaTipoMovimentoPorCodigo (@PathVariable String filial,@PathVariable String codigo){ 
 		try {
	 		TipoMovimento tipoMovimento = service.buscaTipoMovimentoByCodigo(filial, codigo);
	 		return ResponseEntity.status(HttpStatus.OK).body(tipoMovimento);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	
 	
 	
	

}
