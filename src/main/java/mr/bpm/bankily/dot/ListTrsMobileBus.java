package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.List;

public class ListTrsMobileBus implements Serializable {

	private static final long serialVersionUID = 1L;
	
List<TrsMobileBus> mobiles;

public List<TrsMobileBus> getMobiles() {
	return mobiles;
}

public void setMobiles(List<TrsMobileBus> mobiles) {
	this.mobiles = mobiles;
}



}
