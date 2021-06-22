package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RequestMerchant implements Serializable {

	private static final long serialVersionUID = 1L;

	String userId;
	List<String> userIds;
	Date debut;
	Date fin;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<String> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}
	public Date getDebut() {
		return debut;
	}
	public void setDebut(Date debut) {
		this.debut = debut;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	
	



}
