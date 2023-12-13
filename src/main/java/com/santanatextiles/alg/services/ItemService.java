package com.santanatextiles.alg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.Item;
import com.santanatextiles.alg.domain.ItemId;
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
	    
    
    
}    
