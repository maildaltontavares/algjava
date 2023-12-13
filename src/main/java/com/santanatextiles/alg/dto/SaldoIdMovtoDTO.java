package com.santanatextiles.alg.dto;

import com.santanatextiles.alg.projections.SaldoIdMovtoProjection;

public class SaldoIdMovtoDTO {
	
	Double idMov;
	Double qtde;
	Double peso;
	Double vlEst;
	
	public SaldoIdMovtoDTO() {};
	
	
	public SaldoIdMovtoDTO(SaldoIdMovtoProjection  projection ) {
		
		this.idMov = projection.getIdMov();
		this.qtde = projection.getQtde();
		this.peso = projection.getPeso();
		this.vlEst = projection.getVlEst();  
		
	}
	
	public SaldoIdMovtoDTO(Double idMov, Double qtde, Double peso, Double vlEst) {
		super();
		this.idMov = idMov;
		this.qtde = qtde;
		this.peso = peso;
		this.vlEst = vlEst;
	}

	public Double getIdMov() {
		return idMov;
	}

	public void setIdMov(Double idMov) {
		this.idMov = idMov;
	}

	public Double getQtde() {
		return qtde;
	}

	public void setQtde(Double qtde) {
		this.qtde = qtde;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getVlEst() {
		return vlEst;
	}

	public void setVlEst(Double vlEst) {
		this.vlEst = vlEst;
	}


	
	
	
	
	

}
