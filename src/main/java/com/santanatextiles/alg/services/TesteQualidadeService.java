
package com.santanatextiles.alg.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.TesteQualidade;
import com.santanatextiles.alg.dto.MisturaProjectionDTO;
import com.santanatextiles.alg.dto.TesteQualidadeDTO;
import com.santanatextiles.alg.dto.TesteQualidadeProjectionDTO;
import com.santanatextiles.alg.projections.TestesQualidadeProjection;
import com.santanatextiles.alg.repositories.TesteQualidadeRepository;
import com.santanatextiles.alg.resources.exception.ObjectNotFoundException; 
	
@Service
public class TesteQualidadeService { 
	
		@Autowired
		private TesteQualidadeRepository repo;	 
		 
		@Value("${spring.datasource.url}")
		private String JDBC_URL;
		
		@Value("${spring.datasource.username}")
		private String JDBC_USER;

		@Value("${spring.datasource.password}") 
		private String JDBC_PASSWORD;			
		 
		public List<TesteQualidade> buscaTesteQualidadePorParametros(String filial ){ 
			 List<TesteQualidade> obj = repo.buscaTesteQualidadePorParametros(filial ) ;	  
			 return obj;
		}		
				
		public List<TesteQualidade> buscaTesteQualidadeByFilial(String filial ){	 
			 List<TesteQualidade> obj = repo.findByIdfil(filial ) ;	  
			 return obj;
		}			
		
 		
		public TesteQualidade buscaTesteQualidadeByLoteItem(String filial, String produtor, String pLote, String pItem ){	
			
			 //String lote = String.format("%-35s", pLote); 
			 TesteQualidade obj = repo.buscaTesteQualidadePorProdutorLoteItem(filial, produtor, pLote,pItem ) ;	  
			 return obj;
		}			
		
		public List<TesteQualidade> pesquisarTeste(TesteQualidadeDTO testeQualidadeDTO ){	
			
			 //String lote = String.format("%-35s", pLote); 
			 List<TesteQualidade> obj = repo.pesquisarTeste(testeQualidadeDTO.getIdfil(),  testeQualidadeDTO.getDataInicial(),testeQualidadeDTO.getDataFinal(),testeQualidadeDTO.getProdutor(),testeQualidadeDTO.getLote(),testeQualidadeDTO.getItem().toString()) ;	  
 
			 return obj;
		}	
		
		
		public List<TesteQualidadeProjectionDTO> pesquisarTesteRealizados(TesteQualidadeDTO testeQualidadeDTO  ) throws ParseException{ 
		     
		    List<TestesQualidadeProjection> testeQ; 
		  
		    testeQ = repo.pesquisarTesteRealizados(testeQualidadeDTO.getIdfil(),  testeQualidadeDTO.getDataInicial(),testeQualidadeDTO.getDataFinal(),testeQualidadeDTO.getProdutor(),testeQualidadeDTO.getLote(),testeQualidadeDTO.getItem().toString()) ;    
		   
			List<TesteQualidadeProjectionDTO> listaTestes = testeQ.stream().map(x-> new TesteQualidadeProjectionDTO(x)).toList();  		
			
			List<TesteQualidadeProjectionDTO> aTeste =  new ArrayList<>(); 
			
			for (TesteQualidadeProjectionDTO eTestePDTO : listaTestes) {  
				
				TesteQualidadeProjectionDTO tmpTeste = new TesteQualidadeProjectionDTO();
				
				 tmpTeste.setIdfil(eTestePDTO.getIdfil()) ;  
				 tmpTeste.setProdutor(eTestePDTO.getProdutor());	 
				 tmpTeste.setLote(eTestePDTO.getLote());     
				 tmpTeste.setDataTeste(eTestePDTO.getDataTeste()); 
				 tmpTeste.setNumVolumes(eTestePDTO.getNumVolumes()); 
				 tmpTeste.setSac(eTestePDTO.getSac());		 
				 tmpTeste.setMst(eTestePDTO.getMst());	 
				 tmpTeste.setMic(eTestePDTO.getMic());	 
				 tmpTeste.setMat(eTestePDTO.getMat());	 
				 tmpTeste.setUi(eTestePDTO.getUi());	 
				 tmpTeste.setSf(eTestePDTO.getSf()); 
				 tmpTeste.setStr(eTestePDTO.getStr()); 	
				 tmpTeste.setElg(eTestePDTO.getElg());	 
				 tmpTeste.setTipo(eTestePDTO.getTipo()); 
				 tmpTeste.setTrid(eTestePDTO.getTrid()); 
				 tmpTeste.setSc(eTestePDTO.getSc()); 	
				 tmpTeste.setPim(eTestePDTO.getPim());	 
				 tmpTeste.setHvi(eTestePDTO.getHvi());	 
				 tmpTeste.setBenef(eTestePDTO.getBenef()); 
				 tmpTeste.setObs(eTestePDTO.getObs());  
				 tmpTeste.setDataInclusao(eTestePDTO.getDataInclusao()); 
				 tmpTeste.setUsarioInclusao(eTestePDTO.getUsarioInclusao());	
				 tmpTeste.setDataAlteracao(eTestePDTO.getDataAlteracao()); 
				 tmpTeste.setUsarioAlteracao(eTestePDTO.getUsarioAlteracao());		 
				 tmpTeste.setSic(eTestePDTO.getSic());	 
				 tmpTeste.setUhml(eTestePDTO.getUhml()); 
				 tmpTeste.setRs(eTestePDTO.getRs()); 
				 tmpTeste.setB(eTestePDTO.getB()); 
				 tmpTeste.setTrcnt(eTestePDTO.getTrcnt()); 
				 tmpTeste.setTrar(eTestePDTO.getTrar()); 	
				 tmpTeste.setPrdint(eTestePDTO.getPrdint()); 
				 tmpTeste.setArqImportacao(eTestePDTO.getArqImportacao()); 
				 tmpTeste.setPossuiSelo(eTestePDTO.getPossuiSelo()); 
				 tmpTeste.setTipoSelo(eTestePDTO.getTipoSelo()); 
				 tmpTeste.setNumeroSelo(eTestePDTO.getNumeroSelo());
				 tmpTeste.setTipoMic(eTestePDTO.getTipoMic());
				 tmpTeste.setItem(eTestePDTO.getItem()); 
				 tmpTeste.setNomeProdutor(eTestePDTO.getNomeProdutor());

				
				aTeste.add(tmpTeste);
			 
	         }	 
		   
			  return aTeste;
	}		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		@Transactional
		public String excluirTeste(String idfil, String produtor, String pLote, String pItem ) throws ParseException{ 
			
			 Integer movItem = buscaMovimentoDePilha(idfil, produtor,pLote,pItem);
			 
			 if(movItem > 0) {
				 throw new ObjectNotFoundException("TESTE NAO PODE SER EXCLUIDO. JA HOUVE JUNCAO DE PILHA."); 
			 }else {			
			
				repo.excluirTeste(idfil, produtor, pLote,pItem );
				repo.atualizaExclusaoMovimentos(idfil, produtor, pLote, pItem);
				repo.atualizaExclusaoQualidade(idfil, produtor, pLote, pItem);
			 }
			return "Excluido";
		}
		
		
		
		@Transactional
		public TesteQualidade insertTeste(TesteQualidade testeQualidade ) throws ParseException {	
			
			 TesteQualidade obj; 
			 String tipoMic;
			 tipoMic = " ";
			
			 Integer movItem = buscaMovimentoDePilha(testeQualidade.getIdfil(), testeQualidade.getProdutor(), testeQualidade.getLote(), testeQualidade.getItem());
			 
			 if(movItem > 0) {
				 throw new ObjectNotFoundException("TESTE NAO PODE SER ALTERADO. JA HOUVE JUNCAO DE PILHA."); 
			 }else { 
				 
				 validaLimitesTeste(testeQualidade);
				 
				 if(testeQualidade.getIdfil().equals("05")) {
					 tipoMic = classificaMIC(testeQualidade.getMic()) ;
					 testeQualidade.setTipoMic(tipoMic);
				 }
				  
				 
				 obj =  repo.save(testeQualidade);	
				 
				 
				 repo.atualizaQualidade( 
						 testeQualidade.getIdfil(),
						 testeQualidade.getProdutor(),
						 testeQualidade.getLote(),
						 testeQualidade.getItem(),
						 testeQualidade.getSac(),
						 testeQualidade.getPim(),
						 testeQualidade.getTrid(),
						 testeQualidade.getMic(),
						 testeQualidade.getMat(),
						 testeQualidade.getUi(),
						 testeQualidade.getSf(),
						 testeQualidade.getElg(),
						 testeQualidade.getMst(),
						 testeQualidade.getTipo(),
						 testeQualidade.getSic(),
						 testeQualidade.getUhml(),
						 testeQualidade.getRs(),
						 testeQualidade.getB(),
						 testeQualidade.getTrcnt(),
						 testeQualidade.getTrar(),
						 testeQualidade.getTipoMic() ,
						 testeQualidade.getStr() ,
						 testeQualidade.getSc() 
						 );				 
				 
				 repo.atualizaMovimentos( 
						 testeQualidade.getIdfil(),
						 testeQualidade.getProdutor(),
						 testeQualidade.getLote(),
						 testeQualidade.getItem(),
						 testeQualidade.getSac(),
						 testeQualidade.getPim(),
						 testeQualidade.getTrid(),
						 testeQualidade.getMic(),
						 testeQualidade.getMat(),
						 testeQualidade.getUi(),
						 testeQualidade.getSf(),
						 testeQualidade.getElg(),
						 testeQualidade.getMst(),
						 testeQualidade.getTipo(),
						 testeQualidade.getSic(),
						 testeQualidade.getUhml(),
						 testeQualidade.getRs(),
						 testeQualidade.getB(),
						 testeQualidade.getTrcnt(),
						 testeQualidade.getTrar(),
						 testeQualidade.getTipoMic() ,
						 testeQualidade.getStr() ,
						 testeQualidade.getSc() 
						 );
				   
			 }  
			 	
			 return obj;
		}	

		
		@Transactional
		public TesteQualidade updateTeste(TesteQualidade testeQualidade ) throws ParseException {	
			
			 TesteQualidade obj; 
			 String tipoMic;
			 tipoMic = " ";
			
			 Integer movItem = buscaMovimentoDePilha(testeQualidade.getIdfil(), testeQualidade.getProdutor(), testeQualidade.getLote(), testeQualidade.getItem());
			 
			 if(movItem > 0) {
				 throw new ObjectNotFoundException("TESTE NAO PODE SER ALTERADO. JA HOUVE JUNCAO DE PILHA."); 
			 }else { 
				 
				 validaLimitesTeste(testeQualidade);
				 if(testeQualidade.getIdfil().equals("05")) {
					 tipoMic = classificaMIC(testeQualidade.getMic()) ;
					 testeQualidade.setTipoMic(tipoMic);
				 }
				 
				 obj =  repo.save(testeQualidade);	
				 
				 
				 repo.atualizaQualidade( 
						 testeQualidade.getIdfil(),
						 testeQualidade.getProdutor(),
						 testeQualidade.getLote(),
						 testeQualidade.getItem(),
						 testeQualidade.getSac(),
						 testeQualidade.getPim(),
						 testeQualidade.getTrid(),
						 testeQualidade.getMic(),
						 testeQualidade.getMat(),
						 testeQualidade.getUi(),
						 testeQualidade.getSf(),
						 testeQualidade.getElg(),
						 testeQualidade.getMst(),
						 testeQualidade.getTipo(),
						 testeQualidade.getSic(),
						 testeQualidade.getUhml(),
						 testeQualidade.getRs(),
						 testeQualidade.getB(),
						 testeQualidade.getTrcnt(),
						 testeQualidade.getTrar(),
						 testeQualidade.getTipoMic() ,
						 testeQualidade.getStr() ,
						 testeQualidade.getSc() 
						 );				 
				 
				 repo.atualizaMovimentos( 
						 testeQualidade.getIdfil(),
						 testeQualidade.getProdutor(),
						 testeQualidade.getLote(),
						 testeQualidade.getItem(),
						 testeQualidade.getSac(),
						 testeQualidade.getPim(),
						 testeQualidade.getTrid(),
						 testeQualidade.getMic(),
						 testeQualidade.getMat(),
						 testeQualidade.getUi(),
						 testeQualidade.getSf(),
						 testeQualidade.getElg(),
						 testeQualidade.getMst(),
						 testeQualidade.getTipo(),
						 testeQualidade.getSic(),
						 testeQualidade.getUhml(),
						 testeQualidade.getRs(),
						 testeQualidade.getB(),
						 testeQualidade.getTrcnt(),
						 testeQualidade.getTrar(),
						 testeQualidade.getTipoMic() ,
						 testeQualidade.getStr(),
						 testeQualidade.getSc()  
						 );
				   
			 }  
			 	
			 return obj;
		}			
		
		
		public Integer buscaMovimentoDePilha(String idfil, String produtor , String lote, String item){
			
			Integer movItem = repo.buscaMovimentoDePilha(idfil, produtor, lote, item); 
			return movItem;
		}		
		
		
 		 
		public String classificaMIC(Double pMic) {
			
			String classifMIC;
			
			BigDecimal nMic = BigDecimal.valueOf(pMic).setScale(2, RoundingMode.HALF_UP); 
			
			
			BigDecimal faixa01Ini = new BigDecimal("2.90"); 
	        BigDecimal faixa01Fim = new BigDecimal("3.30"); 
	        BigDecimal faixa02Fim = new BigDecimal("3.70");
	        
	        
	        BigDecimal faixa03Fim = new BigDecimal("4.10"); 
	        BigDecimal faixa04Fim = new BigDecimal("4.50");
	        BigDecimal faixa05Fim = new BigDecimal("4.90"); 
	        BigDecimal faixa06Fim = new BigDecimal("5.30");
	        BigDecimal faixa07Fim = new BigDecimal("5.70");
	        
	        
	        
	        classifMIC = " ";
			if(pMic == null || pMic.equals(0.00)) {				
				classifMIC = " ";		        
			}else if (nMic.compareTo(faixa01Ini) < 0 ) {
				classifMIC = "A";	
	        }else if (nMic.compareTo(faixa01Ini) >= 0 && nMic.compareTo(faixa01Fim) < 0) {
				classifMIC = "B";	
	        }else if (nMic.compareTo(faixa01Fim) >= 0 && nMic.compareTo(faixa02Fim) < 0) {
				classifMIC = "C";	
	        }else if (nMic.compareTo(faixa02Fim) >= 0 && nMic.compareTo(faixa03Fim) < 0) {
				classifMIC = "D";	
	        }else if (nMic.compareTo(faixa03Fim) >= 0 && nMic.compareTo(faixa04Fim) < 0) {
				classifMIC = "E";	
	        }else if (nMic.compareTo(faixa04Fim) >= 0 && nMic.compareTo(faixa05Fim) < 0) {
				classifMIC = "F";	
	        }else if (nMic.compareTo(faixa05Fim) >= 0 && nMic.compareTo(faixa06Fim) < 0) {
				classifMIC = "G";	
	        }else if (nMic.compareTo(faixa06Fim) >= 0 && nMic.compareTo(faixa07Fim) < 0) {
				classifMIC = "H";	
	        }else if (nMic.compareTo(faixa07Fim) >= 0 ) {
				classifMIC = "I";	
	        }   
			
	 
			return classifMIC;
			
			
		}
		
		public Boolean validaLimitesTeste(TesteQualidade testeQualidade) throws ParseException,ObjectNotFoundException{
			
			Boolean validado;
			validado = false;
			
			 
			BigDecimal faixaMstIni = new BigDecimal("0.1"); 
	        BigDecimal faixaMstFim = new BigDecimal("9.9");  
	        BigDecimal nMst = BigDecimal.valueOf(testeQualidade.getMst() ).setScale(1, RoundingMode.HALF_UP); 
	         
	        
			BigDecimal faixaMicIni = new BigDecimal("0.01"); 
	        BigDecimal faixaMicFim = new BigDecimal("9.99");  
	        BigDecimal nMic = BigDecimal.valueOf(testeQualidade.getMic() ).setScale(2, RoundingMode.HALF_UP); 	        
			
			BigDecimal faixaMatIni = new BigDecimal("0.01"); 
	        BigDecimal faixaMatFim = new BigDecimal("9.99");  
	        BigDecimal nMat = BigDecimal.valueOf(testeQualidade.getMat() ).setScale(2, RoundingMode.HALF_UP); 	

	        
			BigDecimal faixaUhmlIni ; 
	        BigDecimal faixaUhmlFim;  
	        BigDecimal nUhml ; 	  
	        
	        BigDecimal faixaTrCntIni; 
            BigDecimal faixaTrCntFim;  
    
			BigDecimal faixaTrarIni; 
	        BigDecimal faixaTrarFim;  	        
	        
	        BigDecimal nTrCnt;
	        BigDecimal nTrar;
	        
	        
	        
	        
	        
	        if(testeQualidade.getIdfil().equals("05")) {
				faixaUhmlIni = new BigDecimal("0.001"); 
		        faixaUhmlFim = new BigDecimal("99.999");  
		        nUhml = BigDecimal.valueOf(testeQualidade.getUhml() ).setScale(3, RoundingMode.HALF_UP); 
	        }else {
				faixaUhmlIni = new BigDecimal("0.001"); 
		        faixaUhmlFim = new BigDecimal("9.990");  
		        nUhml = BigDecimal.valueOf(testeQualidade.getUhml() ).setScale(3, RoundingMode.HALF_UP); 	        	
	        }
	        
			BigDecimal faixaUiIni = new BigDecimal("0.1"); 
	        BigDecimal faixaUiFim = new BigDecimal("99.9");  
	        BigDecimal nUi = BigDecimal.valueOf(testeQualidade.getUi() ).setScale(1, RoundingMode.HALF_UP); 
	        
			BigDecimal faixaSfIni = new BigDecimal("0.1"); 
	        BigDecimal faixaSfFim = new BigDecimal("99.9");  
	        BigDecimal nSf = BigDecimal.valueOf(testeQualidade.getSf() ).setScale(1, RoundingMode.HALF_UP); 	        
	        
	        BigDecimal faixaStrIni = new BigDecimal("0.1"); 
	        BigDecimal faixaStrFim = new BigDecimal("99.9");  
	        BigDecimal nStr = BigDecimal.valueOf(testeQualidade.getStr() ).setScale(1, RoundingMode.HALF_UP);	 
	        
			BigDecimal faixaElgIni = new BigDecimal("0.1"); 
	        BigDecimal faixaElgFim = new BigDecimal("9.9");  
	        BigDecimal nElg = BigDecimal.valueOf(testeQualidade.getElg() ).setScale(1, RoundingMode.HALF_UP); 	
	        
			BigDecimal faixaRdIni = new BigDecimal("0.1"); 
	        BigDecimal faixaRdFim = new BigDecimal("99.9");  
	        BigDecimal nRd = BigDecimal.valueOf(testeQualidade.getRs() ).setScale(1, RoundingMode.HALF_UP);	        
	        
			BigDecimal faixaBIni = new BigDecimal("0.1"); 
	        BigDecimal faixaBFim = new BigDecimal("99.9");  
	        BigDecimal nB = BigDecimal.valueOf(testeQualidade.getB() ).setScale(1, RoundingMode.HALF_UP); 	
	        
			BigDecimal faixaTipoIni = new BigDecimal("0.1"); 
	        BigDecimal faixaTipoFim = new BigDecimal("99.9");  
	        BigDecimal nTipo = BigDecimal.valueOf(testeQualidade.getTipo() ).setScale(1, RoundingMode.HALF_UP); 	
	        
	        if(testeQualidade.getIdfil().equals("05")) {
			   faixaTrCntIni = new BigDecimal("0.1"); 
	           faixaTrCntFim = new BigDecimal("999.9");  
	            nTrCnt = BigDecimal.valueOf(testeQualidade.getTrcnt() ).setScale(1, RoundingMode.HALF_UP);
	        }else {
				   faixaTrCntIni = new BigDecimal("0.1"); 
		           faixaTrCntFim = new BigDecimal("99.9");  
		            nTrCnt = BigDecimal.valueOf(testeQualidade.getTrcnt() ).setScale(1, RoundingMode.HALF_UP);	        	   
	        	   
	           }
	        if(testeQualidade.getIdfil().equals("05")) {	        
				faixaTrarIni = new BigDecimal("0.01"); 
		        faixaTrarFim = new BigDecimal("99.99");  
		         nTrar = BigDecimal.valueOf(testeQualidade.getTrar() ).setScale(2, RoundingMode.HALF_UP); 
	        }else {
		        	
					faixaTrarIni = new BigDecimal("0.01"); 
			        faixaTrarFim = new BigDecimal("9.99");  
			        nTrar = BigDecimal.valueOf(testeQualidade.getTrar() ).setScale(2, RoundingMode.HALF_UP); 		        	
		        }
	        
			BigDecimal faixaSacIni = new BigDecimal("0.1"); 
	        BigDecimal faixaSacFim = new BigDecimal("9.9");  
	        BigDecimal nSac = BigDecimal.valueOf(testeQualidade.getSac() ).setScale(1, RoundingMode.HALF_UP); 	        

			BigDecimal faixaPimIni = new BigDecimal("0.1"); 
	        BigDecimal faixaPimFim = new BigDecimal("9.9");  
	        BigDecimal nPim = BigDecimal.valueOf(testeQualidade.getPim() ).setScale(1, RoundingMode.HALF_UP);	  
	        
			BigDecimal faixaScIni = new BigDecimal("0.1"); 
	        BigDecimal faixaScFim = new BigDecimal("9.9");  
	        BigDecimal nSc = BigDecimal.valueOf(testeQualidade.getSc() ).setScale(1, RoundingMode.HALF_UP);		        
	         
			
	        /// Sic
			if(!(testeQualidade.getSic() < 0)) {
				
				if(!testeQualidade.getSic().equals(0.0)) {
					
					if (!(testeQualidade.getSic()  >  0 && testeQualidade.getSic()  < 1000)) { 
						throw new ObjectNotFoundException("Valor do SCI invalido.");					
					}else {
						validado = true;
					}
					
				}
				
			}else {
				throw new ObjectNotFoundException("Valor do SIC invalido.");
			} 			
 
	        /// MST
			if(!(testeQualidade.getMst() < 0)) {
				
				if(!testeQualidade.getMst().equals(0.0)) {
					if (!(nMst.compareTo(faixaMstIni) >= 0 && nMst.compareTo(faixaMstFim) <= 0)) {  
						throw new ObjectNotFoundException("Valor do MST invalido.");					
					}else {
						validado = true;
					} 
				}
				
			}else {
				throw new ObjectNotFoundException("Valor do MST invalido.");
			} 
			
			
			/// MIC
			if(!(testeQualidade.getMic()<0)) {
				
				if(!testeQualidade.getMic().equals(0.0)) {
					if (!(nMic.compareTo(faixaMicIni) >= 0 && nMic.compareTo(faixaMicFim) <= 0)) {  
						throw new ObjectNotFoundException("Valor do MIC invalido.");					
					}else {
						validado = true;
					} 
				}			
				
			}else {
				throw new ObjectNotFoundException("Valor do MIC invalido.");
			}	
			
			
   		    /// MAT	
			if(!(testeQualidade.getMat()<0)) {
				
				if(!testeQualidade.getMat().equals(0.0)) {
					if (!(nMat.compareTo(faixaMatIni) >= 0 && nMat.compareTo(faixaMatFim) <= 0)) {  
						throw new ObjectNotFoundException("Valor do MAT invalido.");					
					}else {
						validado = true;
					} 
				}			
				
			}else {
				throw new ObjectNotFoundException("Valor do MAT invalido.");
			}			
			 		
   		    /// UHML	
			if(!(testeQualidade.getUhml()<0)) {
				
				if(!testeQualidade.getUhml().equals(0.0)) {
					if (!(nUhml.compareTo(faixaUhmlIni) >= 0 && nUhml.compareTo(faixaUhmlFim) <= 0)) {  
						throw new ObjectNotFoundException("Valor do UHML invalido.");					
					}else {
						validado = true;
					} 
				}			
				
			}else {
				throw new ObjectNotFoundException("Valor do UHML invalido.");
			}
			
   		    /// UI	
			if(!(testeQualidade.getUi()<0)) {
				
				if(!testeQualidade.getUi().equals(0.0)) {
					if (!(nUi.compareTo(faixaUiIni) >= 0 && nUi.compareTo(faixaUiFim) <= 0)) {  
						throw new ObjectNotFoundException("Valor do UI invalido.");					
					}else {
						validado = true;
					} 
				}			
				
			}else {
				throw new ObjectNotFoundException("Valor do UI invalido.");
			}	
			
			
   		    /// SF	 
			if(!(testeQualidade.getSf()<0)) {
				
				if(!testeQualidade.getSf().equals(0.0)) {
					if (!(nSf.compareTo(faixaSfIni) >= 0 && nSf.compareTo(faixaSfFim) <= 0)) {  
						throw new ObjectNotFoundException("Valor do SF invalido.");					
					}else {
						validado = true;
					} 
				}			
				
			}else {
				throw new ObjectNotFoundException("Valor do SF invalido.");
			}
			
   		    /// STR	
			if(!(testeQualidade.getStr()<0)) {
				
				if(!testeQualidade.getStr().equals(0.0)) {
					if (!(nStr.compareTo(faixaStrIni) >= 0 && nStr.compareTo(faixaStrFim) <= 0)) {  
						throw new ObjectNotFoundException("Valor do STR invalido.");					
					}else {
						validado = true;
					} 
				}			
				
			}else {
				throw new ObjectNotFoundException("Valor do STR invalido.");
			}			
			
			
   		    /// ELG	
			if(!(testeQualidade.getElg()<0)) {
				
				if(!testeQualidade.getElg().equals(0.0)) {
					if (!(nElg.compareTo(faixaElgIni) >= 0 && nElg.compareTo(faixaElgFim) <= 0)) {  
						throw new ObjectNotFoundException("Valor do ELG invalido.");					
					}else {
						validado = true;
					} 
				}			
				
			}else {
				throw new ObjectNotFoundException("Valor do ELG invalido.");
			} 
			
   		    /// RD	
			if(!(testeQualidade.getRs()<0)) {
				
				if(!testeQualidade.getRs().equals(0.0)) {
					if (!(nRd.compareTo(faixaRdIni) >= 0 && nRd.compareTo(faixaRdFim) <= 0)) {  
						throw new ObjectNotFoundException("Valor do RD invalido.");					
					}else {
						validado = true;
					} 
				}			
				
			}else {
				throw new ObjectNotFoundException("Valor do RD invalido.");
			}			
			
			
   		    /// B	
			if(!(testeQualidade.getB()<0)) {
				
				if(!testeQualidade.getB().equals(0.0)) {
					if (!(nB.compareTo(faixaBIni) >= 0 && nB.compareTo(faixaBFim) <= 0)) {  
						throw new ObjectNotFoundException("Valor do +B invalido.");					
					}else {
						validado = true;
					} 
				}			
				
			}else {
				throw new ObjectNotFoundException("Valor do +B invalido.");
			}
			
   		    /// Tipo	
			if(!(testeQualidade.getTipo()<0)) {
				
				if(!testeQualidade.getTipo().equals(0.0)) {
					if (!(nTipo.compareTo(faixaTipoIni) >= 0 && nTipo.compareTo(faixaTipoFim) <= 0)) {  
						throw new ObjectNotFoundException("Valor do TIPO invalido.");					
					}else {
						validado = true;
					} 
				}			
				
			}else {
				throw new ObjectNotFoundException("Valor do TIPO invalido.");
			}			
			
			
   		    /// Trcnt	
			if(!(testeQualidade.getTrcnt()<0)) {
				
				if(!testeQualidade.getTrcnt().equals(0.0)) {
					if (!(nTrCnt.compareTo(faixaTrCntIni) >= 0 && nTrCnt.compareTo(faixaTrCntFim) <= 0)) {  
						throw new ObjectNotFoundException("Valor do TrCnt invalido.");					
					}else {
						validado = true;
					} 
				}			
				
			}else {
				throw new ObjectNotFoundException("Valor do TrCnt invalido.");
			}	
			
   		    /// TrAr	
			if(!(testeQualidade.getTrar()<0)) {
				
				if(!testeQualidade.getTrar().equals(0.0)) {
					if (!(nTrar.compareTo(faixaTrarIni) >= 0 && nTrar.compareTo(faixaTrarFim) <= 0)) {  
						throw new ObjectNotFoundException("Valor do TrAr invalido.");					
					}else {
						validado = true;
					} 
				}			
				
			}else {
				throw new ObjectNotFoundException("Valor do TrAr invalido.");
			}				
			
			
			
   		    /// Sac	
			if(!(testeQualidade.getSac()<0)) {
				
				if(!testeQualidade.getSac().equals(0.0)) {
					if (!(nSac.compareTo(faixaSacIni) >= 0 && nSac.compareTo(faixaSacFim) <= 0)) {  
						throw new ObjectNotFoundException("Valor do SAC invalido.");					
					}else {
						validado = true;
					} 
				}			
				
			}else {
				throw new ObjectNotFoundException("Valor do SAC invalido.");
			}
			
			
   		    /// Pim	
			if(!(testeQualidade.getPim()<0)) {
				
				if(!testeQualidade.getPim().equals(0.0)) {
					if (!(nPim.compareTo(faixaPimIni) >= 0 && nPim.compareTo(faixaPimFim) <= 0)) {  
						throw new ObjectNotFoundException("Valor do PIM invalido.");					
					}else {
						validado = true;
					} 
				}			
				
			}else {
				throw new ObjectNotFoundException("Valor do PIM invalido.");
			}			
			
			
   		    /// Sc	
			if(!(testeQualidade.getSc()<0)) {
				
				if(!testeQualidade.getSc().equals(0.0)) {
					if (!(nSc.compareTo(faixaScIni) >= 0 && nSc.compareTo(faixaScFim) <= 0)) {  
						throw new ObjectNotFoundException("Valor do SC invalido.");					
					}else {
						validado = true;
					} 
				}			
				
			}else {
				throw new ObjectNotFoundException("Valor do SC invalido.");
			}				
			
			
			return validado;
			
			
			
		}
 



}
