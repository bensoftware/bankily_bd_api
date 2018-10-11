package mr.bpm.mbanking.dot;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class FullStatementIn {
	@XmlElement (required = true)
	public 	BigDecimal alChannelId;
	
	@XmlElement (required = true)
	public	String asUserId;
	
	@XmlElement (required = true)
	public	String asMachineName;
	
	@XmlElement (required = true)
	public	BigDecimal alApiCode;
	
	@XmlElement (required = true)
	public	BigDecimal alCompany;
	
	public	String asAccount;
	
	@XmlElement (required = true)
	public	Date  adFromDate;
	
	@XmlElement (required = true)
	public	Date adToDate;
	
	@XmlElement (required = true)
	public	String asVtFlag;
	
	@XmlElement (required = true)
	public	String asCard; 
	
	public	BigDecimal alCardPresent;
	
	@XmlElement (required = true)
	public	BigDecimal alLastIn;
	
	public	BigDecimal aldbLink;
	
	public	String asUserid ;
	
	@XmlElement (required = true)
	public	BigDecimal alRevFlag;	
}