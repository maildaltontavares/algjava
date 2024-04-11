package com.santanatextiles.alg.domain;

import java.io.Serializable;
import java.util.Objects;

public class LoteFiacaoId implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
	private String  idfil;	
	private String  tipoMaquina;	 
	private String  item;		 
	private Integer idSSM;
	private String  lote;
	
	public LoteFiacaoId() {
		
	}
	
	public LoteFiacaoId(String idfil, String tipoMaquina, String item, Integer idSSM, String lote) {
		super();
		this.idfil = idfil;
		this.tipoMaquina = tipoMaquina;
		this.item = item;
		this.idSSM = idSSM;
		this.lote = lote;
	}
	
	
	

	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public String getTipoMaquina() {
		return tipoMaquina;
	}

	public void setTipoMaquina(String tipoMaquina) {
		this.tipoMaquina = tipoMaquina;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getIdSSM() {
		return idSSM;
	}

	public void setIdSSM(Integer idSSM) {
		this.idSSM = idSSM;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSSM, idfil, item, lote, tipoMaquina);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoteFiacaoId other = (LoteFiacaoId) obj;
		return Objects.equals(idSSM, other.idSSM) && Objects.equals(idfil, other.idfil)
				&& Objects.equals(item, other.item) && Objects.equals(lote, other.lote)
				&& Objects.equals(tipoMaquina, other.tipoMaquina);
	}	
	
	
	

	
	
	
}
