package mr.bpm.mbanking.dot;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class FullStatementIn {
	@XmlElement (required = true)
	public 	BigDecimal al_channel_id;
	
	@XmlElement (required = true)
	public	String as_user_id;
	
	@XmlElement (required = true)
	public	String as_machine_name;
	
	@XmlElement (required = true)
	public	BigDecimal al_api_code;
	
	@XmlElement (required = true)
	public	BigDecimal al_company;
	
	public	String as_account;
	
	@XmlElement (required = true)
	public	String  ad_from_date;
	
	@XmlElement (required = true)
	public	String ad_to_date;
	
	@XmlElement (required = true)
	public	String as_vt_flag;
	
	@XmlElement (required = true)
	public	String as_card; 
	
	public	BigDecimal al_card_present;
	
	@XmlElement (required = true)
	public	BigDecimal al_last_n;
	
	public	BigDecimal Al_dblink;
	
	public	String as_userid ;
	
	@XmlElement (required = true)
	public	BigDecimal Al_rev_flag ;	
}