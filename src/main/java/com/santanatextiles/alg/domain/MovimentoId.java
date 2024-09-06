package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

public class MovimentoId implements Serializable {	

	private static final long serialVersionUID = 1L;  
	 
	private Double id;		  
	
	public MovimentoId() {		
		
	}

	public MovimentoId(Double id) {
		super();
		this.id = id;
	}

	public Double getId() {
		return id;
	}

	public void setId(Double id) {
		this.id = id;
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
		MovimentoId other = (MovimentoId) obj;
		return Objects.equals(id, other.id);
	}
 
	
	 
	
	

}
