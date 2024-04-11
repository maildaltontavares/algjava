package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity 
@Table(name="CPFM3_DBF",schema="CPF")
@IdClass(MovimentoItemId.class)
public class MovimentoItem implements Serializable {	

	private static final long serialVersionUID = 1L;  
	
	@Id
	@Column(name="M3ID")
	private Double idItem;		

	@Column(name="IDFIL")
	private String  idfil;
	

	@Column(name="M3NF")
	private String notaFiscal;		
	

	@Column(name="M3FORN")
	private String fornecedor;	
	

	@Column(name="M3ITEM")
	private String item;		 
	

	@Column(name="M3ORIG")
	private String produtor;
	

	@Column(name="M3PROCED")
	private String procedencia;	

	
	@Column(name="M3LOTE")
	private String lote;
	

	@Column(name="M3QUAL")
	private String qualidade;	
	

	@Column(name="M3TAM")
	private String tamanho;			
	
	@Column(name="M3DESCF")
	private String descFio;		 
	
	@Column(name="M3PSCALC")
	private String pesoCalculadoInformado;		
	
	@Column(name="M3OBS")
	private String observacao;	
	
	@Column(name="M3UM")
	private String unidadeMedida;	
	
	@Column(name="M3PILHA")
	private String pilha;	 	
	
	@Column(name="M3DTINC")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date dataInclusao;	 

	@Column(name="M3DTALT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date dataAlteracao;	 	
	
	@Column(name="M3USRINC")
	private String usuarioInclusao;	
	
	@Column(name="M3USRALT")
	private String usuarioAlteracao;		
		
	@Column(name="M3MOVAUT")
	private String movimentoAutomatico;		
	
	@Column(name="M3MOVPIL")
	private String movimentoDePilha;	
 
	@Column(name="M3QTDE")
	private Double quantidade;		
	
	@Column(name="M3PESO")
	private Double peso;	 
	
	@Column(name="M3IDCAB")
	private Double idCab;		
	
	@Column(name="M3VLUNIT")
	private Double vlUnitario;		
	
	@Column(name="M3IDMOV")
	private Double idMovimento;	 
	
	@Column(name="M3SAC")
	private Double sac;	 
	
	@Column(name="M3TRID")
	private Double trid;	 
	
	@Column(name="M3PIM")
	private Double pim;	 
	
	@Column(name="M3SC")
	private Double sc;	 
	
	@Column(name="M3MST")
	private Double mst;	   

	@Column(name="M3MIC")
	private Double mic;	   
	
	@Column(name="M3MAT")
	private Double mat;	   
	
	@Column(name="M3UI")
	private Double ui;	   
	
	@Column(name="M3SF")
	private Double sf;	  	
	
	@Column(name="M3STR")
	private Double str;	
	
	@Column(name="M3ELG")
	private Double elg;	
	
	@Column(name="M3TIPO")
	private Double tipo;	
	
	@Column(name="M3SIC")
	private Double sic;	 
	
	@Column(name="M3IDAUTO")
	private Double idAutomatico;	
	
	@Column(name="M3UHML")
	private Double uhml;	
	
	@Column(name="M3RS")
	private Double rs;	
	
	@Column(name="M3B")
	private Double b;	
	
	@Column(name="M3TRCNT")
	private Double trcnt;	
	
	@Column(name="M3TRAR")
	private Double trar;	
	
	@Column(name="M3PSMDNF")
	private Double pesoMedio;	 
	
	@Column(name="M3TPQ")
	private String tipoQualidade;
	
	@Column(name="M3CLASQ")
	private String classifQualidade;
	
	@Column(name="M3COLOR")
	private String coloracao;	
	
	@Column(name="M3LTADIC")
	private String loteAdicional;	
	
	@Column(name="M3IDFARD")
	private String idVolume;	
	
	@Column(name="M3TPMIC")
	private String tipoMic;	
	
	@Column(name="M3DEST")
	private String destino;		
	
	
/*	
	M3TPQ
	M3CLASQ
	M3COLOR
	M3LTADIC
	M3IDFARD
	M3TPMIC
	M3DEST
	
*/	
	
	
	@Transient
	private String statusItem;	 
	
	@Transient
	private String statusItemOriginal;	 	
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({	   
	    @JoinColumn(name="m3idcab", referencedColumnName="m2id", insertable = false, updatable = false)
	})
	private Movimento movimento;	
	
	@ManyToOne 
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column=@JoinColumn(name="M3FORN", referencedColumnName="B2COD", insertable = false, updatable = false)),
		@JoinColumnOrFormula(formula=@JoinFormula(value="stl.fn_stl_idfil('CCPB2',idfil)", referencedColumnName="idfil"))	
	})	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Fornecedor fkFornecedor	;	  
	
	
	@ManyToOne 
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column=@JoinColumn(name="M3ORIG", referencedColumnName="M6COD", insertable = false, updatable = false)),
		@JoinColumnOrFormula(formula=@JoinFormula(value="stl.fn_stl_idfil('CPFM6',idfil)", referencedColumnName="idfil"))	
	})		 
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Produtor fkProdutor	;	
	 
	@ManyToOne 
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column=@JoinColumn(name="M3PROCED", referencedColumnName="M7COD", insertable = false, updatable = false)),
		@JoinColumnOrFormula(formula=@JoinFormula(value="stl.fn_stl_idfil('CPFM7',idfil)", referencedColumnName="idfil"))	
	})		 
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Procedencia fkProcedencia	;		
	 	

	@ManyToOne 
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column=@JoinColumn(name="M3COLOR", referencedColumnName="N4COD", insertable = false, updatable = false)),
		@JoinColumnOrFormula(formula=@JoinFormula(value="stl.fn_stl_idfil('CPFN4',idfil)", referencedColumnName="idfil"))	
	})		 
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Coloracao fkColoracao	;		
 
	public MovimentoItem() {}    
	

	public MovimentoItem(Double idItem, String idfil, String notaFiscal, String fornecedor, String item,
			String produtor, String procedencia, String lote, String qualidade, String tamanho, String descFio,
			String pesoCalculadoInformado, String observacao, String unidadeMedida, String pilha, Date dataInclusao,
			Date dataAlteracao, String usuarioInclusao, String usuarioAlteracao, String movimentoAutomatico,
			String movimentoDePilha, Double quantidade, Double peso, Double idCab, Double vlUnitario,
			Double idMovimento, Double sac, Double trid, Double pim, Double sc, Double mst, Double mic, Double mat,
			Double ui, Double sf, Double str, Double elg, Double tipo, Double sic, Double idAutomatico, Double uhml,
			Double rs, Double b, Double trcnt, Double trar, Double pesoMedio, String tipoQualidade,
			String classifQualidade, String coloracao, String loteAdicional, String idVolume, String tipoMic,
			String destino, String statusItem, String statusItemOriginal, Movimento movimento, Fornecedor fkFornecedor,
			Produtor fkProdutor, Procedencia fkProcedencia, Coloracao fkColoracao) {
		super();
		this.idItem = idItem;
		this.idfil = idfil;
		this.notaFiscal = notaFiscal;
		this.fornecedor = fornecedor;
		this.item = item;
		this.produtor = produtor;
		this.procedencia = procedencia;
		this.lote = lote;
		this.qualidade = qualidade;
		this.tamanho = tamanho;
		this.descFio = descFio;
		this.pesoCalculadoInformado = pesoCalculadoInformado;
		this.observacao = observacao;
		this.unidadeMedida = unidadeMedida;
		this.pilha = pilha;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usuarioInclusao = usuarioInclusao;
		this.usuarioAlteracao = usuarioAlteracao;
		this.movimentoAutomatico = movimentoAutomatico;
		this.movimentoDePilha = movimentoDePilha;
		this.quantidade = quantidade;
		this.peso = peso;
		this.idCab = idCab;
		this.vlUnitario = vlUnitario;
		this.idMovimento = idMovimento;
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
		this.idAutomatico = idAutomatico;
		this.uhml = uhml;
		this.rs = rs;
		this.b = b;
		this.trcnt = trcnt;
		this.trar = trar;
		this.pesoMedio = pesoMedio;
		this.tipoQualidade = tipoQualidade;
		this.classifQualidade = classifQualidade;
		this.coloracao = coloracao;
		this.loteAdicional = loteAdicional;
		this.idVolume = idVolume;
		this.tipoMic = tipoMic;
		this.destino = destino;
		this.statusItem = statusItem;
		this.statusItemOriginal = statusItemOriginal;
		this.movimento = movimento;
		this.fkFornecedor = fkFornecedor;
		this.fkProdutor = fkProdutor;
		this.fkProcedencia = fkProcedencia;
		this.fkColoracao = fkColoracao;
	}  
	
	

	public MovimentoItem(Double idItem, String idfil, String notaFiscal, String fornecedor, String item,
			String produtor, String procedencia, String lote, String qualidade, String tamanho, String descFio,
			String pesoCalculadoInformado, String observacao, String unidadeMedida, String pilha, Date dataInclusao,
			Date dataAlteracao, String usuarioInclusao, String usuarioAlteracao, String movimentoAutomatico,
			String movimentoDePilha, Double quantidade, Double peso, Double idCab, Double vlUnitario,
			Double idMovimento, Double sac, Double trid, Double pim, Double sc, Double mst, Double mic, Double mat,
			Double ui, Double sf, Double str, Double elg, Double tipo, Double sic, Double idAutomatico, Double uhml,
			Double rs, Double b, Double trcnt, Double trar, Double pesoMedio, String tipoQualidade,
			String classifQualidade, String coloracao, String loteAdicional, String idVolume, String tipoMic,
			String destino, String statusItem, String statusItemOriginal, Movimento movimento) {
		super();
		this.idItem = idItem;
		this.idfil = idfil;
		this.notaFiscal = notaFiscal;
		this.fornecedor = fornecedor;
		this.item = item;
		this.produtor = produtor;
		this.procedencia = procedencia;
		this.lote = lote;
		this.qualidade = qualidade;
		this.tamanho = tamanho;
		this.descFio = descFio;
		this.pesoCalculadoInformado = pesoCalculadoInformado;
		this.observacao = observacao;
		this.unidadeMedida = unidadeMedida;
		this.pilha = pilha;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usuarioInclusao = usuarioInclusao;
		this.usuarioAlteracao = usuarioAlteracao;
		this.movimentoAutomatico = movimentoAutomatico;
		this.movimentoDePilha = movimentoDePilha;
		this.quantidade = quantidade;
		this.peso = peso;
		this.idCab = idCab;
		this.vlUnitario = vlUnitario;
		this.idMovimento = idMovimento;
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
		this.idAutomatico = idAutomatico;
		this.uhml = uhml;
		this.rs = rs;
		this.b = b;
		this.trcnt = trcnt;
		this.trar = trar;
		this.pesoMedio = pesoMedio;
		this.tipoQualidade = tipoQualidade;
		this.classifQualidade = classifQualidade;
		this.coloracao = coloracao;
		this.loteAdicional = loteAdicional;
		this.idVolume = idVolume;
		this.tipoMic = tipoMic;
		this.destino = destino;
		this.statusItem = statusItem;
		this.statusItemOriginal = statusItemOriginal;
		this.movimento = movimento;
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



	public String getDescFio() {
		return descFio;
	}



	public void setDescFio(String descFio) {
		this.descFio = descFio;
	}



	public String getPesoCalculadoInformado() {
		return pesoCalculadoInformado;
	}



	public void setPesoCalculadoInformado(String pesoCalculadoInformado) {
		this.pesoCalculadoInformado = pesoCalculadoInformado;
	}



	public String getObservacao() {
		return observacao;
	}



	public void setObservacao(String observacao) {
		this.observacao = observacao;
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



	public String getMovimentoAutomatico() {
		return movimentoAutomatico;
	}



	public void setMovimentoAutomatico(String movimentoAutomatico) {
		this.movimentoAutomatico = movimentoAutomatico;
	}



	public String getMovimentoDePilha() {
		return movimentoDePilha;
	}



	public void setMovimentoDePilha(String movimentoDePilha) {
		this.movimentoDePilha = movimentoDePilha;
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



	public Double getVlUnitario() {
		return vlUnitario;
	}



	public void setVlUnitario(Double vlUnitario) {
		this.vlUnitario = vlUnitario;
	}



	public Double getIdMovimento() {
		return idMovimento;
	}



	public void setIdMovimento(Double idMovimento) {
		this.idMovimento = idMovimento;
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



	public Double getIdAutomatico() {
		return idAutomatico;
	}



	public void setIdAutomatico(Double idAutomatico) {
		this.idAutomatico = idAutomatico;
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



	public Double getPesoMedio() {
		return pesoMedio;
	}



	public void setPesoMedio(Double pesoMedio) {
		this.pesoMedio = pesoMedio;
	}



	public Movimento getMovimento() {
		return movimento;
	}



	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
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

	


	public Double getIdItem() {
		return idItem;
	}

	public void setIdItem(Double idItem) {
		this.idItem = idItem;
	}

	public String getStatusItem() {
		return statusItem;
	}

	public void setStatusItem(String statusItem) {
		this.statusItem = statusItem;
	}
	
	
	

	public String getStatusItemOriginal() {
		return statusItemOriginal;
	}

	public void setStatusItemOriginal(String statusItemOriginal) {
		this.statusItemOriginal = statusItemOriginal;
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


	public Coloracao getFkColoracao() {
		return fkColoracao;
	}


	public void setFkColoracao(Coloracao fkColoracao) {
		this.fkColoracao = fkColoracao;
	}


	public String getIdfil() {
		return idfil;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idItem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimentoItem other = (MovimentoItem) obj;
		return Objects.equals(idItem, other.idItem);
	}

	 
	
	
}
