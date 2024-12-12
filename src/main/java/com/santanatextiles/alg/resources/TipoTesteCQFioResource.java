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

import com.santanatextiles.alg.domain.TipoTesteCQFio;
import com.santanatextiles.alg.services.TipoTesteCQFioService;

@RestController
@RequestMapping(value="/tipotestecqf")
public class TipoTesteCQFioResource { 
	
	@Autowired
	private TipoTesteCQFioService service;  
	
 	@CrossOrigin
 	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaTipoTesteCQFioPorParametros (@PathVariable String filial){ 
 		try {
	 		List<TipoTesteCQFio> tipoTesteCQFio = service.buscaTipoTesteCQFioPorParametros(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(tipoTesteCQFio);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	 
	
	
}

 
