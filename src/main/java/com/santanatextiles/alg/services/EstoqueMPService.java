package com.santanatextiles.alg.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.EstoqueMP;
import com.santanatextiles.alg.domain.MovimentoItem;
import com.santanatextiles.alg.dto.EstoqueMPDTO;
import com.santanatextiles.alg.dto.MisturaProjectionDTO;
import com.santanatextiles.alg.dto.MovimentoDTO;
import com.santanatextiles.alg.dto.MovimentoItemDTO;
import com.santanatextiles.alg.dto.SaldoIdMovtoDTO;
import com.santanatextiles.alg.dto.SaldoPesquisaIdDTO;
import com.santanatextiles.alg.projections.MisturaPadraoProjection;
import com.santanatextiles.alg.projections.SaldoIdMovtoProjection;
import com.santanatextiles.alg.projections.SaldoPesquisaIdProjection;
import com.santanatextiles.alg.repositories.EstoqueMPRepository;
import com.santanatextiles.alg.resources.exception.ObjectNotFoundException; 
	
@Service
public class EstoqueMPService { 
	 
	
	@Autowired
	private EstoqueMPRepository repo; 
	
	@Value("${spring.datasource.url}")
	private String JDBC_URL;
	
	@Value("${spring.datasource.username}")
	private String JDBC_USER;

	@Value("${spring.datasource.password}") 
	private String JDBC_PASSWORD;			
	
	public List<EstoqueMP> buscaEstoqueMPPorParametros(String filial ){	   
		 List<EstoqueMP> obj = repo.buscaEstoqueMPPorParametros(filial ) ;	  
		 return obj;
	}		
	
	
	
	
	@Transactional
	public List<EstoqueMPDTO> atualizaPilha(List<EstoqueMPDTO> estoqueMPDTO) {		
		
		Iterator<EstoqueMPDTO> it = estoqueMPDTO.iterator();

		while (it.hasNext()) {
			
			EstoqueMPDTO estDTO = it.next();

			int atlzPilha = repo.atualizaPilha(estDTO.getIdfil(),estDTO.getId(),estDTO.getPilha());

		}
		 
		
		return estoqueMPDTO;
	}; 
	
	public SaldoPesquisaIdDTO buscaEstoqueMPPorId(Double id ){ 
		
		List<SaldoPesquisaIdProjection> saldoPesquisaIdP = repo.buscaEstoqueMPPorId(id); 
		
		List<SaldoPesquisaIdDTO> listaSaldoPesquisaId = saldoPesquisaIdP.stream().map(x-> new SaldoPesquisaIdDTO(x)).toList();  		
		
		SaldoPesquisaIdDTO saldoPesquisaId = new SaldoPesquisaIdDTO(); 
		
		for (SaldoPesquisaIdDTO saldoPesquisaIdDTO : listaSaldoPesquisaId) {
			
			saldoPesquisaId.setIdMov(saldoPesquisaIdDTO.getIdMov());
			saldoPesquisaId.setLote(saldoPesquisaIdDTO.getLote());
			saldoPesquisaId.setTamanho(saldoPesquisaIdDTO.getTamanho());
			saldoPesquisaId.setPesoMedio(saldoPesquisaIdDTO.getPesoMedio());
			saldoPesquisaId.setItem(saldoPesquisaIdDTO.getItem());
			saldoPesquisaId.setNomeItem(saldoPesquisaIdDTO.getNomeItem());
			saldoPesquisaId.setPilha(saldoPesquisaIdDTO.getPilha());
			saldoPesquisaId.setUm(saldoPesquisaIdDTO.getUm());
			saldoPesquisaId.setQtde(saldoPesquisaIdDTO.getQtde());
			saldoPesquisaId.setProdutor(saldoPesquisaIdDTO.getProdutor());
			
			saldoPesquisaId.setNmForn(saldoPesquisaIdDTO.getNmForn());
			saldoPesquisaId.setProcedencia(saldoPesquisaIdDTO.getProcedencia());
			saldoPesquisaId.setNf(saldoPesquisaIdDTO.getNf());
			saldoPesquisaId.setFornecedor(saldoPesquisaIdDTO.getFornecedor());			
			saldoPesquisaId.setTipoQualidade(saldoPesquisaIdDTO.getTipoQualidade()); 
			saldoPesquisaId.setClassifQualidade(saldoPesquisaIdDTO.getClassifQualidade());
			saldoPesquisaId.setQualidade(saldoPesquisaIdDTO.getTipoQualidade() + ' ' + saldoPesquisaIdDTO.getClassifQualidade()) ;
			
			saldoPesquisaId.setLoteAdicional(saldoPesquisaIdDTO.getLoteAdicional());
			saldoPesquisaId.setColoracao(saldoPesquisaIdDTO.getColoracao());
			saldoPesquisaId.setIdVolume(saldoPesquisaIdDTO.getIdVolume()); 
			saldoPesquisaId.setTipoMic(saldoPesquisaIdDTO.getTipoMic());
			saldoPesquisaId.setDestino(saldoPesquisaIdDTO.getDestino());
			saldoPesquisaId.setCorteza(saldoPesquisaIdDTO.getCorteza()); 
			 		
         }	 
	   
		  return saldoPesquisaId;
	}		
	
	 
	public List<EstoqueMP> buscaEstoqueMP() {  
		 List<EstoqueMP> obj = repo.findAll();
		return obj ;
	}	

	
	public List<EstoqueMP> buscaEstoqueMPByFilial(String filial) {  
		 List<EstoqueMP> obj = repo.findByIdfil(filial);
		return obj ;
	}	 
	
	public EstoqueMP findById(Double id) {  
		  EstoqueMP  obj = repo.findById(id);
		return obj ;
	}	
 	
	
	public Integer atualizaEstoque(String idfil , Double idMovto , Double quantidade , Double peso , Double vlEstoque , Double pesoMedio , String atualizaIt   )   {
		
		Integer idEst; 
		 
		// Valida consistencia na M4
		EstoqueMP validaId = findById(idMovto);  // 06/08/2024
		
		if(validaId==null) {
			throw new ObjectNotFoundException("Registro de estoque não pode ser gravado. Comunique ao analista resposavel.");			
		}
		
		 
		if(atualizaIt.equals("S")) { 
			 idEst =   repo.atualizaEstoqueEPesoMedio(idfil, idMovto, quantidade, peso, vlEstoque , pesoMedio);	
		 
		}else {
			 idEst =  repo.atualizaEstoque(idfil, idMovto, quantidade, peso, vlEstoque );	
		}
		 
		return idEst;
		
	}
	
 
	public EstoqueMP insert (MovimentoItem obj, String atualizaEstoque ){ 
		
	        String nf = String.format("%-10s", obj.getNotaFiscal());  
	        obj.setNotaFiscal(nf);   
	    	
		    EstoqueMP itemEstoque = new EstoqueMP();  
		    
		    itemEstoque.setIdfil(obj.getIdfil()); 
		    itemEstoque.setNotaFiscal(obj.getNotaFiscal());	 
		    itemEstoque.setFornecedor(obj.getFornecedor());	  
		    itemEstoque.setItem(obj.getItem());
		    itemEstoque.setProdutor(obj.getProdutor());
		    itemEstoque.setProcedencia(obj.getProcedencia());	 
		    itemEstoque.setLote(obj.getLote());
		    itemEstoque.setQualidade(obj.getQualidade());
		    itemEstoque.setTamanho(obj.getTamanho());
		    itemEstoque.setDescFio(obj.getDescFio());	
		    
		    
		    if(atualizaEstoque.equals("S")) {
			    itemEstoque.setQuantidade(obj.getQuantidade()); 
			    itemEstoque.setPeso(obj.getPeso());	 		 
			    itemEstoque.setValorEstoque(obj.getVlUnitario() * obj.getQuantidade()); 	
		    	
		    }else {
			    itemEstoque.setQuantidade(0.0); 
			    itemEstoque.setPeso(0.0);	 	
			    itemEstoque.setValorEstoque(0.0); 
		    	
		    }
 
		    
		    itemEstoque.setId(obj.getIdItem());	 
		    itemEstoque.setUnidadeMedida(obj.getUnidadeMedida()); 
		    itemEstoque.setPilha(obj.getPilha());
		     
		    itemEstoque.setDataInclusao(obj.getDataInclusao());
		    itemEstoque.setDataAlteracao(obj.getDataAlteracao());	 
		    itemEstoque.setUsuarioInclusao(obj.getUsuarioInclusao());
		    
		    itemEstoque.setUsuarioAlteracao(obj.getUsuarioAlteracao()); 
		    itemEstoque.setPesoMedio(obj.getPesoMedio());
		    itemEstoque.setSac(obj.getSac());
		    itemEstoque.setTrid(obj.getTrid());
		    itemEstoque.setPim(obj.getPim());
		    itemEstoque.setSc(obj.getSc());	 
		    itemEstoque.setMst(obj.getMst()); 
		    itemEstoque.setMic(obj.getMic());	 
		    itemEstoque.setMat(obj.getMat());	  
		    itemEstoque.setUi(obj.getUi());
		    itemEstoque.setSf(obj.getSf());	 
		    itemEstoque.setStr(obj.getStr());	 
		    itemEstoque.setElg(obj.getElg());	 
		    itemEstoque.setTipo(obj.getTipo());	 
		    itemEstoque.setSic(obj.getSic());	   
		    itemEstoque.setUhml(obj.getUhml());
		    itemEstoque.setRs(obj.getRs());	 
		    itemEstoque.setB(obj.getB());	 
		    itemEstoque.setTrcnt(obj.getTrcnt());	 
		    itemEstoque.setTrar(obj.getTrar());	  	
		    
		    itemEstoque.setTipoQualidade(obj.getTipoQualidade()); 
		    itemEstoque.setClassifQualidade(obj.getClassifQualidade());
		    itemEstoque.setQualidade(obj.getTipoQualidade() + ' ' + obj.getClassifQualidade()) ;
		    itemEstoque.setLoteAdicional(obj.getLoteAdicional());  
		    itemEstoque.setColoracao(obj.getColoracao());
			itemEstoque.setIdVolume(obj.getIdVolume()); 
			itemEstoque.setTipoMic(obj.getTipoMic());
			itemEstoque.setDestino(obj.getDestino());
			itemEstoque.setCorteza(obj.getCorteza()); 
		    
		    
		    EstoqueMP  objEstoqueMP = repo.save(itemEstoque);
		    
		    
		    return objEstoqueMP;
	
	    }
	
	 
		public Integer quantidadeDestinos(String idfil,String mistura) throws ParseException {
			Integer obj = repo.quantidadeDestinos(idfil, mistura);
			return obj;
		}		
	
	
	
	   public List<MisturaProjectionDTO> buscaEstoqueMPMistura( String idfil , String mistura   ,String tipoFardo ) throws ParseException{ 
		   
		    
		   if(!tipoFardo.equals("T")) {
		    
			       Integer totDestinos =  quantidadeDestinos(idfil, mistura);
			   
				   if(totDestinos > 1) {
					   throw new ObjectNotFoundException("Mistura possui fardos de destinos diferentes. Destino deve ser TODOS.");  
				   }

		   }  
		   
		    List<MisturaPadraoProjection> saldoPesquisaMistura;
		    
		    if(tipoFardo.equals("T")) {
			    saldoPesquisaMistura = repo.buscaEstoqueMPMistura(idfil, mistura, null);         
		    }else {			   
			    saldoPesquisaMistura = repo.buscaEstoqueMPMistura(idfil, mistura, tipoFardo);    			   
		    } 
		   
			List<MisturaProjectionDTO> listaSaldoPesquisaMistura = saldoPesquisaMistura.stream().map(x-> new MisturaProjectionDTO(x)).toList();  		
			
			List<MisturaProjectionDTO> saldoPesquisaMistLista =  new ArrayList<>(); 
			
			for (MisturaProjectionDTO saldoPesquisaMistPDTO : listaSaldoPesquisaMistura) {  
				
				MisturaProjectionDTO saldoPesquisaMist = new MisturaProjectionDTO();
				
				saldoPesquisaMist.setFORN(saldoPesquisaMistPDTO.getFORN()); 
				saldoPesquisaMist.setPRODUT(saldoPesquisaMistPDTO.getPRODUT());
				saldoPesquisaMist.setCOD_PROD(saldoPesquisaMistPDTO.getCOD_PROD());
				saldoPesquisaMist.setLOTE(saldoPesquisaMistPDTO.getLOTE());
				saldoPesquisaMist.setPI(saldoPesquisaMistPDTO.getPI()) ;
				saldoPesquisaMist.setESTOQUE(saldoPesquisaMistPDTO.getESTOQUE());
				saldoPesquisaMist.setFrd_reserv(saldoPesquisaMistPDTO.getFrd_reserv());
				saldoPesquisaMist.setQTDE(saldoPesquisaMistPDTO.getQTDE());
				saldoPesquisaMist.setDisponivel(saldoPesquisaMistPDTO.getDisponivel());
				saldoPesquisaMist.setTotal_mist_util(saldoPesquisaMistPDTO.getTotal_mist_util());
				saldoPesquisaMist.setM4ID(saldoPesquisaMistPDTO.getM4ID());
				saldoPesquisaMist.setM4NF(saldoPesquisaMistPDTO.getM4NF());
				saldoPesquisaMist.setM4DESCF(saldoPesquisaMistPDTO.getM4DESCF());
				saldoPesquisaMist.setM4ITEM(saldoPesquisaMistPDTO.getM4ITEM());
				saldoPesquisaMist.setM4UM(saldoPesquisaMistPDTO.getM4UM());
				saldoPesquisaMist.setM4PESMED(saldoPesquisaMistPDTO.getM4PESMED());
				saldoPesquisaMist.setM4PROCED(saldoPesquisaMistPDTO.getM4PROCED());
				saldoPesquisaMist.setM4TAM(saldoPesquisaMistPDTO.getM4TAM());
				saldoPesquisaMist.setM4QUAL(saldoPesquisaMistPDTO.getM4QUAL());
				saldoPesquisaMist.setM4FORN(saldoPesquisaMistPDTO.getM4FORN());
				saldoPesquisaMist.setELG(saldoPesquisaMistPDTO.getELG());
				saldoPesquisaMist.setMAT(saldoPesquisaMistPDTO.getMAT());
				saldoPesquisaMist.setMIC(saldoPesquisaMistPDTO.getMIC());
				saldoPesquisaMist.setMST(saldoPesquisaMistPDTO.getMST());
				saldoPesquisaMist.setSF(saldoPesquisaMistPDTO.getSF());
				saldoPesquisaMist.setSIC(saldoPesquisaMistPDTO.getSIC());
				saldoPesquisaMist.setSTR(saldoPesquisaMistPDTO.getSTR());
				saldoPesquisaMist.setTIPO(saldoPesquisaMistPDTO.getTIPO());
				saldoPesquisaMist.setUI(saldoPesquisaMistPDTO.getUI());
				saldoPesquisaMist.setSAC(saldoPesquisaMistPDTO.getSAC());
				saldoPesquisaMist.setTRID(saldoPesquisaMistPDTO.getTRID());
				saldoPesquisaMist.setPIM(saldoPesquisaMistPDTO.getPIM());
				saldoPesquisaMist.setSC(saldoPesquisaMistPDTO.getSC());
				saldoPesquisaMist.setM4B(saldoPesquisaMistPDTO.getM4B());
				saldoPesquisaMist.setM4RS(saldoPesquisaMistPDTO.getM4RS());
				saldoPesquisaMist.setM4TRAR(saldoPesquisaMistPDTO.getM4TRAR());
				saldoPesquisaMist.setM4TRCNT(saldoPesquisaMistPDTO.getM4TRCNT());
				saldoPesquisaMist.setM4UHML(saldoPesquisaMistPDTO.getM4UHML());
				saldoPesquisaMist.setMistura(saldoPesquisaMistPDTO.getMistura());
				saldoPesquisaMist.setM4COLOR(saldoPesquisaMistPDTO.getM4COLOR());
				saldoPesquisaMist.setM4TPMIC(saldoPesquisaMistPDTO.getM4TPMIC());
				saldoPesquisaMist.setM4DEST(saldoPesquisaMistPDTO.getM4DEST());
				saldoPesquisaMist.setM4CORTEZ(saldoPesquisaMistPDTO.getM4CORTEZ());   
				saldoPesquisaMist.setTotTeste(saldoPesquisaMistPDTO.getTotTeste());
				
				saldoPesquisaMistLista.add(saldoPesquisaMist);
			 
	         }	 
		   
			  return saldoPesquisaMistLista;
	} 
	   
	   

	   public List<MisturaProjectionDTO> buscaEstoque( String idfil , String produt   ,String lote ,String item, String fornec,String proced, 
			   String color, String dest,String q1, String q2, String tam,       String pil,       String cortez) throws ParseException{ 
		    
		   
		    String produtor = produt;
		    if(produtor==null || produtor.equals("")) {
		    	produtor = null; 
		    }		   
		   
		    String lt = lote;
		    if(lote==null || lote.equals("")) {
		    	lt = null; 
		    }
		 
		    String it = item;
		    if(it==null || it.equals("")) {
		    	it = null; 
		    }
		    
		    String fornecedor = fornec;
		    if(fornecedor==null || fornecedor.equals("")) {
		    	fornecedor = null; 
		    }	
		    
		    String procedencia = proced;
		    if(procedencia==null || procedencia.equals("")) {
		    	procedencia = null; 
		    }
		    
		    String coloracao = color;
		    if(coloracao==null || coloracao.equals("")) {
		    	coloracao = null; 
		    }	
		    
		    String destino = dest;
		    if(destino==null || destino.equals("")  || destino.equals("T")) {
		    	destino = null; 
		    }		
		    
		    String qual1 = q1;
		    if(qual1==null || qual1.equals("")) {
		    	qual1 = null; 
		    }	
		    
		    String qual2 = q2;
		    if(qual2==null || qual2.equals("")) {
		    	qual2 = null; 
		    }	
		    
		    String tamanho = tam;
		    if(tamanho==null || tamanho.equals("")) {
		    	tamanho = null; 
		    }			    
		    
		    
		    String pilha = pil;
		    if(pilha==null || pilha.equals("")) {
		    	pilha = null; 
		    }	
		    
		    String crt = cortez;
		    if(crt==null || crt.equals("")) {
		    	crt = null; 
		    }			    
		    
		    
		    List<MisturaPadraoProjection> saldoPesquisaEstoque; 
		  
			saldoPesquisaEstoque = repo.buscaEstoque( idfil ,  produtor   , lt , it, fornecedor, procedencia, coloracao, destino, qual1,  qual2, tamanho, pilha , crt );    
		   
			List<MisturaProjectionDTO> listaSaldoPesquisaEstoque = saldoPesquisaEstoque.stream().map(x-> new MisturaProjectionDTO(x)).toList();  		
			
			List<MisturaProjectionDTO> saldoPesquisaEstLista =  new ArrayList<>(); 
			
			for (MisturaProjectionDTO saldoPesquisaEstPDTO : listaSaldoPesquisaEstoque) {  
				
				MisturaProjectionDTO saldoPesquisaEst = new MisturaProjectionDTO();
				
				saldoPesquisaEst.setFORN(saldoPesquisaEstPDTO.getFORN()); 
				saldoPesquisaEst.setPRODUT(saldoPesquisaEstPDTO.getPRODUT());
				saldoPesquisaEst.setCOD_PROD(saldoPesquisaEstPDTO.getCOD_PROD());
				saldoPesquisaEst.setLOTE(saldoPesquisaEstPDTO.getLOTE());
				saldoPesquisaEst.setPI(saldoPesquisaEstPDTO.getPI()) ;
				saldoPesquisaEst.setESTOQUE(saldoPesquisaEstPDTO.getESTOQUE());
				saldoPesquisaEst.setFrd_reserv(saldoPesquisaEstPDTO.getFrd_reserv());
				saldoPesquisaEst.setQTDE(saldoPesquisaEstPDTO.getQTDE());
				saldoPesquisaEst.setDisponivel(saldoPesquisaEstPDTO.getDisponivel());
				saldoPesquisaEst.setTotal_mist_util(saldoPesquisaEstPDTO.getTotal_mist_util());
				saldoPesquisaEst.setM4ID(saldoPesquisaEstPDTO.getM4ID());
				saldoPesquisaEst.setM4NF(saldoPesquisaEstPDTO.getM4NF());
				saldoPesquisaEst.setM4DESCF(saldoPesquisaEstPDTO.getM4DESCF());
				saldoPesquisaEst.setM4ITEM(saldoPesquisaEstPDTO.getM4ITEM());
				saldoPesquisaEst.setM4UM(saldoPesquisaEstPDTO.getM4UM());
				saldoPesquisaEst.setM4PESMED(saldoPesquisaEstPDTO.getM4PESMED());
				saldoPesquisaEst.setM4PROCED(saldoPesquisaEstPDTO.getM4PROCED());
				saldoPesquisaEst.setM4TAM(saldoPesquisaEstPDTO.getM4TAM());
				saldoPesquisaEst.setM4QUAL(saldoPesquisaEstPDTO.getM4QUAL());
				saldoPesquisaEst.setM4FORN(saldoPesquisaEstPDTO.getM4FORN());
				saldoPesquisaEst.setELG(saldoPesquisaEstPDTO.getELG());
				saldoPesquisaEst.setMAT(saldoPesquisaEstPDTO.getMAT());
				saldoPesquisaEst.setMIC(saldoPesquisaEstPDTO.getMIC());
				saldoPesquisaEst.setMST(saldoPesquisaEstPDTO.getMST());
				saldoPesquisaEst.setSF(saldoPesquisaEstPDTO.getSF());
				saldoPesquisaEst.setSIC(saldoPesquisaEstPDTO.getSIC());
				saldoPesquisaEst.setSTR(saldoPesquisaEstPDTO.getSTR());
				saldoPesquisaEst.setTIPO(saldoPesquisaEstPDTO.getTIPO());
				saldoPesquisaEst.setUI(saldoPesquisaEstPDTO.getUI());
				saldoPesquisaEst.setSAC(saldoPesquisaEstPDTO.getSAC());
				saldoPesquisaEst.setTRID(saldoPesquisaEstPDTO.getTRID());
				saldoPesquisaEst.setPIM(saldoPesquisaEstPDTO.getPIM());
				saldoPesquisaEst.setSC(saldoPesquisaEstPDTO.getSC());
				saldoPesquisaEst.setM4B(saldoPesquisaEstPDTO.getM4B());
				saldoPesquisaEst.setM4RS(saldoPesquisaEstPDTO.getM4RS());
				saldoPesquisaEst.setM4TRAR(saldoPesquisaEstPDTO.getM4TRAR());
				saldoPesquisaEst.setM4TRCNT(saldoPesquisaEstPDTO.getM4TRCNT());
				saldoPesquisaEst.setM4UHML(saldoPesquisaEstPDTO.getM4UHML());
				saldoPesquisaEst.setMistura(saldoPesquisaEstPDTO.getMistura());
				saldoPesquisaEst.setM4COLOR(saldoPesquisaEstPDTO.getM4COLOR());
				saldoPesquisaEst.setM4TPMIC(saldoPesquisaEstPDTO.getM4TPMIC());
				saldoPesquisaEst.setM4DEST(saldoPesquisaEstPDTO.getM4DEST());
				saldoPesquisaEst.setM7DESC(saldoPesquisaEstPDTO.getM7DESC());   
				saldoPesquisaEst.setM4CORTEZ(saldoPesquisaEstPDTO.getM4CORTEZ());
				saldoPesquisaEst.setTotTeste(saldoPesquisaEstPDTO.getTotTeste());
				
				saldoPesquisaEstLista.add(saldoPesquisaEst);
			 
	         }	 
		   
			  return saldoPesquisaEstLista;
	}		
	   	   
	   
	   
   
	   public List<MisturaProjectionDTO> buscaEstoqueQualidade( String idfil , String produtor   ,String lote ,String item ) throws ParseException{ 
		    
		   
		    String lt = lote;
		    if(lote==null || lote.equals("")) {
		    	lt = null; 
		    }
		 
		    List<MisturaPadraoProjection> saldoPesquisaEstoque; 
		  
			saldoPesquisaEstoque = repo.buscaEstoqueQualidade( idfil ,  produtor   , lt , item );    
		   
			List<MisturaProjectionDTO> listaSaldoPesquisaEstoque = saldoPesquisaEstoque.stream().map(x-> new MisturaProjectionDTO(x)).toList();  		
			
			List<MisturaProjectionDTO> saldoPesquisaEstLista =  new ArrayList<>(); 
			
			for (MisturaProjectionDTO saldoPesquisaEstPDTO : listaSaldoPesquisaEstoque) {  
				
				MisturaProjectionDTO saldoPesquisaEst = new MisturaProjectionDTO();
				
				saldoPesquisaEst.setFORN(saldoPesquisaEstPDTO.getFORN()); 
				saldoPesquisaEst.setPRODUT(saldoPesquisaEstPDTO.getPRODUT());
				saldoPesquisaEst.setCOD_PROD(saldoPesquisaEstPDTO.getCOD_PROD());
				saldoPesquisaEst.setLOTE(saldoPesquisaEstPDTO.getLOTE());
				saldoPesquisaEst.setPI(saldoPesquisaEstPDTO.getPI()) ;
				saldoPesquisaEst.setESTOQUE(saldoPesquisaEstPDTO.getESTOQUE());
				saldoPesquisaEst.setFrd_reserv(saldoPesquisaEstPDTO.getFrd_reserv());
				saldoPesquisaEst.setQTDE(saldoPesquisaEstPDTO.getQTDE());
				saldoPesquisaEst.setDisponivel(saldoPesquisaEstPDTO.getDisponivel());
				saldoPesquisaEst.setTotal_mist_util(saldoPesquisaEstPDTO.getTotal_mist_util());
				saldoPesquisaEst.setM4ID(saldoPesquisaEstPDTO.getM4ID());
				saldoPesquisaEst.setM4NF(saldoPesquisaEstPDTO.getM4NF());
				saldoPesquisaEst.setM4DESCF(saldoPesquisaEstPDTO.getM4DESCF());
				saldoPesquisaEst.setM4ITEM(saldoPesquisaEstPDTO.getM4ITEM());
				saldoPesquisaEst.setM4UM(saldoPesquisaEstPDTO.getM4UM());
				saldoPesquisaEst.setM4PESMED(saldoPesquisaEstPDTO.getM4PESMED());
				saldoPesquisaEst.setM4PROCED(saldoPesquisaEstPDTO.getM4PROCED());
				saldoPesquisaEst.setM4TAM(saldoPesquisaEstPDTO.getM4TAM());
				saldoPesquisaEst.setM4QUAL(saldoPesquisaEstPDTO.getM4QUAL());
				saldoPesquisaEst.setM4FORN(saldoPesquisaEstPDTO.getM4FORN());
				saldoPesquisaEst.setELG(saldoPesquisaEstPDTO.getELG());
				saldoPesquisaEst.setMAT(saldoPesquisaEstPDTO.getMAT());
				saldoPesquisaEst.setMIC(saldoPesquisaEstPDTO.getMIC());
				saldoPesquisaEst.setMST(saldoPesquisaEstPDTO.getMST());
				saldoPesquisaEst.setSF(saldoPesquisaEstPDTO.getSF());
				saldoPesquisaEst.setSIC(saldoPesquisaEstPDTO.getSIC());
				saldoPesquisaEst.setSTR(saldoPesquisaEstPDTO.getSTR());
				saldoPesquisaEst.setTIPO(saldoPesquisaEstPDTO.getTIPO());
				saldoPesquisaEst.setUI(saldoPesquisaEstPDTO.getUI());
				saldoPesquisaEst.setSAC(saldoPesquisaEstPDTO.getSAC());
				saldoPesquisaEst.setTRID(saldoPesquisaEstPDTO.getTRID());
				saldoPesquisaEst.setPIM(saldoPesquisaEstPDTO.getPIM());
				saldoPesquisaEst.setSC(saldoPesquisaEstPDTO.getSC());
				saldoPesquisaEst.setM4B(saldoPesquisaEstPDTO.getM4B());
				saldoPesquisaEst.setM4RS(saldoPesquisaEstPDTO.getM4RS());
				saldoPesquisaEst.setM4TRAR(saldoPesquisaEstPDTO.getM4TRAR());
				saldoPesquisaEst.setM4TRCNT(saldoPesquisaEstPDTO.getM4TRCNT());
				saldoPesquisaEst.setM4UHML(saldoPesquisaEstPDTO.getM4UHML());
				saldoPesquisaEst.setMistura(saldoPesquisaEstPDTO.getMistura());
				saldoPesquisaEst.setM4COLOR(saldoPesquisaEstPDTO.getM4COLOR());
				saldoPesquisaEst.setM4TPMIC(saldoPesquisaEstPDTO.getM4TPMIC());
				saldoPesquisaEst.setM4DEST(saldoPesquisaEstPDTO.getM4DEST());
				saldoPesquisaEst.setM4CORTEZ(saldoPesquisaEstPDTO.getM4CORTEZ());
				saldoPesquisaEst.setM7DESC(saldoPesquisaEstPDTO.getM7DESC());   
				
				saldoPesquisaEstLista.add(saldoPesquisaEst);
			 
	         }	 
		   
			  return saldoPesquisaEstLista;
	}		
	   
	  
	   
	 
	public  SaldoIdMovtoDTO  buscaSaldoIdMovto(String idfil , Double idMovto){
		
		List<SaldoIdMovtoProjection> saldoIdMovto = repo.buscaSaldoIdMovto(idfil, idMovto); 
		
		List<SaldoIdMovtoDTO> listaSaldoItemMovto = saldoIdMovto.stream().map(x-> new SaldoIdMovtoDTO(x)).toList();  
		
		SaldoIdMovtoDTO sldIdMovimento = new SaldoIdMovtoDTO();
		
		for (SaldoIdMovtoDTO saldoIdMovtoDTO : listaSaldoItemMovto) {
			
			sldIdMovimento.setIdMov(saldoIdMovtoDTO.getIdMov());
			sldIdMovimento.setQtde(saldoIdMovtoDTO.getQtde());
			sldIdMovimento.setPeso(saldoIdMovtoDTO.getPeso());
			sldIdMovimento.setVlEst(saldoIdMovtoDTO.getVlEst()); 
            
        }
		
		return sldIdMovimento;
		
	}
	
	public  List<SaldoPesquisaIdDTO>  pesquisaLotePorParametros(String idfil,String produtor , String lote , String item ){
		
		produtor = produtor.toUpperCase();
		
		List<SaldoPesquisaIdProjection> saldoPesquisaIdP = repo.pesquisaSaldoId(idfil, produtor, lote , item); 
		
		List<SaldoPesquisaIdDTO> listaSaldoPesquisaId = saldoPesquisaIdP.stream().map(x-> new SaldoPesquisaIdDTO(x)).toList();  
		 
		return listaSaldoPesquisaId;
		
	}
	
	@Transactional	
	 public void deletaEstoque(Double id){  
	 	  repo.deleteById(id);  
	}	 
	
	
    ///////// FARDOS EM MISTURA ////////	
    public List<MisturaProjectionDTO> buscaEstoqueEmMistura(MovimentoDTO objParam ) throws ParseException{   
	    	 
	    	Iterator<MovimentoItemDTO> it = objParam.getItemMovimentoDTO().iterator();
	    	List<String> idFardosSelecionados =  new ArrayList<>();  ;
	    	String idfil= "";
	    	
		 
		while (it.hasNext()) { 
			MovimentoItemDTO movimIt =   it.next();			
			
			Integer iI =  movimIt.getIdMovimento().intValue();
			
			idFardosSelecionados.add( "*" + iI.toString()+ "*" );
 
			
			idfil = movimIt.getIdfil();
			
		}	   	   
		
 
		
		List<MisturaProjectionDTO> listaIdsEmMistura = buscaEstoqueMistura(idfil,idFardosSelecionados); 
			
		return listaIdsEmMistura;
     }	
	
	
	 public List<MisturaProjectionDTO> buscaEstoqueMistura( String idfil , List<String>  idFardosSelecionados) throws ParseException{  
		 
		    List<MisturaPadraoProjection> saldoPesquisaEstoque; 
		  
			saldoPesquisaEstoque = repo.buscaEstoqueEmMistura( idfil ,    idFardosSelecionados    );    // 
		   
			List<MisturaProjectionDTO> listaSaldoPesquisaEstoque = saldoPesquisaEstoque.stream().map(x-> new MisturaProjectionDTO(x)).toList();  		
			
			List<MisturaProjectionDTO> saldoPesquisaEstLista =  new ArrayList<>(); 
			
			for (MisturaProjectionDTO saldoPesquisaEstPDTO : listaSaldoPesquisaEstoque) {  
				
				MisturaProjectionDTO saldoPesquisaEst = new MisturaProjectionDTO();
				 
				saldoPesquisaEst.setLOTE(saldoPesquisaEstPDTO.getLOTE()); 
				saldoPesquisaEst.setM4ID(saldoPesquisaEstPDTO.getM4ID());  
				saldoPesquisaEst.setMistura(saldoPesquisaEstPDTO.getMistura());
				 
				
				saldoPesquisaEstLista.add(saldoPesquisaEst);
			 
	         }	 
		   
			  return saldoPesquisaEstLista;
	}		
	
	
	
 
	 

}
