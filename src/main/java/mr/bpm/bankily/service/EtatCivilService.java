package mr.bpm.bankily.service;

import mr.bpm.bankily.dot.ClientNni;

public interface EtatCivilService {
	
	public ClientNni getInfoNni(String nni) throws Exception;

}
