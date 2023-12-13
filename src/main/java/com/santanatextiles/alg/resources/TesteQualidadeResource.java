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

import com.santanatextiles.alg.domain.TesteQualidade;
import com.santanatextiles.alg.services.TesteQualidadeService;

@RestController
@RequestMapping(value="/testecq")
public class TesteQualidadeResource {
	
	
	@Autowired
	private TesteQualidadeService service;  
	
 	@CrossOrigin
 	@RequestMapping(value="/pesquisa/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaTesteQualidadePorParametros (@PathVariable String filial){ 
 		try {
	 		List<TesteQualidade> testeQualidade = service.buscaTesteQualidadePorParametros(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(testeQualidade);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 
 	
 	@CrossOrigin
 	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaTesteQualidadePorFilial (@PathVariable String filial){ 
 		try {
	 		List<TesteQualidade> testeQualidade = service.buscaTesteQualidadeByFilial(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(testeQualidade);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	
 	
 	
 	@CrossOrigin
 	@RequestMapping(value="/{filial}/{produtor}/{lote}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaTesteQualidadePorLote (@PathVariable String filial,@PathVariable String produtor,@PathVariable String lote){ 
 		try {
	 		 TesteQualidade  testeQualidade = service.buscaTesteQualidadeByLote(filial, produtor, lote) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(testeQualidade);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	 	
	
	
	
	
	

}
