package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.santanatextiles.alg.dto.MovimentoItemDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
 
@Entity 
@Table(name="CPFM2_DBF",schema="CPF")
@IdClass(MovimentoId.class)
public class Movimento implements Serializable {	

	private static final long serialVersionUID = 1L;  
	
	@Id
	@Column(name="M2ID")
	private Double id;	 	
 
	@Column(name="IDFIL")
	private String  idfil;
	
	 
	@Column(name="M2NF")
	private String notaFiscal;		
	
 
	@Column(name="M2FORN")
	private String fornecedor;	 
	
	 
	@Column(name="M2TPMOV",length = 5)
 
	///@Column()
	private String tipoMovimento;	 
	 
	@Column(name="M2TPMP")
	private String tipoMP;	 	
	
	@Column(name="M2DTBASE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataBase;	 
	
	@Column(name="M2DTEMI")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataEmissao;	 

	@Column(name="M2ENTSAI")
	private String entradaSaida;	 
	 
	@Column(name="M2LOTFIA")
	private String loteFiacao;		

	@Column(name="M2PESMED")
	private Double pesoMedio;		  
	
	@Column(name="M2PESTOT")
	private Double pesoTotal;		
	
	@Column(name="M2NUMVOL")
	private Double numVolumes;	 
	
	@Column(name="M2ORIG")
	private String produtor;		
	
	@Column(name="M2PROCED")
	private String procedencia;		
	
	@Column(name="M2LINABR")
	private String linhaAbertura;			
	 
	@Column(name="M2IDAUTO")
	private Double idAutomatico;	 

	@Column(name="M2MOVAUT")
	private String movimentoAutomatico;
	
	@Column(name="M2MOVPIL")
	private String movimentoPilha;	
 
	@Column(name="M2MIST")
	private String mistura;	
	
	@Column(name="M2SEQMST")
	private String sequenciaMistura;	 
	
	@Column(name="M2Q1C")
	private String qual1;
	
	@Column(name="M2Q2C")
	private String qual2;	 
	 
	@Column(name="M2USRINC")
	private String usuarioInclusao;	
	
	@Column(name="M2USRALT")
	private String usuarioAlteracao;		
	
	@Column(name="M2DTINC")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataInclusao;	 		
	
	@Column(name="M2DTALT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataAlteracao;	
	
	@OneToMany(mappedBy="movimento")
	private Set<MovimentoItem> itemMovimento = new HashSet<>();	 
	
	@Transient
	private Set<MovimentoItemDTO> itemMovimentoDTO = new HashSet<>();	
	
	@Transient
	private String nomeFornecedor;	

	@Transient
	private String nomeProdutor;	
	
	@Transient
	private String nomeProcedencia;
	
	
	@Transient
	private String nomeTipoMateriaPrima;
	
	@Transient
	private String nomeTipoMovimento;	
	

	

	@ManyToOne 
	@JoinColumnsOrFormulas({
	 @JoinColumnOrFormula(column=@JoinColumn(name="M2TPMOV", referencedColumnName="M5CDMOV", insertable = false, updatable = false)), 
		//@JoinColumnOrFormula(formula=@JoinFormula(value="M2TPMOV", referencedColumnName="M5CDMOV"))	,
		//@JoinColumnOrFormula(column=@JoinColumn(name="M2TPMOV", referencedColumnName="M5CDMOV", insertable = false, updatable = false)), 
		///@JoinColumnOrFormula(formula=@JoinFormula(value="(select TRIM(M5.M5CDMOV)  from CPF.CPFM5_DBF M5 where TRIM(M5.M5CDMOV) = TRIM(M2TPMOV) )"  )), 
		@JoinColumnOrFormula(formula=@JoinFormula(value="stl.fn_stl_idfil('CPFM5',idfil)", referencedColumnName="idfil"))	
	})	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private TipoMovimentoView fkTipoMovimento	;	
	
	
	@ManyToOne 
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column=@JoinColumn(name="M2FORN", referencedColumnName="B2COD", insertable = false, updatable = false)),
		@JoinColumnOrFormula(formula=@JoinFormula(value="stl.fn_stl_idfil('CCPB2',idfil)", referencedColumnName="idfil"))	
	})	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Fornecedor fkFornecedor	;	  
	
	
	@ManyToOne 
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column=@JoinColumn(name="M2ORIG", referencedColumnName="M6COD", insertable = false, updatable = false)),
		@JoinColumnOrFormula(formula=@JoinFormula(value="stl.fn_stl_idfil('CPFM6',idfil)", referencedColumnName="idfil"))	
	})		 
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Produtor fkProdutor	;	
	 
	@ManyToOne 
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column=@JoinColumn(name="M2PROCED", referencedColumnName="M7COD", insertable = false, updatable = false)),
		@JoinColumnOrFormula(formula=@JoinFormula(value="stl.fn_stl_idfil('CPFM7',idfil)", referencedColumnName="idfil"))	
	})		 
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Procedencia fkProcedencia	;		
	 
	@ManyToOne 
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column=@JoinColumn(name="M2TPMP", referencedColumnName="M8COD", insertable = false, updatable = false)),
		@JoinColumnOrFormula(formula=@JoinFormula(value="stl.fn_stl_idfil('CPFM8',idfil)", referencedColumnName="idfil"))	
	})		
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private TipoMateriaPrima fkTipoMP	;	 
	
	
	public Movimento() {
		
	}     
	

	public Movimento(Double id, String idfil, String notaFiscal, String fornecedor, String tipoMovimento, String tipoMP,
			Date dataBase, Date dataEmissao, String entradaSaida, String loteFiacao, Double pesoMedio, Double pesoTotal,
			Double numVolumes, String produtor, String procedencia, String linhaAbertura, Double idAutomatico,
			String movimentoAutomatico, String movimentoPilha, String mistura, String sequenciaMistura, String qual1,
			String qual2, String usuarioInclusao, String usuarioAlteracao, Date dataInclusao, Date dataAlteracao,
			Set<MovimentoItem> itemMovimento, Set<MovimentoItemDTO> itemMovimentoDTO, String nomeFornecedor,
			String nomeProdutor, String nomeProcedencia, String nomeTipoMateriaPrima, String nomeTipoMovimento,
			TipoMovimentoView fkTipoMovimento, Fornecedor fkFornecedor, Produtor fkProdutor, Procedencia fkProcedencia,
			TipoMateriaPrima fkTipoMP) {
		super();
		this.id = id;
		this.idfil = idfil;
		this.notaFiscal = notaFiscal;
		this.fornecedor = fornecedor;
		this.tipoMovimento = tipoMovimento;
		this.tipoMP = tipoMP;
		this.dataBase = dataBase;
		this.dataEmissao = dataEmissao;
		this.entradaSaida = entradaSaida;
		this.loteFiacao = loteFiacao;
		this.pesoMedio = pesoMedio;
		this.pesoTotal = pesoTotal;
		this.numVolumes = numVolumes;
		this.produtor = produtor;
		this.procedencia = procedencia;
		this.linhaAbertura = linhaAbertura;
		this.idAutomatico = idAutomatico;
		this.movimentoAutomatico = movimentoAutomatico;
		this.movimentoPilha = movimentoPilha;
		this.mistura = mistura;
		this.sequenciaMistura = sequenciaMistura;
		this.qual1 = qual1;
		this.qual2 = qual2;
		this.usuarioInclusao = usuarioInclusao;
		this.usuarioAlteracao = usuarioAlteracao;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
		this.itemMovimento = itemMovimento;
		this.itemMovimentoDTO = itemMovimentoDTO;
		this.nomeFornecedor = nomeFornecedor;
		this.nomeProdutor = nomeProdutor;
		this.nomeProcedencia = nomeProcedencia;
		this.nomeTipoMateriaPrima = nomeTipoMateriaPrima;
		this.nomeTipoMovimento = nomeTipoMovimento;
		this.fkTipoMovimento = fkTipoMovimento;
		this.fkFornecedor = fkFornecedor;
		this.fkProdutor = fkProdutor;
		this.fkProcedencia = fkProcedencia;
		this.fkTipoMP = fkTipoMP;
	}





	public Double getId() {
		return id;
	}


	public void setId(Double id) {
		this.id = id;
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


	public Double getNumVolumes() {
		return numVolumes;
	}


	public void setNumVolumes(Double numVolumes) {
		this.numVolumes = numVolumes;
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


	public Set<MovimentoItem> getItemMovimento() {
		return itemMovimento;
	}


	public void setItemMovimento(Set<MovimentoItem> itemMovimento) {
		this.itemMovimento = itemMovimento;
	}


	public Set<MovimentoItemDTO> getItemMovimentoDTO() {
		return itemMovimentoDTO;
	}


	public void setItemMovimentoDTO(Set<MovimentoItemDTO> itemMovimentoDTO) {
		this.itemMovimentoDTO = itemMovimentoDTO;
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


	public TipoMovimentoView getFkTipoMovimento() {
		return fkTipoMovimento;
	}


	public void setFkTipoMovimento(TipoMovimentoView fkTipoMovimento) {
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
	

	public String getQual1() {
		return qual1;
	}


	public void setQual1(String qual1) {
		this.qual1 = qual1;
	}


	public String getQual2() {
		return qual2;
	}


	public void setQual2(String qual2) {
		this.qual2 = qual2;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimento other = (Movimento) obj;
		return Objects.equals(id, other.id);
	}

 
 
	
	
	
}
