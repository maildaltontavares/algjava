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
	
@Entity
@Table(name="CPFM9_DBF",schema="CPF")
@IdClass(TesteQualidadeId.class)

public class TesteQualidade implements Serializable {	

	private static final long serialVersionUID = 1L;  
	
	@Id
	@Column(name="IDFIL")
	private String  idfil;
	
	@Id
	@Column(name="M9ORIG")
	private String produtor;	
	
	@Id
	@Column(name="M9LOTE")
    private String lote;		
	
	@Column(name="M9DTTEST")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataTeste;
	
	@Column(name="M9NUMVOL")
	private Double numVolumes;		
	
	@Column(name="M9SAC")	 
	private Double sac;		
	
	@Column(name="M9MST")	
	private Double mst;		
	
	@Column(name="M9MIC")
	private Double mic;		
	
	@Column(name="M9MAT")
	private Double mat;		
	
	@Column(name="M9UI")
	private Double ui;		
	
	@Column(name="M9SF")
	private Double sf;		
	
	@Column(name="M9STR")
	private Double str;		
	
	@Column(name="M9ELG")	
	private Double elg;		
	
	@Column(name="M9TIPO")
	private Double tipo;		
	
	@Column(name="M9TRID")
	private Double trid;		
		
	@Column(name="M9SC")
	private Double sc;	
	
	@Column(name="M9PIM")	
	private Double pim;	
	
	@Column(name="M9HVI")
    private String hvi;		
	
	@Column(name="M9BENEF")
    private String benef;	
	
	@Column(name="M9OBS")
    private String obs;	 
	
	@Column(name="M9DTINC")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataInclusao;
		
	@Column(name="M9USRINC")
    private String usarioInclusao;	 
	
	@Column(name="M9DTALT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date  dataAlteracao;
		
	@Column(name="M9USRALT")
    private String usarioAlteracao;		
 
	@Column(name="M9SIC")	
	private Double sic;	
	
	@Column(name="M9UHML")	
	private Double uhml;		

	@Column(name="M9RS")	
	private Double rs;		
	
	@Column(name="M9B")	
	private Double b;			
	
	@Column(name="M9TRCNT")	
	private Double trcnt;	
	
	@Column(name="M9TRAR")	
	private Double trar;		
	
	@Column(name="M9PRDINT")	
    private String prdint;	
	
	@Column(name="M9ARQ")	
    private String arqImportacao;		

	@Column(name="M9PSELO")	
    private String possuiSelo;	
	
	@Column(name="M9TPSELO")	
    private String tipoSelo;		
	
	@Column(name="M9NSELO")	
    private String numeroSelo;
	
	@ManyToOne 
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column=@JoinColumn(name="M9ORIG", referencedColumnName="M6COD", insertable = false, updatable = false)),
		@JoinColumnOrFormula(formula=@JoinFormula(value="stl.fn_stl_idfil('CPFM6',idfil)", referencedColumnName="idfil"))	
	})		 
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Produtor fkProdutor	;	
	
	
	public TesteQualidade() {
		
	}  

	public TesteQualidade(String idfil, String produtor, String lote, Date dataTeste, Double numVolumes, Double sac,
			Double mst, Double mic, Double mat, Double ui, Double sf, Double str, Double elg, Double tipo, Double trid,
			Double sc, Double pim, String hvi, String benef, String obs, Date dataInclusao, String usarioInclusao,
			Date dataAlteracao, String usarioAlteracao, Double sic, Double uhml, Double rs, Double b, Double trcnt,
			Double trar, String prdint, String arqImportacao, String possuiSelo, String tipoSelo, String numeroSelo,
			Produtor fkProdutor) {
		super();
		this.idfil = idfil;
		this.produtor = produtor;
		this.lote = lote;
		this.dataTeste = dataTeste;
		this.numVolumes = numVolumes;
		this.sac = sac;
		this.mst = mst;
		this.mic = mic;
		this.mat = mat;
		this.ui = ui;
		this.sf = sf;
		this.str = str;
		this.elg = elg;
		this.tipo = tipo;
		this.trid = trid;
		this.sc = sc;
		this.pim = pim;
		this.hvi = hvi;
		this.benef = benef;
		this.obs = obs;
		this.dataInclusao = dataInclusao;
		this.usarioInclusao = usarioInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usarioAlteracao = usarioAlteracao;
		this.sic = sic;
		this.uhml = uhml;
		this.rs = rs;
		this.b = b;
		this.trcnt = trcnt;
		this.trar = trar;
		this.prdint = prdint;
		this.arqImportacao = arqImportacao;
		this.possuiSelo = possuiSelo;
		this.tipoSelo = tipoSelo;
		this.numeroSelo = numeroSelo;
		this.fkProdutor = fkProdutor;
	}  


	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public String getProdutor() {
		return produtor;
	}

	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Date getDataTeste() {
		return dataTeste;
	}

	public void setDataTeste(Date dataTeste) {
		this.dataTeste = dataTeste;
	}

	public Double getNumVolumes() {
		return numVolumes;
	}

	public void setNumVolumes(Double numVolumes) {
		this.numVolumes = numVolumes;
	}

	public Double getSac() {
		return sac;
	}

	public void setSac(Double sac) {
		this.sac = sac;
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

	public Double getTrid() {
		return trid;
	}

	public void setTrid(Double trid) {
		this.trid = trid;
	}

	public Double getSc() {
		return sc;
	}

	public void setSc(Double sc) {
		this.sc = sc;
	}

	public Double getPim() {
		return pim;
	}

	public void setPim(Double pim) {
		this.pim = pim;
	}

	public String getHvi() {
		return hvi;
	}

	public void setHvi(String hvi) {
		this.hvi = hvi;
	}

	public String getBenef() {
		return benef;
	}

	public void setBenef(String benef) {
		this.benef = benef;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getUsarioInclusao() {
		return usarioInclusao;
	}

	public void setUsarioInclusao(String usarioInclusao) {
		this.usarioInclusao = usarioInclusao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getUsarioAlteracao() {
		return usarioAlteracao;
	}

	public void setUsarioAlteracao(String usarioAlteracao) {
		this.usarioAlteracao = usarioAlteracao;
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

	public String getPrdint() {
		return prdint;
	}

	public void setPrdint(String prdint) {
		this.prdint = prdint;
	}

	public String getArqImportacao() {
		return arqImportacao;
	}

	public void setArqImportacao(String arqImportacao) {
		this.arqImportacao = arqImportacao;
	}

	public String getPossuiSelo() {
		return possuiSelo;
	}

	public void setPossuiSelo(String possuiSelo) {
		this.possuiSelo = possuiSelo;
	}

	public String getTipoSelo() {
		return tipoSelo;
	}

	public void setTipoSelo(String tipoSelo) {
		this.tipoSelo = tipoSelo;
	}

	public String getNumeroSelo() {
		return numeroSelo;
	}

	public void setNumeroSelo(String numeroSelo) {
		this.numeroSelo = numeroSelo;
	}

	public Produtor getFkProdutor() {
		return fkProdutor;
	}

	public void setFkProdutor(Produtor fkProdutor) {
		this.fkProdutor = fkProdutor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idfil, lote, produtor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TesteQualidade other = (TesteQualidade) obj;
		return Objects.equals(idfil, other.idfil) && Objects.equals(lote, other.lote)
				&& Objects.equals(produtor, other.produtor);
	}		
	
 
	
	
	
	
	
	
	
	
	
	
	
 

}
