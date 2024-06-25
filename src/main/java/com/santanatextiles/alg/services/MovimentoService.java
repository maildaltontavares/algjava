package com.santanatextiles.alg.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.MisturaPadraoItem;
import com.santanatextiles.alg.domain.Movimento;
import com.santanatextiles.alg.domain.MovimentoItem;
import com.santanatextiles.alg.domain.TipoMovimento;
import com.santanatextiles.alg.dto.LoteDTO;
import com.santanatextiles.alg.dto.MovimentoDTO;
import com.santanatextiles.alg.dto.MovimentoItemDTO;
import com.santanatextiles.alg.projections.LotesProjection;
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
		
		@Autowired
		private MisturaPadraoItemService serviceMisturaItem;		
		
		@Autowired
		private EstoqueMPService serviceEstoqueMP;			
		
		@Autowired
		private ProducaoAberturaService producaoAberturaService;			
		
		
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
		
		public Double codigoNovoMovimento(){	 
		  	 Double obj = repo.codigoNovoMovimento() ;	  
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
 
		
		     /////////  GERAR PILHA   ////////
	    	@Transactional
		    public String gerarPilha(List<MovimentoDTO> objParam ) throws ParseException{	 
					insert(objParam);  
				    return "";
		    }
	
			
			////////////  METODOS DE ALTERACAO   //////////		
		
			@Transactional
			public String update(List<MovimentoDTO> objParam ) throws ParseException{	 
				
				    Iterator<MovimentoDTO> movimDTO = objParam.iterator();
				    Movimento obj1 = new Movimento();
				    MovimentoDTO objDTO; 
				    
				    String statusTransacao = "";

			        // Iterar sobre a lista usando os cabecalhos dos movimentos. Pode processar mais de um movimento de uma vez.
			         while (movimDTO.hasNext()) {
			     
			        	    objDTO = movimDTO.next();
					        Movimento obj = fromDTO(objDTO);
					        
					        Double numIdAutom = objDTO.getIdAutomatico();
					        String tipoMovimto = obj.getTipoMovimento();
					        updateMovimento(obj);
					        
					        
					        
					        // Deleta o cabecalho do movimento caso todos os itens tenham sido deletados. 
					        List<MovimentoItem> mvItem = serviceItem.findByIdCab(obj.getId());
					        if(mvItem == null || mvItem.isEmpty()) {
					        	
					        	repo.deleteById(obj.getId());
					        	statusTransacao = "Deletado";
					        	
					        	// Via movimentos, a mistura só pode ser deletada. Nunca inserida em alterada.
					        	if(numIdAutom!=null && tipoMovimto.equals("MIST") ) {	  // Exclui apontamento Mistura				        		
					        		producaoAberturaService.deleteByIdfilAndIdAutomatico(obj.getIdfil(), numIdAutom);	
/*					        	}
					        	
					        }else if(mvItem.isEmpty()){  
					        	
					        	repo.deleteById(obj.getId());
					        	statusTransacao = "Deletado";
					        	
					        	if(numIdAutom!=null && tipoMovimto == "MIST" ) {	  // Exclui apontamento Mistura				        		
					        		producaoAberturaService.deleteByIdfilAndIdAutomatico(obj.getIdfil(), numIdAutom);	
	*/				        	}					        	
					        }
					        
						       
			        }
			         
			        if(statusTransacao.equals("")) {  
			        	statusTransacao = "Alterado";			        	
			        }
			         
				    return statusTransacao;
			}			
			
			 
			public Movimento updateMovimento( Movimento  obj ) throws ParseException, ObjectNotFoundException{	
				
				    List<String> listaDeIds = new ArrayList<>();
				  
				    TipoMovimento tipoMovto = serviceTipoMovto.buscaTipoMovimentoByCodigo(obj.getIdfil(),obj.getTipoMovimento());
				    
					if(tipoMovto == null) {
						throw new ObjectNotFoundException("Tipo de Movimento não encontrado!");  
					}else {
						obj.setEntradaSaida(tipoMovto.getEntradaSaida()); 	
					}  
				    
				    Movimento movimento = configuraMovimentoAlteracao(obj);
				    
					
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
								movimento.getMovimentoPilha(), 
								tipoMovto.getAtualizaEstoque(),
								movimento ) ;
						
						// Valida duplicidade de idMovimento no documento
						if (!listaDeIds.contains(movimentoItem.getIdMovimento().toString())) {						
							listaDeIds.add(movimentoItem.getIdMovimento().toString());
						}else {
							throw new ObjectNotFoundException("Lote: " + movimentoItem.getLote() + " duplicado no documento.");							
							
						}						
						
						if(movimentoItem.getStatusItemOriginal().equals("Inclusão")) {
							
						    serviceItem.insert(movimentoItem, tipoMovto.getAtualizaEstoque(),
								   tipoMovto.getAtualizaItem(),tipoMovto.getPesoCalculadoInformado());
						    
						}else if(movimentoItem.getStatusItemOriginal().equals("Alteração")) { 
							
							if(movimentoItem.getStatusItem().equals("Alteração") ) {  
								 serviceItem.update(movimentoItem, tipoMovto.getAtualizaEstoque(),
										   tipoMovto.getAtualizaItem(),tipoMovto.getPesoCalculadoInformado());	  
							} else if(movimentoItem.getStatusItem().equals("Exclusão") ) {  
								
								if(tipoMovto.getAtualizaEstoque().equals("S")) {
									
									
									 if(movimentoItem.getIdMovimento().equals(movimentoItem.getIdItem())) { 
									
											List<MisturaPadraoItem> misturaPadraoItem = serviceMisturaItem.buscaMisturaPorId(movimentoItem.getIdItem());
											
											// Nao pertence a mistura padrao
											if(!misturaPadraoItem.isEmpty()  ) { 
												throw new ObjectNotFoundException("Lote: " + movimentoItem.getLote() + " já pertence a mistura padrão. Registro não pode ser excluido."); 
											}  
											
											// Verifica se tem mais movimentos com esse ID. Se sim não poderá ser excluido.
											Double totMovItem =  serviceItem.contarMovimentoItem(movimentoItem.getIdfil(),movimentoItem.getIdItem());
											
											if(totMovItem != null ) {
												if(totMovItem > 1 ) {
												    throw new ObjectNotFoundException("Existem outros movimentos do lote: " + movimentoItem.getLote() + ". Registro não pode ser excluido.");
												}    
											} 											
									
											
									 }  
							         
							         serviceItem.deletaMovimentoItem(movimentoItem,tipoMovto.getAtualizaEstoque()); 
							         
							         if(movimentoItem.getIdMovimento().equals(movimentoItem.getIdItem())) {
							        	 serviceEstoqueMP.deletaEstoque(movimentoItem.getIdItem());
							         }
									
									
								} else { 
							
							         serviceEstoqueMP.deletaEstoque(movimentoItem.getIdItem());
							         serviceItem.deletaMovimentoItem(movimentoItem,tipoMovto.getAtualizaEstoque());
									  
								}
								 
								
							 
							}
							
							
						}
					}   
			   
				    return movimento;
			}	
			
			 
			
			private Movimento configuraMovimentoAlteracao(Movimento obj) throws ParseException { 
				
				LocalDate dataAtual = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
				String dataFormatada = dataAtual.format(formatter); 
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
			    
			    obj.setDataAlteracao(dateFormat.parse(dataFormatada));
				
				return obj;
				
				
			}			
 		
			//////////// METODOS DE INCLUSAO //////////
		 	
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
						        	obj1.setIdAutomatico(novoCodigoAutomaticoCab);  
						        }else {
						        	
						        	novoCodigoAutomaticoCab = null;
						        }; 
						        primeiraIteracao = false; 
					        };
					        
					        obj.setIdAutomatico(novoCodigoAutomaticoCab);
					        
					        insertMovimento(obj);
						       
			        }
				    return obj1;   // Retorna o ID automatico no atributo do movimento
			}				
	 
		public Movimento insertMovimento( Movimento  obj ) throws ParseException{	 
			
			  
			    TipoMovimento tipoMovto = serviceTipoMovto.buscaTipoMovimentoByCodigo(obj.getIdfil(),obj.getTipoMovimento());
			    
				if(tipoMovto == null) {
					throw new ObjectNotFoundException("Tipo de Movimento não encontrado!");  
				}else {
					obj.setEntradaSaida(tipoMovto.getEntradaSaida()); 	
				}  
			    
			    Movimento movimento = configuraMovimentoInclusao(obj); 
			    
				
				if (!this.msg.isEmpty()) {
					throw new ObjectNotFoundException(String.join(",", this.msg)); 
				} 
				
				repo.save(movimento);
				 
				Iterator<MovimentoItemDTO> it = obj.getItemMovimentoDTO().iterator();
				 
				while (it.hasNext()) {
//					/it.next(),
					MovimentoItemDTO movimIt =   it.next();
					
					
				    if(movimento.getMovimentoPilha().equals("S")) {
				    	
				    	if(movimento.getEntradaSaida().equals("S")){  
				    		serviceItem.populaItem(movimIt);   
				    	}					
					
				    }
					
					
					MovimentoItem movimentoItem = serviceItem.fromDTO(
							
							movimIt,
							movimento.getId(),
							tipoMovto.getAtualizaItem(),
							movimento.getIdAutomatico(),
							movimento.getMovimentoAutomatico(),
							movimento.getMovimentoPilha(), 
							tipoMovto.getAtualizaEstoque(),
							movimento 
						 
							) ; 
					
					
					serviceItem.insert(movimentoItem, tipoMovto.getAtualizaEstoque(),
							   tipoMovto.getAtualizaItem(),tipoMovto.getPesoCalculadoInformado());
				}   
		   
			    return movimento;
		}	 
 
 
	 
		private Movimento configuraMovimentoInclusao(Movimento obj) throws ParseException { 
			
			LocalDate dataAtual = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
			String dataFormatada = dataAtual.format(formatter); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			
			String nf = String.format("%-10s", obj.getNotaFiscal()); 
		    	
		    
		    if(obj.getId()==null) {
			    Double novoCodigo = repo.codigoNovoMovimento(); 
			    obj.setId(novoCodigo); 

		    }  
		    
		    if(obj.getMovimentoPilha().equals("S")) {
		    	
		    	if(obj.getEntradaSaida().equals("S")){ 
		    		obj.setNotaFiscal("PS" + String.format("%08d", obj.getIdAutomatico().intValue()  ));
		    	}else{
		    		obj.setNotaFiscal("PI" + String.format("%08d", obj.getIdAutomatico().intValue() ));
		    	}
		     
		    	obj.setDataBase(dateFormat.parse(dataFormatada));
		    	obj.setDataEmissao(dateFormat.parse(dataFormatada));
		    	obj.setDataAlteracao(dateFormat.parse(dataFormatada));
		    	
		    	
		    }else {
		    	obj.setNotaFiscal(nf);  
		    }
		     
		    
		    obj.setDataInclusao(dateFormat.parse(dataFormatada));
			
			return obj;
			
			
		}
		
		@Transactional	
		 public void deletaMovimento(Double id){	 
		 	  repo.deleteById(id);  
		}		 
	
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
	        movimento.setNumVolumes(objDTO.getNumVolumes());
		    movimento.setPesoMedio(objDTO.getPesoMedio());	 
		    movimento.setPesoTotal(objDTO.getPesoTotal());	 
		    movimento.setProdutor(objDTO.getProdutor());	 
		    movimento.setProcedencia(objDTO.getProcedencia());		 
	        movimento.setLinhaAbertura(objDTO.getLinhaAbertura());  
	        
	        movimento.setMovimentoAutomatico(objDTO.getMovimentoAutomatico());		 
		    movimento.setMovimentoPilha(objDTO.getMovimentoPilha());
		    movimento.setQual1(objDTO.getQual1());
		    movimento.setQual2(objDTO.getQual2());
		    
		    movimento.setMistura(objDTO.getMistura());	 
		    movimento.setSequenciaMistura(objDTO.getSequenciaMistura());	 
		    
		    movimento.setUsuarioInclusao(objDTO.getUsuarioInclusao());	 
		    movimento.setUsuarioAlteracao(objDTO.getUsuarioAlteracao());  
		    
		    movimento.setDataInclusao(objDTO.getDataInclusao());
		    movimento.setDataAlteracao(objDTO.getDataAlteracao());	   
		    movimento.setItemMovimentoDTO(objDTO.getItemMovimentoDTO()); 
			
			
			return movimento;
		}	
		
		
        public MovimentoDTO fromDTOMovimentoToMovimentoDTO(Movimento obj) throws ParseException {   
			
			MovimentoDTO movimentoDTO = new MovimentoDTO();     
			
			movimentoDTO.setId(obj.getId());	 
			movimentoDTO.setIdfil(obj.getIdfil());  
			movimentoDTO.setNotaFiscal(obj.getNotaFiscal());	 
			movimentoDTO.setFornecedor(obj.getFornecedor());	 
			movimentoDTO.setTipoMovimento(obj.getTipoMovimento());	 
			movimentoDTO.setTipoMP(obj.getTipoMP());	 	 
			movimentoDTO.setDataBase(obj.getDataBase());	  
			movimentoDTO.setDataEmissao(obj.getDataEmissao());	 
			movimentoDTO.setEntradaSaida(obj.getEntradaSaida());  
            
			movimentoDTO.setLoteFiacao(obj.getLoteFiacao());
			movimentoDTO.setNumVolumes(obj.getNumVolumes());
			movimentoDTO.setPesoMedio(obj.getPesoMedio());	 
			movimentoDTO.setPesoTotal(obj.getPesoTotal());	 
			movimentoDTO.setProdutor(obj.getProdutor());	 
			movimentoDTO.setProcedencia(obj.getProcedencia());		 
			movimentoDTO.setLinhaAbertura(obj.getLinhaAbertura());
			movimentoDTO.setIdAutomatico(obj.getIdAutomatico()); 
	        
			movimentoDTO.setMovimentoAutomatico(obj.getMovimentoAutomatico());		 
			movimentoDTO.setMovimentoPilha(obj.getMovimentoPilha());
			movimentoDTO.setQual1(obj.getQual1());
			movimentoDTO.setQual2(obj.getQual2());
		    
			movimentoDTO.setMistura(obj.getMistura());	 
			movimentoDTO.setSequenciaMistura(obj.getSequenciaMistura());	 
		    
			movimentoDTO.setUsuarioInclusao(obj.getUsuarioInclusao());	 
			movimentoDTO.setUsuarioAlteracao(obj.getUsuarioAlteracao());  
		    
			movimentoDTO.setDataInclusao(obj.getDataInclusao());
			movimentoDTO.setDataAlteracao(obj.getDataAlteracao());	   
			movimentoDTO.setItemMovimentoDTO(obj.getItemMovimentoDTO()); 
			
			
			return movimentoDTO;
		}			
		
		 
		@Transactional
		public Double excluirPilha( Double idAutomatico) throws ParseException, ObjectNotFoundException {  
			
			List<MovimentoDTO> movimentosDTO = new ArrayList<>();
			List<MovimentoItemDTO> movimentosItemDTOSaida = new ArrayList<>();
						
		    ///// Movimento  Saida
			
			Movimento movimentoSaida = repo.findByIdAutomaticoAndTipoMovimento(idAutomatico,"SAIPL");
			
			Iterator<MovimentoItem> it = movimentoSaida.getItemMovimento().iterator();
			 
			while (it.hasNext()) {
 
				MovimentoItem movimIt =   it.next();
				
				MovimentoItemDTO movimentoItemDTO = new MovimentoItemDTO();
				
				movimentoItemDTO.setIdMovimento(movimIt.getIdMovimento());
				movimentoItemDTO.setIdItem(movimIt.getIdItem());
				movimentoItemDTO.setIdfil(movimIt.getIdfil()); 
				movimentoItemDTO.setNotaFiscal(movimIt.getNotaFiscal()); 
				movimentoItemDTO.setFornecedor(movimIt.getFornecedor()); 
				movimentoItemDTO.setNotaFiscal(movimIt.getNotaFiscal());	 
				movimentoItemDTO.setFornecedor(movimIt.getFornecedor()); 
				movimentoItemDTO.setItem(movimIt.getItem());
				movimentoItemDTO.setProdutor(movimIt.getProdutor());
				movimentoItemDTO.setProcedencia(movimIt.getProcedencia());	 
				movimentoItemDTO.setLote(movimIt.getLote()); 
				movimentoItemDTO.setTamanho(movimIt.getTamanho());
				movimentoItemDTO.setDescFio(movimIt.getDescFio());			
				movimentoItemDTO.setUnidadeMedida(movimIt.getUnidadeMedida()); 
				movimentoItemDTO.setPilha(movimIt.getPilha());	 
				movimentoItemDTO.setPesoMedio(movimIt.getPesoMedio()); 
				movimentoItemDTO.setTipoQualidade(movimIt.getTipoQualidade()); 
				movimentoItemDTO.setClassifQualidade(movimIt.getClassifQualidade());
				movimentoItemDTO.setQualidade(movimIt.getTipoQualidade() ) ;
				movimentoItemDTO.setLoteAdicional(movimIt.getLoteAdicional());  
				movimentoItemDTO.setColoracao(movimIt.getColoracao());
				movimentoItemDTO.setIdVolume(movimIt.getIdVolume()); 
				movimentoItemDTO.setTipoMic(movimIt.getTipoMic());
				movimentoItemDTO.setDestino(movimIt.getDestino());  
				movimentoItemDTO.setSac(movimIt.getSac());
				movimentoItemDTO.setTrid(movimIt.getTrid());			
				movimentoItemDTO.setPim(movimIt.getPim());
				movimentoItemDTO.setSc(movimIt.getSc());	 
				movimentoItemDTO.setMst(movimIt.getMst()); 
				movimentoItemDTO.setMic(movimIt.getMic());	   
				movimentoItemDTO.setMat(movimIt.getMat());
				movimentoItemDTO.setUi(movimIt.getUi());
				movimentoItemDTO.setSf(movimIt.getSf());	 
				movimentoItemDTO.setStr(movimIt.getStr());	 
				movimentoItemDTO.setElg(movimIt.getElg());	 
				movimentoItemDTO.setTipo(movimIt.getTipo());	 
				movimentoItemDTO.setSic(movimIt.getSic());	  
				movimentoItemDTO.setUhml(movimIt.getUhml());
				movimentoItemDTO.setRs(movimIt.getRs());	 
				movimentoItemDTO.setB(movimIt.getB());	 
				movimentoItemDTO.setTrcnt(movimIt.getTrcnt());	 
				movimentoItemDTO.setTrar(movimIt.getTrar());	 
				movimentoItemDTO.setUsuarioInclusao(movimIt.getUsuarioInclusao());	 
				movimentoItemDTO.setUsuarioAlteracao(movimIt.getUsuarioAlteracao());   
				movimentoItemDTO.setQuantidade(movimIt.getQuantidade());	 
				movimentoItemDTO.setPeso(movimIt.getPeso());
				movimentoItemDTO.setPesoMedio(movimIt.getPesoMedio()); 				
				movimentoItemDTO.setPesoCalculadoInformado(movimIt.getPesoCalculadoInformado()); 
				movimentoItemDTO.setDataInclusao(movimIt.getDataInclusao());
				movimentoItemDTO.setDataAlteracao(movimIt.getDataAlteracao());	 
				movimentoItemDTO.setVlUnitario(movimIt.getVlUnitario());  
				movimentoItemDTO.setMovimentoAutomatico(movimIt.getMovimentoAutomatico());  
				movimentoItemDTO.setMovimentoDePilha(movimIt.getMovimentoDePilha());
				movimentoItemDTO.setIdAutomatico(movimIt.getIdAutomatico());  
				movimentoItemDTO.setObservacao(movimIt.getObservacao());  
				movimentoItemDTO.setStatusItem("Exclusão");
				movimentoItemDTO.setStatusItemOriginal("Alteração");
				
				movimentosItemDTOSaida.add(movimentoItemDTO);
			}
			
			Set<MovimentoItemDTO> setItemMovimentoDTOSaida = new HashSet<>(movimentosItemDTOSaida);  
			movimentoSaida.setItemMovimento(null);
			movimentoSaida.setItemMovimentoDTO(setItemMovimentoDTOSaida);   
			
		    ///// Movimento  Entrada
			
			List<MovimentoItemDTO> movimentosItemDTOEntrada = new ArrayList<>();
			Movimento movimentoEntrada = repo.findByIdAutomaticoAndTipoMovimento(idAutomatico,"ENTPL"); 
			
			Iterator<MovimentoItem> itEntrada = movimentoEntrada.getItemMovimento().iterator();
			 
			while (itEntrada.hasNext()) {
 
				MovimentoItem movimIt =   itEntrada.next();
				
				MovimentoItemDTO movimentoItemDTO = new MovimentoItemDTO();
				
				movimentoItemDTO.setIdMovimento(movimIt.getIdMovimento());
				movimentoItemDTO.setIdItem(movimIt.getIdItem());
				movimentoItemDTO.setIdfil(movimIt.getIdfil()); 
				movimentoItemDTO.setNotaFiscal(movimIt.getNotaFiscal()); 
				movimentoItemDTO.setFornecedor(movimIt.getFornecedor()); 
				movimentoItemDTO.setNotaFiscal(movimIt.getNotaFiscal());	 
				movimentoItemDTO.setFornecedor(movimIt.getFornecedor()); 
				movimentoItemDTO.setItem(movimIt.getItem());
				movimentoItemDTO.setProdutor(movimIt.getProdutor());
				movimentoItemDTO.setProcedencia(movimIt.getProcedencia());	 
				movimentoItemDTO.setLote(movimIt.getLote()); 
				movimentoItemDTO.setTamanho(movimIt.getTamanho());
				movimentoItemDTO.setDescFio(movimIt.getDescFio());			
				movimentoItemDTO.setUnidadeMedida(movimIt.getUnidadeMedida()); 
				movimentoItemDTO.setPilha(movimIt.getPilha());	 
				movimentoItemDTO.setPesoMedio(movimIt.getPesoMedio()); 
				movimentoItemDTO.setTipoQualidade(movimIt.getTipoQualidade()); 
				movimentoItemDTO.setClassifQualidade(movimIt.getClassifQualidade());
				movimentoItemDTO.setQualidade(movimIt.getTipoQualidade() ) ;
				movimentoItemDTO.setLoteAdicional(movimIt.getLoteAdicional());  
				movimentoItemDTO.setColoracao(movimIt.getColoracao());
				movimentoItemDTO.setIdVolume(movimIt.getIdVolume()); 
				movimentoItemDTO.setTipoMic(movimIt.getTipoMic());
				movimentoItemDTO.setDestino(movimIt.getDestino());  
				movimentoItemDTO.setSac(movimIt.getSac());
				movimentoItemDTO.setTrid(movimIt.getTrid());			
				movimentoItemDTO.setPim(movimIt.getPim());
				movimentoItemDTO.setSc(movimIt.getSc());	 
				movimentoItemDTO.setMst(movimIt.getMst()); 
				movimentoItemDTO.setMic(movimIt.getMic());	   
				movimentoItemDTO.setMat(movimIt.getMat());
				movimentoItemDTO.setUi(movimIt.getUi());
				movimentoItemDTO.setSf(movimIt.getSf());	 
				movimentoItemDTO.setStr(movimIt.getStr());	 
				movimentoItemDTO.setElg(movimIt.getElg());	 
				movimentoItemDTO.setTipo(movimIt.getTipo());	 
				movimentoItemDTO.setSic(movimIt.getSic());	  
				movimentoItemDTO.setUhml(movimIt.getUhml());
				movimentoItemDTO.setRs(movimIt.getRs());	 
				movimentoItemDTO.setB(movimIt.getB());	 
				movimentoItemDTO.setTrcnt(movimIt.getTrcnt());	 
				movimentoItemDTO.setTrar(movimIt.getTrar());	 
				movimentoItemDTO.setUsuarioInclusao(movimIt.getUsuarioInclusao());	 
				movimentoItemDTO.setUsuarioAlteracao(movimIt.getUsuarioAlteracao());   
				movimentoItemDTO.setQuantidade(movimIt.getQuantidade());	 
				movimentoItemDTO.setPeso(movimIt.getPeso());
				movimentoItemDTO.setPesoMedio(movimIt.getPesoMedio()); 				
				movimentoItemDTO.setPesoCalculadoInformado(movimIt.getPesoCalculadoInformado()); 
				movimentoItemDTO.setDataInclusao(movimIt.getDataInclusao());
				movimentoItemDTO.setDataAlteracao(movimIt.getDataAlteracao());	 
				movimentoItemDTO.setVlUnitario(movimIt.getVlUnitario());  
				movimentoItemDTO.setMovimentoAutomatico(movimIt.getMovimentoAutomatico());  
				movimentoItemDTO.setMovimentoDePilha(movimIt.getMovimentoDePilha());
				movimentoItemDTO.setIdAutomatico(movimIt.getIdAutomatico());  
				movimentoItemDTO.setObservacao(movimIt.getObservacao());  
				movimentoItemDTO.setStatusItem("Exclusão");
				movimentoItemDTO.setStatusItemOriginal("Alteração");
				
				movimentosItemDTOEntrada.add(movimentoItemDTO);
			}
			
			Set<MovimentoItemDTO> setItemMovimentoDTOEntrada = new HashSet<>(movimentosItemDTOEntrada);  
			movimentoEntrada.setItemMovimento(null);
			movimentoEntrada.setItemMovimentoDTO(setItemMovimentoDTOEntrada); 	  
			
			movimentosDTO.add(fromDTOMovimentoToMovimentoDTO(movimentoEntrada)); 
			movimentosDTO.add(fromDTOMovimentoToMovimentoDTO(movimentoSaida)); 
			
			
			String grava = update(movimentosDTO); 
			
			
			return 0.0;
			
		
		}
		
		
		public List<LoteDTO> buscaMovimentosLote(String idfil, String produtor, String lote , String item){ 
			
			
			lote = lote.trim();  
			item = item.trim();
		 
			
			
			List<LotesProjection> loteProj = repo.buscaMovimentosLote(idfil, produtor, lote, item); 			
			List<LoteDTO> listaLote = loteProj.stream().map(x-> new LoteDTO(x)).toList();			
			ArrayList<LoteDTO> LoteP = new ArrayList<>(); 
			
			for (LoteDTO lotePDTO : listaLote) {
				
				 LoteDTO loteDTOItem = new LoteDTO();   
				
				 loteDTOItem.setIdfil(lotePDTO.getIdfil());
				 loteDTOItem.setNotaFiscal(lotePDTO.getNotaFiscal());
				 loteDTOItem.setDataBase(lotePDTO.getDataBase());
				 loteDTOItem.setFornecedor(lotePDTO.getFornecedor());
				 loteDTOItem.setNomeFornecedor(lotePDTO.getNomeFornecedor());
				 loteDTOItem.setDataTeste(lotePDTO.getDataTeste()); 
				 loteDTOItem.setQuantidade(lotePDTO.getQuantidade());
				 loteDTOItem.setTipoMovimento(lotePDTO.getTipoMovimento()); 
				
				 LoteP.add(loteDTOItem);
				 		
	         }	 
		   
			 return LoteP;
		}		
		
		 
	 

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
