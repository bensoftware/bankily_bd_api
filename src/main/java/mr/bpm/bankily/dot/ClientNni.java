package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.Date;

public class ClientNni implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String nni;
	String dateDeNaissance; 
	String img;
	String lieuNaissance;
	String nationaliteIso;
	String nomFamille;
	String prenom;
	String prenomPere;
	String sexe;
	Date dateInscription;

	
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	public String getNni() {
		return nni;
	}
	public void setNni(String nni) {
		this.nni = nni;
	}

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	public String getNationaliteIso() {
		return nationaliteIso;
	}
	public void setNationaliteIso(String nationaliteIso) {
		this.nationaliteIso = nationaliteIso;
	}
	public String getNomFamille() {
		return nomFamille;
	}
	public void setNomFamille(String nomFamille) {
		this.nomFamille = nomFamille;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPrenomPere() {
		return prenomPere;
	}
	public void setPrenomPere(String prenomPere) {
		this.prenomPere = prenomPere;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public ClientNni() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public ClientNni(String nni, String dateDeNaissance, String img, String lieuNaissance, String nationaliteIso,
			String nomFamille, String prenom, String prenomPere, String sexe) {
		super();
		this.nni = nni;
		this.dateDeNaissance = dateDeNaissance;
		this.img = img;
		this.lieuNaissance = lieuNaissance;
		this.nationaliteIso = nationaliteIso;
		this.nomFamille = nomFamille;
		this.prenom = prenom;
		this.prenomPere = prenomPere;
		this.sexe = sexe;
	}

	

	

}
