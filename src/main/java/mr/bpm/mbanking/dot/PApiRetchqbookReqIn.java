package mr.bpm.mbanking.dot;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class PApiRetchqbookReqIn {
	@XmlElement (required = true, nillable = false)
	public BigDecimal alChannelId;
	@XmlElement (required = true, nillable = false)
	public String asUserId;
	@XmlElement (required = true, nillable = false)
	public String asMachineName;
	@XmlElement (required = true, nillable = false)
	public BigDecimal alAPiCode;
	@XmlElement (required = true, nillable = false)
	public BigDecimal alCompany;
	@XmlElement (required = false, nillable = true)
	public BigDecimal alBranch;
	@XmlElement (required = false, nillable = true)
	public BigDecimal alAccBr;
	@XmlElement (required = false, nillable = true)
	public BigDecimal alAccCy;
	@XmlElement (required = false, nillable = true)
	public BigDecimal alAccGl;
	@XmlElement (required = false, nillable = true)
	public BigDecimal alAccCif;
	@XmlElement (required = false, nillable = true)
	public BigDecimal alAccSl;
	@XmlElement (required = false, nillable = true)
	public String asAccount;
	@XmlElement (required = true, nillable = false)
	public String asChqtype;
	@XmlElement (required = true, nillable = false)
	public String asUserType;	
	@XmlElement (required = false, nillable = true)
	public BigDecimal alDeliveryMode;
	@XmlElement (required = false, nillable = true)
	public BigDecimal alDestinationBranch;
	@XmlElement (required = false, nillable = true)
	public String asDeliveryLocation;
	@XmlElement (required = false, nillable = true)
	public String asCard;
	@XmlElement (required = true, nillable = false)
	public BigDecimal alCardPresent;
}
