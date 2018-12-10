package mr.bpm.mbanking.dot;

import java.io.Serializable;
import java.util.List;

public class ListHistorique implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Historique> list;

	public List<Historique> getList() {
		return list;
	}

	public void setList(List<Historique> list) {
		this.list = list;
	}

	public ListHistorique(List<Historique> list) {
		super();
		this.list = list;
	}

	public ListHistorique() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
