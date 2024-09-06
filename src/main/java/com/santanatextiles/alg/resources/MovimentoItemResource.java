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

import com.santanatextiles.alg.domain.MovimentoItem;
import com.santanatextiles.alg.services.MovimentoItemService;

@RestController
@RequestMapping(value="/movimentoitem")
public class MovimentoItemResource {
	 
	
	@Autowired
	private MovimentoItemService service;  
	
 	@CrossOrigin
 	@RequestMapping(value="/pesquisa/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaMovimentoItemPorParametros (@PathVariable String filial){ 
 		try {
	 		List<MovimentoItem> movimentoItem = service.buscaMovimentoItemPorParametros(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(movimentoItem);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 
 	
 	@CrossOrigin
 	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaMovimentoItemPorFilial (@PathVariable String filial){ 
 		try {
	 		List<MovimentoItem> movimentoItem = service.buscaMovimentoItemByFilial(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(movimentoItem);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	  	
 	 
 
	
	

}
