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

import com.santanatextiles.alg.domain.Movimento;
import com.santanatextiles.alg.dto.MovimentoDTO;
import com.santanatextiles.alg.services.MovimentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/movimento")
public class MovimentoResource {
	
	
	
	@Autowired
	private MovimentoService service;  
	
 	@CrossOrigin
 	@RequestMapping(value="/busca/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaMovimentoPorParametros (@PathVariable String filial){ 
 		try {
	 		List<Movimento> Movimento = service.buscaMovimentoPorParametros(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(Movimento);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 
 	
 	
 	@CrossOrigin 
 	@RequestMapping(value="/pesquisa", method=RequestMethod.POST)
 	public  ResponseEntity< ? > pesquisaMovimentoPorParametros (@Valid @RequestBody  MovimentoDTO movimentoDTO){ 
 		try {
	 		List<Movimento> Movimento = service.pesquisaMovimentoPorParametros(movimentoDTO) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(Movimento);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}  	
 	
 	@CrossOrigin
 	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaMisturaPadraoPorFilial (@PathVariable String filial){ 
 		try {
	 		List<Movimento> Movimento = service.buscaMovimentoByFilial(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(Movimento);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	
 	
 
 	
 
 	@CrossOrigin 
 	@RequestMapping(value="/buscadoc", method=RequestMethod.POST) 	
 	public  ResponseEntity< ? > findByIdfilAndFornecedorAndNotaFiscal (@Valid @RequestBody  MovimentoDTO movimentoDTO){ 
 		try {
	 		Movimento movimento = service.findByIdfilAndFornecedorAndNotaFiscal(movimentoDTO) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(movimento);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}  	
 	
 	
 	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> insert (@Valid @RequestBody List<MovimentoDTO> objDTO){   
 		try { 
		     
			service.insert(objDTO);
			return ResponseEntity.status(HttpStatus.OK).body("OK");
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}  	 	
 	 
 	@CrossOrigin
	@RequestMapping(value="/movim", method=RequestMethod.POST)
	public ResponseEntity<String> insertMovimento  (@Valid @RequestBody MovimentoDTO objDTO){   
 		try {
		    Movimento obj = service.fromDTO(objDTO);	 
			service.insertMovimento(obj);
			return ResponseEntity.status(HttpStatus.OK).body(obj.getNotaFiscal());
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}  	
 	
	 
    		
	

}
