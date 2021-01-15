package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.Date;

public class TransImal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String status;
	String noTrans;
	String idTrans;
	double montant;
	int operateur;
	String beneficiaire;
	Date date;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNoTrans() {
		return noTrans;
	}
	public void setNoTrans(String noTrans) {
		this.noTrans = noTrans;
	}
	public String getIdTrans() {
		return idTrans;
	}
	public void setIdTrans(String idTrans) {
		this.idTrans = idTrans;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public int getOperateur() {
		return operateur;
	}
	public void setOperateur(int operateur) {
		this.operateur = operateur;
	}
	public String getBeneficiaire() {
		return beneficiaire;
	}
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
