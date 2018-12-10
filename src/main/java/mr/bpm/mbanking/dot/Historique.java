package mr.bpm.mbanking.dot;

import java.io.Serializable;
import java.util.Date;

public class Historique implements Serializable {


	Date date;
	double recharge;
	double auth_cumu;
	double utilise_cumu;
	String genClearing; 
	String host; 


	
	public String getGenClearing() {
		return genClearing;
	}




	public void setGenClearing(String genClearing) {
		this.genClearing = genClearing;
	}




	public String getHost() {
		return host;
	}




	public void setHost(String host) {
		this.host = host;
	}




	public Historique() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public double getRecharge() {
		return recharge;
	}



	public void setRecharge(double recharge) {
		this.recharge = recharge;
	}



	public double getAuth_cumu() {
		return auth_cumu;
	}



	public void setAuth_cumu(double auth_cumu) {
		this.auth_cumu = auth_cumu;
	}



	public double getUtilise_cumu() {
		return utilise_cumu;
	}



	public void setUtilise_cumu(double utilise_cumu) {
		this.utilise_cumu = utilise_cumu;
	}


	
	

}
