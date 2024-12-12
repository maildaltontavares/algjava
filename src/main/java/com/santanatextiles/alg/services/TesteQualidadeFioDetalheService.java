package com.santanatextiles.alg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.MisturaPadrao;
import com.santanatextiles.alg.domain.TesteQualidadeFio;
import com.santanatextiles.alg.domain.TesteQualidadeFioDetalhe;
import com.santanatextiles.alg.dto.TesteQualidadeFioDTO;
import com.santanatextiles.alg.dto.TesteQualidadeFioDetalheDTO;
import com.santanatextiles.alg.repositories.TesteQualidadeFioDetalheRepository;

@Service
public class TesteQualidadeFioDetalheService { 
	
		@Autowired
		private TesteQualidadeFioDetalheRepository repo;	  
		 
		public List<TesteQualidadeFioDetalhe> buscaTesteQualidadeFioDetalhePorParametros(String filial ){ 
			 List<TesteQualidadeFioDetalhe> obj = repo.buscaTesteQualidadeFioDetalhePorParametros(filial ) ;	  
			 return obj;
		}	
	 
		
		public Double codigoNovoTesteDetalhe(){	 
		  	 Double obj = repo.codigoNovoTesteDetalhe() ;	  
			 return obj;
		}	
		
		public TesteQualidadeFioDetalhe insereResultado(TesteQualidadeFioDetalheDTO objResultado, Double pIdPai) {
			
			Double novoCodigoAutomaticoCab = null; 
			
			objResultado.setIdPai(pIdPai);
			TesteQualidadeFioDetalhe result =  fromDTODetalhe(objResultado);
			
			
			novoCodigoAutomaticoCab = repo.codigoNovoTesteDetalhe();	 
			result.setId(novoCodigoAutomaticoCab);	
			
			repo.save(result);
			
			return result;
			
			
		}
	
		
		public TesteQualidadeFioDetalhe fromDTODetalhe(TesteQualidadeFioDetalheDTO obj ) {  
			
			TesteQualidadeFioDetalhe oResult = new TesteQualidadeFioDetalhe(); 
						 
			oResult.setIdfil(obj.getIdfil()); 
			oResult.setIdPai(obj.getIdPai());
			oResult.setSeqProva(obj.getSeqProva());
			oResult.setNumeroFusos(obj.getNumeroFusos());
			oResult.setPeso(obj.getPeso());
			oResult.setTitulo(obj.getTitulo());
	   	  
			return oResult; 
			
		}		
		
		@Transactional	
		 public void deletaResultado(String idfil,Double pId){	  
		 	    repo.deletaResultado(idfil,pId)   ;  
		}				
		
		  
	

} 