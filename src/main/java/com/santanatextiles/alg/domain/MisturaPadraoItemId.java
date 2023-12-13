package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

public class MisturaPadraoItemId  implements Serializable {	

	private static final long serialVersionUID = 1L;  
	
	private String  idfil;  
	private String mistura;	 
	private Double idItem;
	
	public MisturaPadraoItemId() {
		
	} 


	public MisturaPadraoItemId(String idfil, String mistura, Double idItem) {
		super();
		this.idfil = idfil;
		this.mistura = mistura;
		this.idItem = idItem;
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


	public Double getIdItem() {
		return idItem;
	}


	public void setIdItem(Double idItem) {
		this.idItem = idItem;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idItem, idfil, mistura);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MisturaPadraoItemId other = (MisturaPadraoItemId) obj;
		return Objects.equals(idItem, other.idItem) && Objects.equals(idfil, other.idfil)
				&& Objects.equals(mistura, other.mistura);
	}	
	
	
	
	
	
	
	

}
