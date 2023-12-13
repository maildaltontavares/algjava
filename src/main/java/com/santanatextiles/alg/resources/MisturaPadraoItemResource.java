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

import com.santanatextiles.alg.domain.MisturaPadraoItem;
import com.santanatextiles.alg.services.MisturaPadraoItemService;

@RestController
@RequestMapping(value="/mpitem")
public class MisturaPadraoItemResource {
	
	@Autowired
	private MisturaPadraoItemService service;  
	
 	@CrossOrigin
 	@RequestMapping(value="/pesquisa/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaMisturaPadraoItemPorParametros (@PathVariable String filial){ 
 		try {
	 		List<MisturaPadraoItem> misturaPadraoItem = service.buscaMisturaPadraoItemPorParametros(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(misturaPadraoItem);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	
 		

}
