package mr.bpm.mbanking.dot;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class PApiTransferEx3In {
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
	public BigDecimal alBranch;
	@XmlElement (required = true)
	public BigDecimal alTeller;
	@XmlElement (required = true)
	public BigDecimal alTrxType;
	@XmlElement (required = true)
	public BigDecimal alUseCardAccno;
	@XmlElement (required = true)
	public String asTransactionType;
	
	public String asCard;
	
	public BigDecimal alAccBr;
	
	public BigDecimal alAccCy;
	
	public BigDecimal alAccGl;
	
	public BigDecimal alAccCif;
	
	public BigDecimal alAccSl;
	
	public String asAccount;
	
	public BigDecimal alToAccBr;
	
	public BigDecimal alToAccCy;
	
	public BigDecimal alToAccGl;
	
	public BigDecimal alToAccCif;
	
	public BigDecimal alToAccSl;
	
	public String asToAccount;
	@XmlElement (required = true)
	public BigDecimal adecAmount;
	@XmlElement (required = true)
	public String asCurrency;
	@XmlElement (required = true)
	public String asDateTime;
	@XmlElement (required = true)
	public String asReference;
	@XmlElement (required = true)
	public BigDecimal alPos;
	
	public String asDesc;
	
	public String asDescArab;
	
	public String adtValueDate;
	
	public String asBillerCode;
	
	public String asSoReference;
	
	@XmlElement (required = true)
	public BigDecimal alAddNumber;
	
	public BigDecimal alNumOfShares;
	
	public String asInstructions1;
	
	public String asInstructions2;
	
	public String asInstructions3;
	
	public String asInstructions4;
	
	public BigDecimal alTrxPurpose;
	
	public String asApprovedTrx;
}
