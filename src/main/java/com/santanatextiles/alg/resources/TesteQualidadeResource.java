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

import com.santanatextiles.alg.domain.TesteQualidade;
import com.santanatextiles.alg.dto.TesteQualidadeDTO;
import com.santanatextiles.alg.dto.TesteQualidadeProjectionDTO;
import com.santanatextiles.alg.services.TesteQualidadeService;

import jakarta.validation.Valid;

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
 	@RequestMapping(value="/busca", method=RequestMethod.PUT)
 	public  ResponseEntity< ? > buscaTesteQualidadeByLoteItem (@Valid @RequestBody  TesteQualidadeDTO testeQualidadeDTO){ 
 		try {
 		 
 			TesteQualidade  testeQualidade = service.buscaTesteQualidadeByLoteItem(testeQualidadeDTO.getIdfil(), testeQualidadeDTO.getProdutor() , testeQualidadeDTO.getLote(),testeQualidadeDTO.getItem()) ;
	 		return ResponseEntity.status(HttpStatus.OK).body(testeQualidade);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}   
 	
 	/*
 	@CrossOrigin
 	@RequestMapping(value="delete/{filial}/{produtor}/{lote}/{item}", method=RequestMethod.DELETE)
 	public  ResponseEntity< ? > exluirTeste (@PathVariable String filial,@PathVariable String produtor,@PathVariable String lote, @PathVariable String item){ 
 		try {
	 		String excl = service.excluirTeste(filial, produtor, lote,item) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(excl);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}  	
 	*/
 	
 	
 	@CrossOrigin
 	@RequestMapping(value="delete", method=RequestMethod.PUT)
 	public  ResponseEntity< ? > exluirTeste (@Valid @RequestBody  TesteQualidadeDTO testeQualidadeDTO){ 
 		try {
	 		String excl = service.excluirTeste(testeQualidadeDTO.getIdfil(), testeQualidadeDTO.getProdutor() , testeQualidadeDTO.getLote(),testeQualidadeDTO.getItem()) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(excl);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}  	
 	
 	
 	@CrossOrigin 
 	@RequestMapping(value="/pesquisa", method=RequestMethod.POST)
 	public  ResponseEntity< ? > pesquisarTeste (@Valid @RequestBody  TesteQualidadeDTO testeQualidadeDTO){ 
 		try {
 			List<TesteQualidade> testeQualidade = service.pesquisarTeste(testeQualidadeDTO) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(testeQualidade);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}   
 	
 	
 	@CrossOrigin 
 	@RequestMapping(value="/pesquisateste", method=RequestMethod.POST)
 	public  ResponseEntity< ? > pesquisarTesteRealizados (@Valid @RequestBody  TesteQualidadeDTO testeQualidadeDTO){ 
 		try {
 			List<TesteQualidadeProjectionDTO> testeQualidade = service.pesquisarTesteRealizados(testeQualidadeDTO) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(testeQualidade);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}    	
 	
 
 	@CrossOrigin 
 	@RequestMapping(value="/insert", method=RequestMethod.POST)
 	public  ResponseEntity< ? > insertTeste (@Valid @RequestBody  TesteQualidade testeQualidade){ 
 		try {
 			TesteQualidade testeQualidadeFim = service.insertTeste(testeQualidade) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(testeQualidadeFim);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}   	
 	
 	@CrossOrigin 
 	@RequestMapping(value="/update", method=RequestMethod.PUT)
 	public  ResponseEntity< ? > updateTeste (@Valid @RequestBody  TesteQualidade testeQualidade){ 
 		try {
 			TesteQualidade testeQualidadeFim = service.updateTeste(testeQualidade) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(testeQualidadeFim);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}  	
	
 

}
