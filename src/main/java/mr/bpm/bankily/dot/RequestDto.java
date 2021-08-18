package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RequestDto  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String telephone;
	String nni;
	String cif;
	List<String> comptes;
	
	String phone;
	String amount;
	String userId;
	Date beginDate;
	Date endDate;
	
	
	
	public List<String> getComptes() {
		return comptes;
	}
	public void setComptes(List<String> comptes) {
		this.comptes = comptes;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getNni() {
		return nni;
	}
	public void setNni(String nni) {
		this.nni = nni;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
}
