package com.santanatextiles.alg.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.EstoqueMP;
import com.santanatextiles.alg.domain.MovimentoItem;
import com.santanatextiles.alg.dto.MisturaProjectionDTO;
import com.santanatextiles.alg.dto.SaldoIdMovtoDTO;
import com.santanatextiles.alg.dto.SaldoPesquisaIdDTO;
import com.santanatextiles.alg.projections.MisturaPadraoProjection;
import com.santanatextiles.alg.projections.SaldoIdMovtoProjection;
import com.santanatextiles.alg.projections.SaldoPesquisaIdProjection;
import com.santanatextiles.alg.repositories.EstoqueMPRepository; 
	
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
 	
	
	public Integer atualizaEstoque(String idfil , Double idMovto , Double quantidade , Double peso , Double vlEstoque , Double pesoMedio , String atualizaIt ) {
		
		if(atualizaIt.equals("S")) { 
			return repo.atualizaEstoqueEPesoMedio(idfil, idMovto, quantidade, peso, vlEstoque , pesoMedio);	
		}else {
			return repo.atualizaEstoque(idfil, idMovto, quantidade, peso, vlEstoque );	
		}
		
	}
	
 
	public EstoqueMP insert (MovimentoItem obj ){ 
		
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
		    itemEstoque.setQuantidade(obj.getQuantidade()); 
		    itemEstoque.setPeso(obj.getPeso());	 
		    itemEstoque.setId(obj.getIdItem());	 
		    itemEstoque.setUnidadeMedida(obj.getUnidadeMedida()); 
		    itemEstoque.setPilha(obj.getPilha());
		    itemEstoque.setValorEstoque(obj.getVlUnitario() * obj.getQuantidade()); 	 
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
		    
		    
		    EstoqueMP  objEstoqueMP = repo.save(itemEstoque);
		    
		    
		    return objEstoqueMP;
	
	    }
	
	
	   public List<MisturaProjectionDTO> buscaEstoqueMPMistura( String idfil , String mistura   ,String tipoFardo ){ 
		   
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
				
				saldoPesquisaMistLista.add(saldoPesquisaMist);
			 
	         }	 
		   
			  return saldoPesquisaMistLista;
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
		
	
	
	
	
	
	

	 

}
