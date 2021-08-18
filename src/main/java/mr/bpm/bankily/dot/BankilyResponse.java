package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BankilyResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	boolean updateMajBankily;
	String cif;
	String additionalReference;
	String telephone;
	String partyId;
	String userId;
	String status;
	String nomBankily;
	String login_id;
	String otp;
	Date dateExpiration;
	int tentative;
	int statusUser;
	boolean blocage=false;
	String nni;
	
	boolean isExiste;
	boolean isIncomplet ;
	
	
	
	
	public boolean isExiste() {
		return isExiste;
	}

	public void setExiste(boolean isExiste) {
		this.isExiste = isExiste;
	}

	public boolean isIncomplet() {
		return isIncomplet;
	}

	public void setIncomplet(boolean isIncomplet) {
		this.isIncomplet = isIncomplet;
	}

	public String getNni() {
		return nni;
	}

	public void setNni(String nni) {
		this.nni = nni;
	}

	public boolean isBlocage() {
		return blocage;
	}

	public void setBlocage(boolean blocage) {
		this.blocage = blocage;
	}

	List<BankilyRespCust> listC;

	
	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public int getTentative() {
		return tentative;
	}

	public void setTentative(int tentative) {
		this.tentative = tentative;
	}

	public List<BankilyRespCust> getListC() {
		return listC;
	}

	public void setListC(List<BankilyRespCust> listC) {
		this.listC = listC;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public int getStatusUser() {
		return statusUser;
	}

	public void setStatusUser(int statusUser) {
		this.statusUser = statusUser;
	}

	public String getNomBankily() {
		return nomBankily;
	}

	public void setNomBankily(String nomBankily) {
		this.nomBankily = nomBankily;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getAdditionalReference() {
		return additionalReference;
	}

	public void setAdditionalReference(String additionalReference) {
		this.additionalReference = additionalReference;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isUpdateMajBankily() {
		return updateMajBankily;
	}

	public void setUpdateMajBankily(boolean updateMajBankily) {
		this.updateMajBankily = updateMajBankily;
	}
	
	
	
	
}