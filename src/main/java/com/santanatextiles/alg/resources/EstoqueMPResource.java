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
import com.santanatextiles.alg.dto.EstoqueMPDTO;
import com.santanatextiles.alg.dto.MisturaProjectionDTO;
import com.santanatextiles.alg.dto.SaldoPesquisaIdDTO;
import com.santanatextiles.alg.services.EstoqueMPService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/estoquemp")
public class EstoqueMPResource {
	
	@Autowired
	private EstoqueMPService service;  
	
 	@CrossOrigin
 	@RequestMapping(value="/pesquisa/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaEstoqueMPPorParametros (@PathVariable String filial){ 
 		try {
	 		List<EstoqueMP> estoqueMP = service.buscaEstoqueMPPorParametros(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(estoqueMP);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}
 	
 	
 	@CrossOrigin
 	@RequestMapping(value="/id/{id}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaEstoqueMPPorId (@PathVariable Double id){ 
 		try {
 			SaldoPesquisaIdDTO  estoqueMP = service.buscaEstoqueMPPorId(id) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(estoqueMP);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}  	
 	
 	
 	@CrossOrigin
 	@RequestMapping(value="/all", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaEstoqueMP (){ 
 		try {
	 		List<EstoqueMP> estoqueMP = service.buscaEstoqueMP() ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(estoqueMP);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	 
 	
 	@CrossOrigin
 	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaEstoqueMPPorFilial (@PathVariable String filial){ 
 		try {
	 		List<EstoqueMP> estoqueMP = service.buscaEstoqueMPByFilial(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(estoqueMP);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 
 	
 	@CrossOrigin
 	@RequestMapping(value="/mistura/{filial}/{mistura}/{tipoFardo}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaEstoqueMPMistura (@PathVariable String filial,@PathVariable String mistura, @PathVariable String tipoFardo){ 
 		try {
 			List<MisturaProjectionDTO> estoqueMP = service.buscaEstoqueMPMistura(filial, mistura, tipoFardo); 
	 		return ResponseEntity.status(HttpStatus.OK).body(estoqueMP);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}  	
 	
 	
 	/*
 	@CrossOrigin
 	@RequestMapping(value="/id/{filial}/{produtor}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > pesquisaSaldoId (@PathVariable String filial,@PathVariable String produtor){ 
 		try {
 			List<SaldoPesquisaIdDTO> saldoPesquisaId = service.pesquisaSaldoId(filial, produtor); 
	 		return ResponseEntity.status(HttpStatus.OK).body(saldoPesquisaId);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 
 	*/
 	
 	@CrossOrigin 
 	@RequestMapping(value="/id", method=RequestMethod.POST)
 	public  ResponseEntity< ? > pesquisaLotePorParametros (@Valid @RequestBody  EstoqueMPDTO estoqueMPDTO){ 
 		try {
 			List<SaldoPesquisaIdDTO> saldoPesquisaId = service.pesquisaLotePorParametros(estoqueMPDTO.getIdfil(), estoqueMPDTO.getProdutor(), estoqueMPDTO.getLote(), estoqueMPDTO.getItem()); 
	 		return ResponseEntity.status(HttpStatus.OK).body(saldoPesquisaId);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}  	
 	 	
 		 	
 		

}
