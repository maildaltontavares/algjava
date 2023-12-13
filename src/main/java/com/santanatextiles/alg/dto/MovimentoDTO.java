package com.santanatextiles.alg.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santanatextiles.alg.domain.Fornecedor;
import com.santanatextiles.alg.domain.Procedencia;
import com.santanatextiles.alg.domain.Produtor;
import com.santanatextiles.alg.domain.TipoMateriaPrima;
import com.santanatextiles.alg.domain.TipoMovimento;

public class MovimentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;  
 
	private String idfil;  
	private String notaFiscal;	 
	private String fornecedor;	 
	private String tipoMovimento;	 
	private String tipoMP;	 	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataBase;	  
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataEmissao;	 
	private Double id;	 		 
	private String entradaSaida; 
	private String loteFiacao;	 
	private Double pesoMedio;	 
	private Double pesoTotal;	 
	private String produtor;	 
	private String procedencia;		 
	private String linhaAbertura;	 
	private Double idAutomatico; 
	private String movimentoAutomatico; 
	private String movimentoPilha;	 
	private String mistura;	 
	private String sequenciaMistura;	 
	private String usuarioInclusao;	 
	private String usuarioAlteracao; 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataInclusao; 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataAlteracao;	 
	private TipoMovimento fkTipoMovimento	; 
	private Fornecedor fkFornecedor	;	  
	private Produtor fkProdutor	;	 
	private Procedencia fkProcedencia	; 
	private TipoMateriaPrima fkTipoMP	;
	private Double numVolumes;	  
	private String nomeFornecedor;	 
	private String nomeProdutor;	 
	private String nomeProcedencia; 
	private String nomeTipoMateriaPrima; 
	private String nomeTipoMovimento;	 
	private String dataInicial; 
	private String dataFinal;
	
	private Set<MovimentoItemDTO> itemMovimentoDTO = new HashSet<>();
	
	
	public MovimentoDTO() {} 
	
 
	public MovimentoDTO(String idfil, String notaFiscal, String fornecedor, String tipoMovimento, String tipoMP,
			Date dataBase, Date dataEmissao, Double id, String entradaSaida, String loteFiacao, Double pesoMedio,
			Double pesoTotal, String produtor, String procedencia, String linhaAbertura, Double idAutomatico,
			String movimentoAutomatico, String movimentoPilha, String mistura, String sequenciaMistura,
			String usuarioInclusao, String usuarioAlteracao, Date dataInclusao, Date dataAlteracao,
			TipoMovimento fkTipoMovimento, Fornecedor fkFornecedor, Produtor fkProdutor, Procedencia fkProcedencia,
			TipoMateriaPrima fkTipoMP, Double numVolumes, String nomeFornecedor, String nomeProdutor,
			String nomeProcedencia, String nomeTipoMateriaPrima, String nomeTipoMovimento, String dataInicial,
			String dataFinal, Set<MovimentoItemDTO> itemMovimentoDTO) {
		super();
		this.idfil = idfil;
		this.notaFiscal = notaFiscal;
		this.fornecedor = fornecedor;
		this.tipoMovimento = tipoMovimento;
		this.tipoMP = tipoMP;
		this.dataBase = dataBase;
		this.dataEmissao = dataEmissao;
		this.id = id;
		this.entradaSaida = entradaSaida;
		this.loteFiacao = loteFiacao;
		this.pesoMedio = pesoMedio;
		this.pesoTotal = pesoTotal;
		this.produtor = produtor;
		this.procedencia = procedencia;
		this.linhaAbertura = linhaAbertura;
		this.idAutomatico = idAutomatico;
		this.movimentoAutomatico = movimentoAutomatico;
		this.movimentoPilha = movimentoPilha;
		this.mistura = mistura;
		this.sequenciaMistura = sequenciaMistura;
		this.usuarioInclusao = usuarioInclusao;
		this.usuarioAlteracao = usuarioAlteracao;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
		this.fkTipoMovimento = fkTipoMovimento;
		this.fkFornecedor = fkFornecedor;
		this.fkProdutor = fkProdutor;
		this.fkProcedencia = fkProcedencia;
		this.fkTipoMP = fkTipoMP;
		this.numVolumes = numVolumes;
		this.nomeFornecedor = nomeFornecedor;
		this.nomeProdutor = nomeProdutor;
		this.nomeProcedencia = nomeProcedencia;
		this.nomeTipoMateriaPrima = nomeTipoMateriaPrima;
		this.nomeTipoMovimento = nomeTipoMovimento;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.itemMovimentoDTO = itemMovimentoDTO;
	} 



	public String getIdfil() {
		return idfil;
	}


	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}


	public String getNotaFiscal() {
		return notaFiscal;
	}


	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}


	public String getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}


	public String getTipoMovimento() {
		return tipoMovimento;
	}


	public void setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}


	public String getTipoMP() {
		return tipoMP;
	}


	public void setTipoMP(String tipoMP) {
		this.tipoMP = tipoMP;
	}


	public Date getDataBase() {
		return dataBase;
	}


	public void setDataBase(Date dataBase) {
		this.dataBase = dataBase;
	}


	public Date getDataEmissao() {
		return dataEmissao;
	}


	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}


	public Double getId() {
		return id;
	}


	public void setId(Double id) {
		this.id = id;
	}


	public String getEntradaSaida() {
		return entradaSaida;
	}


	public void setEntradaSaida(String entradaSaida) {
		this.entradaSaida = entradaSaida;
	}


	public String getLoteFiacao() {
		return loteFiacao;
	}


	public void setLoteFiacao(String loteFiacao) {
		this.loteFiacao = loteFiacao;
	}


	public Double getPesoMedio() {
		return pesoMedio;
	}


	public void setPesoMedio(Double pesoMedio) {
		this.pesoMedio = pesoMedio;
	}


	public Double getPesoTotal() {
		return pesoTotal;
	}


	public void setPesoTotal(Double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}


	public String getProdutor() {
		return produtor;
	}


	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}


	public String getProcedencia() {
		return procedencia;
	}


	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}


	public String getLinhaAbertura() {
		return linhaAbertura;
	}


	public void setLinhaAbertura(String linhaAbertura) {
		this.linhaAbertura = linhaAbertura;
	}


	public Double getIdAutomatico() {
		return idAutomatico;
	}


	public void setIdAutomatico(Double idAutomatico) {
		this.idAutomatico = idAutomatico;
	}


	public String getMovimentoAutomatico() {
		return movimentoAutomatico;
	}


	public void setMovimentoAutomatico(String movimentoAutomatico) {
		this.movimentoAutomatico = movimentoAutomatico;
	}


	public String getMovimentoPilha() {
		return movimentoPilha;
	}


	public void setMovimentoPilha(String movimentoPilha) {
		this.movimentoPilha = movimentoPilha;
	}


	public String getMistura() {
		return mistura;
	}


	public void setMistura(String mistura) {
		this.mistura = mistura;
	}


	public String getSequenciaMistura() {
		return sequenciaMistura;
	}


	public void setSequenciaMistura(String sequenciaMistura) {
		this.sequenciaMistura = sequenciaMistura;
	}


	public String getUsuarioInclusao() {
		return usuarioInclusao;
	}


	public void setUsuarioInclusao(String usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}


	public String getUsuarioAlteracao() {
		return usuarioAlteracao;
	}


	public void setUsuarioAlteracao(String usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}


	public Date getDataInclusao() {
		return dataInclusao;
	}


	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}


	public Date getDataAlteracao() {
		return dataAlteracao;
	}


	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}


	public TipoMovimento getFkTipoMovimento() {
		return fkTipoMovimento;
	}


	public void setFkTipoMovimento(TipoMovimento fkTipoMovimento) {
		this.fkTipoMovimento = fkTipoMovimento;
	}


	public Fornecedor getFkFornecedor() {
		return fkFornecedor;
	}


	public void setFkFornecedor(Fornecedor fkFornecedor) {
		this.fkFornecedor = fkFornecedor;
	}


	public Produtor getFkProdutor() {
		return fkProdutor;
	}


	public void setFkProdutor(Produtor fkProdutor) {
		this.fkProdutor = fkProdutor;
	}


	public Procedencia getFkProcedencia() {
		return fkProcedencia;
	}


	public void setFkProcedencia(Procedencia fkProcedencia) {
		this.fkProcedencia = fkProcedencia;
	}


	public TipoMateriaPrima getFkTipoMP() {
		return fkTipoMP;
	}


	public void setFkTipoMP(TipoMateriaPrima fkTipoMP) {
		this.fkTipoMP = fkTipoMP;
	}


	public Double getNumVolumes() {
		return numVolumes;
	}


	public void setNumVolumes(Double numVolumes) {
		this.numVolumes = numVolumes;
	}


	public String getNomeFornecedor() {
		return nomeFornecedor;
	}


	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}


	public String getNomeProdutor() {
		return nomeProdutor;
	}


	public void setNomeProdutor(String nomeProdutor) {
		this.nomeProdutor = nomeProdutor;
	}


	public String getNomeProcedencia() {
		return nomeProcedencia;
	}


	public void setNomeProcedencia(String nomeProcedencia) {
		this.nomeProcedencia = nomeProcedencia;
	}


	public String getNomeTipoMateriaPrima() {
		return nomeTipoMateriaPrima;
	}


	public void setNomeTipoMateriaPrima(String nomeTipoMateriaPrima) {
		this.nomeTipoMateriaPrima = nomeTipoMateriaPrima;
	}


	public String getNomeTipoMovimento() {
		return nomeTipoMovimento;
	}


	public void setNomeTipoMovimento(String nomeTipoMovimento) {
		this.nomeTipoMovimento = nomeTipoMovimento;
	}


	public String getDataInicial() {
		return dataInicial;
	}


	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}


	public String getDataFinal() {
		return dataFinal;
	}


	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}


	public Set<MovimentoItemDTO> getItemMovimentoDTO() {
		return itemMovimentoDTO;
	}


	public void setItemMovimentoDTO(Set<MovimentoItemDTO> itemMovimentoDTO) {
		this.itemMovimentoDTO = itemMovimentoDTO;
	}

 
	
	
	

 
	
	
	

}
