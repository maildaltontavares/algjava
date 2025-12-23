package com.santanatextiles.alg.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.FardoDocumentoItem;
import com.santanatextiles.alg.dto.FardoDocumentoDTO;
import com.santanatextiles.alg.dto.FardoDocumentoItemDTO;
import com.santanatextiles.alg.repositories.FardoDocumentoItemRepository;
import com.santanatextiles.alg.resources.exception.ObjectNotFoundException;

@Service
public class FardoDocumentoItemService {
	
	@Autowired
	private FardoDocumentoItemRepository repo;	
	
	private ArrayList<String> msg = new ArrayList<>();  
	
	
	
	public  Double gravaItem(FardoDocumentoItemDTO  obj, Double idPai) throws ParseException {
		
		
		   String mensagem ="";
		   try {

				   verificaEntidades(obj); 
					
					if (!this.msg.isEmpty()) {
						throw new ObjectNotFoundException(String.join(",", this.msg)); 
					}	 
				
				    Double novoCodigoItem = null; 
			    
				    FardoDocumentoItem fardoDocumentoItem = fromDTO(obj, idPai);  
				    if(!obj.getStatusItem().equals("Exclusão") ) {
				    	
				    	if(!obj.getStatusItem().equals("Alteração") ) { 
 
					    		// Inclusao
						    	novoCodigoItem = repo.codigoNovoId();	
						    	fardoDocumentoItem.setId(novoCodigoItem);
						    	fardoDocumentoItem.setIdFardo(novoCodigoItem);
						    	fardoDocumentoItem.setDataAlteracao(null);
								fardoDocumentoItem.setUsuarioAlteracao(null);
							 
							
						}else {
							
							 // Alteracao
							
							 LocalDate dataAtual = LocalDate.now();
							 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
							 String dataFormatada = dataAtual.format(formatter); 
							 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
							 fardoDocumentoItem.setDataAlteracao(dateFormat.parse(dataFormatada)); 		
							 
							 fardoDocumentoItem.setUsuarioAlteracao(fardoDocumentoItem.getUsuarioInclusao());
						 
							 
						}
						
						repo.save(fardoDocumentoItem);   
				    }else{
				    	FardoDocumentoItem frd = repo.findByIdFardo(obj.getIdFardo());
				    	
				    	if(frd.getMistura()== null || frd.getMistura().equals("") ) {
				    		  repo.deleteByIdFardo(obj.getIdFardo());	
				    	}else {
				    		
				    		mensagem = " Fardo " + obj.getNumeroFardo().toString() + " ja pertence a mistura " + obj.getMistura();
				    		throw new ObjectNotFoundException(" Fardo " + obj.getNumeroFardo().toString() + " ja pertence a mistura " + obj.getMistura()); 
				    	}
				    	
				    	
				    	
				    }
		   }
		   catch (Exception e) {
			   if(mensagem.equals("")) {
				   throw new ObjectNotFoundException("Registro nao gravado. Fale com analista responsável.");   
			   }else {
				   throw new ObjectNotFoundException(mensagem);
			   }
			    
		}
		
		
		
		
		
		
		return 0.0;
		
	}; 
	
	
	 private void verificaEntidades(FardoDocumentoItemDTO obj) {			  
		 
		    this.msg.clear();		    
		    if(obj.getIdMov()==null  ) {
			 
			   this.msg.add("Id do movimento invalido");	
			 
		    }
	 }	
	 
	 
	 
	 private FardoDocumentoItem fromDTO(FardoDocumentoItemDTO obj,Double idPai) {			 
		    
			
		    FardoDocumentoItem oFardoDocumentoItem = new FardoDocumentoItem(); 
			
		    oFardoDocumentoItem.setId(obj.getId());
		    oFardoDocumentoItem.setIdfil(obj.getIdfil());
		    oFardoDocumentoItem.setObs(obj.getObs());  
		    oFardoDocumentoItem.setDataInclusao(obj.getDataInclusao()); 
		    oFardoDocumentoItem.setUsuarioInclusao(obj.getUsuarioInclusao());  
		    oFardoDocumentoItem.setDataAlteracao(obj.getDataAlteracao()); 
		    oFardoDocumentoItem.setUsuarioAlteracao(obj.getUsuarioAlteracao());
		    oFardoDocumentoItem.setIdMov(obj.getIdMov());
		    oFardoDocumentoItem.setProdutor(obj.getProdutor());
		    oFardoDocumentoItem.setLote(obj.getLote());		   
		    
		    
		    oFardoDocumentoItem.setIdFardo(obj.getIdFardo());	 
		    oFardoDocumentoItem.setIdPai( idPai);	 		
		    oFardoDocumentoItem.setNumeroFardo(obj.getNumeroFardo());	  
		    oFardoDocumentoItem.setQualidade(obj.getQualidade());	 
		    oFardoDocumentoItem.setTamanho(obj.getTamanho());	 
		    oFardoDocumentoItem.setPeso(obj.getPeso());	 
		    oFardoDocumentoItem.setDataMovimentacao(obj.getDataMovimentacao());	 
		    oFardoDocumentoItem.setSac(obj.getSac());	 
		    oFardoDocumentoItem.setTrid(obj.getTrid());	 
		    oFardoDocumentoItem.setPim(obj.getPim());	 	 
		    oFardoDocumentoItem.setSc(obj.getSc());	 	 
		    oFardoDocumentoItem.setMst(obj.getMst());	    
		    oFardoDocumentoItem.setMic(obj.getMic());	 
		    oFardoDocumentoItem.setMat(obj.getMat());	 
		    oFardoDocumentoItem.setUi(obj.getUi());	 	   
		    oFardoDocumentoItem.setSf(obj.getSf());	 	  	
		    oFardoDocumentoItem.setStr(obj.getStr());	 
		    oFardoDocumentoItem.setElg(obj.getElg());	 
		    oFardoDocumentoItem.setTipo(obj.getTipo());	 
		    oFardoDocumentoItem.setSic(obj.getSic());	 
		    oFardoDocumentoItem.setUhml(obj.getUhml());	 
		    oFardoDocumentoItem.setRs(obj.getRs());	 	
		    oFardoDocumentoItem.setB(obj.getB());	 
		    oFardoDocumentoItem.setTrcnt(obj.getTrcnt());	 
		    oFardoDocumentoItem.setTrar(obj.getTrar());	 
		    oFardoDocumentoItem.setTipoQualidade(obj.getTipoQualidade());	 
		    oFardoDocumentoItem.setClassifQualidade(obj.getClassifQualidade());	 
		    oFardoDocumentoItem.setColoracao(obj.getColoracao());	 
		    oFardoDocumentoItem.setLoteAdicional(obj.getLoteAdicional());	 
		    oFardoDocumentoItem.setTipoMic(obj.getTipoMic());	 
		    oFardoDocumentoItem.setDestino(obj.getDestino());	 
		    oFardoDocumentoItem.setCorteza(obj.getCorteza());	 
		    oFardoDocumentoItem.setHvi(obj.getHvi());	 
		    oFardoDocumentoItem.setBenef(obj.getBenef());	 
		    oFardoDocumentoItem.setObs(obj.getObs());	 
		    oFardoDocumentoItem.setMistura(obj.getMistura());	 
		    oFardoDocumentoItem.setSequencia(obj.getSequencia());	 
		    oFardoDocumentoItem.setPossuiSelo(obj.getPossuiSelo());	 
		    oFardoDocumentoItem.setTipoSelo(obj.getTipoSelo());	 
		    oFardoDocumentoItem.setNumeroSelo(obj.getNumeroSelo());	  
			
					 
			return oFardoDocumentoItem;
			
		   
	 }	 
	 
	 
		public Double contarMovimentoFardo(String idfil,Double idMovto ){	 
			 Double obj = repo.contarMovimentoFardo(idfil,idMovto)	 ; 
			 return obj;
		}
	
	

}
