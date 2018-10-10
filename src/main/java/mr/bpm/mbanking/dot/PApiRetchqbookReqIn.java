package mr.bpm.mbanking.dot;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class PApiRetchqbookReqIn {
	@XmlElement (required = true)
	public BigDecimal alChannelId;
	@XmlElement (required = true)
	public String asUserId;
	@XmlElement (required = true)
	public String asMachineName;
	@XmlElement (required = true)
	public BigDecimal alAPiCode;
	@XmlElement (required = true)
	public BigDecimal alCompany;
	
	public BigDecimal alBranch;
	
	public BigDecimal alAccBr;
	
	public BigDecimal alAccCy;
	
	public BigDecimal alAccGl;
	
	public BigDecimal alAccCif;
	
	public BigDecimal alAccSl;
	
	public String asAccount;
	@XmlElement (required = true)
	public String asChqtype;
	@XmlElement (required = true)
	public String asUserType;	
	
	public BigDecimal alDeliveryMode;
	
	public BigDecimal alDestinationBranch;
	
	public String asDeliveryLocation;
	
	public String asCard;
	@XmlElement (required = true)
	public BigDecimal alCardPresent;
}
