package mr.bpm.mbanking.dot;

import java.io.Serializable;
import java.util.List;

public class ListPan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Double> list;


	public List<Double> getList() {
		return list;
	}


	public void setList(List<Double> list) {
		this.list = list;
	}


	public ListPan(List<Double> list) {
		super();
		this.list = list;
	}


	public ListPan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
