package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

public class EstoqueMPId implements Serializable {	

	private static final long serialVersionUID = 1L;   
	 
	private Double id; 
	 
	
	public EstoqueMPId() {
		
	}


	public EstoqueMPId(Double id) {
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
		EstoqueMPId other = (EstoqueMPId) obj;
		return Objects.equals(id, other.id);
	}

 
	
	
  
	
	
	
	
	
	
	

}
