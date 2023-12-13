package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

public class MaterialId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long localizacao;
	private Long codigo;
	
	public MaterialId() {
		
	}
	public MaterialId(Long localizacao, Long codigo) {
		this.localizacao = localizacao;
		this.codigo = codigo;
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
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialId materialId = (MaterialId) o;
        return localizacao.equals(materialId.localizacao) &&
                codigo.equals(materialId.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localizacao, codigo);
    }
}
