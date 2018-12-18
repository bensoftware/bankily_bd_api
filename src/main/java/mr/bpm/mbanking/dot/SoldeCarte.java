package mr.bpm.mbanking.dot;

import java.io.Serializable;
import java.util.List;

public class SoldeCarte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	double rechargeCum;
	double authCum;
	double usedCum;
	
	
	
	public SoldeCarte(double rechargeCum, double authCum, double usedCum) {
		super();
		this.rechargeCum = rechargeCum;
		this.authCum = authCum;
		this.usedCum = usedCum;
	}



	public double getRechargeCum() {
		return rechargeCum;
	}



	public void setRechargeCum(double rechargeCum) {
		this.rechargeCum = rechargeCum;
	}



	public double getAuthCum() {
		return authCum;
	}



	public void setAuthCum(double authCum) {
		this.authCum = authCum;
	}



	public double getUsedCum() {
		return usedCum;
	}



	public void setUsedCum(double usedCum) {
		this.usedCum = usedCum;
	}



	public SoldeCarte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
