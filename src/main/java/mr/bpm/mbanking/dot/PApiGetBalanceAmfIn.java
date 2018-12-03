package mr.bpm.mbanking.dot;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class PApiGetBalanceAmfIn {

	@XmlElement (required = true)
	public BigDecimal alCompCode;

	public String  alAdditionalRef;     
	
	@XmlElement (required = true)
	public String asActiveWithd;
	
	public BigDecimal alBranchCode;
	
	public BigDecimal alCurrencyCode;
	
	public BigDecimal alGlcode;
	
	public BigDecimal alCifSubNo;
	
	public BigDecimal alSlNo;	
	
}
