package com.santanatextiles.alg.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.alg.domain.Fornecedor;
import com.santanatextiles.alg.services.FornecedorService;



@RestController
@RequestMapping(value="/fornecedor")
public class FornecedorResource {
	
	@Autowired
	private FornecedorService service; 	
	
	
	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaFornecedor(@PathVariable String filial){  
		try {
			List<Fornecedor> listaFornecedor = service.buscaFornecedor(filial);  
			return ResponseEntity.status(HttpStatus.OK).body(listaFornecedor);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
			
	}
	 
	@RequestMapping(value="/pesquisanmred/{filial}/{nome}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaFornecedorPorNomeReduzido(@PathVariable String filial,@PathVariable String nome){  
		try {
			List<Fornecedor> listaFornecedor = service.buscaFornecedorPorNomeReduzido(filial, nome); 
			return ResponseEntity.status(HttpStatus.OK).body(listaFornecedor);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
			
	}	
	
	
	

}
