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

import com.santanatextiles.alg.domain.EstoqueMP;
import com.santanatextiles.alg.domain.MisturaPadrao;
import com.santanatextiles.alg.domain.MisturaPadraoItem;
import com.santanatextiles.alg.domain.Movimento;
import com.santanatextiles.alg.domain.ProducaoAbertura;
import com.santanatextiles.alg.dto.MisturaPadraoCabecDTO;
import com.santanatextiles.alg.dto.MisturaPadraoDTO;
import com.santanatextiles.alg.dto.MisturaPadraoItemDTO;
import com.santanatextiles.alg.dto.MovimentoDTO;
import com.santanatextiles.alg.dto.MovimentoItemDTO;
import com.santanatextiles.alg.projections.MisturaPadraoCabecProjection;
import com.santanatextiles.alg.repositories.MisturaPadraoRepository;

@Service
public class MisturaPadraoService {

	@Autowired
	private MisturaPadraoRepository repo;

	@Autowired
	private MisturaPadraoItemService misturaItemservice;

	@Autowired
	private MovimentoService movimentoService;
	
	@Autowired
	private EstoqueMPService estoqueService;	
	
	@Autowired
	private  ProducaoAberturaService ProducaoAberturaService;

	@Value("${spring.datasource.url}")
	private String JDBC_URL;

	@Value("${spring.datasource.username}")
	private String JDBC_USER;

	@Value("${spring.datasource.password}")
	private String JDBC_PASSWORD;

	public List<MisturaPadrao> buscaMisturaPadraoPorParametros(String filial) {
		List<MisturaPadrao> obj = repo.buscaMisturaPadraoPorParametros(filial);
		return obj;
	}

	public List<MisturaPadrao> buscaMisturasAbertas(String filial) {
		List<MisturaPadrao> obj = repo.buscaMisturasAbertas(filial);
		return obj;
	}

	public List<MisturaPadrao> buscaMisturasABaixar(String filial) {
		List<MisturaPadrao> obj = repo.buscaMisturasABaixar(filial);
		return obj;
	}

	public List<MisturaPadrao> buscaMisturasFull(String filial) {
		List<MisturaPadrao> obj = repo.buscaMisturasFull(filial);
		return obj;
	}

	public List<MisturaPadrao> buscaMisturaPadraoByFilial(String filial) {
		List<MisturaPadrao> obj = repo.findByIdfil(filial);
		return obj;
	}

	public String buscaNovoIdMistura(String idfil) {
		String numNovaMistura = repo.buscaNovoIdMistura(idfil);
		String obj = String.format("%010d", Integer.parseInt(numNovaMistura));
		return obj;

	}

	@Transactional
	public String reabrirMistura(MisturaPadraoDTO misturaDTO) throws ParseException {
		Integer obj = repo.reabrirMistura(misturaDTO.getIdfil(), misturaDTO.getMistura());
		return misturaDTO.getMistura();
	}
	
	@Transactional
	public String encerrarMistura(String idfil,String mistura) throws ParseException {
		Integer obj = repo.encerrarMistura(idfil, mistura);
		return mistura;
	}
	
	@Transactional
	public Integer qtdeMistura(String idfil,String mistura) throws ParseException {
		Integer obj = repo.qtdeMistura(idfil, mistura);
		return obj;
	}	
	

	public String incluirMistura(MisturaPadraoDTO misturaDTO, String oper) throws ParseException {
		String obj = gravarMistura(misturaDTO, oper);
		return obj;
	}

	public String alterarMistura(MisturaPadraoDTO misturaDTO, String oper) throws ParseException {
		String obj = gravarMistura(misturaDTO, oper);
		return obj;
	}

	@Transactional
	public String gravarMistura(MisturaPadraoDTO misturaDTO, String oper) throws ParseException {

		LocalDate dataAtual = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = dataAtual.format(formatter);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		if (oper.equals("I")) {
			misturaDTO.setDataInclusao(dateFormat.parse(dataFormatada));
			misturaDTO.setDataAlteracao(dateFormat.parse(dataFormatada));
		} else if (oper.equals("A")) {
			misturaDTO.setDataAlteracao(dateFormat.parse(dataFormatada));

		}

		MisturaPadrao mistPadrao = fromDTO(misturaDTO, oper, dataFormatada);

		repo.save(mistPadrao);
		misturaItemservice.deletaMisturaItem(mistPadrao);

		Iterator<MisturaPadraoItemDTO> it = misturaDTO.getMisturaPadraoItemDTO().iterator();

		while (it.hasNext()) {

			MisturaPadraoItem movimentoItem = misturaItemservice.gravaItem(it.next(), oper, dataFormatada, mistPadrao);

		}

		return mistPadrao.getMistura();

	}

	public MisturaPadrao fromDTO(MisturaPadraoDTO misturaDTO, String operac, String dtDia) throws ParseException {

		MisturaPadrao mistura = new MisturaPadrao();

		String codMistura;

		if (misturaDTO.getMistura().equals("")) {
			codMistura = buscaNovoIdMistura(misturaDTO.getIdfil());
		} else {
			codMistura = misturaDTO.getMistura();
		}

		mistura.setIdfil(misturaDTO.getIdfil());
		mistura.setMistura(codMistura);
		mistura.setLote(misturaDTO.getLote());
		mistura.setStatus(misturaDTO.getStatus());
		mistura.setDataInicial(misturaDTO.getDataInicial());
		mistura.setDataFinal(misturaDTO.getDataFinal());
		mistura.setTotalMisturas(misturaDTO.getTotalMisturas());
		mistura.setDataInclusao(misturaDTO.getDataInclusao());
		mistura.setUsuarioInclusao(misturaDTO.getUsuarioInclusao());
		mistura.setDataAlteracao(misturaDTO.getDataAlteracao());
		mistura.setUsuarioAlteracao(misturaDTO.getUsuarioAlteracao());
		mistura.setNumMisturasLiberadas(misturaDTO.getNumMisturasLiberadas());
		mistura.setObservacao(misturaDTO.getObservacao());
		mistura.setNumFardos(misturaDTO.getNumFardos());

		return mistura;

	}

	@Transactional
	public void deletaMistura(String idfil, String mistura) {

		MisturaPadrao mistPadrao = new MisturaPadrao();
		mistPadrao.setIdfil(idfil);
		mistPadrao.setMistura(mistura);

		repo.deleteByIdfilAndMistura(idfil, mistura);

		misturaItemservice.deletaMisturaItem(mistPadrao);

	}

	public MisturaPadraoCabecDTO buscaMisturaCalculada(String filial, String mistura) {

		List<MisturaPadraoCabecProjection> misturaPesquisaCabecP = repo.buscaMisturaCalculada(filial, mistura);

		List<MisturaPadraoCabecDTO> listaMisturaPesquisaCabec = misturaPesquisaCabecP.stream()
				.map(x -> new MisturaPadraoCabecDTO(x)).toList();

		MisturaPadraoCabecDTO misturaPesquisaCabec = new MisturaPadraoCabecDTO();

		for (MisturaPadraoCabecDTO misturaPesquisaIdDTO : listaMisturaPesquisaCabec) {

			misturaPesquisaCabec.setIdfil(misturaPesquisaIdDTO.getIdfil());
			misturaPesquisaCabec.setMistura(misturaPesquisaIdDTO.getMistura());
			misturaPesquisaCabec.setLoteFiacao(misturaPesquisaIdDTO.getLoteFiacao());
			misturaPesquisaCabec.setStatus(misturaPesquisaIdDTO.getStatus());

			misturaPesquisaCabec.setDataInicial(misturaPesquisaIdDTO.getDataInicial());
			misturaPesquisaCabec.setDataFinal(misturaPesquisaIdDTO.getDataFinal());
			misturaPesquisaCabec.setQuantidade(misturaPesquisaIdDTO.getQuantidade());

			misturaPesquisaCabec.setDataInclusao(misturaPesquisaIdDTO.getDataInclusao());
			misturaPesquisaCabec.setUsuarioInclusao(misturaPesquisaIdDTO.getUsuarioInclusao());

			misturaPesquisaCabec.setDataAlteracao(misturaPesquisaIdDTO.getDataAlteracao());
			misturaPesquisaCabec.setUsuarioAlteracao(misturaPesquisaIdDTO.getUsuarioAlteracao());

			misturaPesquisaCabec.setNumMisturasLiberadas(misturaPesquisaIdDTO.getNumMisturasLiberadas());
			misturaPesquisaCabec.setNumFardos(misturaPesquisaIdDTO.getNumFardos());
			misturaPesquisaCabec.setTotalUtilizadas(misturaPesquisaIdDTO.getTotalUtilizadas());
			misturaPesquisaCabec.setObservacao(misturaPesquisaIdDTO.getObservacao());

		}

		return misturaPesquisaCabec;
	}

	@Transactional
	public String baixarMistura(MisturaPadraoDTO misturaDTO) throws ParseException { 
		
		   ArrayList<MovimentoDTO> mov = new ArrayList<>(); 
		   Set<MovimentoItemDTO> itemMovimentoDTO = new HashSet<>();
		   
		   MovimentoDTO movimDTO = fromMistDTOToMovim(misturaDTO ); 
		   ArrayList<MovimentoItemDTO> movItensDTO = (ArrayList<MovimentoItemDTO>) fromMistDTOToItemMovim(misturaDTO); 
		   
		   Set<MovimentoItemDTO> setItemMovimentoDTO = new HashSet<>(movItensDTO);  
		   movimDTO.setItemMovimentoDTO(setItemMovimentoDTO); 
		   
		   mov.add(movimDTO);   
		   Movimento movimGravado =  movimentoService.insert(mov);  
		   
		   // Buscar a total de misturas baixadas
		   Integer totBaixadas = repo.numMisturasBaixadas(misturaDTO.getIdfil(),misturaDTO.getMistura());  
		   String totBaixada = String.format("%02d",  totBaixadas );  
		   
	       /// Buscar a total de misturas a baixar 
		   Integer numMist = qtdeMistura(misturaDTO.getIdfil(),misturaDTO.getMistura());	 
		   String numMistTotal = String.format("%02d",  numMist );   
		   
		   if(misturaDTO.getStatus().equals("L") &&  numMistTotal.equals(totBaixada)) { 
			   encerrarMistura(misturaDTO.getIdfil(),misturaDTO.getMistura()); 
		   }  		   
		   
		   ProducaoAbertura pa = gravaProducaoMistura(movimGravado.getIdAutomatico(),misturaDTO.getMistura(),movimDTO.getSequenciaMistura(), movimDTO.getIdfil());
		    
		   return movimDTO.getNotaFiscal();
		
	}
	
	
	private ProducaoAbertura gravaProducaoMistura(Double idAuto, String mistura, String sequencia, String idfil) throws ParseException {
		 
		
		   ProducaoAbertura prodAber = new ProducaoAbertura();
		   prodAber.setIdfil(idfil);  
		   prodAber.setMistura(mistura);  
		   prodAber.setSeq(sequencia);
		   prodAber.setIdAutomatico(idAuto);
		   
		   
		   ProducaoAberturaService.gravaBaixaMistura(prodAber);
		   
		   
		
		return prodAber;
	}
	
	private List<MovimentoItemDTO> fromMistDTOToItemMovim(MisturaPadraoDTO misturaDTO) {  
	   
		   Iterator<MisturaPadraoItemDTO> it = misturaDTO.getMisturaPadraoItemDTO().iterator();
			 
		   ArrayList<MovimentoItemDTO> movItens = new ArrayList<>();
		   
		   while (it.hasNext()) {
				
			    MisturaPadraoItemDTO misturaIt =   it.next();
			   
			    EstoqueMP itemEstoque = estoqueService.findById(misturaIt.getIdItem());  
				
				MovimentoItemDTO movimentoItem = new MovimentoItemDTO();  
				
				movimentoItem.setIdMovimento(misturaIt.getIdItem());   
				movimentoItem.setIdfil(misturaIt.getIdfil()); 
				movimentoItem.setNotaFiscal(itemEstoque.getNotaFiscal()); 
				movimentoItem.setFornecedor(itemEstoque.getFornecedor()); 
				movimentoItem.setNotaFiscal(itemEstoque.getNotaFiscal());	 
				movimentoItem.setFornecedor(itemEstoque.getFornecedor()); 
				movimentoItem.setItem(itemEstoque.getItem());
				movimentoItem.setProdutor(itemEstoque.getProdutor());
				movimentoItem.setProcedencia(itemEstoque.getProcedencia());	 
				movimentoItem.setLote(itemEstoque.getLote()); 
				movimentoItem.setTamanho(itemEstoque.getTamanho());
				movimentoItem.setDescFio(itemEstoque.getDescFio());			
				movimentoItem.setUnidadeMedida(itemEstoque.getUnidadeMedida()); 
				movimentoItem.setPilha(itemEstoque.getPilha());	 
				movimentoItem.setPesoMedio(itemEstoque.getPesoMedio()); 
				movimentoItem.setTipoQualidade(itemEstoque.getTipoQualidade()); 
				movimentoItem.setClassifQualidade(itemEstoque.getClassifQualidade());
				movimentoItem.setQualidade(itemEstoque.getTipoQualidade() ) ;
				movimentoItem.setLoteAdicional(itemEstoque.getLoteAdicional());  
				movimentoItem.setColoracao(itemEstoque.getColoracao());
				movimentoItem.setIdVolume(itemEstoque.getIdVolume()); 
				movimentoItem.setTipoMic(itemEstoque.getTipoMic());
				movimentoItem.setDestino(itemEstoque.getDestino());  
				movimentoItem.setSac(itemEstoque.getSac());
				movimentoItem.setTrid(itemEstoque.getTrid());			
				movimentoItem.setPim(itemEstoque.getPim());
				movimentoItem.setSc(itemEstoque.getSc());	 
				movimentoItem.setMst(itemEstoque.getMst()); 
				movimentoItem.setMic(itemEstoque.getMic());	   
				movimentoItem.setMat(itemEstoque.getMat());
				movimentoItem.setUi(itemEstoque.getUi());
				movimentoItem.setSf(itemEstoque.getSf());	 
				movimentoItem.setStr(itemEstoque.getStr());	 
				movimentoItem.setElg(itemEstoque.getElg());	 
				movimentoItem.setTipo(itemEstoque.getTipo());	 
				movimentoItem.setSic(itemEstoque.getSic());	  
				movimentoItem.setUhml(itemEstoque.getUhml());
				movimentoItem.setRs(itemEstoque.getRs());	 
				movimentoItem.setB(itemEstoque.getB());	 
				movimentoItem.setTrcnt(itemEstoque.getTrcnt());	 
				movimentoItem.setTrar(itemEstoque.getTrar());	 
		 	 
				//movimentoItem.setPesoCalculadoInformado(itemEstoque.getPesoCalculadoInformado()); 
				//movimentoItem.setDataInclusao(itemEstoque.getDataInclusao());
				//movimentoItem.setDataAlteracao(itemEstoque.getDataAlteracao());	 
				//movimentoItem.setVlUnitario(itemEstoque.getV); 
				
				movimentoItem.setUsuarioInclusao(itemEstoque.getUsuarioInclusao());	 
				movimentoItem.setUsuarioAlteracao(itemEstoque.getUsuarioAlteracao());   
			      
				movimentoItem.setQuantidade(misturaIt.getQuantidade());	 
				movimentoItem.setPeso(itemEstoque.getPesoMedio() * misturaIt.getQuantidade());   
				movimentoItem.setStatusItem("Inclusão");
				movimentoItem.setStatusItemOriginal("Inclusão");	 
				
				movItens.add(movimentoItem);
				
				
		   } 
		   
		   return movItens;
	   
	}
	
	
	
	
	
	
	public MovimentoDTO fromMistDTOToMovim(MisturaPadraoDTO misturaDTO ) throws ParseException {		
		LocalDate dataAtual = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		String dataFormatada = dataAtual.format(formatter); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
	     
	    //Double novoCodigo = movimentoService.codigoNovoMovimento(); 
	    Integer novaSeq = repo.seqMisturasBaixadas(misturaDTO.getIdfil(),misturaDTO.getMistura());
	    if(  novaSeq==null) {
	    	novaSeq =1; 
	    }else {
	      novaSeq = novaSeq +1;
	    }  
	    
	    String novaSequencia = String.format("%02d",  novaSeq );  
	    //String nf = misturaDTO.getMistura().substring(3)  + '/' + String.format("%02d", Integer.parseInt(novaSequencia.toString())); ;
	    String nf = misturaDTO.getMistura().substring(3)  + '/' + novaSequencia ;
	     
	    
	    //if(obj.getMovimentoAutomatico() !=null && obj.getMovimentoAutomatico().equals("S")) { 
		    //Double novoCodigoAutomatico = repo.codigoNovoMovimento(); 
		    //obj.setIdAutomatico(novoCodigoAutomatico);		 
	    //}
	  
		
		MovimentoDTO movimento = new MovimentoDTO();

		//Preencher
		
		//movimento.setId(novoCodigo); 
		movimento.setEntradaSaida("S"); 
		movimento.setIdfil(misturaDTO.getIdfil());
		movimento.setNotaFiscal(nf);
		if (misturaDTO.getIdfil().equals("01")) {
			movimento.setFornecedor("01366");
		} else if(misturaDTO.getIdfil().equals("05")) {
			movimento.setFornecedor("00249");
		} else if(misturaDTO.getIdfil().equals("03")) {
			movimento.setFornecedor("01366");	  // Corrigir		
		}
	    movimento.setTipoMovimento("MIST"); 
		movimento.setTipoMP("ALG");  
		movimento.setLoteFiacao(misturaDTO.getLote());
		movimento.setNumVolumes(misturaDTO.getNumFardos());
		if(misturaDTO.getNumFardos() >0) {
			movimento.setPesoMedio(misturaDTO.getPesoTotal() / misturaDTO.getNumFardos());	
		} 
		movimento.setPesoTotal( misturaDTO.getPesoTotal() ); 

		movimento.setMovimentoAutomatico("A");
		movimento.setMovimentoPilha("N");  
		movimento.setMistura(misturaDTO.getMistura());
		movimento.setSequenciaMistura(novaSequencia);  
		
		movimento.setUsuarioInclusao(misturaDTO.getUsuarioInclusao());
		movimento.setUsuarioAlteracao(misturaDTO.getUsuarioAlteracao());   
		
		movimento.setDataBase(dateFormat.parse(dataFormatada));	
		movimento.setDataEmissao(dateFormat.parse(dataFormatada));	
	 
		 
 
		//movimento.setItemMovimentoDTO(objDTO.getItemMovimentoDTO());

		 

		return movimento;
	}
	
	
	
	

}
