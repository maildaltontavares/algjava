package com.santanatextiles.alg.dto;

import com.santanatextiles.alg.projections.MisturaPadraoProjection;
import com.santanatextiles.alg.projections.SaldoIdMovtoProjection;

public class MisturaProjectionDTO {
	
	String FORN;  
	String PRODUT;
	String COD_PROD;
	String LOTE;
	String PI;  
	Double ESTOQUE;  
	Double frd_reserv ;
	Double QTDE;
	Double Disponivel;  
	Double total_mist_util; 
	Double M4ID ;   
	String M4NF;    
	String M4DESCF;   
	String M4ITEM;        
	String M4UM ;   
	Double M4PESMED ;   
	String M4PROCED ;     
	String M4TAM  ;       
	String M4QUAL;      
	String M4FORN;     
	Double ELG;
	Double MAT;
	Double MIC;
	Double MST;
	Double SF;
	Double SIC;
	Double STR;
	Double TIPO; 
	Double UI;              
	Double SAC;
	Double TRID;
	Double PIM;
	Double SC;     
	Double M4B;    
	Double M4RS;    
	Double M4TRAR;    
	Double M4TRCNT;    
	Double M4UHML ; 
	String Mistura ; 
	String M4COLOR; 
	String M4TPMIC;
	String M4DEST;
	String M7DESC;	 
	String M4TPQ;
	String M4CLASQ; 
	
	public MisturaProjectionDTO() {}
	
	public MisturaProjectionDTO(MisturaPadraoProjection projection ) {
		 
		this.FORN        = projection.getFORN(); 
		this.PRODUT		 = projection.getPRODUT();
		this.COD_PROD	 = projection.getCOD_PROD() ;
		this.LOTE		 = projection.getLOTE();
		this.PI  		 = projection.getPI() ;
		this.ESTOQUE  	 = projection.getESTOQUE();
		this.frd_reserv  = projection.getFrd_reserv();
		this.QTDE		 = projection.getQTDE();
		this.Disponivel  = projection.getDisponivel();
		this.total_mist_util  = projection.getTotal_mist_util();
		this.M4ID    	 = projection.getM4ID();
		this.M4NF    	 = projection.getM4NF();
		this.M4DESCF   	 = projection.getM4DESCF();
		this.M4ITEM      = projection.getM4ITEM();
		this.M4UM    	 = projection.getM4UM();
		this.M4PESMED    = projection.getM4PESMED();
		this.M4PROCED    = projection.getM4PROCED();
		this.M4TAM       = projection.getM4TAM();
		this.M4QUAL      = projection.getM4QUAL();
		this.M4FORN      = projection.getM4FORN();
		this.ELG		 = projection.getELG();
		this.MAT		 = projection.getMAT();
		this.MIC		 = projection.getMIC();
		this.MST		 = projection.getMST();
		this.SF		     = projection.getSF();
		this.SIC		 = projection.getSIC();
		this.STR		 = projection.getSTR();
		this.TIPO 		 = projection.getTIPO();
		this.UI          = projection.getUI();
		this.SAC		 = projection.getSAC();
		this.TRID		 = projection.getTRID();
		this.PIM		 = projection.getPIM();
		this.SC          = projection.getSC();
		this.M4B    	 = projection.getM4B();
		this.M4RS    	 = projection.getM4RS();
		this.M4TRAR    	 = projection.getM4TRAR();
		this.M4TRCNT     = projection.getM4TRCNT();
		this.M4UHML  	 = projection.getM4UHML();
		this.Mistura  	 = projection.getMistura();
		this.M4COLOR 	 = projection.getM4COLOR();
		this.M4TPMIC	 = projection.getM4TPMIC();
		this.M4DEST 	 = projection.getM4DEST();
		this.M7DESC 	 = projection.getM7DESC(); 
		this.M4TPQ       = projection.getM4TPQ(); 
		this.M4CLASQ     = projection.getM4CLASQ(); 
	}	 
	
	 
	public MisturaProjectionDTO(String fORN, String pRODUT, String cOD_PROD, String lOTE, String pI, Double eSTOQUE,
			Double frd_reserv, Double qTDE, Double disponivel, Double total_mist_util, Double m4id, String m4nf,
			String m4descf, String m4item, String m4um, Double m4pesmed, String m4proced, String m4tam, String m4qual,
			String m4forn, Double eLG, Double mAT, Double mIC, Double mST, Double sF, Double sIC, Double sTR,
			Double tIPO, Double uI, Double sAC, Double tRID, Double pIM, Double sC, Double m4b, Double m4rs,
			Double m4trar, Double m4trcnt, Double m4uhml, String mistura, String m4color, String m4tpmic, String m4dest,
			String m7desc, String m4tpq, String m4clasq) {
		super();
		FORN = fORN;
		PRODUT = pRODUT;
		COD_PROD = cOD_PROD;
		LOTE = lOTE;
		PI = pI;
		ESTOQUE = eSTOQUE;
		this.frd_reserv = frd_reserv;
		QTDE = qTDE;
		Disponivel = disponivel;
		this.total_mist_util = total_mist_util;
		M4ID = m4id;
		M4NF = m4nf;
		M4DESCF = m4descf;
		M4ITEM = m4item;
		M4UM = m4um;
		M4PESMED = m4pesmed;
		M4PROCED = m4proced;
		M4TAM = m4tam;
		M4QUAL = m4qual;
		M4FORN = m4forn;
		ELG = eLG;
		MAT = mAT;
		MIC = mIC;
		MST = mST;
		SF = sF;
		SIC = sIC;
		STR = sTR;
		TIPO = tIPO;
		UI = uI;
		SAC = sAC;
		TRID = tRID;
		PIM = pIM;
		SC = sC;
		M4B = m4b;
		M4RS = m4rs;
		M4TRAR = m4trar;
		M4TRCNT = m4trcnt;
		M4UHML = m4uhml;
		Mistura = mistura;
		M4COLOR = m4color;
		M4TPMIC = m4tpmic;
		M4DEST = m4dest;
		M7DESC = m7desc;
		M4TPQ = m4tpq;
		M4CLASQ = m4clasq;
	}

	public String getFORN() {
		return FORN;
	}

	public void setFORN(String fORN) {
		FORN = fORN;
	}

	public String getPRODUT() {
		return PRODUT;
	}

	public void setPRODUT(String pRODUT) {
		PRODUT = pRODUT;
	}

	public String getCOD_PROD() {
		return COD_PROD;
	}

	public void setCOD_PROD(String cOD_PROD) {
		COD_PROD = cOD_PROD;
	}

	public String getLOTE() {
		return LOTE;
	}

	public void setLOTE(String lOTE) {
		LOTE = lOTE;
	}

	public String getPI() {
		return PI;
	}

	public void setPI(String pI) {
		PI = pI;
	}

	public Double getESTOQUE() {
		return ESTOQUE;
	}

	public void setESTOQUE(Double eSTOQUE) {
		ESTOQUE = eSTOQUE;
	}

	public Double getFrd_reserv() {
		return frd_reserv;
	}

	public void setFrd_reserv(Double frd_reserv) {
		this.frd_reserv = frd_reserv;
	}

	public Double getQTDE() {
		return QTDE;
	}

	public void setQTDE(Double qTDE) {
		QTDE = qTDE;
	}

	public Double getDisponivel() {
		return Disponivel;
	}

	public void setDisponivel(Double disponivel) {
		Disponivel = disponivel;
	}

	public Double getTotal_mist_util() {
		return total_mist_util;
	}

	public void setTotal_mist_util(Double total_mist_util) {
		this.total_mist_util = total_mist_util;
	}

	public Double getM4ID() {
		return M4ID;
	}

	public void setM4ID(Double m4id) {
		M4ID = m4id;
	}

	public String getM4NF() {
		return M4NF;
	}

	public void setM4NF(String m4nf) {
		M4NF = m4nf;
	}

	public String getM4DESCF() {
		return M4DESCF;
	}

	public void setM4DESCF(String m4descf) {
		M4DESCF = m4descf;
	}

	public String getM4ITEM() {
		return M4ITEM;
	}

	public void setM4ITEM(String m4item) {
		M4ITEM = m4item;
	}

	public String getM4UM() {
		return M4UM;
	}

	public void setM4UM(String m4um) {
		M4UM = m4um;
	}

	public Double getM4PESMED() {
		return M4PESMED;
	}

	public void setM4PESMED(Double m4pesmed) {
		M4PESMED = m4pesmed;
	}

	public String getM4PROCED() {
		return M4PROCED;
	}

	public void setM4PROCED(String m4proced) {
		M4PROCED = m4proced;
	}

	public String getM4TAM() {
		return M4TAM;
	}

	public void setM4TAM(String m4tam) {
		M4TAM = m4tam;
	}

	public String getM4QUAL() {
		return M4QUAL;
	}

	public void setM4QUAL(String m4qual) {
		M4QUAL = m4qual;
	}

	public String getM4FORN() {
		return M4FORN;
	}

	public void setM4FORN(String m4forn) {
		M4FORN = m4forn;
	}

	public Double getELG() {
		return ELG;
	}

	public void setELG(Double eLG) {
		ELG = eLG;
	}

	public Double getMAT() {
		return MAT;
	}

	public void setMAT(Double mAT) {
		MAT = mAT;
	}

	public Double getMIC() {
		return MIC;
	}

	public void setMIC(Double mIC) {
		MIC = mIC;
	}

	public Double getMST() {
		return MST;
	}

	public void setMST(Double mST) {
		MST = mST;
	}

	public Double getSF() {
		return SF;
	}

	public void setSF(Double sF) {
		SF = sF;
	}

	public Double getSIC() {
		return SIC;
	}

	public void setSIC(Double sIC) {
		SIC = sIC;
	}

	public Double getSTR() {
		return STR;
	}

	public void setSTR(Double sTR) {
		STR = sTR;
	}

	public Double getTIPO() {
		return TIPO;
	}

	public void setTIPO(Double tIPO) {
		TIPO = tIPO;
	}

	public Double getUI() {
		return UI;
	}

	public void setUI(Double uI) {
		UI = uI;
	}

	public Double getSAC() {
		return SAC;
	}

	public void setSAC(Double sAC) {
		SAC = sAC;
	}

	public Double getTRID() {
		return TRID;
	}

	public void setTRID(Double tRID) {
		TRID = tRID;
	}

	public Double getPIM() {
		return PIM;
	}

	public void setPIM(Double pIM) {
		PIM = pIM;
	}

	public Double getSC() {
		return SC;
	}

	public void setSC(Double sC) {
		SC = sC;
	}

	public Double getM4B() {
		return M4B;
	}

	public void setM4B(Double m4b) {
		M4B = m4b;
	}

	public Double getM4RS() {
		return M4RS;
	}

	public void setM4RS(Double m4rs) {
		M4RS = m4rs;
	}

	public Double getM4TRAR() {
		return M4TRAR;
	}

	public void setM4TRAR(Double m4trar) {
		M4TRAR = m4trar;
	}

	public Double getM4TRCNT() {
		return M4TRCNT;
	}

	public void setM4TRCNT(Double m4trcnt) {
		M4TRCNT = m4trcnt;
	}

	public Double getM4UHML() {
		return M4UHML;
	}

	public void setM4UHML(Double m4uhml) {
		M4UHML = m4uhml;
	}

	public String getMistura() {
		return Mistura;
	}

	public void setMistura(String mistura) {
		Mistura = mistura;
	}

	public String getM4COLOR() {
		return M4COLOR;
	}

	public void setM4COLOR(String m4color) {
		M4COLOR = m4color;
	}

	public String getM4TPMIC() {
		return M4TPMIC;
	}

	public void setM4TPMIC(String m4tpmic) {
		M4TPMIC = m4tpmic;
	}

	public String getM4DEST() {
		return M4DEST;
	}

	public void setM4DEST(String m4dest) {
		M4DEST = m4dest;
	}

	public String getM7DESC() {
		return M7DESC;
	}

	public void setM7DESC(String m7desc) {
		M7DESC = m7desc;
	}

	public String getM4TPQ() {
		return M4TPQ;
	}

	public void setM4TPQ(String m4tpq) {
		M4TPQ = m4tpq;
	}

	public String getM4CLASQ() {
		return M4CLASQ;
	}

	public void setM4CLASQ(String m4clasq) {
		M4CLASQ = m4clasq;
	}
	
	
	
	
	

}
