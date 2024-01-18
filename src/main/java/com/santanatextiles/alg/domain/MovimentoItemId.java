package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

public class MovimentoItemId implements Serializable {	

	private static final long serialVersionUID = 1L;  
	 
	private Double idItem;	  
	
	public MovimentoItemId() {
		
	}

	public MovimentoItemId(Double idItem) {
		super();
		this.idItem = idItem;
	}

	public Double getidItem() {
		return idItem;
	}

	public void setId(Double idItem) {
		this.idItem = idItem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idItem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimentoItemId other = (MovimentoItemId) obj;
		return Objects.equals(idItem, other.idItem);
	}
 
	
	
	
	

}
