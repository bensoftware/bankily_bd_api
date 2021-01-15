package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.Date;

public class TrsMobile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String transactionId;
	String correction;
	
	String telephone;
	Date date; 
	
	String status;
	
	
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getCorrection() {
		return correction;
	}
	public void setCorrection(String correction) {
		this.correction = correction;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TrsMobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrsMobile(String telephone, Date date) {
		super();
		this.telephone = telephone;
		this.date = date;
	}
	
	public TrsMobile(String telephone, Date date,String status) {
		super();
		this.telephone = telephone;
		this.date = date;
		this.status=status;
	}
	
	
	
}
