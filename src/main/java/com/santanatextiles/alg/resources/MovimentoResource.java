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
import com.santanatextiles.alg.dto.LoteDTO;
import com.santanatextiles.alg.dto.MovimentoDTO;
import com.santanatextiles.alg.dto.MovimentoItemDTO;
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
 	public  ResponseEntity< ? > buscaMovPorFilial (@PathVariable String filial){ 
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
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<String> update (@Valid @RequestBody List<MovimentoDTO> objDTO){   
 		try {  
		    String resultado = service.update(objDTO);
			return ResponseEntity.status(HttpStatus.OK).body(resultado);
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
 	
 	
 	@CrossOrigin
 	@RequestMapping(value="/novoitem", method=RequestMethod.GET)
 	public  ResponseEntity< ? > codigoNovoMovimento (){ 
 		try {
	 		Double novoId = service.codigoNovoMovimento() ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(novoId);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	
 	
 	
 	@CrossOrigin 
 	@RequestMapping(value="/pilha", method=RequestMethod.POST)
	public ResponseEntity<String> geraPilha (@Valid @RequestBody List<MovimentoDTO> objDTO){   
 		try { 
		     
			service.gerarPilha(objDTO);
			return ResponseEntity.status(HttpStatus.OK).body("OK");
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}  	 	
	 
 	 
 	@CrossOrigin
 	@RequestMapping(value="/excluirpilha/{idAutomatico}", method=RequestMethod.GET)
 	public  ResponseEntity< ? > excluirPilha ( @PathVariable Double idAutomatico){ 
 		try {
	 		Double idExclusao = service.excluirPilha( idAutomatico) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body("OK");
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}  	
 	
 	
 	
 	
 	@CrossOrigin
 	@RequestMapping(value="/exibemovimentacao", method=RequestMethod.POST)
 	public  ResponseEntity< ? > buscaExistenciaLote (@Valid @RequestBody MovimentoItemDTO objDTO){ 
 		try {
	 		 List<LoteDTO>  movimentosLote = service.buscaMovimentosLote(objDTO.getIdfil(), objDTO.getProdutor(), objDTO.getLote(), objDTO.getItem());
	 		return ResponseEntity.status(HttpStatus.OK).body(movimentosLote);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}  	
    	 
 

}
