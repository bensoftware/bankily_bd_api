package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.List;

public class ListTrsMobile implements Serializable {

	private static final long serialVersionUID = 1L;
	
List<TrsMobile> mobiles;

public List<TrsMobile> getMobiles() {
	return mobiles;
}

public void setMobiles(List<TrsMobile> mobiles) {
	this.mobiles = mobiles;
}



}
