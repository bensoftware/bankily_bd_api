package mr.bpm.mbanking.dot;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class PApiGetCifAccountsIn {
	
	@XmlElement (required = true)
	public BigDecimal alChannelId;
	
	@XmlElement (required = true)
	public String asUserId;
	
	@XmlElement (required = true)
	public String asMachineName;
	
	@XmlElement (required = true)
	public BigDecimal alApiCode;
	
	@XmlElement (required = true)
	public BigDecimal alCompCode;
	
	@XmlElement (required = true)
	public BigDecimal alIndicator;	
	public BigDecimal  alCifNo;       	
	public String asAddReference;    	
	public String adtDateCreated;     
	public String asAccType;
	public String asGmiFlag;

}
