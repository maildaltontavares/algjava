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
			    //SaldoIdMovtoDTO sldIdMovto =  serviceEstoqueMP.buscaSaldoIdMovto(movItem.getIdfil(), movItem.getIdMovimento());
			    //serviceEstoqueMP.atualizaEstoque(movItem.getIdfil(),movItem.getIdMovimento(),sldIdMovto.getQtde(),sldIdMovto.getPeso(),sldIdMovto.getVlEst());	
		    	atlzEstok(movItem);
		    }
		    
		    return movItem;
		    
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
		    if(atualizaItem.equals("S")) {    
			    serviceEstoqueMP.insert(movItem);	 
		    }
		    
		    /// Atualiza o saldo de estoque
		    if(atualizaEstoque.equals("S")) {    
		    	atlzEstok(movItem);
		    }
		    
		    return movItem;
		    
		}	 
		
		
		public void atlzEstok(MovimentoItem pMovItem) {
			
			SaldoIdMovtoDTO sldIdMovto =  serviceEstoqueMP.buscaSaldoIdMovto(pMovItem.getIdfil(), pMovItem.getIdMovimento());
			
			if(sldIdMovto.getQtde() >= -0.90 && sldIdMovto.getPeso() >= -1) {
				serviceEstoqueMP.atualizaEstoque(pMovItem.getIdfil(),pMovItem.getIdMovimento(),sldIdMovto.getQtde(),sldIdMovto.getPeso(),sldIdMovto.getVlEst());				
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
		 public void deletaMovimentoItem(MovimentoItem pMovItemEst,String atualizaEstoque){	 
			
		 	    repo.deleteByIdItem(pMovItemEst.getIdItem())  ;  
		 	  
			    if(atualizaEstoque.equals("S")) {    
			    	atlzEstok(pMovItemEst);
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
			
			
			///// Testa se já foi feito teste no lote deste produtor
			
			if(objDTO.getMat() ==null ||
			   objDTO.getSic() ==null ||
			   objDTO.getMic() ==null ||
			   objDTO.getUhml()==null   ) {
				
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
			
					
			movimentoItem.setIdfil(objDTO.getIdfil());  
			movimentoItem.setNotaFiscal(objDTO.getNotaFiscal());	 
			movimentoItem.setFornecedor(objDTO.getFornecedor());	  
			movimentoItem.setItem(objDTO.getItem());
			movimentoItem.setProdutor(objDTO.getProdutor());
			movimentoItem.setProcedencia(objDTO.getProcedencia());	 
			movimentoItem.setLote(objDTO.getLote());
			movimentoItem.setQualidade(objDTO.getQualidade());
			movimentoItem.setTamanho(objDTO.getTamanho());
			movimentoItem.setDescFio(objDTO.getDescFio());	 
			movimentoItem.setPesoCalculadoInformado(objDTO.getPesoCalculadoInformado());
			
			
			movimentoItem.setUnidadeMedida(objDTO.getUnidadeMedida()); 
			movimentoItem.setPilha(objDTO.getPilha());
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
			
			movimentoItem.setQuantidade(objDTO.getQuantidade());	 
			movimentoItem.setPeso(objDTO.getPeso());
			movimentoItem.setIdCab(idCab);	
			
			if(objDTO.getVlUnitario() != null) {
				movimentoItem.setVlUnitario(objDTO.getVlUnitario());  
			}else {
				movimentoItem.setVlUnitario(0.0);
				
			}
 
			
			movimentoItem.setPesoMedio(objDTO.getPesoMedio()); 
			movimentoItem.setStatusItem(objDTO.getStatusItem());
			movimentoItem.setStatusItemOriginal(objDTO.getStatusItemOriginal());
					
			return movimentoItem;  
				
		}			
	

}
