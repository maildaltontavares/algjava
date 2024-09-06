package com.santanatextiles.alg.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;

public class MovimentoItemDTO  implements Serializable {	

	private static final long serialVersionUID = 1L;  
 
	private Double idItem; 
	private String  idfil;
	private String notaFiscal;
	private String fornecedor;	
	private String item;
	private String produtor; 
	private String procedencia;	 
	private String lote; 
	private String qualidade; 
	private String tamanho; 
	private String descFio;	 
	private String pesoCalculadoInformado; 
	private String observacao;	 
	private String unidadeMedida; 
	private String pilha; 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date dataInclusao; 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date dataAlteracao;	 
	private String usuarioInclusao;	 
	private String usuarioAlteracao; 
	private String movimentoAutomatico; 
	private String movimentoDePilha; 
	private Double quantidade;	 
	private Double peso; 
	private Double idCab;	 
	private Double vlUnitario; 
	private Double idMovimento;	 
	private Double sac; 
	private Double trid; 
	private Double pim; 
	private Double sc;	 
	private Double mst; 
	private Double mic;	   
	private Double mat;	  
	private Double ui; 
	private Double sf;	 
	private Double str;	 
	private Double elg;	 
	private Double tipo;	 
	private Double sic;	  
	private Double idAutomatico;	 
	private Double uhml; 
	private Double rs;	 
	private Double b;	 
	private Double trcnt;	 
	private Double trar; 
	private Double pesoMedio;
	private String statusItem;
	private String statusItemOriginal; 
    private String tipoQualidade; 
	private String classifQualidade; 
	private String coloracao; 
	private String loteAdicional;	 
	private String idVolume; 
	private String tipoMic;	 
	private String destino;
	private String corteza;	
	
	
	public MovimentoItemDTO() {}   
	
	
	public MovimentoItemDTO(Double idItem, String idfil, String notaFiscal, String fornecedor, String item,
			String produtor, String procedencia, String lote, String qualidade, String tamanho, String descFio,
			String pesoCalculadoInformado, String observacao, String unidadeMedida, String pilha, Date dataInclusao,
			Date dataAlteracao, String usuarioInclusao, String usuarioAlteracao, String movimentoAutomatico,
			String movimentoDePilha, Double quantidade, Double peso, Double idCab, Double vlUnitario,
			Double idMovimento, Double sac, Double trid, Double pim, Double sc, Double mst, Double mic, Double mat,
			Double ui, Double sf, Double str, Double elg, Double tipo, Double sic, Double idAutomatico, Double uhml,
			Double rs, Double b, Double trcnt, Double trar, Double pesoMedio, String statusItem,
			String statusItemOriginal, String tipoQualidade, String classifQualidade, String coloracao,
			String loteAdicional, String idVolume, String tipoMic, String destino, String corteza) {
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
		this.statusItem = statusItem;
		this.statusItemOriginal = statusItemOriginal;
		this.tipoQualidade = tipoQualidade;
		this.classifQualidade = classifQualidade;
		this.coloracao = coloracao;
		this.loteAdicional = loteAdicional;
		this.idVolume = idVolume;
		this.tipoMic = tipoMic;
		this.destino = destino;
		this.corteza = corteza;
	}






	public MovimentoItemDTO(Double idItem, String idfil, String produtor, String lote) {
		super();
		this.idItem = idItem;
		this.idfil = idfil;
		this.produtor = produtor;
		this.lote = lote;
	}

	public Double getIdItem() {
		return idItem;
	}


	public void setIdItem(Double idItem) {
		this.idItem = idItem;
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


	public String getCorteza() {
		return corteza;
	}


	public void setCorteza(String corteza) {
		this.corteza = corteza;
	}




	 
	
	
	
	
	
	
	

}
