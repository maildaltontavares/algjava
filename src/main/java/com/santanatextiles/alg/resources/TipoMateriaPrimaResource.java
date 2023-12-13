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

import com.santanatextiles.alg.domain.TipoMateriaPrima;
import com.santanatextiles.alg.services.TipoMateriaPrimaService;

@RestController
@RequestMapping(value="/tipomp")
public class TipoMateriaPrimaResource {
	
	@Autowired
	private TipoMateriaPrimaService service;  
	
 	@CrossOrigin
 	@RequestMapping(value="/pesquisa/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaMovimentoItemPorParametros (@PathVariable String filial){ 
 		try {
	 		List<TipoMateriaPrima> tipoMateriaPrima = service.buscaTipoMateriaPrimaPorParametros(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(tipoMateriaPrima);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 
 	
 	@CrossOrigin
 	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > buscaTipoMateriaPrimaPorFilial (@PathVariable String filial){ 
 		try {
	 		List<TipoMateriaPrima> tipoMateriaPrima = service.buscaTipoMateriaPrimaByFilial(filial) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(tipoMateriaPrima);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 
	
	
	
	
	
	

}
