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

import com.santanatextiles.alg.domain.EstoqueMP;
import com.santanatextiles.alg.domain.FardoDocumento;
import com.santanatextiles.alg.dto.FardoDocumentoDTO;
import com.santanatextiles.alg.services.FardoDocumentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/fardo")
public class FardoDocumentoResource {

	@Autowired
	private FardoDocumentoService service; 	
	
	
	
 	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> insert (@Valid @RequestBody FardoDocumentoDTO objDTO){   
 		try { 
		     
			service.gravaFardos(objDTO);
			return ResponseEntity.status(HttpStatus.OK).body("OK");
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}  	 	
		
 	
 	@CrossOrigin 
 	@RequestMapping(value="/pesquisafardos/{idMov}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaFardos (@PathVariable Double idMov){ 
 		try {
	 		FardoDocumento fardoDocumento = service.buscaFardos(idMov) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(fardoDocumento);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}  	
	
	
}
