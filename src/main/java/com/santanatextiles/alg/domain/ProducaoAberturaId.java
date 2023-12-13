package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

public class ProducaoAberturaId   implements Serializable {	

	private static final long serialVersionUID = 1L;  
 
	private String  idfil; 
	private String mistura;	  
	private String seq;
	
	public ProducaoAberturaId() {}
	
	
	public ProducaoAberturaId(String idfil, String mistura, String seq) {
		super();
		this.idfil = idfil;
		this.mistura = mistura;
		this.seq = seq;
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


	public String getSeq() {
		return seq;
	}


	public void setSeq(String seq) {
		this.seq = seq;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idfil, mistura, seq);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProducaoAberturaId other = (ProducaoAberturaId) obj;
		return Objects.equals(idfil, other.idfil) && Objects.equals(mistura, other.mistura)
				&& Objects.equals(seq, other.seq);
	}	
	
	
	
	
	
	
	

}
