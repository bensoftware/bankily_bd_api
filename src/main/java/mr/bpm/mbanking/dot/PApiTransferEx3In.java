package mr.bpm.mbanking.dot;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class PApiTransferEx3In {
	@XmlElement (required = true, nillable = false)
	public BigDecimal alChannelId;
	@XmlElement (required = true, nillable = false)
	public String asUserId;
	@XmlElement (required = true, nillable = false)
	public String asMachineName;
	@XmlElement (required = true, nillable = false)
	public BigDecimal alApiCode;
	@XmlElement (required = true, nillable = false)
	public BigDecimal alCompCode;
	@XmlElement (required = true, nillable = false)
	public BigDecimal alBranch;
	@XmlElement (required = true, nillable = false)
	public BigDecimal alTeller;
	@XmlElement (required = true, nillable = false)
	public BigDecimal alTrxType;
	@XmlElement (required = true, nillable = false)
	public BigDecimal alUseCardAccno;
	@XmlElement (required = true, nillable = false)
	public String asTransactionType;
	@XmlElement (required = false, nillable = true)
	public String asCard;
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
	@XmlElement (required = false, nillable = true)
	public BigDecimal alToAccBr;
	@XmlElement (required = false, nillable = true)
	public BigDecimal alToAccCy;
	@XmlElement (required = false, nillable = true)
	public BigDecimal alToAccGl;
	@XmlElement (required = false, nillable = true)
	public BigDecimal alToAccCif;
	@XmlElement (required = false, nillable = true)
	public BigDecimal alToAccSl;
	@XmlElement (required = false, nillable = true)
	public String asToAccount;
	@XmlElement (required = true, nillable = false)
	public BigDecimal adecAmount;
	@XmlElement (required = true, nillable = false)
	public String asCurrency;
	@XmlElement (required = true, nillable = false)
	public String asDateTime;
	@XmlElement (required = true, nillable = false)
	public String asReference;
	@XmlElement (required = true, nillable = false)
	public BigDecimal alPos;
	@XmlElement (required = false, nillable = true)
	public String asDesc;
	@XmlElement (required = false, nillable = true)
	public String asDescArab;
	@XmlElement (required = false, nillable = true)
	public String adtValueDate;
	@XmlElement (required = false, nillable = true)
	public String asBillerCode;
	@XmlElement (required = false, nillable = true)
	public String asSoReference;
	@XmlElement (required = true, nillable = false)
	public BigDecimal alAddNumber;
	@XmlElement (required = false, nillable = true)
	public BigDecimal alNumOfShares;
	@XmlElement (required = false, nillable = true)
	public String asInstructions1;
	@XmlElement (required = false, nillable = true)
	public String asInstructions2;
	@XmlElement (required = false, nillable = true)
	public String asInstructions3;
	@XmlElement (required = false, nillable = true)
	public String asInstructions4;
	@XmlElement (required = false, nillable = true)
	public BigDecimal alTrxPurpose;
	@XmlElement (required = false, nillable = true)
	public String asApprovedTrx;
}
