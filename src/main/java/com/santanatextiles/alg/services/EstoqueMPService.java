package com.santanatextiles.alg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.santanatextiles.alg.domain.EstoqueMP;
import com.santanatextiles.alg.domain.MovimentoItem;
import com.santanatextiles.alg.dto.SaldoIdMovtoDTO;
import com.santanatextiles.alg.projections.SaldoIdMovtoProjection;
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
	
	 
	public List<EstoqueMP> buscaEstoqueMP() {  
		 List<EstoqueMP> obj = repo.findAll();
		return obj ;
	}	

	
	public List<EstoqueMP> buscaEstoqueMPByFilial(String filial) {  
		 List<EstoqueMP> obj = repo.findByIdfil(filial);
		return obj ;
	}	 
 	
	
	public Integer atualizaEstoque(String idfil , Double idMovto , Double quantidade , Double peso , Double vlEstoque) {
		return repo.atualizaEstoque(idfil, idMovto, quantidade, peso, vlEstoque);
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
		    itemEstoque.setId(obj.getId());	 
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
		    
		    EstoqueMP  objEstoqueMP = repo.save(itemEstoque);
		    
		    
		    return objEstoqueMP;
	
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

	 

}
