package com.santanatextiles.alg.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.MovimentoItem;
import com.santanatextiles.alg.domain.TesteQualidade;
import com.santanatextiles.alg.dto.MovimentoItemDTO;
import com.santanatextiles.alg.dto.SaldoIdMovtoDTO;
import com.santanatextiles.alg.repositories.MovimentoItemRepository; 
	
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
		
		
		public MovimentoItem insert(MovimentoItem obj,String atualizaEstoque,
				   String atualizaItem,String pesoCalculadoInformado ) throws ParseException{  
			
		    MovimentoItem movItem = repo.save(configuraMovimentoItem(obj));
		    
		    /// Permite inserir novos itens de estoque (IDs)
		    if(atualizaItem.equals("S")) {    
			    serviceEstoqueMP.insert(movItem);	 
		    }
		    
		    /// Atualiza o saldo de estoque
		    if(atualizaEstoque.equals("S")) {    
			    SaldoIdMovtoDTO sldIdMovto =  serviceEstoqueMP.buscaSaldoIdMovto(movItem.getIdfil(), movItem.getIdMovimento());
			    serviceEstoqueMP.atualizaEstoque(movItem.getIdfil(),movItem.getIdMovimento(),sldIdMovto.getQtde(),sldIdMovto.getPeso(),sldIdMovto.getVlEst());			    
		    }
		    
		    return movItem;
		    
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
		
		
		
		public MovimentoItem fromDTO(MovimentoItemDTO objDTO,Double idCab,String atualizaItem, Double idAutomatico, String movimentoAutomatico,String movimentoPilha ) {
			
			MovimentoItem movimentoItem = new MovimentoItem(); 
			
			Double novoMovimentoItem = repo.codigoNovoMovimentoItem();
			
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
			
			movimentoItem.setId(novoMovimentoItem) ;			
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
			//movimentoItem.setVlUnitario(objDTO.getVlUnitario()); 
			
			
			if(atualizaItem.equals("S")) {
				movimentoItem.setIdMovimento(novoMovimentoItem); 
			}else {
				movimentoItem.setIdMovimento(objDTO.getIdMovimento()); 
			} 
			
			movimentoItem.setPesoMedio(objDTO.getPesoMedio()); 
					
			return movimentoItem;  
				
		}			
	

}
