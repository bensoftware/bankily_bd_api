package mr.bpm.mbanking.dot;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class PApiCheckNniIn {

	@XmlElement (required = true)
	public BigDecimal alChannelId;
	
	@XmlElement (required = true)
	public String asUseerId;
	
	
	@XmlElement (required = true)
	public String asMachineName;
	
	@XmlElement (required = true)
	public BigDecimal alApiCode;
	
	@XmlElement (required = true)
	public BigDecimal alCompCode;
	
	@XmlElement (required = true)
	public BigDecimal alIndicator;
	
	@XmlElement (required = true)
	public String alCifNni;
	
	public String asAddReference;
	
	public String adtDateCreated;
	
	public String asAccType;
	
	public String asGmiFlag;

}
