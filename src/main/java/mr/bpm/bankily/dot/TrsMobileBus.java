package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.Date;

public class TrsMobileBus implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String telephoneClient;
	double montant;
	Date dateCreation;
	Date dateModification;
	String status;
	String operateur;
	String language;
	String typeOperation;
	String transactionId;
	
	
	
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getTelephoneClient() {
		return telephoneClient;
	}
	public void setTelephoneClient(String telephoneClient) {
		this.telephoneClient = telephoneClient;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateModification() {
		return dateModification;
	}
	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOperateur() {
		return operateur;
	}
	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getTypeOperation() {
		return typeOperation;
	}
	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}
	
	
	
	
}
