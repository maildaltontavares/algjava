package com.santanatextiles.alg.dto;

import java.io.Serializable;

import com.santanatextiles.alg.domain.Material;

public class ItemDTO  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo; 
	private Long filial; 
	private Long localizacao; 
	private Material material;
	
	public ItemDTO(){
		
	} 
	
	public ItemDTO(Long codigo, Long filial, Long localizacao,   Material material) {
		super();
		this.codigo = codigo;
		this.filial = filial;
		this.localizacao = localizacao;
		this.material = material;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getFilial() {
		return filial;
	}

	public void setFilial(Long filial) {
		this.filial = filial;
	}

	public Long getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Long localizacao) {
		this.localizacao = localizacao;
	} 

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}	 
	
	

}
