package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.Date;

public class PaiementMerchant implements Serializable {

	private static final long serialVersionUID = 1L;
	
    String transactionId;
    Date datePaiement;
    double montant;
    String caisse;
    
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public Date getDatePaiement() {
		return datePaiement;
	}
	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getCaisse() {
		return caisse;
	}
	public void setCaisse(String caisse) {
		this.caisse = caisse;
	}
	
    
    
	
}
