package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table; 
	
@Entity
@Table(name="CPFJ2_DBF",schema="CPF")
@IdClass(TesteQualidadeFioDetalheId.class)
public class TesteQualidadeFioDetalhe  implements Serializable {	

		private static final long serialVersionUID = 1L;  
		
		@Id
		@Column(name="J2ID")
		private Double id;		 
		
		@Column(name="IDFIL")
		private String  idfil;  
	 
		@Column(name="J2IDPAI")
		private Double idPai;	
		
		@Column(name="J2NUMPRV")
		private String seqProva;	
		
		@Column(name="J2NUMFUS")  
		private Integer numeroFusos;		
		
		@Column(name="J2PESO")
		private Double peso;			
		
		@Column(name="J2TIT")
		private Double titulo;
		
		
		@JsonIgnore
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumns({	   
		    @JoinColumn(name="J2IDPAI", referencedColumnName="J1ID", insertable = false, updatable = false)
		})
		private TesteQualidadeFio testeQualidadeFio;			

		public TesteQualidadeFioDetalhe() {
 
		}  
		
		public TesteQualidadeFioDetalhe(Double id, String idfil, Double idPai, String seqProva, Integer numeroFusos,
				Double peso, Double titulo, TesteQualidadeFio testeQualidadeFio) {
			super();
			this.id = id;
			this.idfil = idfil;
			this.idPai = idPai;
			this.seqProva = seqProva;
			this.numeroFusos = numeroFusos;
			this.peso = peso;
			this.titulo = titulo;
			this.testeQualidadeFio = testeQualidadeFio;
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

		public Double getIdPai() {
			return idPai;
		}

		public void setIdPai(Double idPai) {
			this.idPai = idPai;
		}

		public String getSeqProva() {
			return seqProva;
		}

		public void setSeqProva(String seqProva) {
			this.seqProva = seqProva;
		}

		public Integer getNumeroFusos() {
			return numeroFusos;
		}

		public void setNumeroFusos(Integer numeroFusos) {
			this.numeroFusos = numeroFusos;
		}

		public Double getPeso() {
			return peso;
		}

		public void setPeso(Double peso) {
			this.peso = peso;
		}

		public Double getTitulo() {
			return titulo;
		}

		public void setTitulo(Double titulo) {
			this.titulo = titulo;
		}

		public TesteQualidadeFio getTesteQualidadeFio() {
			return testeQualidadeFio;
		}

		public void setTesteQualidadeFio(TesteQualidadeFio testeQualidadeFio) {
			this.testeQualidadeFio = testeQualidadeFio;
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
			TesteQualidadeFioDetalhe other = (TesteQualidadeFioDetalhe) obj;
			return Objects.equals(id, other.id);
		}		
		
		
		
		
		
		
		
		 
				

}
