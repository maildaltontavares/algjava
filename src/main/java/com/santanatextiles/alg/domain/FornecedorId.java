package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

public class FornecedorId implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	private String idfil;
	private String codigo;
	
	public FornecedorId() {
		
	}
	public FornecedorId(String idfil, String codigo) {
		this.idfil = idfil;
		this.codigo = codigo;
	}
	
	
	
	public String getIdfil() {
		return idfil;
	}
	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FornecedorId fornecedorId = (FornecedorId) o;
        return idfil.equals(fornecedorId.idfil) &&
                codigo.equals(fornecedorId.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfil, codigo);
    }
}
