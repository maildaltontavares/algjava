package com.santanatextiles.alg.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.MisturaPadrao;
import com.santanatextiles.alg.domain.MisturaPadraoItem;
import com.santanatextiles.alg.dto.MisturaPadraoCabecDTO;
import com.santanatextiles.alg.dto.MisturaPadraoDTO;
import com.santanatextiles.alg.dto.MisturaPadraoItemDTO;
import com.santanatextiles.alg.projections.MisturaPadraoCabecProjection;
import com.santanatextiles.alg.repositories.MisturaPadraoRepository; 
	
@Service
public class MisturaPadraoService {
		
		@Autowired
		private MisturaPadraoRepository repo;		
		
		@Autowired
		private MisturaPadraoItemService misturaItemservice;  		
		
		@Value("${spring.datasource.url}")
		private String JDBC_URL;
		
		@Value("${spring.datasource.username}")
		private String JDBC_USER;

		@Value("${spring.datasource.password}") 
		private String JDBC_PASSWORD;			
		
		public List<MisturaPadrao> buscaMisturaPadraoPorParametros(String filial ){	   
			 List<MisturaPadrao> obj = repo.buscaMisturaPadraoPorParametros(filial)  ;	  
			 return obj;
		}	
		
		public List<MisturaPadrao> buscaMisturasAbertas(String filial ){	   
			 List<MisturaPadrao> obj = repo.buscaMisturasAbertas(filial)  ;	  
			 return obj;
		}		
		
		public List<MisturaPadrao> buscaMisturaPadraoByFilial(String filial) {  
			 List<MisturaPadrao> obj = repo.findByIdfil(filial);
			return obj ;
		}	
		
		
		public String buscaNovoIdMistura(String idfil ){ 	 
			String numNovaMistura =   repo.buscaNovoIdMistura(idfil);
			String obj = String.format("%010d", Integer.parseInt(numNovaMistura)); 
			return  obj;	
			
			
			
		}  	
		
		public String incluirMistura( MisturaPadraoDTO misturaDTO,String oper ) throws ParseException { 
			String obj = gravarMistura(misturaDTO,"I"); 
			return obj; 
		}
		
		public String alterarMistura( MisturaPadraoDTO misturaDTO,String oper ) throws ParseException { 
			String obj = gravarMistura(misturaDTO,"A"); 
			return obj; 
		}		
		
		@Transactional
		public String gravarMistura( MisturaPadraoDTO misturaDTO, String oper) throws ParseException { 
			
			LocalDate dataAtual = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
			String dataFormatada = dataAtual.format(formatter); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		    
			if(oper.equals("I")) {
				misturaDTO.setDataInclusao(dateFormat.parse(dataFormatada));
				misturaDTO.setDataAlteracao(dateFormat.parse(dataFormatada));
			}else {
				misturaDTO.setDataAlteracao(dateFormat.parse(dataFormatada));
			}
			 
			MisturaPadrao mistPadrao = fromDTO(misturaDTO,  oper, dataFormatada);
			
			repo.save(mistPadrao); 
			misturaItemservice.deletaMisturaItem(mistPadrao);
			
			Iterator<MisturaPadraoItemDTO> it = misturaDTO.getMisturaPadraoItemDTO().iterator();
	 		 
			while (it.hasNext()) {
				
				  MisturaPadraoItem movimentoItem = misturaItemservice.gravaItem(
						it.next() ,
						oper,
						dataFormatada,
						mistPadrao
						) ; 
				 
			}  
			
			return mistPadrao.getMistura();
			
		} 
		
        public MisturaPadrao fromDTO(MisturaPadraoDTO misturaDTO, String operac, String dtDia) throws ParseException {   
			
        	MisturaPadrao mistura = new MisturaPadrao();   
        	
        	String codMistura;
        	
        	if(misturaDTO.getMistura().equals("")) { 
        	    codMistura = buscaNovoIdMistura(misturaDTO.getIdfil());  
        	}else { 
        		codMistura = misturaDTO.getMistura();
        	}
		 	 
			mistura.setIdfil(misturaDTO.getIdfil());
			mistura.setMistura(codMistura);  
			mistura.setLote(misturaDTO.getLote());
			mistura.setStatus(misturaDTO.getStatus());
			mistura.setDataInicial(misturaDTO.getDataInicial());
			mistura.setDataFinal(misturaDTO.getDataFinal());
			mistura.setTotalMisturas(misturaDTO.getTotalMisturas()); 			
			mistura.setDataInclusao(misturaDTO.getDataInclusao());
			mistura.setUsuarioInclusao(misturaDTO.getUsuarioInclusao()); 	 
			mistura.setDataAlteracao(misturaDTO.getDataAlteracao());
			mistura.setUsuarioAlteracao(misturaDTO.getUsuarioAlteracao()); 		 
			mistura.setNumMisturasLiberadas(misturaDTO.getNumMisturasLiberadas()); 	 
			mistura.setObservacao(misturaDTO.getObservacao());
			mistura.setNumFardos(misturaDTO.getNumFardos());   
			
			return mistura;
			 		
        }
        
		@Transactional	
		 public void deletaMistura(String idfil,String mistura){	 
			
		    	MisturaPadrao mistPadrao = new MisturaPadrao();  
		    	mistPadrao.setIdfil(idfil);
		    	mistPadrao.setMistura(mistura); 
		    	
		 	    repo.deleteByIdfilAndMistura(idfil,mistura )   ; 
		 	    
				misturaItemservice.deletaMisturaItem(mistPadrao);
		 	  
		}	        
		
				
		
		public MisturaPadraoCabecDTO buscaMisturaCalculada(String filial,String mistura ){ 
		
		List<MisturaPadraoCabecProjection> misturaPesquisaCabecP = repo.buscaMisturaCalculada(filial, mistura);
		
		List<MisturaPadraoCabecDTO> listaMisturaPesquisaCabec = misturaPesquisaCabecP.stream().map(x-> new MisturaPadraoCabecDTO(x)).toList();  		
		
		MisturaPadraoCabecDTO misturaPesquisaCabec = new MisturaPadraoCabecDTO(); 
		
		for (MisturaPadraoCabecDTO misturaPesquisaIdDTO : listaMisturaPesquisaCabec) { 
			 
			
			misturaPesquisaCabec.setIdfil(misturaPesquisaIdDTO.getIdfil());
			misturaPesquisaCabec.setMistura(misturaPesquisaIdDTO.getMistura());
			misturaPesquisaCabec.setLoteFiacao(misturaPesquisaIdDTO.getLoteFiacao());
			misturaPesquisaCabec.setStatus(misturaPesquisaIdDTO.getStatus());
  
			misturaPesquisaCabec.setDataInicial(misturaPesquisaIdDTO.getDataInicial());
			misturaPesquisaCabec.setDataFinal(misturaPesquisaIdDTO.getDataFinal());
			misturaPesquisaCabec.setQuantidade(misturaPesquisaIdDTO.getQuantidade());
			
			misturaPesquisaCabec.setDataInclusao(misturaPesquisaIdDTO.getDataInclusao());
			misturaPesquisaCabec.setUsuarioInclusao(misturaPesquisaIdDTO.getUsuarioInclusao());
			
			misturaPesquisaCabec.setDataAlteracao(misturaPesquisaIdDTO.getDataAlteracao());
			misturaPesquisaCabec.setUsuarioAlteracao(misturaPesquisaIdDTO.getUsuarioAlteracao());	

			misturaPesquisaCabec.setNumMisturasLiberadas(misturaPesquisaIdDTO.getNumMisturasLiberadas());
			misturaPesquisaCabec.setNumFardos(misturaPesquisaIdDTO.getNumFardos());	
			misturaPesquisaCabec.setTotalUtilizadas(misturaPesquisaIdDTO.getTotalUtilizadas());
			misturaPesquisaCabec.setObservacao(misturaPesquisaIdDTO.getObservacao());		 
 		 		
          }	 
 	   
 		  return misturaPesquisaCabec;
 	}			
		
		
		
				

}
