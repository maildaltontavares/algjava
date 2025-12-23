package com.santanatextiles.alg.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.alg.domain.Item;
import com.santanatextiles.alg.dto.ItemFioProjectionDTO;
import com.santanatextiles.alg.services.ItemService;

@RestController
@RequestMapping(value="/item")
public class ItemResource { 
	
	@Autowired
	private ItemService service; 	
	
	
	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaItem(@PathVariable Long filial){  
		try {
			List<Item> listaItem = service.buscaItem(filial);  
			return ResponseEntity.status(HttpStatus.OK).body(listaItem);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
			
	}
	
 	@RequestMapping(value="/filial/{filial}/paginado",method=RequestMethod.GET)
 	public  ResponseEntity<Page<Item>> buscaItemPag(
 			@PathVariable Long filial,
 			@RequestParam(value="page", defaultValue="0") Integer page, 
 			@RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage, 
 			@RequestParam(value="orderBy", defaultValue="d0422_id_item") String orderBy, 
 			@RequestParam(value="direction", defaultValue="ASC") String direction) {	 
 		Page<Item> lista = service.buscaItemPag(page, linesPerPage, orderBy, direction, filial  );
 		return ResponseEntity.status(HttpStatus.OK).body(lista);
 	} 	
 	 
 	
	@CrossOrigin
	@RequestMapping(value="/{idfil}/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String idfil, @PathVariable Long codigo) {
		try {
			Item obj = service.buscar(idfil,codigo); 
			return ResponseEntity.ok().body(obj);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
		
	} 
 
	@CrossOrigin
	@RequestMapping(value="/{idfil}/descricao/{descricao}",method=RequestMethod.GET)
	public  ResponseEntity<?> procuraPorDescricao(
			@PathVariable String idfil,
			@PathVariable String descricao) {
		try {
			List<Item> lista = service.procuraPorDescricao(idfil,descricao);
			return ResponseEntity.ok().body(lista);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
		
	} 	
	
	@CrossOrigin
	@RequestMapping(value="/pesquisa/{idfil}/codigo/{codigo}",method=RequestMethod.GET)
	public  ResponseEntity<?> buscaFioPorCodigo(
			@PathVariable String idfil,
			@PathVariable String codigo) {
		try {
			List<ItemFioProjectionDTO> lista = service.buscaFioPorCodigo(idfil,codigo);
			return ResponseEntity.ok().body(lista);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
		
	} 	
	
	@CrossOrigin
	@RequestMapping(value="/pesquisa/{idfil}/descricao/{descricao}",method=RequestMethod.GET)
	public  ResponseEntity<?> buscaFioPorDescricao(
			@PathVariable String idfil,
			@PathVariable String descricao) {
		try {
			List<ItemFioProjectionDTO> lista = service.buscaFioPorDescricao(idfil,descricao);
			return ResponseEntity.ok().body(lista);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
		
	} 	
 	 
	@CrossOrigin
	@RequestMapping(value="/pesquisa/{idfil}/codigo/{codigo}/tpMaq/{tipoMaquina}",method=RequestMethod.GET)
	public  ResponseEntity<?> buscaFioPorCodigoTipoMaquina(
			@PathVariable String idfil,
			@PathVariable String codigo,
			@PathVariable String tipoMaquina) {
		try {
			List<ItemFioProjectionDTO> lista = service.buscaFioPorCodigoTipoMaquina(idfil,codigo,tipoMaquina);
			return ResponseEntity.ok().body(lista);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
		
	}
	
	

}
