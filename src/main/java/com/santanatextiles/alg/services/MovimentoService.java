package com.santanatextiles.alg.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.Movimento;
import com.santanatextiles.alg.domain.MovimentoItem;
import com.santanatextiles.alg.domain.TipoMovimento;
import com.santanatextiles.alg.dto.MovimentoDTO;
import com.santanatextiles.alg.dto.MovimentoItemDTO;
import com.santanatextiles.alg.repositories.MovimentoRepository;
import com.santanatextiles.alg.resources.exception.ObjectNotFoundException;  
	
@Service
public class MovimentoService {
				
		@Autowired
		private MovimentoRepository repo;		
		
		@Autowired
		private MovimentoItemService serviceItem;	
		
		@Autowired
		private TipoMovimentoService serviceTipoMovto;	
		
		
		
		@Value("${spring.datasource.url}")
		private String JDBC_URL;
		
		@Value("${spring.datasource.username}")
		private String JDBC_USER;

		@Value("${spring.datasource.password}") 
		private String JDBC_PASSWORD;	
		
		private ArrayList<String> msg = new ArrayList<>();
		
		public List<Movimento> buscaMovimentoPorParametros(String filial ){	 
			 List<Movimento> obj = repo.buscaMovimentoPorParametros(filial) ;	  
			 return obj;
		}		
		
		
		public List<Movimento> pesquisaMovimentoPorParametros(MovimentoDTO movimentoDTO ){	  
					
		 	 String idfil          = movimentoDTO.getIdfil();
			 String tipoMovimento  = movimentoDTO.getTipoMovimento();
		 	 String tipoMP         = movimentoDTO.getTipoMP();
			 String codFornecedor  = movimentoDTO.getFornecedor();
			 String notaFiscal;
			 
		 	 
			 if(movimentoDTO.getNotaFiscal()!=null) {
				 notaFiscal     = String.format("%-10s", movimentoDTO.getNotaFiscal());
			 }else {
				 notaFiscal     = movimentoDTO.getNotaFiscal();
			 }
		 
		 	 
		 	 String produtor       = movimentoDTO.getProdutor();
		 	 String dataInicial    = movimentoDTO.getDataInicial();
		 	 String dataFinal      = movimentoDTO.getDataFinal(); 
			
			 List<Movimento> obj = repo.pesquisaMovimentoPorParametros(
					 
					 idfil, 
					 tipoMovimento,
					 tipoMP,
					 codFornecedor,
					 notaFiscal,
					 produtor ,
					 dataInicial ,
					 dataFinal  
					 
					 ) ;	  
			 return obj;
		}			
		
		  
		
		public List<Movimento> buscaMovimentoByFilial(String filial ){	 
			 List<Movimento> obj = repo.findByIdfil(filial ) ;	  
			 return obj;
		}	

	
		public Movimento findByIdfilAndFornecedorAndNotaFiscal(MovimentoDTO movimentoDTO){	
			
		     String filial      = movimentoDTO.getIdfil(); 
			 String fornecedor  = movimentoDTO.getFornecedor();
			 String notaFiscal;
			 
		 	 
			 if(movimentoDTO.getNotaFiscal()!=null) {
				 notaFiscal     = String.format("%-10s", movimentoDTO.getNotaFiscal());
			 }else {
				 notaFiscal     = movimentoDTO.getNotaFiscal();
			 }  
	 
			 Movimento obj = repo.findByIdfilAndFornecedorAndNotaFiscal(filial, fornecedor, notaFiscal);	  
			 return obj;
		}

	 
	 	
			@Transactional
			public Movimento insert(List<MovimentoDTO> objParam ) throws ParseException{	 
				
				    Iterator<MovimentoDTO> movimDTO = objParam.iterator();
				    Movimento obj1 = new Movimento();
				    MovimentoDTO objDTO;
				    Double novoCodigoAutomaticoCab = null;
				    
				    Boolean primeiraIteracao = true;

			        // Iterar sobre a lista usando o Iterator
			         while (movimDTO.hasNext()) {
			     
			        	    objDTO = movimDTO.next();
					        Movimento obj = fromDTO(objDTO); 
					        
					        if(primeiraIteracao) {
						        if(obj.getMovimentoAutomatico() != null &&  obj.getMovimentoAutomatico().equals("A")) {
						        	novoCodigoAutomaticoCab = repo.codigoNovoMovimento(); 
						        	  
						        }else {
						        	
						        	novoCodigoAutomaticoCab = null;
						        }; 
						        primeiraIteracao = false; 
					        };
					        
					        obj.setIdAutomatico(novoCodigoAutomaticoCab);
					        
					        insertMovimento(obj);
						       
			        }
				    return obj1;
			}			
		
		
 	/*
 	
		@Transactional
		public Movimento insert(List<Movimento> objParam ) throws ParseException{	 
			
			    Iterator<Movimento> movim = objParam.iterator();
			    Movimento obj1 = new Movimento();
			    
			    Movimento obj;

		        // Iterar sobre a lista usando o Iterator
		         while (movim.hasNext()) {
		     
				        obj = movim.next();
					    TipoMovimento tipoMovto = serviceTipoMovto.buscaTipoMovimentoByCodigo(obj.getIdfil(),obj.getTipoMovimento());
					    
						if(tipoMovto == null) {
							throw new ObjectNotFoundException("Tipo de Movimento não encontrado!");  
						}else {
							obj.setEntradaSaida(tipoMovto.getEntradaSaida()); 	
						}  
					    
					    Movimento movimento = configuraMovimento(obj);
					    
						
						if (!this.msg.isEmpty()) {
							throw new ObjectNotFoundException(String.join(",", this.msg)); 
						} 
						
						repo.save(movimento);
						 
						Iterator<MovimentoItemDTO> it = obj.getItemMovimentoDTO().iterator();
						 
						while (it.hasNext()) {
							MovimentoItem movimentoItem = serviceItem.fromDTO(
									it.next(),
									movimento.getId(),-
								//	tipoMovto.getAtualizaItem(),
									'S',
									movimento.getIdAutomatico(),
									movimento.getMovimentoAutomatico(),
									movimento.getMovimentoPilha()) ;
							
							serviceItem.insert(movimentoItem, tipoMovto.getAtualizaEstoque(),
									   tipoMovto.getAtualizaItem(),tipoMovto.getPesoCalculadoInformado());
						}   
		        }
			    return obj1;
		}	 	
 
		
*/ 	
 		
	 
		public Movimento insertMovimento( Movimento  obj ) throws ParseException{	 
			
			  
			    TipoMovimento tipoMovto = serviceTipoMovto.buscaTipoMovimentoByCodigo(obj.getIdfil(),obj.getTipoMovimento());
			    
				if(tipoMovto == null) {
					throw new ObjectNotFoundException("Tipo de Movimento não encontrado!");  
				}else {
					obj.setEntradaSaida(tipoMovto.getEntradaSaida()); 	
				}  
			    
			    Movimento movimento = configuraMovimento(obj);
			    
				
				if (!this.msg.isEmpty()) {
					throw new ObjectNotFoundException(String.join(",", this.msg)); 
				} 
				
				repo.save(movimento);
				 
				Iterator<MovimentoItemDTO> it = obj.getItemMovimentoDTO().iterator();
				 
				while (it.hasNext()) {
					MovimentoItem movimentoItem = serviceItem.fromDTO(
							it.next(),
							movimento.getId(),
							tipoMovto.getAtualizaItem(),
							movimento.getIdAutomatico(),
							movimento.getMovimentoAutomatico(),
							movimento.getMovimentoPilha()) ;
					
					serviceItem.insert(movimentoItem, tipoMovto.getAtualizaEstoque(),
							   tipoMovto.getAtualizaItem(),tipoMovto.getPesoCalculadoInformado());
				}   
		   
			    return movimento;
		}	 

 
		
/*		
		public Movimento update(Movimento movimento ){				
			 String nf = String.format("%-10s", movimento.getNotaFiscal());
			 movimento.setNotaFiscal(nf);
			 Movimento obj = repo.save(movimento);	  
			 return obj;
		}	

		
		private void verificaEntidades() {
			
			this.msg.clear();
		}
		
		*/
		private Movimento configuraMovimento(Movimento obj) throws ParseException { 
			
			LocalDate dataAtual = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
			String dataFormatada = dataAtual.format(formatter); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");			
			
		    Double novoCodigo = repo.codigoNovoMovimento();   
		    String nf = String.format("%-10s", obj.getNotaFiscal()); 	 
			
		    obj.setId(novoCodigo);
		    obj.setNotaFiscal(nf); 
		    
		    //if(obj.getMovimentoAutomatico() !=null && obj.getMovimentoAutomatico().equals("S")) { 
			    //Double novoCodigoAutomatico = repo.codigoNovoMovimento(); 
			    //obj.setIdAutomatico(novoCodigoAutomatico);		 
		    //}
		    
		    obj.setDataInclusao(dateFormat.parse(dataFormatada)); 

			
			return obj;
			
			
		}
		
/*		
		public List<Movimento> fromDTO(List<MovimentoDTO> objDTOParam) throws ParseException {   
			
			   Iterator<MovimentoDTO> movimTmp = objDTOParam.iterator();  
			   
			   List<Movimento> listMovimento =  new ArrayList<>();
			   
			   MovimentoDTO objDTO;
			   
		       while (movimTmp.hasNext()) {
		     
		        	objDTO = movimTmp.next();	 
			
					Movimento movimento = new Movimento();     
					
					movimento.setId(objDTO.getId());	 
					movimento.setIdfil(objDTO.getIdfil());  
					movimento.setNotaFiscal(objDTO.getNotaFiscal());	 
					movimento.setFornecedor(objDTO.getFornecedor());	 
					movimento.setTipoMovimento(objDTO.getTipoMovimento());	 
					movimento.setTipoMP(objDTO.getTipoMP());	 	 
					movimento.setDataBase(objDTO.getDataBase());	  
					movimento.setDataEmissao(objDTO.getDataEmissao());	 
					movimento.setEntradaSaida(objDTO.getEntradaSaida());  
		            
			        movimento.setLoteFiacao(objDTO.getLoteFiacao());	 
				    movimento.setPesoMedio(objDTO.getPesoMedio());	 
				    movimento.setPesoTotal(objDTO.getPesoTotal());	 
				    movimento.setProdutor(objDTO.getProdutor());	 
				    movimento.setProcedencia(objDTO.getProcedencia());		 
			        movimento.setLinhaAbertura(objDTO.getLinhaAbertura()); 
				    
			        movimento.setIdAutomatico(objDTO.getIdAutomatico());		 
				    movimento.setMovimentoPilha(objDTO.getMovimentoPilha()); 
				    
				    
				    movimento.setMistura(objDTO.getMistura());	 
				    movimento.setSequenciaMistura(objDTO.getSequenciaMistura());	 
				    movimento.setUsuarioInclusao(objDTO.getUsuarioInclusao());	 
				    movimento.setUsuarioAlteracao(objDTO.getUsuarioAlteracao());  
				    
				    movimento.setDataAlteracao(objDTO.getDataAlteracao());	   
				    movimento.setItemMovimentoDTO(objDTO.getItemMovimentoDTO());	
				    
				    listMovimento.add(movimento);
			 		
		       }
			
			return listMovimento;
		}			
					
*/		
	
public Movimento fromDTO(MovimentoDTO objDTO) throws ParseException {   
			
			Movimento movimento = new Movimento();     
			
			movimento.setId(objDTO.getId());	 
			movimento.setIdfil(objDTO.getIdfil());  
			movimento.setNotaFiscal(objDTO.getNotaFiscal());	 
			movimento.setFornecedor(objDTO.getFornecedor());	 
			movimento.setTipoMovimento(objDTO.getTipoMovimento());	 
			movimento.setTipoMP(objDTO.getTipoMP());	 	 
			movimento.setDataBase(objDTO.getDataBase());	  
			movimento.setDataEmissao(objDTO.getDataEmissao());	 
			movimento.setEntradaSaida(objDTO.getEntradaSaida());  
            
	        movimento.setLoteFiacao(objDTO.getLoteFiacao());	 
		    movimento.setPesoMedio(objDTO.getPesoMedio());	 
		    movimento.setPesoTotal(objDTO.getPesoTotal());	 
		    movimento.setProdutor(objDTO.getProdutor());	 
		    movimento.setProcedencia(objDTO.getProcedencia());		 
	        movimento.setLinhaAbertura(objDTO.getLinhaAbertura()); 
		    
	        movimento.setMovimentoAutomatico(objDTO.getMovimentoAutomatico());		 
		    movimento.setMovimentoPilha(objDTO.getMovimentoPilha()); 
		    
		    
		    movimento.setMistura(objDTO.getMistura());	 
		    movimento.setSequenciaMistura(objDTO.getSequenciaMistura());	 
		    movimento.setUsuarioInclusao(objDTO.getUsuarioInclusao());	 
		    movimento.setUsuarioAlteracao(objDTO.getUsuarioAlteracao());  
		    
		    movimento.setDataAlteracao(objDTO.getDataAlteracao());	   
		    movimento.setItemMovimentoDTO(objDTO.getItemMovimentoDTO());	
			 		
			
			
			return movimento;
		}			
		
		
	 

}
