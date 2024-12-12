package com.santanatextiles.alg.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.Item;
import com.santanatextiles.alg.domain.ItemId;
import com.santanatextiles.alg.dto.ItemFioProjectionDTO;
import com.santanatextiles.alg.projections.FioProjection;
import com.santanatextiles.alg.repositories.ItemRepository;
import com.santanatextiles.alg.resources.utils.URL;
 

@Service
public class ItemService {
	
	@Autowired 
	private ItemRepository repo;
	
	public List<Item> buscaItem(Long idfil){	 
		List<Item> obj = repo.buscaItem(idfil); 
		return  obj;							 
	}	
	
    public Page<Item> buscaItemPag(Integer page, Integer linesPerPage, String orderBy, String direction, Long idfil) {
	PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);  
	return repo.buscaItemPag(pageRequest, idfil);
    }	
    
	public Item buscar(String idfil, Long codigo) {
		Long localizacao = URL.codigoLocalizacao(idfil);
		Optional<Item> obj = repo.findById(new ItemId(localizacao,codigo));
		return obj.orElse(null);
	}
	
	public List<Item> procuraPorDescricao(String idfil,String descricao) {
		Long localizacao = URL.codigoLocalizacao(idfil);
		return repo.procuraPorDescricao(localizacao, Long.valueOf(idfil), descricao.toUpperCase());
	}
	
	
	 //public List<MisturaProjectionDTO> buscaEstoqueMistura( String idfil , List<String>  idFardosSelecionados) throws ParseException{
	 public List<ItemFioProjectionDTO> buscaFioPorDescricao( String idfil , String descricao ) throws ParseException{  
		 
		    //List<MisturaPadraoProjection> saldoPesquisaEstoque; 
		    List<FioProjection> listaFioProjection;
		    
		    int filial = Integer.parseInt(idfil) ;
		  
		    listaFioProjection = repo.buscaFio( filial , descricao.toUpperCase(), null    );    // 
		   
			//List<MisturaProjectionDTO> listaSaldoPesquisaEstoque = saldoPesquisaEstoque.stream().map(x-> new MisturaProjectionDTO(x)).toList();  		
		    List<ItemFioProjectionDTO> listaItemProj= listaFioProjection.stream().map(x-> new ItemFioProjectionDTO(x)).toList();
			
			//List<MisturaProjectionDTO> saldoPesquisaEstLista =  new ArrayList<>(); 
		    List<ItemFioProjectionDTO> listaItemFinal =  new ArrayList<>();
			
			for (ItemFioProjectionDTO itemLista : listaItemProj) {  
				
				ItemFioProjectionDTO elemento = new ItemFioProjectionDTO();
				 
				elemento.setIdfil(itemLista.getIdfil()); 
				elemento.setCodigo(itemLista.getCodigo()); 
				elemento.setCodMaterial(itemLista.getCodMaterial()); 
				elemento.setLocalizacao(itemLista.getLocalizacao()); 
				elemento.setDescricao(itemLista.getDescricao()); 
				elemento.setTitulo(itemLista.getTitulo()); 
				elemento.setClasseMaterial(itemLista.getClasseMaterial());
				elemento.setComposicao(itemLista.getComposicao());   
				
				listaItemFinal.add(elemento);
			 
	         }	 
		   
			  return listaItemFinal;
	}	
	 
	 public List<ItemFioProjectionDTO> buscaFioPorCodigo( String idfil , String codigo ) throws ParseException{  
		 
		    //List<MisturaPadraoProjection> saldoPesquisaEstoque; 
		    List<FioProjection> listaFioProjection;
		    
		    int filial = Integer.parseInt(idfil) ;
		  
		    listaFioProjection = repo.buscaFio( filial , null, codigo    );    // 
		   
			//List<MisturaProjectionDTO> listaSaldoPesquisaEstoque = saldoPesquisaEstoque.stream().map(x-> new MisturaProjectionDTO(x)).toList();  		
		    List<ItemFioProjectionDTO> listaItemProj= listaFioProjection.stream().map(x-> new ItemFioProjectionDTO(x)).toList();
			
			//List<MisturaProjectionDTO> saldoPesquisaEstLista =  new ArrayList<>(); 
		    List<ItemFioProjectionDTO> listaItemFinal =  new ArrayList<>();
			
			for (ItemFioProjectionDTO itemLista : listaItemProj) {  
				
				ItemFioProjectionDTO elemento = new ItemFioProjectionDTO();
				 
				elemento.setIdfil(itemLista.getIdfil()); 
				elemento.setCodigo(itemLista.getCodigo()); 
				elemento.setCodMaterial(itemLista.getCodMaterial()); 
				elemento.setLocalizacao(itemLista.getLocalizacao()); 
				elemento.setDescricao(itemLista.getDescricao()); 
				elemento.setTitulo(itemLista.getTitulo()); 
				elemento.setClasseMaterial(itemLista.getClasseMaterial());
				elemento.setComposicao(itemLista.getComposicao());   
				
				listaItemFinal.add(elemento);
			 
	         }	 
		   
			  return listaItemFinal;
	}		 
	
	
	    
    
    
}    
