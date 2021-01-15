package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.Date;

public class ClientStatistique implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String telephone;
	String userId;
	boolean actif;
	Date dateCreation;
	String nom;
	String cif;
	String agence;
	String compte;
	String agenceCreation;
    String tokenFirebase;
    String nni;
	
	
	
	public String getNni() {
		return nni;
	}
	public void setNni(String nni) {
		this.nni = nni;
	}
	public String getTokenFirebase() {
		return tokenFirebase;
	}
	public void setTokenFirebase(String tokenFirebase) {
		this.tokenFirebase = tokenFirebase;
	}
	
	
	public String getAgenceCreation() {
		return agenceCreation;
	}
	public void setAgenceCreation(String agenceCreation) {
		this.agenceCreation = agenceCreation;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getAgence() {
		return agence;
	}
	public void setAgence(String agence) {
		this.agence = agence;
	}
	public String getCompte() {
		return compte;
	}
	public void setCompte(String compte) {
		this.compte = compte;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public ClientStatistique(String telephone, String userId, boolean actif) {
		super();
		this.telephone = telephone;
		this.userId = userId;
		this.actif = actif;
	}
	public ClientStatistique() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
