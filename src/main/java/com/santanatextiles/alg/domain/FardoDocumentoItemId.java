package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

public class FardoDocumentoItemId implements Serializable {	

	private static final long serialVersionUID = 1L;    
	
	private Double idFardo;	  
	private Double idMov;
	
	public FardoDocumentoItemId() {
		 
	}

	public FardoDocumentoItemId(Double idFardo, Double idMov) {
		super();
		this.idFardo = idFardo;
		this.idMov = idMov;
	}

	public Double getIdFardo() {
		return idFardo;
	}

	public void setIdFardo(Double idFardo) {
		this.idFardo = idFardo;
	}

	public Double getIdMov() {
		return idMov;
	}

	public void setIdMov(Double idMov) {
		this.idMov = idMov;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idFardo, idMov);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FardoDocumentoItemId other = (FardoDocumentoItemId) obj;
		return Objects.equals(idFardo, other.idFardo) && Objects.equals(idMov, other.idMov);
	}
	
	
	
	
	
	
	
	
	
	
	
 
	
}	