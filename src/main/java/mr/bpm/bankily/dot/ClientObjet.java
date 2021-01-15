package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.List;

public class ClientObjet implements Serializable {

	private static final long serialVersionUID = 1L;
	
List<Client> clients;
boolean fullKyc;
String telephone;

public List<Client> getClients() {
	return clients;
}

public void setClients(List<Client> clients) {
	this.clients = clients;
}

public boolean isFullKyc() {
	return fullKyc;
}

public void setFullKyc(boolean fullKyc) {
	this.fullKyc = fullKyc;
}

public String getTelephone() {
	return telephone;
}

public void setTelephone(String telephone) {
	this.telephone = telephone;
}


	
	
	
}
