package mr.bpm.mbanking.dot;

import java.io.Serializable;
import java.util.Date;


public class MonetiqueClass implements Serializable {

	Date date;
	int type; // 1 (achat,retrait) ,2 recharge, 3 clearing 
	int code; // code transaction
	double refTrans;
	int deviseSS;
	int deviseCl;
	double montantTrans;
	double commission;
	double refCl;
	double montantCl;
	double rechargeCl;
	double rechargeCumule;
	double authorisationCumule;
	double utiliseCumule;
	double clearing;
	double solde;
    
	int etat=0;
	String refErone;
	double montantOrigine;
	int deviseOrigine;
	double taux;
	double codeAuth;
	boolean verified=false;
	

	
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public double getCodeAuth() {
		return codeAuth;
	}
	public void setCodeAuth(double codeAuth) {
		this.codeAuth = codeAuth;
	}
	public double getMontantOrigine() {
		return montantOrigine;
	}
	public void setMontantOrigine(double montantOrigine) {
		this.montantOrigine = montantOrigine;
	}
	public int getDeviseOrigine() {
		return deviseOrigine;
	}
	public void setDeviseOrigine(int deviseOrigine) {
		this.deviseOrigine = deviseOrigine;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public String getRefErone() {
		return refErone;
	}
	public void setRefErone(String refErone) {
		this.refErone = refErone;
	}
	
	
	

	public int getDeviseCl() {
		return deviseCl;
	}
	public void setDeviseCl(int deviseCl) {
		this.deviseCl = deviseCl;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	public int getDeviseSS() {
		return deviseSS;
	}
	public void setDeviseSS(int deviseSS) {
		this.deviseSS = deviseSS;
	}
	public double getMontantTrans() {
		return montantTrans;
	}
	public void setMontantTrans(double montantTrans) {
		this.montantTrans = montantTrans;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}


	
	public double getRefTrans() {
		return refTrans;
	}
	public void setRefTrans(double refTrans) {
		this.refTrans = refTrans;
	}
	public double getRefCl() {
		return refCl;
	}
	public void setRefCl(double refCl) {
		this.refCl = refCl;
	}
	public double getMontantCl() {
		return montantCl;
	}
	public void setMontantCl(double montantCl) {
		this.montantCl = montantCl;
	}
	public double getRechargeCl() {
		return rechargeCl;
	}
	public void setRechargeCl(double rechargeCl) {
		this.rechargeCl = rechargeCl;
	}
	public double getRechargeCumule() {
		return rechargeCumule;
	}
	public void setRechargeCumule(double rechargeCumule) {
		this.rechargeCumule = rechargeCumule;
	}
	public double getAuthorisationCumule() {
		return authorisationCumule;
	}
	public void setAuthorisationCumule(double authorisationCumule) {
		this.authorisationCumule = authorisationCumule;
	}
	public double getUtiliseCumule() {
		return utiliseCumule;
	}
	public void setUtiliseCumule(double utiliseCumule) {
		this.utiliseCumule = utiliseCumule;
	}
	public double getClearing() {
		return clearing;
	}
	public void setClearing(double clearing) {
		this.clearing = clearing;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	
	
	
	

}
