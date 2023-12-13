package com.santanatextiles.alg.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="E0421_STL_MATERIAL",schema="STL")
@IdClass(MaterialId.class)
public class Material implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="D0003_ID_LOCALIZACAO")
	private Long localizacao;
	
	@Id
	@Column(name="D0421_ID_MATERIAL")
	private Long codigo;
	
	@Column(name="D0421_NOME")
	private String descricao;
	
	public Material() {
		
	}

	public Material(Long localizacao, Long codigo, String descricao) {
		super();
		this.localizacao = localizacao;
		this.codigo = codigo;
		this.descricao = descricao;
	}

	
	public Long getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Long localizacao) {
		this.localizacao = localizacao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((localizacao == null) ? 0 : localizacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (localizacao == null) {
			if (other.localizacao != null)
				return false;
		} else if (!localizacao.equals(other.localizacao))
			return false;
		return true;
	}


}
