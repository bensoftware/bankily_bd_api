package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.Date;

public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String telephone;
	String login;
	String partyId;
	String otp;
	Date dateCreationOtp;
	Date dateExpirationOtp;
	int langue;
	String nni;
	boolean actif=false;
	
	
	
	public String getNni() {
		return nni;
	}
	public void setNni(String nni) {
		this.nni = nni;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public int getLangue() {
		return langue;
	}
	public void setLangue(int langue) {
		this.langue = langue;
	}
	public Date getDateCreationOtp() {
		return dateCreationOtp;
	}
	public void setDateCreationOtp(Date dateCreationOtp) {
		this.dateCreationOtp = dateCreationOtp;
	}
	public Date getDateExpirationOtp() {
		return dateExpirationOtp;
	}
	public void setDateExpirationOtp(Date dateExpirationOtp) {
		this.dateExpirationOtp = dateExpirationOtp;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String telephone, String login) {
		super();
		this.telephone = telephone;
		this.login = login;
	}
	
	
	
}
