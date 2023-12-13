package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

public class MisturaPadraoId implements Serializable {	

	private static final long serialVersionUID = 1L;   
 
	private String  idfil; 
	private String mistura;
	
	
	public MisturaPadraoId() {
		
		
	}
	
	public MisturaPadraoId(String idfil, String mistura) {
		super();
		this.idfil = idfil;
		this.mistura = mistura;
	}

	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public String getMistura() {
		return mistura;
	}

	public void setMistura(String mistura) {
		this.mistura = mistura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idfil, mistura);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MisturaPadraoId other = (MisturaPadraoId) obj;
		return Objects.equals(idfil, other.idfil) && Objects.equals(mistura, other.mistura);
	}	
	
	

	
	
	
}

