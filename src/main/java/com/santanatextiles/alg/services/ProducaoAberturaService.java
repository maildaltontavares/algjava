package com.santanatextiles.alg.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.Movimento;
import com.santanatextiles.alg.domain.ProducaoAbertura;
import com.santanatextiles.alg.dto.MovimentoDTO;
import com.santanatextiles.alg.dto.ProducaoAberturaDTO;
import com.santanatextiles.alg.repositories.ProducaoAberturaRepository;
import com.santanatextiles.alg.resources.exception.ObjectNotFoundException;
 

@Service
public class ProducaoAberturaService {
	
	
	@Autowired
	private ProducaoAberturaRepository repo; 
	
	@Value("${spring.datasource.url}")
	private String JDBC_URL;
	
	@Value("${spring.datasource.username}")    
	private String JDBC_USER;

	@Value("${spring.datasource.password}") 
	private String JDBC_PASSWORD;	
	
	public  ProducaoAbertura  gravaBaixaMistura(ProducaoAbertura producaoAbertura ){	   
		 ProducaoAbertura pa = repo.save(producaoAbertura ) ;	  
		 return pa;
	}	
	
	
	@Transactional
	public  ProducaoAberturaDTO inserirProducaoAbertura(ProducaoAberturaDTO producaoAberturaDTO ) throws ParseException{  
		
		ProducaoAbertura existeProd = buscaProducaoAberturaPorFilialMisturaSeq(
				producaoAberturaDTO.getIdfil(),
			    producaoAberturaDTO.getMistura(),
			    producaoAberturaDTO.getSeq()
				)  ;  			
		
		
		if (existeProd==null) { 
			throw new ObjectNotFoundException("Sequencia nao encontrada para esta mistura.");	  
		}
		
		String proxSeqABaixar = repo.ultMisturasBaixadas(producaoAberturaDTO.getIdfil() ,producaoAberturaDTO.getMistura()  );
		 
		proxSeqABaixar = proxSeqABaixar.replaceAll("\\s+$", "");
		
		if (!proxSeqABaixar.equals(producaoAberturaDTO.getSeq().replaceAll("\\s+$", ""))) {
			throw new ObjectNotFoundException("A proxima sequencia a baixar deve ser a " 
					+ proxSeqABaixar);
		};  
		
		 
		
		  Integer reg = repo.gravaApontamento(
				    producaoAberturaDTO.getIdfil(),
				    producaoAberturaDTO.getMistura(),
				    producaoAberturaDTO.getSeq(),
				    producaoAberturaDTO.getMaquina(),
				    producaoAberturaDTO.getLocalFisico(),
				    producaoAberturaDTO.getTurno(),
				    producaoAberturaDTO.getOperador(),
				    producaoAberturaDTO.getDataMovimento(),
				    producaoAberturaDTO.getObservacao(),
				    producaoAberturaDTO.getLado(), 
				    producaoAberturaDTO.getHoraMovimento(),
				    producaoAberturaDTO.getDataInclusao(),
				    producaoAberturaDTO.getUsarioInclusao(), 
				    producaoAberturaDTO.getDataAlteracao(),
				    producaoAberturaDTO.getUsarioAlteracao()  
				  
				  ) ;	
		 
		 
		 return producaoAberturaDTO;
	}	  
	
	 
	
	
	@Transactional
	public  ProducaoAberturaDTO alterarProducaoAbertura(ProducaoAberturaDTO producaoAberturaDTO ) throws ParseException{  
		
		  Integer reg = repo.gravaApontamento(
				    producaoAberturaDTO.getIdfil(),
				    producaoAberturaDTO.getMistura(),
				    producaoAberturaDTO.getSeq(),
				    producaoAberturaDTO.getMaquina(),
				    producaoAberturaDTO.getLocalFisico(),
				    producaoAberturaDTO.getTurno(),
				    producaoAberturaDTO.getOperador(),
				    producaoAberturaDTO.getDataMovimento(),
				    producaoAberturaDTO.getObservacao(),
				    producaoAberturaDTO.getLado(), 
				    producaoAberturaDTO.getHoraMovimento(),
				    producaoAberturaDTO.getDataInclusao(),
				    producaoAberturaDTO.getUsarioInclusao(), 
				    producaoAberturaDTO.getDataAlteracao(),
				    producaoAberturaDTO.getUsarioAlteracao()  
				  
				  ) ;	
		 
		 
		 return producaoAberturaDTO;
	}	
	
	public Double deleteByIdfilAndIdAutomatico(String filial , Double idAuto){	 
		 Double obj = repo.deleteByIdfilAndIdAutomatico(filial ,idAuto) ;	 
		 return obj;
	}	
	 
	public ProducaoAbertura buscaProducaoAberturaPorFilialMisturaSeq(   String filial,  String mistura,  String seq) {
		
		String sequencia = seq + ' ';
		
		
		ProducaoAbertura obj = repo.buscaProducaoAberturaPorFilialMisturaSeq(
				filial, 
				mistura, 
				sequencia);
		 
		return obj;
	} 
	
	public List<ProducaoAbertura>  buscaProducaoAberturaPorFilialMistura(   String filial,  String mistura) { 
		
		List<ProducaoAbertura>  obj = repo.buscaProducaoAberturaPorFilialMistura(
				filial, 
				mistura );
		 
		return obj;
	} 	
 
	@Transactional
	public Integer excluirApontamento(   String filial,  String mistura,  String seq) { 
		
		
		Integer obj = repo.excluirApontamento(
				filial, 
				mistura, 
				seq);  
		 
		return obj;
	} 
	 
	
	public List<ProducaoAbertura> buscaProducaoAberturaPorParametros(ProducaoAberturaDTO producaoAberturaDTO ){	
		 
		 List<ProducaoAbertura> obj = repo.buscaProducaoAberturaPorParametros(producaoAberturaDTO.getIdfil(),  producaoAberturaDTO.getDataInicialS(),producaoAberturaDTO.getDataFinalS(),producaoAberturaDTO.getMistura()) ;	  
		 return obj;
	}	
	 	
/*	
	public List<ProducaoAberturaDTO>buscaProducaoAberturaPorParametros(String filial, String mistura, String dataInicial, String dataFinal) {

		List<ProducaoAberturaProjection> producaoAberturaP = repo.buscaProducaoAberturaPorParametros(filial, dataInicial,dataFinal,mistura);

		List<ProducaoAberturaDTO> listaProducaoAbertura = producaoAberturaP.stream()
				.map(x -> new ProducaoAberturaDTO(x)).toList();

		List<ProducaoAberturaDTO> ProducaoAberturaPar = new ProducaoAberturaDTO();

		for (ProducaoAberturaDTO listaProducaoAberturaPDTO : listaProducaoAbertura) {

			ProducaoAberturaPar.setIdfil(listaProducaoAberturaPDTO.getIdfil());
			ProducaoAberturaPar.setMistura(listaProducaoAberturaPDTO.getMistura()); 
			ProducaoAberturaPar.setSeq(listaProducaoAberturaPDTO.getSeq());
			ProducaoAberturaPar.setDataMovimento(listaProducaoAberturaPDTO.getDataMovimento());
			ProducaoAberturaPar.setHoraMovimento(listaProducaoAberturaPDTO.getHoraMovimento());
			ProducaoAberturaPar.setTurno(listaProducaoAberturaPDTO.getTurno()); 
			ProducaoAberturaPar.setMaquina(listaProducaoAberturaPDTO.getMaquina());  
			ProducaoAberturaPar.setLado(listaProducaoAberturaPDTO.getLado());  
	 
		}

		return ProducaoAberturaPar;
	}
	
*/	
	
	
	
	 		

}
