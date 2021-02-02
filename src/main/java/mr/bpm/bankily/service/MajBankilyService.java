package mr.bpm.bankily.service;

import mr.bpm.bankily.dot.BankilyResponse;
import mr.bpm.bankily.dot.ClientConsultation;

public interface MajBankilyService {
	
	public boolean updateCompteBankily(String mobileNumber, String cifParticulier, String addRef) throws Exception;

	public BankilyResponse verifierCompte(String telephone) throws Exception;
	
	public BankilyResponse verifierPinTemp(String telephone) throws Exception;
	
	public BankilyResponse verifierBlocage(String telephone) throws Exception;
	
	public boolean deblocageUser(String userId) throws Exception;
	

}
