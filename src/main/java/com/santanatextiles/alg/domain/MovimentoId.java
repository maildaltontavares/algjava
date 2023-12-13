package com.santanatextiles.alg.domain;

import java.io.Serializable;

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
 
	
	 
	
	

}
