package mr.bpm.mbanking.dot;

import java.io.Serializable;
import java.util.Date;

public class TraitementDto1 implements Serializable {


	Date date;
	Double montant;
	String pan;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public TraitementDto1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TraitementDto1(Date date, Double montant, String pan) {
		super();
		this.date = date;
		this.montant = montant;
		this.pan = pan;
	}
	

	
	

}
