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

import com.santanatextiles.alg.domain.Procedencia;
import com.santanatextiles.alg.services.ProcedenciaService;

@RestController
@RequestMapping(value="/procedencia")
public class ProcedenciaResource {
	
	@Autowired
	private ProcedenciaService service;  
	
 	@CrossOrigin
 	@RequestMapping(value="/pesquisa/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaProcedenciaPorParametros (@PathVariable String filial){ 
 		try {
	 		List<Procedencia> procedencia = service.buscaProcedenciaPorParametros(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(procedencia);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 
 	
 	@CrossOrigin
 	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaProcedenciaPorFilial (@PathVariable String filial){ 
 		try {
	 		List<Procedencia> procedencia = service.buscaProcedenciaByFilial(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(procedencia);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	
	
	

}
