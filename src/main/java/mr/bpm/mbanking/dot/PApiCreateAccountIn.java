package mr.bpm.mbanking.dot;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class PApiCreateAccountIn {
	
	@XmlElement (required = true)
	public BigDecimal alChannelId;
	
	@XmlElement (required = true)
	public String asUserId;
	
	@XmlElement (required = true)
	public String asMachineName;
	
	@XmlElement (required = true)
	public BigDecimal alAPiCode;
	
	@XmlElement (required = true)
	public String adtDate; 
	
	@XmlElement (required = true)
	public BigDecimal alCompCode;
	
	@XmlElement (required = true)
	public BigDecimal alBranchCode;
	
	@XmlElement (required = true)
	public String asCurrencyCode; 
	
	@XmlElement (required = true)
	public BigDecimal alGlCode;
	
	@XmlElement (required = true)
	public BigDecimal alCifSubNo;
	
	@XmlElement (required = true)
	public String asTellerId;
	
	@XmlElement (required = true)
	public String asRenew;
	
	public BigDecimal alTrfBr;
	public BigDecimal alTrfCy;
	public BigDecimal alTrfGl;
	public BigDecimal alTrfCif;
	public BigDecimal alTrfSl;
	public String asTrfAddRef;
	public String asPftPostTo; 
	public BigDecimal alProfitBr;
	public BigDecimal alProfitCy;
	public BigDecimal alProfitGl;
	public BigDecimal alProfitCif;
	public BigDecimal alProfitSl;
	public String asProfitAddRef;
	public BigDecimal alMaturityGl;       
	public String asExtTrf;  
	public BigDecimal alOffBr;  
	public BigDecimal alOffCy;  
	public BigDecimal alOffGl;
	public BigDecimal aloffCIF;
	public BigDecimal aloffSL;
	public String asoffAddRef;
	
	@XmlElement (required = true)
	public BigDecimal alTransfertAm; 
	
	public BigDecimal alDebitBranch;
	public BigDecimal alDebitCurrency;
	public BigDecimal alDebitGlCode;
	public BigDecimal alDebitCifSubNo;
	public BigDecimal alDebitSl;
	public String asDebitAddRef;
	public String asRemarks;
	
	@XmlElement (required = true)
	public BigDecimal alDivCode;
	
	@XmlElement (required = true)
	public BigDecimal alDeptCode;
	
	@XmlElement (required = true)
	public String asReference;
	
	@XmlElement (required = true)
	public BigDecimal alPos;
	
	public String asInst1;  
	public String asInst2;  
	
	@XmlElement (required = true)
	public BigDecimal alTrxType;
	
	public String asStatus;
	
	@XmlElement (required = true)
	public String asCreatedTrx;
	
	public String adtMaturityDate;
}
