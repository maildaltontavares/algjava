package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

public class TesteQualidadeId implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	private String idfil; 
	private String produtor;	  
    private String lote;
    
    public TesteQualidadeId() {
    	
    }
    
	public TesteQualidadeId(String idfil, String produtor, String lote) {
		super();
		this.idfil = idfil;
		this.produtor = produtor;
		this.lote = lote;
	}

	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public String getProdutor() {
		return produtor;
	}

	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idfil, lote, produtor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TesteQualidadeId other = (TesteQualidadeId) obj;
		return Objects.equals(idfil, other.idfil) && Objects.equals(lote, other.lote)
				&& Objects.equals(produtor, other.produtor);
	}	
	
	
    
    
    

}
