package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.List;

public class ResponseMerchant implements Serializable {

	private static final long serialVersionUID = 1L;
	
List<Merchant> merchants;

List<PaiementMerchant> paiementMerchants;

public List<Merchant> getMerchants() {
	return merchants;
}

public void setMerchants(List<Merchant> merchants) {
	this.merchants = merchants;
}

public List<PaiementMerchant> getPaiementMerchants() {
	return paiementMerchants;
}

public void setPaiementMerchants(List<PaiementMerchant> paiementMerchants) {
	this.paiementMerchants = paiementMerchants;
}




}
