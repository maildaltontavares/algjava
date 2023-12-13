package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;


public class TipoMovimentoId  implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	private String idfil;
	private String codigo;
	
	public TipoMovimentoId() {
		 
	}	 
	
	public TipoMovimentoId(String idfil, String codigo) {
		super();
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
	public int hashCode() {
		return Objects.hash(codigo, idfil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoMovimentoId other = (TipoMovimentoId) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(idfil, other.idfil);
	}
	
	
	
	
	

	
}
