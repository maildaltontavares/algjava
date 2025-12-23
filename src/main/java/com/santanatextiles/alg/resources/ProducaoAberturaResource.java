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

import com.santanatextiles.alg.domain.ProducaoAbertura;
import com.santanatextiles.alg.dto.ProducaoAberturaDTO;
import com.santanatextiles.alg.services.ProducaoAberturaService;

import jakarta.validation.Valid;

 
@RestController
@RequestMapping(value="/producaoabertura")
public class ProducaoAberturaResource { 
	
	@Autowired
	private ProducaoAberturaService service;  
	
 	@CrossOrigin
 	@RequestMapping(value="/producao/{filial}/{mistura}/{seq}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaProdutorPorParametros (@PathVariable String filial,@PathVariable String mistura,@PathVariable String seq){ 
 		try {
	 		ProducaoAbertura producaoAbertura = service.buscaProducaoAberturaPorFilialMisturaSeq(filial, mistura, seq);
	 		return ResponseEntity.status(HttpStatus.OK).body(producaoAbertura);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
 	}
 	
 	@CrossOrigin
 	@RequestMapping(value="/pesquisabaixa/{filial}/{mistura}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaProducaoAberturaPorFilialMistura (@PathVariable String filial,@PathVariable String mistura){ 
 		try {
 			List<ProducaoAbertura>  producaoAbertura = service.buscaProducaoAberturaPorFilialMistura(filial, mistura );
	 		return ResponseEntity.status(HttpStatus.OK).body(producaoAbertura);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
 	}
 	 	
 	
  
 	@CrossOrigin
 	@RequestMapping(value="/pesquisa", method=RequestMethod.POST)
 	public  ResponseEntity< ? > buscaProducaoAberturaPorParametros (@Valid @RequestBody ProducaoAberturaDTO objDTO){ 
 		try {
 			List<ProducaoAbertura> producaoAbertura = service.buscaProducaoAberturaPorParametros( objDTO ) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(producaoAbertura);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}
 	
 	
 	@CrossOrigin
 	@RequestMapping(value="/insert", method=RequestMethod.POST)
 	public  ResponseEntity< ? > inserirProducaoAbertura(@Valid @RequestBody ProducaoAberturaDTO objDTO){ 
 		try {
 			 ProducaoAberturaDTO  producaoAbertura = service.inserirProducaoAbertura( objDTO ) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(producaoAbertura);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	 
 	
 	@CrossOrigin
 	@RequestMapping(value="/update", method=RequestMethod.PUT)
 	public  ResponseEntity< ? > alterarProducaoAbertura(@Valid @RequestBody ProducaoAberturaDTO objDTO){ 
 		try {
 			 ProducaoAberturaDTO  producaoAbertura = service.alterarProducaoAbertura( objDTO ) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(producaoAbertura);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 
 	
 	@CrossOrigin
 	@RequestMapping(value="/delete/{filial}/{mistura}/{seq}", method=RequestMethod.DELETE)
 	public  ResponseEntity< ? > excluirApontamento (@PathVariable String filial,@PathVariable String mistura,@PathVariable String seq){ 
 		try {
	 		Integer reg = service.excluirApontamento(filial, mistura, seq);
	 		return ResponseEntity.status(HttpStatus.OK).body(reg);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
 	} 	
 	
 	 
 	
} 	
