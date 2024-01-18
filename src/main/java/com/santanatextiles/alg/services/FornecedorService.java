package com.santanatextiles.alg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.Fornecedor;
import com.santanatextiles.alg.repositories.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repo;
	
	public List<Fornecedor> buscaFornecedor(String idfil){	 
		List<Fornecedor> obj = repo.buscaFornecedor(idfil); 
		return  obj;							 
	}	
	
	public List<Fornecedor> buscaFornecedorPorNomeReduzido(String idfil, String nome){	 
		nome = nome.toUpperCase();
		List<Fornecedor> obj = repo.buscaFornecedorPorNomeReduzido(idfil,nome); 
		return  obj;							 
	}	
	
	public List<Fornecedor> buscaFornecedorPorCodigo(String idfil, String codigo){	 
		
		List<Fornecedor> obj = repo.buscaFornecedorPorCodigo(idfil,codigo); 
		return  obj;							 
	}	
	
    
	
}
