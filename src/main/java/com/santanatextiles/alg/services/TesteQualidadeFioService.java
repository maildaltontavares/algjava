package com.santanatextiles.alg.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.TesteQualidadeFio;
import com.santanatextiles.alg.dto.TesteQualidadeFioDTO;
import com.santanatextiles.alg.dto.TesteQualidadeFioDetalheDTO;
import com.santanatextiles.alg.dto.TesteQualidadeFioProjectionDTO;
import com.santanatextiles.alg.projections.TesteQualidadeFioProjection;
import com.santanatextiles.alg.repositories.TesteQualidadeFioRepository;
import com.santanatextiles.alg.resources.exception.ObjectNotFoundException; 
	
	
@Service
public class TesteQualidadeFioService { 
	
		@Autowired
		private TesteQualidadeFioRepository repo;	  
		
		@Autowired
		private TesteQualidadeFioDetalheService serviceDetalhe;		
		
		@Autowired
		private MaquinaService maquinaService;				
		
		private ArrayList<String> msg = new ArrayList<>(); 
		 
		public List<TesteQualidadeFio> buscaTesteQualidadeFioPorParametros(String filial ){ 
			 List<TesteQualidadeFio> obj = repo.buscaTesteQualidadeFioPorParametros(filial ) ;	  
			 return obj;
		}	
		
		@Transactional
		public  Double  insert(TesteQualidadeFioDTO obj ){  
			
			   verificaEntidades(obj); 
				
				if (!this.msg.isEmpty()) {
					throw new ObjectNotFoundException(String.join(",", this.msg)); 
				}	 
			
			    Double novoCodigoAutomaticoCab = null; 
			    TesteQualidadeFio testeCqFio = fromDTO(obj);  
				
				novoCodigoAutomaticoCab = repo.codigoNovoTeste();	 
				testeCqFio.setId(novoCodigoAutomaticoCab);
				testeCqFio.setDataAlteracao(null); 
				
				repo.save(testeCqFio);   
				
				
				
				Iterator<TesteQualidadeFioDetalheDTO> it = obj.getTesteQualidadeFioDetalheDTO().iterator();

				while (it.hasNext()) {
					
					TesteQualidadeFioDetalheDTO resultadoTeste = it.next();

					//TesteQualidadeFioDetalhe ItemDetalhe = serviceDetalhe.insereResultado(resultadoTeste,novoCodigoAutomaticoCab) ;
					
					serviceDetalhe.insereResultado(resultadoTeste,novoCodigoAutomaticoCab) ;
					

				}
				
				
				
				
				
			    return novoCodigoAutomaticoCab;
			 
		}	
		
		@Transactional
		public  TesteQualidadeFio  update(TesteQualidadeFioDTO obj ) throws ParseException{ 
			 
			 LocalDate dataAtual = LocalDate.now();
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
			 String dataFormatada = dataAtual.format(formatter); 
			 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		     obj.setDataAlteracao(dateFormat.parse(dataFormatada)); 
			 
			 TesteQualidadeFio testeCqFio = null;
			 
			 if(obj.getId()!=null || !obj.getId().equals(0)) {  
			  	 
			 	 testeCqFio = fromDTO(obj);   
			 	 
			 }else {
			 	 
			 	 throw new ObjectNotFoundException("ERRO DE GRAVACAO. CONTATE O ADMINISTADOR DO SISTEMA!"); 
			 }
			 
			 repo.save(testeCqFio);  
			 
			 serviceDetalhe.deletaResultado(obj.getIdfil(),obj.getId());
			 
			Iterator<TesteQualidadeFioDetalheDTO> it = obj.getTesteQualidadeFioDetalheDTO().iterator();

			while (it.hasNext()) {
				
				TesteQualidadeFioDetalheDTO resultadoTeste = it.next();

				//TesteQualidadeFioDetalhe ItemDetalhe = serviceDetalhe.insereResultado(resultadoTeste,obj.getId());
				
				serviceDetalhe.insereResultado(resultadoTeste,obj.getId());
				

			}			 
			 
			 
			 
			 return testeCqFio;
			 
		}			
				
		
		
		
		public  TesteQualidadeFio  buscaTesteQualidadeFioPorChave(TesteQualidadeFioDTO obj )  throws ParseException{ 
			
			 TesteQualidadeFio testeCqFio;
			 
			 if(obj.getId()==null || obj.getId().equals(0.0) ) {
				 
				 
					//if(obj.getLadoMaquina()==null) {
					//	obj.setLadoMaquina("U"); 
					//} 				 
				 
					
			     obj.setPosicaoMaquina("9999999999");
			     
			     testeCqFio = repo.buscaTesteQualidadeFioPorChave(
					 obj.getIdfil(),
					 obj.getCodigoMaquina().substring(2,4),
					 obj.getDataTesteParam(),
					 obj.getLocalFisico(), 
					 obj.getLadoMaquina(),
					 obj.getTurno(),
					 obj.getItem(),
					 obj.getTipoTesteFiacao(),
					 obj.getHora(),
					 obj.getPosicaoMaquina()
				  
					 ) ;	 
			 }else {
				 testeCqFio = findById(obj.getId());
			 }
			 return testeCqFio;
			 
		}	 
		
		
		
		public  TesteQualidadeFio  findById(Double id ){ 
			
			 TesteQualidadeFio testeCqFio = repo.findById(id) ;	  
			 return testeCqFio;
			 
		}	
		
		public List<TesteQualidadeFioProjectionDTO> pesquisaTesteQualidadeFioPorParametros(TesteQualidadeFioDTO obj) { 
			
			List<TesteQualidadeFioProjection> testeQualidadeFioP = repo.pesquisaTesteQualidadeFioPorParametros(
		        		obj.getIdfil(),
		        		obj.getDataInicial(),
		        		obj.getDataFinal(),
		        		obj.getTipoMaquina(),
		        		obj.getTurno(),
		        		obj.getLocalFisico(),         
		        		obj.getLoteFiacao() ,
		        		obj.getItem() 
             		);  

			List<TesteQualidadeFioProjectionDTO> listaTesteQualidadeFio = testeQualidadeFioP.stream()
					.map(x -> new TesteQualidadeFioProjectionDTO(x)).toList();

			List<TesteQualidadeFioProjectionDTO> aTesteQualidadeFioEnd = new ArrayList<>(); 

			for (TesteQualidadeFioProjectionDTO testeQualidadeFioEndDTO : listaTesteQualidadeFio) {
				
				TesteQualidadeFioProjectionDTO testeQualidadeFioEnd = new TesteQualidadeFioProjectionDTO();

				testeQualidadeFioEnd.setIdfil(testeQualidadeFioEndDTO.getIdfil()); 
				testeQualidadeFioEnd.setLoteFiacao(testeQualidadeFioEndDTO.getLoteFiacao()); 
				testeQualidadeFioEnd.setTurno(testeQualidadeFioEndDTO.getTurno()); 
				testeQualidadeFioEnd.setDescTipoMaquina(testeQualidadeFioEndDTO.getDescTipoMaquina());  
				testeQualidadeFioEnd.setMaquina(testeQualidadeFioEndDTO.getMaquina()); 
				testeQualidadeFioEnd.setLado(testeQualidadeFioEndDTO.getLado()); 
				testeQualidadeFioEnd.setItem(testeQualidadeFioEndDTO.getItem());  
				testeQualidadeFioEnd.setDescTipoTeste(testeQualidadeFioEndDTO.getDescTipoTeste()); 
				testeQualidadeFioEnd.setId(testeQualidadeFioEndDTO.getId()); 
				testeQualidadeFioEnd.setDataTeste(testeQualidadeFioEndDTO.getDataTeste());    
				testeQualidadeFioEnd.setDataInclusao(testeQualidadeFioEndDTO.getDataInclusao());  
				testeQualidadeFioEnd.setTipoMaquina(testeQualidadeFioEndDTO.getTipoMaquina());  
				
				testeQualidadeFioEnd.setHora(testeQualidadeFioEndDTO.getHora());
				testeQualidadeFioEnd.setPosicaoMaquina(testeQualidadeFioEndDTO.getPosicaoMaquina());
				
				aTesteQualidadeFioEnd.add(testeQualidadeFioEnd);

			}

			return aTesteQualidadeFioEnd;
		}
		
		
		
		public TesteQualidadeFio fromDTO(TesteQualidadeFioDTO obj) { 
			
		 
			
			TesteQualidadeFio oTesteQualidadeFio = new TesteQualidadeFio(); 
			
			oTesteQualidadeFio.setId(obj.getId()); 
			oTesteQualidadeFio.setIdfil(obj.getIdfil()); 
			oTesteQualidadeFio.setLoteFiacao(obj.getLoteFiacao()); 
			oTesteQualidadeFio.setTurno(obj.getTurno());  
			oTesteQualidadeFio.setCodigoMaquina(obj.getCodigoMaquina()); 
			oTesteQualidadeFio.setLadoMaquina(obj.getLadoMaquina());  
			
			oTesteQualidadeFio.setItem(obj.getItem());  	 			
			oTesteQualidadeFio.setDataTeste(obj.getDataTeste());    
			oTesteQualidadeFio.setDataInclusao(obj.getDataInclusao());
			oTesteQualidadeFio.setDataAlteracao(obj.getDataAlteracao()); 
			oTesteQualidadeFio.setTipoTesteFiacao(obj.getTipoTesteFiacao());
			oTesteQualidadeFio.setDobradora(obj.getDobradora());    
			oTesteQualidadeFio.setOperador(obj.getOperador());
			oTesteQualidadeFio.setLocalFisico(obj.getLocalFisico());
			oTesteQualidadeFio.setEstiragem(obj.getEstiragem());
			oTesteQualidadeFio.setUsuarioInclusao(obj.getUsuarioInclusao());
			oTesteQualidadeFio.setUsuarioAlteracao(obj.getUsuarioAlteracao());    
			oTesteQualidadeFio.setObservacao(obj.getObservacao());    
			oTesteQualidadeFio.setHora(obj.getHora()); 
			oTesteQualidadeFio.setPosicaoMaquina("9999999999");  
			
	 
			
			if(obj.getLadoMaquina()==null) {
				oTesteQualidadeFio.setLadoMaquina("U"); 
			} 
			
			return oTesteQualidadeFio;
			
		     
		}
		
		public Double codigoNovoTeste(){	 
		  	 Double obj = repo.codigoNovoTeste() ;	  
			 return obj;
		}	
		
		@Transactional
		public void delete(Double id){
			
			repo.deletaDetalheTeste(id);
			repo.deletaTeste(id);
			
		  	 
		}			
		
		 
		
		 private void verificaEntidades(TesteQualidadeFioDTO obj) {			 
			    
			 
			    String pLado = null;
			    this.msg.clear();
			    
			    if(obj.getTipoMaquina().equals("04")  ) {
				
			    	if(obj.getLadoMaquina().equals("A") || obj.getLadoMaquina().equals("B")) {
				    	pLado = "D";
				    }else if(obj.getLadoMaquina().equals("U") ) {
				    	pLado = "U"; 
				    }else {
				    	pLado = null; 
				    	this.msg.add("Lado maquina invalido");
				    }
			    	
				 
			    }
			    
				try {
					
					if(obj.getTipoMaquina().equals("04")  ) {
						if(pLado!=null) {
							if(maquinaService.buscaMaquinaPorCodigoLado(obj.getIdfil(), obj.getCodigoMaquina(), pLado) == null) {
								  this.msg.add("Máquina/Lado não encontrado");
						    }   
						}
					}		
					
	 
					 
				}			
				catch (Exception e) {			
				}
				return; 			 
		 }			
		
		
		
	// Maquina buscaMaquinaPorCodigoLado(String filial, String maquina, String lado) 

}
