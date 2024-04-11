package com.santanatextiles.alg.resources;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.alg.domain.LoteFiacao;
import com.santanatextiles.alg.dto.LoteFiacaoDTO;
import com.santanatextiles.alg.services.LoteFiacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/lotefiacao")
public class LoteFiacaoResource {
	
	@Autowired
	private LoteFiacaoService service; 	 
	
	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaLoteFiacao(@PathVariable String filial){  
		try {
			List<LoteFiacao> listaLoteFiacao = service.buscaLoteFiacao(filial);  
			return ResponseEntity.status(HttpStatus.OK).body(listaLoteFiacao); 
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}
	
 	@RequestMapping(value="/filial/{filial}/paginado",method=RequestMethod.GET)
 	public  ResponseEntity<Page<LoteFiacao>> buscaLoteFiacaoPag(
 			@PathVariable String filial,
 			@RequestParam(value="page", defaultValue="0") Integer page, 
 			@RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage, 
 			@RequestParam(value="orderBy", defaultValue="j0lote") String orderBy, 
 			@RequestParam(value="direction", defaultValue="ASC") String direction) {	 
 		Page<LoteFiacao> lista = service.buscaLoteFiacaoPag(page, linesPerPage, orderBy, direction, filial  );
 		return ResponseEntity.status(HttpStatus.OK).body(lista);
 	} 
 	
 	@CrossOrigin
 	@RequestMapping(value="/buscaLotePorChave", method=RequestMethod.POST)
 	public  ResponseEntity<?>  buscaLotePorChave (@Valid @RequestBody LoteFiacaoDTO obj){ 
 		try {
	 		System.out.println(obj.getLote());
	 		LoteFiacao  loteFiacao = service.buscaLotePorChave(obj.getIdfil(), obj.getTipoMaquina(), obj.getItem(), obj.getIdSSM(), obj.getLote());
	 		return ResponseEntity.status(HttpStatus.OK).body(loteFiacao);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	
 	
 	
 	@CrossOrigin
 	@RequestMapping(value="/pesquisa", method=RequestMethod.POST)
 	public  ResponseEntity< ? > pesquisaLoteFiacaoByParam (@Valid @RequestBody LoteFiacaoDTO objDTO){ 
 		try {
	 		List<Map<String, Object>> loteFiacao = service.pesquisaLoteFiacaoByParam(objDTO) ; 
	 		return ResponseEntity.status(HttpStatus.OK).body(loteFiacao);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	
 	
 	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> insert  (@Valid @RequestBody LoteFiacaoDTO objDTO){   
 		try {
		    LoteFiacao obj = service.fromDTO(objDTO);	
			service.insert(obj);
			return ResponseEntity.status(HttpStatus.OK).body(obj.getLote());
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	} 	 	
 	
 	@CrossOrigin
 	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<String> update(@Valid @RequestBody LoteFiacaoDTO objDTO) { 
 		try {
	 		LoteFiacao obj = service.fromDTO(objDTO);	
			service.update(obj);
			return ResponseEntity.status(HttpStatus.OK).body(obj.getLote());
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}	
 	
	@CrossOrigin
	@RequestMapping(value="/filial/{idfil}/tipo/{tipoMaquina}/lote/{lote}/item/{item}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deletaLoteFiacao(@PathVariable  String idfil, @PathVariable  String tipoMaquina  , @PathVariable  String lote, @PathVariable String item) throws SQLException{
		try {
			service.deletaLoteFiacao(idfil, tipoMaquina, lote, item);
			return ResponseEntity.status(HttpStatus.OK).body( lote);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}
	
	
	@RequestMapping(value="/buscalote/{filial}/{lote}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaLoteFiacaoPorCodigo(@PathVariable String filial,@PathVariable String lote){  
		try {
			List<Map<String, Object>> loteFiacao = service.buscaLoteFiacaoPorCodigo(filial, lote)  ;
			return ResponseEntity.status(HttpStatus.OK).body(loteFiacao); 
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}	
	
 	
 	
} 	
