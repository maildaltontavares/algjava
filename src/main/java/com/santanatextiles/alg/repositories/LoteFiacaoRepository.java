package com.santanatextiles.alg.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.alg.domain.LoteFiacao;
import com.santanatextiles.alg.domain.LoteFiacaoId;
import com.santanatextiles.alg.dto.LoteFiacaoDTO;

@Repository
public interface LoteFiacaoRepository extends JpaRepository<LoteFiacao, LoteFiacaoId>{
	
   	
	
   @Query(value =  
      "Select  IDFIL,J0TPMAQ,J0ITEM,J0ID,J0LOTE,J0DTABER,J0DTENC ,J0QTDPRD  " +
      " from cpf.cpfj0_dbf j0 " +
      " where j0.idfil =  STL.FN_STL_IDFIL('cpfJ0',?1)",nativeQuery = true)
    List<LoteFiacao> buscaLoteFiacao(String filial) ; 
     
   @Query(value =  
      "Select  IDFIL,J0TPMAQ,J0ITEM,J0ID,J0LOTE,J0DTABER,J0DTENC ,J0QTDPRD  " +
      " from cpf.cpfj0_dbf j0 " +
      " where j0.idfil =  STL.FN_STL_IDFIL('cpfJ0',?1)",nativeQuery = true)
    Page<LoteFiacao> buscaLoteFiacaoPag(PageRequest pageRequest, @Param("idfil") String idfil) ;  
   
  
   
   @Query(value =  
    "Select  distinct J0LOTE lote  " +
    " from cpf.cpfj0_dbf j0 " +
    " where j0.idfil =  STL.FN_STL_IDFIL('cpfJ0',?1) and j0.j0lote = ?2  ",nativeQuery = true)
    List<Map<String, Object>> buscaLoteFiacaoPorCodigo(String filial, String lote) ;    
   
   @Transactional(readOnly=true)
   LoteFiacao findByIdfilAndTipoMaquinaAndItemAndIdSSMAndLote(String idfil,String tipoMaquina, String Item, Integer idSSM,String lote);   
   
   @Transactional
   Long deleteByIdfilAndTipoMaquinaAndItemAndIdSSMAndLote(String idfil,String tipoMaquina, String Item, Integer idSSM,String lote); 
   
   
   @Query(value = "" +
	" select j0.j0tpmaq cd_tipo_maquina ,j0id, " +
    " b2.b2desc nome_tp_maquina, " + 
    " j0.j0lote lote, " + 
    " i.D0422_ID_ITEM item, " +
    " m.D0421_NOME desc_item, " +
    " j0.j0qtdprd qtde_a_prod, " +
    " j0dtaber data_abertura, " +
    " j0.j0obs  obs , " +
    " j0.j0obs1  obs1 ," +
    " j0.j0obs2 obs2  " +  
    " from  " +
    " cpf.cpfj0_dbf j0 " +
    " left join cpf.cpfb2_dbf b2 on b2.idfil = stl.fn_stl_idfil('CPFB2',j0.idfil)  and j0.j0tpmaq = b2.b2cod " +
    " left join STL.E0422_STL_ITEM i on to_number(j0.j0item) = i.D0422_ID_ITEM " +
    " inner join STL.E0421_STL_MATERIAL m on m.D0421_ID_MATERIAL = i.D0421_ID_MATERIAL " +  
    " where j0.idfil = :idfil and j0id is not null and " + 
    "(:tipoMaquina IS NULL OR j0tpmaq = :tipoMaquina )   and " +
    "(:dataLoteIni IS NULL OR TO_CHAR(J0DTCRIA,'YYYYMMDD') >= :dataLoteIni )   and " +
    "(:dataLoteFim IS NULL OR TO_CHAR(J0DTCRIA,'YYYYMMDD') <= :dataLoteFim )   and " + 
    "(:lote IS NULL OR J0LOTE = :lote ) and "+
    "(:item IS NULL OR J0ITEM = :item )   "+ 
    " order by j0tpmaq, j0lote,j0item "
    ,nativeQuery = true)		
    List<Map<String, Object>> pesquisaLoteFiacaoByParam(
		@Param("idfil") String idfil ,
		@Param("dataLoteIni") String dataProdIni,
		@Param("dataLoteFim") String dataProdFim,		
		@Param("tipoMaquina") String tipoMaquina,
		@Param("lote") String lote, 
		@Param("item") String item
		);
   
   
	

   
   
   
   
   
   

}
