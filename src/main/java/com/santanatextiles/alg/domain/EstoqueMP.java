package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity 
@Table(name="CPFM4_DBF",schema="CPF")
@IdClass(EstoqueMPId.class)
public class EstoqueMP implements Serializable {	

	private static final long serialVersionUID = 1L;    
	
	@Id
	@Column(name="M4ID")
	private Double id;	 	
	
	@Column(name="IDFIL")
	private String  idfil;
	
  //  @Formula(value = "stl.fn_stl_idfil('CPFM6', idfil)")
 //   private String idFilProdutor;	
	
	 
	@Column(name="M4NF")
	private String notaFiscal;		
	
 
	@Column(name="M4FORN")
	private String fornecedor;	
	
 
	@Column(name="M4ITEM")
	private String item;		 
	
 
	@Column(name="M4ORIG")
	private String produtor;
	
 
	@Column(name="M4PROCED")
	private String procedencia;	

	 
	@Column(name="M4LOTE")
	private String lote;
	
	 
	@Column(name="M4QUAL")
	private String qualidade;	
	
 
	@Column(name="M4TAM")
	private String tamanho;	
	
	 
	@Column(name="M4QTDE")
	private Double quantidade;		
	
	@Column(name="M4PESO")
	private Double peso;	   
	
	@Column(name="M4IDCAB")
	private Double idCab;	 	
	
	@Column(name="M4UM")
	private String unidadeMedida;	
	
	@Column(name="M4PILHA")
	private String pilha;		
	
	@Column(name="M4DESCF")
	private String descFio;		 
	
	@Column(name="M4VLEST")
	private Double valorEstoque; 	 
	 
	@Column(name="M4DTINC")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date dataInclusao;	 

	@Column(name="M4DTALT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date dataAlteracao;	 	
	
	@Column(name="M4DTMOV")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date dataMovimentacao;	 		
	
	@Column(name="M4USRINC")
	private String usuarioInclusao;	
	
	@Column(name="M4USRALT")
	private String usuarioAlteracao; 
	
	@Column(name="M4PESMED")
	private Double pesoMedio;	 

	@Column(name="M4SAC")
	private Double sac;	 
	
	@Column(name="M4TRID")
	private Double trid;	 
	
	@Column(name="M4PIM")
	private Double pim;	 
	
	@Column(name="M4SC")
	private Double sc;	 
	
	@Column(name="M4MST")
	private Double mst;	   

	@Column(name="M4MIC")
	private Double mic;	  
 
	@Column(name="M4MAT")
	private Double mat;	   
	
	@Column(name="M4UI")
	private Double ui;	   
	
	@Column(name="M4SF")
	private Double sf;	  	
	
	@Column(name="M4STR")
	private Double str;	
	
	@Column(name="M4ELG")
	private Double elg;	
	
	@Column(name="M4TIPO")
	private Double tipo;	
	
	@Column(name="M4SIC")
	private Double sic;	 	
	
	@Column(name="M4UHML")
	private Double uhml;	
	
	@Column(name="M4RS")
	private Double rs;	
	
	@Column(name="M4B")
	private Double b;	
	
	@Column(name="M4TRCNT")
	private Double trcnt;	
	
	@Column(name="M4TRAR")
	private Double trar;	
	
	@Column(name="M4TPQ")
	private String tipoQualidade;
	
	@Column(name="M4CLASQ")
	private String classifQualidade;
	
	@Column(name="M4COLOR")
	private String coloracao;	
	
	@Column(name="M4LTADIC")
	private String loteAdicional;	
	
	@Column(name="M4IDFARD")
	private String idVolume;	
	
	@Column(name="M4TPMIC")
	private String tipoMic;	
	
	@Column(name="M4DEST")
	private String destino;	  
	
	@Transient
	private String dsFornecedor;	
	
	@Transient
	private String dsProdutor;	

	@Transient
	private String dsProcedencia;	
	
	
	@ManyToOne 
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column=@JoinColumn(name="M4FORN", referencedColumnName="B2COD", insertable = false, updatable = false)),
		@JoinColumnOrFormula(formula=@JoinFormula(value="stl.fn_stl_idfil('CCPB2',idfil)", referencedColumnName="idfil"))	
	})	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Fornecedor fkFornecedor	;	  
	
	
	@ManyToOne 
	    @JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column=@JoinColumn(name="M4ORIG", referencedColumnName="M6COD", insertable = false, updatable = false)) ,
		@JoinColumnOrFormula(formula=@JoinFormula(value="stl.fn_stl_idfil('CPFM6',idfil)", referencedColumnName="idfil"))
	})	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Produtor fkProdutor	;	  
 
	
	@ManyToOne 
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column=@JoinColumn(name="M4PROCED", referencedColumnName="M7COD", insertable = false, updatable = false)),
		@JoinColumnOrFormula(formula=@JoinFormula(value="stl.fn_stl_idfil('CPFM7',idfil)", referencedColumnName="idfil"))	
	})		 
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Procedencia fkProcedencia	;
	
	public EstoqueMP() {}   


	public EstoqueMP(Double id, String idfil, String notaFiscal, String fornecedor, String item, String produtor,
			String procedencia, String lote, String qualidade, String tamanho, Double quantidade, Double peso,
			Double idCab, String unidadeMedida, String pilha, String descFio, Double valorEstoque, Date dataInclusao,
			Date dataAlteracao, Date dataMovimentacao, String usuarioInclusao, String usuarioAlteracao,
			Double pesoMedio, Double sac, Double trid, Double pim, Double sc, Double mst, Double mic, Double mat,
			Double ui, Double sf, Double str, Double elg, Double tipo, Double sic, Double uhml, Double rs, Double b,
			Double trcnt, Double trar, String tipoQualidade, String classifQualidade, String coloracao,
			String loteAdicional, String idVolume, String tipoMic, String destino, String dsFornecedor,
			String dsProdutor, String dsProcedencia, Fornecedor fkFornecedor, Produtor fkProdutor,
			Procedencia fkProcedencia) {
		super();
		this.id = id;
		this.idfil = idfil;
		this.notaFiscal = notaFiscal;
		this.fornecedor = fornecedor;
		this.item = item;
		this.produtor = produtor;
		this.procedencia = procedencia;
		this.lote = lote;
		this.qualidade = qualidade;
		this.tamanho = tamanho;
		this.quantidade = quantidade;
		this.peso = peso;
		this.idCab = idCab;
		this.unidadeMedida = unidadeMedida;
		this.pilha = pilha;
		this.descFio = descFio;
		this.valorEstoque = valorEstoque;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
		this.dataMovimentacao = dataMovimentacao;
		this.usuarioInclusao = usuarioInclusao;
		this.usuarioAlteracao = usuarioAlteracao;
		this.pesoMedio = pesoMedio;
		this.sac = sac;
		this.trid = trid;
		this.pim = pim;
		this.sc = sc;
		this.mst = mst;
		this.mic = mic;
		this.mat = mat;
		this.ui = ui;
		this.sf = sf;
		this.str = str;
		this.elg = elg;
		this.tipo = tipo;
		this.sic = sic;
		this.uhml = uhml;
		this.rs = rs;
		this.b = b;
		this.trcnt = trcnt;
		this.trar = trar;
		this.tipoQualidade = tipoQualidade;
		this.classifQualidade = classifQualidade;
		this.coloracao = coloracao;
		this.loteAdicional = loteAdicional;
		this.idVolume = idVolume;
		this.tipoMic = tipoMic;
		this.destino = destino;
		this.dsFornecedor = dsFornecedor;
		this.dsProdutor = dsProdutor;
		this.dsProcedencia = dsProcedencia;
		this.fkFornecedor = fkFornecedor;
		this.fkProdutor = fkProdutor;
		this.fkProcedencia = fkProcedencia;
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





	public String getItem() {
		return item;
	}





	public void setItem(String item) {
		this.item = item;
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





	public String getLote() {
		return lote;
	}





	public void setLote(String lote) {
		this.lote = lote;
	}





	public String getQualidade() {
		return qualidade;
	}





	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}





	public String getTamanho() {
		return tamanho;
	}





	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}





	public Double getQuantidade() {
		return quantidade;
	}





	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}





	public Double getPeso() {
		return peso;
	}





	public void setPeso(Double peso) {
		this.peso = peso;
	}





	public Double getIdCab() {
		return idCab;
	}





	public void setIdCab(Double idCab) {
		this.idCab = idCab;
	}





	public String getUnidadeMedida() {
		return unidadeMedida;
	}





	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}





	public String getPilha() {
		return pilha;
	}





	public void setPilha(String pilha) {
		this.pilha = pilha;
	}





	public String getDescFio() {
		return descFio;
	}





	public void setDescFio(String descFio) {
		this.descFio = descFio;
	}





	public Double getValorEstoque() {
		return valorEstoque;
	}





	public void setValorEstoque(Double valorEstoque) {
		this.valorEstoque = valorEstoque;
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





	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}





	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
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





	public Double getPesoMedio() {
		return pesoMedio;
	}





	public void setPesoMedio(Double pesoMedio) {
		this.pesoMedio = pesoMedio;
	}





	public Double getSac() {
		return sac;
	}





	public void setSac(Double sac) {
		this.sac = sac;
	}





	public Double getTrid() {
		return trid;
	}





	public void setTrid(Double trid) {
		this.trid = trid;
	}





	public Double getPim() {
		return pim;
	}





	public void setPim(Double pim) {
		this.pim = pim;
	}





	public Double getSc() {
		return sc;
	}





	public void setSc(Double sc) {
		this.sc = sc;
	}





	public Double getMst() {
		return mst;
	}





	public void setMst(Double mst) {
		this.mst = mst;
	}





	public Double getMic() {
		return mic;
	}





	public void setMic(Double mic) {
		this.mic = mic;
	}





	public Double getMat() {
		return mat;
	}





	public void setMat(Double mat) {
		this.mat = mat;
	}





	public Double getUi() {
		return ui;
	}





	public void setUi(Double ui) {
		this.ui = ui;
	}





	public Double getSf() {
		return sf;
	}





	public void setSf(Double sf) {
		this.sf = sf;
	}





	public Double getStr() {
		return str;
	}





	public void setStr(Double str) {
		this.str = str;
	}





	public Double getElg() {
		return elg;
	}





	public void setElg(Double elg) {
		this.elg = elg;
	}





	public Double getTipo() {
		return tipo;
	}





	public void setTipo(Double tipo) {
		this.tipo = tipo;
	}





	public Double getSic() {
		return sic;
	}





	public void setSic(Double sic) {
		this.sic = sic;
	}





	public Double getUhml() {
		return uhml;
	}





	public void setUhml(Double uhml) {
		this.uhml = uhml;
	}





	public Double getRs() {
		return rs;
	}





	public void setRs(Double rs) {
		this.rs = rs;
	}





	public Double getB() {
		return b;
	}





	public void setB(Double b) {
		this.b = b;
	}





	public Double getTrcnt() {
		return trcnt;
	}





	public void setTrcnt(Double trcnt) {
		this.trcnt = trcnt;
	}





	public Double getTrar() {
		return trar;
	}





	public void setTrar(Double trar) {
		this.trar = trar;
	}





	public String getDsFornecedor() {
		return dsFornecedor;
	}





	public void setDsFornecedor(String dsFornecedor) {
		this.dsFornecedor = dsFornecedor;
	}





	public String getDsProdutor() {
		return dsProdutor;
	}





	public void setDsProdutor(String dsProdutor) {
		this.dsProdutor = dsProdutor;
	}





	public String getDsProcedencia() {
		return dsProcedencia;
	}





	public void setDsProcedencia(String dsProcedencia) {
		this.dsProcedencia = dsProcedencia;
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


	public String getTipoQualidade() {
		return tipoQualidade;
	}


	public void setTipoQualidade(String tipoQualidade) {
		this.tipoQualidade = tipoQualidade;
	}


	public String getClassifQualidade() {
		return classifQualidade;
	}


	public void setClassifQualidade(String classifQualidade) {
		this.classifQualidade = classifQualidade;
	}


	public String getColoracao() {
		return coloracao;
	}


	public void setColoracao(String coloracao) {
		this.coloracao = coloracao;
	}


	public String getLoteAdicional() {
		return loteAdicional;
	}


	public void setLoteAdicional(String loteAdicional) {
		this.loteAdicional = loteAdicional;
	}


	public String getIdVolume() {
		return idVolume;
	}


	public void setIdVolume(String idVolume) {
		this.idVolume = idVolume;
	}


	public String getTipoMic() {
		return tipoMic;
	}


	public void setTipoMic(String tipoMic) {
		this.tipoMic = tipoMic;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
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
		EstoqueMP other = (EstoqueMP) obj;
		return Objects.equals(id, other.id);
	}

	 
	
	
	
	
	
	
	
	
	
	
}
