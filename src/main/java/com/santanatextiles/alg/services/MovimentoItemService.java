package com.santanatextiles.alg.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.EstoqueMP;
import com.santanatextiles.alg.domain.MovimentoItem;
import com.santanatextiles.alg.domain.TesteQualidade;
import com.santanatextiles.alg.dto.MovimentoItemDTO;
import com.santanatextiles.alg.dto.SaldoIdMovtoDTO;
import com.santanatextiles.alg.repositories.MovimentoItemRepository;
import com.santanatextiles.alg.resources.exception.ObjectNotFoundException; 
	
@Service
public class MovimentoItemService {
			
		@Autowired
		private MovimentoItemRepository repo;		
		
		@Autowired
		private TesteQualidadeService serviceCQ;  
		
		@Autowired
		private EstoqueMPService serviceEstoqueMP;		
		
		
		@Value("${spring.datasource.url}")
		private String JDBC_URL;
		
		@Value("${spring.datasource.username}")
		private String JDBC_USER;

		@Value("${spring.datasource.password}") 
		private String JDBC_PASSWORD;			
		
		public List<MovimentoItem> buscaMovimentoItemPorParametros(String filial ){	 
			 List<MovimentoItem> obj = repo.buscaMovimentoItemPorParametros(filial ) ;	  
			 return obj;
		}	
		
		public List<MovimentoItem> buscaMovimentoItemByFilial(String filial ){	 
			 List<MovimentoItem> obj = repo.findByIdfil(filial ) ;	  
			 return obj;
		}	   
		
		public MovimentoItem update(MovimentoItem obj,String atualizaEstoque,
				   String atualizaItem,String pesoCalculadoInformado ) throws ParseException{  
			
		    MovimentoItem movItem = repo.save(configuraMovimentoItemAlteracao(obj)); 
		    
		    /// Atualiza o saldo de estoque
		    if(atualizaEstoque.equals("S")) { 
		    	 
		           
		           if(atualizaItem.equals("S")) { 
		        	   atualizaPesoMedMovtos(obj.getIdfil(),obj.getIdMovimento(),obj.getPesoMedio());
		           }
		           
		           atlzEstok(movItem,atualizaItem );
		    	 
		    }
		    
		    return movItem;
		    
		}	
		
		private Integer atualizaPesoMedMovtos(String idfil,Double IdMovtoIt,Double pesoMedio) {
			
			return repo.atualizaPesoMedMovtos( idfil,IdMovtoIt,pesoMedio);
			
		}
		
		private MovimentoItem configuraMovimentoItemAlteracao(MovimentoItem obj) throws ParseException { 
			
			MovimentoItem movItem = obj;
			
			LocalDate dataAtual = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
			String dataFormatada = dataAtual.format(formatter); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		    		    
		    movItem.setDataAlteracao(dateFormat.parse(dataFormatada));
		    
			
		    return movItem;
		     
		}		
		
		
		public MovimentoItem insert(MovimentoItem obj,String atualizaEstoque,
				   String atualizaItem,String pesoCalculadoInformado ) throws ParseException{  
			
		    MovimentoItem movItem = repo.save(configuraMovimentoItem(obj));
		    
		    /// Permite inserir novos itens de estoque (IDs)
		    if(atualizaItem.equals("S")) {        // NFE e EST+
			    serviceEstoqueMP.insert(movItem);	 
		    }
		    
		    /// Atualiza o saldo de estoque
		    if(atualizaEstoque.equals("S")) {  
		    	// Na insercao nao precisa atualizar o peso medio pois ja inseriu tudo certinho 
		    	   atlzEstok(movItem,"N" );
		     
		    }
		    
		    return movItem;
		    
		}	 
		
/*		
		// Chamado pelo Update
		public void atlzEstok(MovimentoItem pMovItem, String atualizaItem) {
			
			SaldoIdMovtoDTO sldIdMovto =  serviceEstoqueMP.buscaSaldoIdMovto(pMovItem.getIdfil(), pMovItem.getIdMovimento());
			
			if(sldIdMovto.getQtde() >= -0.90 && sldIdMovto.getPeso() >= -1) {
				
				if(atualizaItem.equals("N")){
				    serviceEstoqueMP.atualizaEstoque(pMovItem.getIdfil(),pMovItem.getIdMovimento(),sldIdMovto.getQtde(),sldIdMovto.getPeso(),sldIdMovto.getVlEst());				    
				}else{
					serviceEstoqueMP.atualizaEstoqueEPesoMedio(pMovItem.getIdfil(),pMovItem.getIdMovimento(),sldIdMovto.getQtde(),sldIdMovto.getPeso(),sldIdMovto.getVlEst());					
				}
				
			}else {
				throw new ObjectNotFoundException("Lote: " + pMovItem.getLote() + " apresentou saldo negativo.");
			} 
		    
		}		
*/		
		public void atlzEstok(MovimentoItem pMovItem, String atualzMovto) {
			
			SaldoIdMovtoDTO sldIdMovto =  serviceEstoqueMP.buscaSaldoIdMovto(pMovItem.getIdfil(), pMovItem.getIdMovimento());
			
			if(sldIdMovto.getQtde() >= -0.90 && sldIdMovto.getPeso() >= -1) {
				/*
		        BigDecimal bd = BigDecimal.valueOf(sldIdMovto.getPeso()/sldIdMovto.getQtde());
		        bd = bd.setScale(4, RoundingMode.HALF_UP); // Arredonda para 2 casas decimais
		        double pesMed = bd.doubleValue();				
				*/
				serviceEstoqueMP.atualizaEstoque(pMovItem.getIdfil(),pMovItem.getIdMovimento(),sldIdMovto.getQtde(),sldIdMovto.getPeso(),sldIdMovto.getVlEst(),pMovItem.getPesoMedio(),atualzMovto);				
			}else {
				throw new ObjectNotFoundException("Lote: " + pMovItem.getLote() + " apresentou saldo negativo.");
			} 
		    
		}
		
		
		private MovimentoItem configuraMovimentoItem(MovimentoItem obj) throws ParseException { 
			
			MovimentoItem movItem = obj;
			
			LocalDate dataAtual = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
			String dataFormatada = dataAtual.format(formatter); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");	 
			
			
		    String nf = String.format("%-10s", obj.getNotaFiscal());  
		    movItem.setNotaFiscal(nf);  		    
		    movItem.setDataInclusao(dateFormat.parse(dataFormatada));
		    
			
		     return movItem;
		     
		}
		
		
	 
		
		
		@Transactional	
		 public void deletaMovimentoItem(MovimentoItem pMovItemEst,String atualizaEstoque ){	 
			
		 	    repo.deleteByIdItem(pMovItemEst.getIdItem())  ;   
		 	    
			    if(atualizaEstoque.equals("S")) {
			    	
			    	// Nao atualiza estoque quando o item for ser totalmente excluido
			    	if(!(pMovItemEst.getIdMovimento().equals(pMovItemEst.getIdItem()))   ) { 
			    		atlzEstok(pMovItemEst,"N" );
			    	}    
			    }		 	  
		 	  
		 	  
		}	
		
		public List<MovimentoItem> findByIdCab(Double idCab ){	 
			 List<MovimentoItem> obj = repo.findByIdCab(idCab ) ;	  
			 return obj;
		}	 
		
		public Double contarMovimentoItem(String idfil,Double idMovto ){	 
			 Double obj = repo.contarMovimentoItem(idfil,idMovto)	 ; 
			 return obj;
		}	 		
		
		
		
		
		public MovimentoItem fromDTO(MovimentoItemDTO objDTO,Double idCab,String atualizaItem, Double idAutomatico, String movimentoAutomatico,String movimentoPilha  ) {
			
			MovimentoItem movimentoItem = new MovimentoItem();  
			Double novoMovimentoItem;
			
			if(atualizaItem.equals("N")) {   // Nao gera novo item na CPFM4 
			  if(objDTO.getIdMovimento().equals(0) || objDTO.getIdMovimento() == null) {
					throw new ObjectNotFoundException("Id do Lote: " + objDTO.getLote() + " inválido.");
			  }				
			
			}
			
			
			if(objDTO.getIdItem() == null) {
				novoMovimentoItem = repo.codigoNovoMovimentoItem();
			}else {
				novoMovimentoItem = objDTO.getIdItem();
			}
				
			movimentoItem.setIdItem(novoMovimentoItem) ;	
			
			if(atualizaItem.equals("S")) { 
				movimentoItem.setIdMovimento(novoMovimentoItem); 
			}else {
				movimentoItem.setIdMovimento(objDTO.getIdMovimento()); 
			} 			
			
			if(atualizaItem.equals("S")) {
				
				
		     		movimentoItem.setNotaFiscal(objDTO.getNotaFiscal());	 
					movimentoItem.setFornecedor(objDTO.getFornecedor()); 
					movimentoItem.setItem(objDTO.getItem());
					movimentoItem.setProdutor(objDTO.getProdutor());
					movimentoItem.setProcedencia(objDTO.getProcedencia());	 
					movimentoItem.setLote(objDTO.getLote());
					movimentoItem.setQualidade(objDTO.getQualidade());
					movimentoItem.setTamanho(objDTO.getTamanho());
					movimentoItem.setDescFio(objDTO.getDescFio());			
					movimentoItem.setUnidadeMedida(objDTO.getUnidadeMedida()); 
					movimentoItem.setPilha(objDTO.getPilha());	 
					movimentoItem.setPesoMedio(objDTO.getPesoMedio()); 	
					

				
			///// Testa se já foi feito teste no lote deste produtor
					
					if(objDTO.getMat().equals(0.0) ||
					   objDTO.getSic().equals(0.0) ||
					   objDTO.getMic().equals(0.0)  ||
					   objDTO.getUhml().equals(0.0))  {
						
					   TesteQualidade testeCq = serviceCQ.buscaTesteQualidadeByLote(objDTO.getIdfil(),objDTO.getProdutor(),objDTO.getLote());	
					   
					   if( testeCq != null ) {
						   
							movimentoItem.setSac(testeCq.getSac());
							movimentoItem.setTrid(testeCq.getTrid());			
							movimentoItem.setPim(testeCq.getPim());
							movimentoItem.setSc(testeCq.getSc());	 
							movimentoItem.setMst(testeCq.getMst()); 
							movimentoItem.setMic(testeCq.getMic());	   
							movimentoItem.setMat(testeCq.getMat());
							movimentoItem.setUi(testeCq.getUi());
							movimentoItem.setSf(testeCq.getSf());	 
							movimentoItem.setStr(testeCq.getStr());	 
							movimentoItem.setElg(testeCq.getElg());	 
							movimentoItem.setTipo(testeCq.getTipo());	 
							movimentoItem.setSic(testeCq.getSic());	  
							movimentoItem.setUhml(testeCq.getUhml());
							movimentoItem.setRs(testeCq.getRs());	 
							movimentoItem.setB(testeCq.getB());	 
							movimentoItem.setTrcnt(testeCq.getTrcnt());	 
							movimentoItem.setTrar(testeCq.getTrar());	 
						    
					   }else {
						   
							movimentoItem.setSac(objDTO.getSac());
							movimentoItem.setTrid(objDTO.getTrid());			
							movimentoItem.setPim(objDTO.getPim());
							movimentoItem.setSc(objDTO.getSc());	 
							movimentoItem.setMst(objDTO.getMst()); 
							movimentoItem.setMic(objDTO.getMic());	   
							movimentoItem.setMat(objDTO.getMat());
							movimentoItem.setUi(objDTO.getUi());
							movimentoItem.setSf(objDTO.getSf());	 
							movimentoItem.setStr(objDTO.getStr());	 
							movimentoItem.setElg(objDTO.getElg());	 
							movimentoItem.setTipo(objDTO.getTipo());	 
							movimentoItem.setSic(objDTO.getSic());	  
							movimentoItem.setUhml(objDTO.getUhml());
							movimentoItem.setRs(objDTO.getRs());	 
							movimentoItem.setB(objDTO.getB());	 
							movimentoItem.setTrcnt(objDTO.getTrcnt());	 
							movimentoItem.setTrar(objDTO.getTrar());		 
						   
					   } 
						
						
					} else {
						   
							movimentoItem.setSac(objDTO.getSac());
							movimentoItem.setTrid(objDTO.getTrid());			
							movimentoItem.setPim(objDTO.getPim());
							movimentoItem.setSc(objDTO.getSc());	 
							movimentoItem.setMst(objDTO.getMst()); 
							movimentoItem.setMic(objDTO.getMic());	   
							movimentoItem.setMat(objDTO.getMat());
							movimentoItem.setUi(objDTO.getUi());
							movimentoItem.setSf(objDTO.getSf());	 
							movimentoItem.setStr(objDTO.getStr());	 
							movimentoItem.setElg(objDTO.getElg());	 
							movimentoItem.setTipo(objDTO.getTipo());	 
							movimentoItem.setSic(objDTO.getSic());	  
							movimentoItem.setUhml(objDTO.getUhml());
							movimentoItem.setRs(objDTO.getRs());	 
							movimentoItem.setB(objDTO.getB());	 
							movimentoItem.setTrcnt(objDTO.getTrcnt());	 
							movimentoItem.setTrar(objDTO.getTrar());  
						   
					   } 
			}else {
				
				//// Não atualiza o item
				
				 EstoqueMP e = serviceEstoqueMP.findById(objDTO.getIdMovimento());
				 
				 if(e != null) {
					 
			     		movimentoItem.setNotaFiscal(e.getNotaFiscal());	 
						movimentoItem.setFornecedor(e.getFornecedor()); 
						movimentoItem.setItem(e.getItem());
						movimentoItem.setProdutor(e.getProdutor());
						movimentoItem.setProcedencia(e.getProcedencia());	 
						movimentoItem.setLote(e.getLote());
						movimentoItem.setQualidade(e.getQualidade());
						movimentoItem.setTamanho(e.getTamanho());
						movimentoItem.setDescFio(e.getDescFio());			
						movimentoItem.setUnidadeMedida(e.getUnidadeMedida()); 
						movimentoItem.setPilha(e.getPilha());	 
						movimentoItem.setPesoMedio(e.getPesoMedio());   
					 
						movimentoItem.setSac(e.getSac());
						movimentoItem.setTrid(e.getTrid());			
						movimentoItem.setPim(e.getPim());
						movimentoItem.setSc(e.getSc());	 
						movimentoItem.setMst(e.getMst()); 
						movimentoItem.setMic(e.getMic());	   
						movimentoItem.setMat(e.getMat());
						movimentoItem.setUi(e.getUi());
						movimentoItem.setSf(e.getSf());	 
						movimentoItem.setStr(e.getStr());	 
						movimentoItem.setElg(e.getElg());	 
						movimentoItem.setTipo(e.getTipo());	 
						movimentoItem.setSic(e.getSic());	  
						movimentoItem.setUhml(e.getUhml());
						movimentoItem.setRs(e.getRs());	 
						movimentoItem.setB(e.getB());	 
						movimentoItem.setTrcnt(e.getTrcnt());	 
						movimentoItem.setTrar(e.getTrar());					 
					 
					 
				 }else {
					 
						throw new ObjectNotFoundException("Id do lote: " + objDTO.getLote() + " não encontrado.");
				 }  
				 
				
			}  
					
			movimentoItem.setIdfil(objDTO.getIdfil());   
			movimentoItem.setPesoCalculadoInformado(objDTO.getPesoCalculadoInformado()); 
			movimentoItem.setDataInclusao(objDTO.getDataInclusao());
			movimentoItem.setDataAlteracao(objDTO.getDataAlteracao());	 
			movimentoItem.setUsuarioInclusao(objDTO.getUsuarioInclusao());	 
			movimentoItem.setUsuarioAlteracao(objDTO.getUsuarioAlteracao()); 
			
			if(idAutomatico!=null && idAutomatico >0) {
				movimentoItem.setIdAutomatico(idAutomatico); 
			}
			 
			if(movimentoAutomatico!=null && movimentoAutomatico.equals("A")) {
				movimentoItem.setMovimentoAutomatico(movimentoAutomatico); 
				movimentoItem.setObservacao("MOVIMENTO AUTOMATICO");	 
			}else {				
				movimentoItem.setObservacao(objDTO.getObservacao() );
			}
			 
			if(movimentoPilha!=null ) {
				movimentoItem.setMovimentoDePilha(movimentoPilha);
			}	 
			
			
			if(objDTO.getVlUnitario() != null) {
				movimentoItem.setVlUnitario(objDTO.getVlUnitario());  
			}else {
				movimentoItem.setVlUnitario(0.0);
				
			} 			
			
			movimentoItem.setQuantidade(objDTO.getQuantidade());	 
			movimentoItem.setPeso(objDTO.getPeso()); 
			movimentoItem.setIdCab(idCab); 
			movimentoItem.setStatusItem(objDTO.getStatusItem());
			movimentoItem.setStatusItemOriginal(objDTO.getStatusItemOriginal());
					
			return movimentoItem;  
				
		}			
	

}
