package mr.bpm.bankily.dot;

import java.io.Serializable;

public class DateObjet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	long date;



	public long getDate() {
		return date;
	}



	public void setDate(long date) {
		this.date = date;
	}



	public DateObjet(long date) {
		super();
		this.date = date;
	}


	
	
	
	
}
