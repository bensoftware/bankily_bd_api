package mr.bpm.bankily.service;

import mr.bpm.bankily.dot.ClientConsultation;

public interface ClientInfoService {
	
	public ClientConsultation getInfoClientByNni(String nni) throws Exception;
	public ClientConsultation getInfoClientByCif(String cif) throws Exception;
	public ClientConsultation getInfoClientByTel(String tel) throws Exception;
	
}
