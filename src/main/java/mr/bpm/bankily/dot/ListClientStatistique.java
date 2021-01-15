package mr.bpm.bankily.dot;

import java.io.Serializable;
import java.util.List;

public class ListClientStatistique implements Serializable {

	private static final long serialVersionUID = 1L;
	
List<ClientStatistique> clients;

public List<ClientStatistique> getClients() {
	return clients;
}

public void setClients(List<ClientStatistique> clients) {
	this.clients = clients;
}





}
