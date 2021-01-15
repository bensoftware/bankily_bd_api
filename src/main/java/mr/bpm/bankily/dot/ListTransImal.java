package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.List;

public class ListTransImal implements Serializable {

	private static final long serialVersionUID = 1L;
	
List<TransImal> imals;

public List<TransImal> getImals() {
	return imals;
}

public void setImals(List<TransImal> imals) {
	this.imals = imals;
}


}
