package com.santanatextiles.alg.domain;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="E0422_STL_ITEM",schema="STL")
@IdClass(ItemId.class)
public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="D0003_ID_LOCALIZACAO")
	private Long localizacao;
	
	@Id
	@Column(name="D0422_ID_ITEM")
	private Long codigo;	 
	 
	@Column(name="D0421_ID_MATERIAL")
	private Long codMaterial;  
	 
	@Column(name="D0002_ID_FIL")
	private Long idfil;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumns({
	    @JoinColumn(name="D0003_ID_LOCALIZACAO", referencedColumnName="D0003_ID_LOCALIZACAO", insertable = false, updatable = false),
	    @JoinColumn(name="D0421_ID_MATERIAL", referencedColumnName="D0421_ID_MATERIAL", insertable = false, updatable = false)
	})
	private Material material;
	
	public Item() {
		
	}

	public Item(Long localizacao, Long codMaterial , Long codigo, Long idfil , String descricao, Material material) {
		super();
		this.localizacao = localizacao;
		this.codigo = codigo;
		this.codMaterial = codMaterial;
		this.material = material;
		this.idfil = idfil;
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

	public Long getIdfil() {
		return idfil;
	}

	public void setIdfil(Long idfil) {
		this.idfil = idfil;
	}

	public Long getCodMaterial() {
		return codMaterial;
	}

	public void setCodMaterial(Long codMaterial) {
		this.codMaterial = codMaterial;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
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
		Item other = (Item) obj;
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
