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
import com.santanatextiles.alg.dto.TesteQualidadeFioDetalheDTO;

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
@Table(name="CPFJ1_DBF",schema="CPF")
@IdClass(TesteQualidadeFioId.class)
public class TesteQualidadeFio  implements Serializable {	

	private static final long serialVersionUID = 1L;     
		
	
		@Id
		@Column(name="J1ID")
		private Double id;		
	 
		@Column(name="IDFIL")
		private String  idfil; 
		
		@Column(name="J1TPTEST")
		private String tipoTesteFiacao;
		
		@Column(name="J1DOBRA")
		private String dobradora;		
		
		@Column(name="J1DTTEST")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
		private Date dataTeste;			
		
		@Column(name="J1TURNO")
		private String turno;	
		
		@Column(name="J1OPER")
		private String operador;	
		
		@Column(name="J1LOCAL")
		private String localFisico;		
		
		@Column(name="J1LADO")
		private String ladoMaquina;	
		
		@Column(name="J1CODMAQ")
		private String codigoMaquina;	
		
		@Column(name="J1ITEM")
		private String item;	
		
		@Column(name="J1LOTFIA")
		private String loteFiacao;		
		
		@Column(name="J1ESTIRA") 
		private Double estiragem;	
		
		@Column(name="J1USRINC")
		private String usuarioInclusao;		
		
		@Column(name="J1USRALT")
		private String usuarioAlteracao;	
		
		@Column(name="J1DTINC")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
		private Date  dataInclusao;		
		
		@Column(name="J1DTALT")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
		private Date  dataAlteracao;
		
		@Column(name="J1OBS")
		private String observacao;			
		
		@ManyToOne 
		@JoinColumnsOrFormulas({ 
			@JoinColumnOrFormula(column=@JoinColumn(name=" J1TPTEST", referencedColumnName="J3COD", insertable = false, updatable = false)),
			@JoinColumnOrFormula(formula=@JoinFormula(value="stl.fn_stl_idfil('CPFJ3',idfil)", referencedColumnName="idfil"))	
		})	
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private TipoTesteCQFio fkTipoTesteCQio	;	 		
		
 		
		@OneToMany(mappedBy="testeQualidadeFio")
		private Set<TesteQualidadeFioDetalhe> testeQualidadeFioDetalhe = new HashSet<>();	 
		
		@Transient
		private Set<TesteQualidadeFioDetalheDTO> testeQualidadeFioDetalheDTO = new HashSet<>();

		public TesteQualidadeFio() {
 
		}    
		
		
		public TesteQualidadeFio(Double id, String idfil, String tipoTesteFiacao, String dobradora, Date dataTeste,
				String turno, String operador, String localFisico, String ladoMaquina, String codigoMaquina,
				String item, String loteFiacao, Double estiragem, String usuarioInclusao, String usuarioAlteracao,
				Date dataInclusao, Date dataAlteracao, String observacao, TipoTesteCQFio fkTipoTesteCQio,
				Set<TesteQualidadeFioDetalhe> testeQualidadeFioDetalhe,
				Set<TesteQualidadeFioDetalheDTO> testeQualidadeFioDetalheDTO) {
			super();
			this.id = id;
			this.idfil = idfil;
			this.tipoTesteFiacao = tipoTesteFiacao;
			this.dobradora = dobradora;
			this.dataTeste = dataTeste;
			this.turno = turno;
			this.operador = operador;
			this.localFisico = localFisico;
			this.ladoMaquina = ladoMaquina;
			this.codigoMaquina = codigoMaquina;
			this.item = item;
			this.loteFiacao = loteFiacao;
			this.estiragem = estiragem;
			this.usuarioInclusao = usuarioInclusao;
			this.usuarioAlteracao = usuarioAlteracao;
			this.dataInclusao = dataInclusao;
			this.dataAlteracao = dataAlteracao;
			this.observacao = observacao;
			this.fkTipoTesteCQio = fkTipoTesteCQio;
			this.testeQualidadeFioDetalhe = testeQualidadeFioDetalhe;
			this.testeQualidadeFioDetalheDTO = testeQualidadeFioDetalheDTO;
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


		public String getTipoTesteFiacao() {
			return tipoTesteFiacao;
		}


		public void setTipoTesteFiacao(String tipoTesteFiacao) {
			this.tipoTesteFiacao = tipoTesteFiacao;
		}


		public String getDobradora() {
			return dobradora;
		}


		public void setDobradora(String dobradora) {
			this.dobradora = dobradora;
		}


		public Date getDataTeste() {
			return dataTeste;
		}


		public void setDataTeste(Date dataTeste) {
			this.dataTeste = dataTeste;
		}


		public String getTurno() {
			return turno;
		}


		public void setTurno(String turno) {
			this.turno = turno;
		}


		public String getOperador() {
			return operador;
		}


		public void setOperador(String operador) {
			this.operador = operador;
		}


		public String getLocalFisico() {
			return localFisico;
		}


		public void setLocalFisico(String localFisico) {
			this.localFisico = localFisico;
		}


		public String getLadoMaquina() {
			return ladoMaquina;
		}


		public void setLadoMaquina(String ladoMaquina) {
			this.ladoMaquina = ladoMaquina;
		}


		public String getCodigoMaquina() {
			return codigoMaquina;
		}


		public void setCodigoMaquina(String codigoMaquina) {
			this.codigoMaquina = codigoMaquina;
		}


		public String getItem() {
			return item;
		}


		public void setItem(String item) {
			this.item = item;
		}


		public String getLoteFiacao() {
			return loteFiacao;
		}


		public void setLoteFiacao(String loteFiacao) {
			this.loteFiacao = loteFiacao;
		}


		public Double getEstiragem() {
			return estiragem;
		}


		public void setEstiragem(Double estiragem) {
			this.estiragem = estiragem;
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


		public String getObservacao() {
			return observacao;
		}


		public void setObservacao(String observacao) {
			this.observacao = observacao;
		}


		public TipoTesteCQFio getFkTipoTesteCQio() {
			return fkTipoTesteCQio;
		}


		public void setFkTipoTesteCQio(TipoTesteCQFio fkTipoTesteCQio) {
			this.fkTipoTesteCQio = fkTipoTesteCQio;
		}


		public Set<TesteQualidadeFioDetalhe> getTesteQualidadeFioDetalhe() {
			return testeQualidadeFioDetalhe;
		}


		public void setTesteQualidadeFioDetalhe(Set<TesteQualidadeFioDetalhe> testeQualidadeFioDetalhe) {
			this.testeQualidadeFioDetalhe = testeQualidadeFioDetalhe;
		}


		public Set<TesteQualidadeFioDetalheDTO> getTesteQualidadeFioDetalheDTO() {
			return testeQualidadeFioDetalheDTO;
		}


		public void setTesteQualidadeFioDetalheDTO(Set<TesteQualidadeFioDetalheDTO> testeQualidadeFioDetalheDTO) {
			this.testeQualidadeFioDetalheDTO = testeQualidadeFioDetalheDTO;
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
			TesteQualidadeFio other = (TesteQualidadeFio) obj;
			return Objects.equals(id, other.id);
		}	 	
		
		
		
		
		
		
		
		
				
	 
	
	
}
