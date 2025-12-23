package com.santanatextiles.alg.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.santanatextiles.alg.domain.Item;
import com.santanatextiles.alg.domain.ItemId;
import com.santanatextiles.alg.projections.FioProjection; 

@Repository
public interface ItemRepository extends JpaRepository<Item , ItemId> {
	

	   @Query(value =  
	      "Select D0422_ID_ITEM,D0002_ID_FIL ,it.D0003_ID_LOCALIZACAO ,it.D0421_ID_MATERIAL  " +  
	      " from stl.e0422_stl_item it" +
	      " inner join stl.e0421_stl_material mat on it.D0421_ID_MATERIAL = mat.D0421_ID_MATERIAL " +
	      " where it.d0002_id_fil =   ?1 ",nativeQuery = true)
	    List<Item> buscaItem(Long filial) ; 
	     
	   @Query(value =  
		  "Select D0422_ID_ITEM,D0002_ID_FIL ,it.D0003_ID_LOCALIZACAO ,it.D0421_ID_MATERIAL  " +  
	      " from stl.e0422_stl_item it " +
	      " inner join stl.e0421_stl_material mat on it.D0421_ID_MATERIAL = mat.D0421_ID_MATERIAL " +
	      " where it.d0002_id_fil =   ?1 order by d0421_nome",nativeQuery = true)
	    Page<Item> buscaItemPag(PageRequest pageRequest, @Param("idfil") Long filial) ;   
 	
		@Query(value="SELECT i "
		+ "FROM Item i "
		+ "WHERE i.localizacao = :localizacao "
		+ "AND i.idfil = :idfil "
		+ "AND UPPER(i.material.descricao) LIKE %:descricao% "
		+ "ORDER BY i.material.descricao")
        List<Item> procuraPorDescricao(Long localizacao , Long idfil,  String descricao);
		
 /*
		@Query(value=  
				"select   " + 
				" trim(to_char(item.D0422_ID_ITEM,'0000000')) codigo , " + 
				" item.D0421_ID_MATERIAL  codMaterial , " + 
				" trim(to_char(item.d0002_id_fil,'00')) idfil," + 
				" item.D0003_ID_LOCALIZACAO localizacao," + 
				" (trim(mat.D0421_NOME) || ' ' || trim(mat.D0421_NOME_DIMENSAO) )   descricao," + 
				" titulo, " + 
				" mat.D0403_ID_CLASSE_MATERIAL classeMaterial" + 
				" from " + 
				" STL.E0422_STL_ITEM item " + 
				" inner JOIN STL.e0421_stl_material mat on  item.D0421_ID_MATERIAL = mat.D0421_ID_MATERIAL    " + 
				" inner join " + 
				" (" + 
				 
				" 	Select " + 
				" 	idfil,h8cod item,h8tit  titulo" + 
				" 	from cpfh8_dbf h8" + 
				" 	where h8tit is not null" +  
				"  	union all " +  
				" 	Select " +  
				" 	idfil, " + 
				" 	item, " + 
				" 	TO_NUMBER(REPLACE(titulo,'.',',')) titulo " + 
				" 	from " + 
				" 	(" + 
				" 		Select trim(to_char(it.d0002_id_fil,'00')) idfil,trim(to_char(it.D0422_ID_ITEM,'0000000')) item, " + 
				" 		trim(tbt.tb_tp) titulo " + 
				" 		from" + 
				" 		STL.E0422_STL_ITEM it " + 
				" 		inner JOIN STL.e0421_stl_material mat on  it.D0421_ID_MATERIAL = mat.D0421_ID_MATERIAL    " + 
				" 		inner join sap.tec_dbf tec  on  tec.idfil = STL.FN_STL_IDFIL('TEC',it.d0002_id_fil ) and tec.pd_cd = mat.d0421_id_mat_sap   " + 
				" 		LEFT JOIN sap.tb_dbf tbt on  tbt.idfil = STL.FN_STL_IDFIL('TB',it.d0002_id_fil ) and tec.pd_titulo   = SUBSTR(tbt.tb_cd,1,3) AND tbt.tb_nr = 'TT'  " + 
				" 		where " + 
				" 		it.d0002_id_fil in ( 1,3,5) and " + 
				" 		TEC.PD_TIPOPD = 'F'" + 
				" 		and tbt.tb_tp is not null  " + 
				" 	)" + 
				" 	where TO_NUMBER(REPLACE(titulo,'.',','))  < 30   " + 
				" ) tit on  trim(to_char(item.D0422_ID_ITEM,'0000000'))  = tit.item	  " +
				" WHERE item.d0002_id_fil  =   :idfil   and	" +  
				" (:descricaoFio IS NULL OR UPPER(mat.D0421_NOME) like  %:descricaoFio%  )   and " +
				" (:codigo IS NULL OR trim(to_char(item.D0422_ID_ITEM,'0000000')) = :codigo)   " +
				" order by mat.D0421_NOME,mat.D0421_NOME_DIMENSAO                    " 
	    		,nativeQuery = true)   
		        List<FioProjection> buscaFio(@Param("idfil") int idfil,@Param("descricaoFio") String descricaoFio,@Param("codigo") String codigo) ;
*/     
		 
		 
		 
		
		@Query(value=  
				"select   " + 
				" trim(to_char(item.D0422_ID_ITEM,'0000000')) codigo , " + 
				" item.D0421_ID_MATERIAL  codMaterial , " + 
				" trim(to_char(item.d0002_id_fil,'00')) idfil," + 
				" item.D0003_ID_LOCALIZACAO localizacao," + 
				" (trim(mat.D0421_NOME) || ' ' || trim(mat.D0421_NOME_DIMENSAO) )   descricao," + 
				" titulo, " + 
				" mat.D0403_ID_CLASSE_MATERIAL classeMaterial," +
				" tipoMaquina," + 
				" toleranciaInferior," + 
				" toleranciaSuperior " + 
				" from " + 
				" STL.E0422_STL_ITEM item " + 
				" inner JOIN STL.e0421_stl_material mat on  item.D0421_ID_MATERIAL = mat.D0421_ID_MATERIAL    " + 
				" inner join " + 
				" (" + 				 
				" 	  Select " + 
				" 	  idfil,h8cod item,h8tit  titulo, h8tpmaq tipoMaquina, H8TOLUP toleranciaSuperior, H8TOLDWN toleranciaInferior" + 
				" 	  from cpfh8_dbf h8" + 
				" 	  where h8tit is not null" + 
				" ) tit on  trim(to_char(item.D0422_ID_ITEM,'0000000'))  = tit.item	  " +
				" WHERE item.d0002_id_fil  =   :idfil   and	" +  
				" (:descricaoFio IS NULL OR UPPER(mat.D0421_NOME) like  %:descricaoFio%  )   and " +
				" (:codigo IS NULL OR trim(to_char(item.D0422_ID_ITEM,'0000000')) = :codigo)   " +
				" order by mat.D0421_NOME,mat.D0421_NOME_DIMENSAO                    " 
	    		,nativeQuery = true)   
		        List<FioProjection> buscaFio(@Param("idfil") int idfil,@Param("descricaoFio") String descricaoFio,@Param("codigo") String codigo) ;
 	
		
		
	   

}

