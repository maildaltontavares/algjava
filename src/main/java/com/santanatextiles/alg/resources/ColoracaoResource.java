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

import com.santanatextiles.alg.domain.Coloracao;
import com.santanatextiles.alg.services.ColoracaoService;

@RestController
@RequestMapping(value="/coloracao")
public class ColoracaoResource {
	
	
	@Autowired
	private ColoracaoService service;  
	
 	@CrossOrigin
 	@RequestMapping(value="/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaColoracaoByFilial (@PathVariable String filial){ 
 		try {
	 		List<Coloracao> Coloracao = service.buscaColoracaoByFilial(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(Coloracao);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 
 	
 	@CrossOrigin
 	@RequestMapping(value="/{filial}/{codigo}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaColoracaoByFilialAndCodigo (@PathVariable String filial,@PathVariable String codigo){ 
 		try {
	 		List<Coloracao> Coloracao = service.buscaColoracaoByFilialAndCodigo(filial, codigo) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(Coloracao);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	
	
	

}


 