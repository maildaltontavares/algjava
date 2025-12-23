package com.santanatextiles.alg.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.FardoDocumento;
import com.santanatextiles.alg.dto.FardoDocumentoDTO;
import com.santanatextiles.alg.dto.FardoDocumentoItemDTO;
import com.santanatextiles.alg.repositories.FardoDocumentoRepository;
import com.santanatextiles.alg.resources.exception.ObjectNotFoundException;

@Service
public class FardoDocumentoService {
	
	@Autowired
	private FardoDocumentoRepository repo;	
	
	@Autowired
	private FardoDocumentoItemService fardoDocumentoItemService;	
	

	
	private ArrayList<String> msg = new ArrayList<>();  
	
	
	
	public  FardoDocumento  buscaFardos(Double idMov )  {
		
		    return repo.findByIdMov(idMov);
		
	}
	
	
	@Transactional
	public  Double  gravaFardos(FardoDocumentoDTO obj ) throws ParseException{  
		
		
			try {
				    verificaEntidades(obj); 
					
					if (!this.msg.isEmpty()) {
						throw new ObjectNotFoundException(String.join(",", this.msg)); 
					}	 
				
				    Double novoCodigoAutomaticoCab = null; 
		 	    
				    FardoDocumento fardoDocumento = fromDTO(obj);  
					
				    //Inserção do Cabecalho
				    if(obj.getId()==null || obj.getId().equals(0.0)) {
						
						novoCodigoAutomaticoCab = repo.codigoNovoId();	
						fardoDocumento.setId(novoCodigoAutomaticoCab);
						fardoDocumento.setDataAlteracao(null);
						fardoDocumento.setUsuarioAlteracao(null);
						
					}else {
						
						 LocalDate dataAtual = LocalDate.now();
						 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
						 String dataFormatada = dataAtual.format(formatter); 
						 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
						 fardoDocumento.setDataAlteracao(dateFormat.parse(dataFormatada)); 		
						 
						 fardoDocumento.setUsuarioAlteracao(fardoDocumento.getUsuarioAlteracao());
						 novoCodigoAutomaticoCab = obj.getId();	
						 
					}
					
					repo.save(fardoDocumento);   
		 			
				 	
					
					Iterator<FardoDocumentoItemDTO> it = obj.getFardoDocumentoItemDTO().iterator();
		
					while (it.hasNext()) {
						
						FardoDocumentoItemDTO itemFardo = it.next();
						
						fardoDocumentoItemService.gravaItem(itemFardo,novoCodigoAutomaticoCab) ;
						 
					}
					
					// Verifica se tem mais fardos com esse ID. Se sim não poderá ser excluido.
					Double totMovFardo =  fardoDocumentoItemService.contarMovimentoFardo(obj.getIdfil(),obj.getIdMov());
					
					if(totMovFardo != null ) {
						if(totMovFardo.equals(0.0)) {
							repo.deleteByIdMov(obj.getIdMov());
						}    
					}					
					
					 
					
					
					
				    return novoCodigoAutomaticoCab;
			}catch (Exception e) {
			    throw new ObjectNotFoundException("Registro nao gravado. Fale com analista responsável." + e.getMessage());
	        }
	}	

	
	 private FardoDocumento fromDTO(FardoDocumentoDTO obj) {			 
		    
			
		    FardoDocumento oFardoDocumento = new FardoDocumento(); 
			
			oFardoDocumento.setId(obj.getId()); 
			oFardoDocumento.setIdfil(obj.getIdfil()); 
			oFardoDocumento.setArquivoImportado(obj.getArquivoImportado()); 
			oFardoDocumento.setObs(obj.getObs());  
			oFardoDocumento.setDataInclusao(obj.getDataInclusao()); 
			oFardoDocumento.setUsuarioInclusao(obj.getUsuarioInclusao());  
			oFardoDocumento.setDataAlteracao(obj.getDataAlteracao()); 
			oFardoDocumento.setUsuarioAlteracao(obj.getUsuarioAlteracao());
			oFardoDocumento.setIdMov(obj.getIdMov());
			oFardoDocumento.setProdutor(obj.getProdutor());
			oFardoDocumento.setLote(obj.getLote());
			oFardoDocumento.setLote(obj.getLote());
			oFardoDocumento.setNf(obj.getNf());
			
					 
			return oFardoDocumento;
			
		   
	 }
		
	
	
	
	 private void verificaEntidades(FardoDocumentoDTO obj) {			  
		 
		    this.msg.clear();		    
		    if(obj.getIdMov()==null  ) {
			 
			   this.msg.add("Id do movimento invalido");	
			 
		    }
	 }
	
	
	
	
	

}
