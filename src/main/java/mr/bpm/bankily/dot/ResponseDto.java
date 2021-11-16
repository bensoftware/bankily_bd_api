package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.List;

public class ResponseDto  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<TransImal> transactionIds;
    String userId;
    int totalTrs;
    String trsIdMobile;
    int status;
    
    
	public String getTrsIdMobile() {
		return trsIdMobile;
	}

	public void setTrsIdMobile(String trsIdMobile) {
		this.trsIdMobile = trsIdMobile;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<TransImal> getTransactionIds() {
		return transactionIds;
	}

	public void setTransactionIds(List<TransImal> transactionIds) {
		this.transactionIds = transactionIds;
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

	
	
}
