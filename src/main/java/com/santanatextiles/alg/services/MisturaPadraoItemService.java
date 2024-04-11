package com.santanatextiles.alg.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.MisturaPadrao;
import com.santanatextiles.alg.domain.MisturaPadraoItem;
import com.santanatextiles.alg.domain.MovimentoItem;
import com.santanatextiles.alg.dto.MisturaPadraoDTO;
import com.santanatextiles.alg.dto.MisturaPadraoItemDTO;
import com.santanatextiles.alg.repositories.MisturaPadraoItemRepository;

 
	
@Service
public class MisturaPadraoItemService {
			
		@Autowired
		private MisturaPadraoItemRepository repo;		
		
		@Value("${spring.datasource.url}")
		private String JDBC_URL;
		
		@Value("${spring.datasource.username}")
		private String JDBC_USER;

		@Value("${spring.datasource.password}") 
		private String JDBC_PASSWORD;			
		
		public List<MisturaPadraoItem> buscaMisturaPadraoItemPorParametros(String filial ){	 
			 List<MisturaPadraoItem> obj = repo.buscaMisturaPadraoItemPorParametros(filial ) ;	  
			 return obj;
		}		 
	

		public List<MisturaPadraoItem> buscaMisturaPorId(Double id ){	 
			 List<MisturaPadraoItem> obj = repo.buscaMisturaPorId( id ) ;	  
			 return obj;
		}	
		
		 public MisturaPadraoItem gravaItem(MisturaPadraoItemDTO misturaItemDTO, String operac, String dtDia, MisturaPadrao mistura) throws ParseException {
			 
			      MisturaPadraoItem mistIt=   fromDTO(
			        		 misturaItemDTO ,
			        		 operac,
			        		 dtDia,
			        		 mistura
						) ; 
			      
			      repo.save(mistIt);
			      
			      return mistIt;
			      
		 }
		 
		@Transactional	
		 public void deletaMisturaItem(MisturaPadrao  mistura){	  
		 	    repo.deleteByIdfilAndMistura(mistura.getIdfil(),mistura.getMistura())   ;  
		}			 
		
		
		 public MisturaPadraoItem fromDTO(MisturaPadraoItemDTO misturaItemDTO, String operac, String dtDia, MisturaPadrao mistura) throws ParseException {   
				
	        	MisturaPadraoItem misturaItem = new MisturaPadraoItem();
	        	
	        	misturaItem.setIdfil(misturaItemDTO.getIdfil()); 
	        	
				if(operac.equals("I")) {
					misturaItem.setDataInclusao(mistura.getDataInclusao());
					misturaItem.setDataAlteracao(mistura.getDataAlteracao());
				}else {
					misturaItem.setDataAlteracao(mistura.getDataAlteracao());
				}	 
	        	
	        	misturaItem.setMistura(mistura.getMistura());
	        	misturaItem.setQuantidade(misturaItemDTO.getQuantidade());  
	        	misturaItem.setIdItem(misturaItemDTO.getIdItem());  
	        	
	        	misturaItem.setUsuarioInclusao(mistura.getUsuarioInclusao());  
	        	misturaItem.setUsuarioAlteracao(mistura.getUsuarioAlteracao());   
	        	
				return misturaItem;
				 		
	        }		
		
		
}
