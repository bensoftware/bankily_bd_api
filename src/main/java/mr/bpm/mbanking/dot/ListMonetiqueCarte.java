package mr.bpm.mbanking.dot;

import java.io.Serializable;
import java.util.List;

public class ListMonetiqueCarte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<MonetiqueClass> list;

	public List<MonetiqueClass> getList() {
		return list;
	}

	public void setList(List<MonetiqueClass> list) {
		this.list = list;
	}

	public ListMonetiqueCarte(List<MonetiqueClass> list) {
		super();
		this.list = list;
	}

	public ListMonetiqueCarte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
