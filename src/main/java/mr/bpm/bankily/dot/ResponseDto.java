package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.List;

public class ResponseDto  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	String userId;
	int totalTrs;
	String kycStatus;
	int status;	
	List<String> transactionIds;
	
	public List<String> getTransactionIds() {
		return transactionIds;
	}
	public void setTransactionIds(List<String> transactionIds) {
		this.transactionIds = transactionIds;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getTotalTrs() {
		return totalTrs;
	}
	public void setTotalTrs(int totalTrs) {
		this.totalTrs = totalTrs;
	}
	public String getKycStatus() {
		return kycStatus;
	}
	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;
	}
	
	
	
	
	
}
