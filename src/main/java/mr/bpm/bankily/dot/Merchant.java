package mr.bpm.bankily.dot;

import java.io.Serializable;

public class Merchant implements Serializable {

	private static final long serialVersionUID = 1L;
	
    String userId;
    String parentId;
    String caisse;
    String commercant;
    String telephone;
	String categorie;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getCaisse() {
		return caisse;
	}
	public void setCaisse(String caisse) {
		this.caisse = caisse;
	}
	public String getCommercant() {
		return commercant;
	}
	public void setCommercant(String commercant) {
		this.commercant = commercant;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	
	
}
