package com.santanatextiles.alg.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.LoteFiacao;
import com.santanatextiles.alg.dto.LoteFiacaoDTO;
import com.santanatextiles.alg.repositories.LoteFiacaoRepository;

 

@Service
public class LoteFiacaoService {
	
	@Autowired
	private LoteFiacaoRepository repo; 
 
	@Value("${spring.datasource.url}")
	private String JDBC_URL;
	
	@Value("${spring.datasource.username}")
	private String JDBC_USER;

	@Value("${spring.datasource.password}")
	private String JDBC_PASSWORD;				
	
	@Transactional
	public LoteFiacao insert(LoteFiacao obj) {	  		
 		return repo.save(obj);			
	} 		
	
	@Transactional
	public LoteFiacao update(LoteFiacao obj) {	  	
		System.out.println(obj.getQtdeAProduzir());
 		return repo.save(obj);			
	} 		

	@Transactional
	public Boolean  deletaLoteFiacao(String idfil, String tipoMaquina, String lote,  String item ) throws SQLException {
 	 
		
		try {
			
			Connection myConnection=DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
	
	        Statement sqlStatement = myConnection.createStatement();
	        String deleteRecordSQL = "" +
	                "Delete from cpf.cpfj0_dbf d4 where " + 
	        		" idfil = '" + idfil + "' " + 
	        		" and j0tpmaq = '" +  tipoMaquina + "'" +
	        		" and j0lote = '" + lote + "' " +  
	        		" and j0id = 0 " +  
	        		" and j0item = '" + item + "'" ;	 
	        		
	        		 //System.out.println(deleteRecordSQL); 
	        int linhasAfetadas = sqlStatement.executeUpdate(deleteRecordSQL); 
	        
	        System.out.println("Linhas afetadas: " + linhasAfetadas); 
   
	        sqlStatement.close();
	        myConnection.close();	        
	        
	        	
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return true;
		
	}	 
	
	public List<LoteFiacao> buscaLoteFiacao(String idfil){	 
		List<LoteFiacao> obj = repo.buscaLoteFiacao(idfil); 
		return  obj;							 
	}	
	
	public List<Map<String, Object>> buscaLoteFiacaoPorCodigo(String idfil,String lote){ 	 
		List<Map<String, Object>> obj = repo.buscaLoteFiacaoPorCodigo(idfil, lote);  
		return  obj;							 
	}  		
	
 
	
    public Page<LoteFiacao> buscaLoteFiacaoPag(Integer page, Integer linesPerPage, String orderBy, String direction, String idfil) {
	    PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);  
	    return repo.buscaLoteFiacaoPag(pageRequest, idfil);
    }		
    
    public LoteFiacao buscaLotePorChave(String idfil,String tipoMaquina, String Item, Integer idSSM,String lote) {
    	LoteFiacao obj = repo. findByIdfilAndTipoMaquinaAndItemAndIdSSMAndLote(idfil,tipoMaquina, Item, idSSM,lote); 
		return  obj;
    }
    
    public List<Map<String, Object>> pesquisaLoteFiacaoByParam(LoteFiacaoDTO objDTO) { 
    	
    	List<Map<String, Object>> obj = repo.pesquisaLoteFiacaoByParam(
    			objDTO.getIdfil(),
    			objDTO.getDataInicial(),
    			objDTO.getDataFinal(),
    			objDTO.getTipoMaquina(),
    			objDTO.getLote(),
    			objDTO.getItem()    			
    			); 
		return  obj;
		
    }     
    
    
	public LoteFiacao fromDTO(LoteFiacaoDTO objDTO) {
		
		return new LoteFiacao(
				objDTO.getIdfil(),
				objDTO.getTipoMaquina(),
				objDTO.getItem(),
				objDTO.getIdSSM(),
				objDTO.getLote(),	
				objDTO.getDataAbertura(),
				objDTO.getDataEncerramento(),
				objDTO.getQtdeAProduzir(),
				objDTO.getDataInsercao(),
				objDTO.getUsuarioInsercao(),
				objDTO.getCodFornElastano(),
				objDTO.getCodFornPoliester(),
				objDTO.getNfFornElastano(),
				objDTO.getNfFornPoliester(),
				objDTO.getNomeFornElastano(),
				objDTO.getNomeFornPoliester(),
				objDTO.getObs(),
				objDTO.getObs1(),
				objDTO.getOb2(),
				objDTO.getRpm(),
				objDTO.getTurnoInicial(),
				objDTO.getTurnoFinal()  
				);
		
 	 }	      

}
