package mr.bpm.bankily.dao;

import java.util.Date;
import java.util.List;

import mr.bpm.bankily.dot.BankilyResponse;
import mr.bpm.bankily.dot.Client;
import mr.bpm.bankily.dot.ClientConsultation;
import mr.bpm.bankily.dot.ClientStatistique;
import mr.bpm.bankily.dot.ListClientStatistique;
import mr.bpm.bankily.dot.ListTrsMobile;
import mr.bpm.bankily.dot.ListTrsMobileBus;
import mr.bpm.bankily.dot.Merchant;
import mr.bpm.bankily.dot.PaiementMerchant;
import mr.bpm.bankily.dot.TrsMobile;
import mr.bpm.bankily.dot.RequestDto;
import mr.bpm.bankily.dot.ResponseDto;
import mr.bpm.bankily.dot.TrsMobileBus;

public interface MonetiqueServiceDao {
	public BankilyResponse getVerificationImalByCif(String cif) throws Exception;
	public BankilyResponse getVerificationMobileByTelephone(String telephone) throws Exception;
	
	public BankilyResponse getUserIdClientByTelephone(String telephone) throws Exception;
	public BankilyResponse getUserIdUserByLogin(String login) throws Exception;

	
	public String getCIFBANKILY(String mobileNumber);
	public boolean getPartyIdUserId(String mobileNumber, String cifParticulier, String addRef);
	public boolean updateDigitalWokspace(String cifParticulier, String userId);
	
	public boolean updateParty(String cifParticulier, String partyId);
	public boolean updateInstrumentMgmt(String cifParticulier, String addRef, String userId);


	public BankilyResponse getAdditionalRefByCif(String cif);
	
	public BankilyResponse getPartyIdByTelephone(String telephone);
	
	public void debloquerClientBankily(String telephone) throws Exception;
	
	
	public String getCifByPartyId(String partyId);
	
	public BankilyResponse getInfoPINTemp(String telephone);
	
	public int getEtatUserByUserId(String userId);
	
	public BankilyResponse getNbLiaisonParAgence();
	
	public Client getTelephoneByUserId(String userId);
	
	public String  getKycIdByNni(String nni);
	public String  getPartyIdByKycId(String kycId);

	
	public String  getCifByNni(String nni);
	
	
	public ListTrsMobileBus getAllTransRechargeTA();

	public boolean setFullKyc(String nni);
	
	public BankilyResponse getTelephoneByNni(String nni);
	
	
	///
	
	public ListClientStatistique getAllEtatClient(List<ClientStatistique> e);
	
	public ListClientStatistique getAllClientPartialActif();
	public ListClientStatistique getAllClientPartialInactif();
	public ListClientStatistique getAllClientFullInactif();
	public ListClientStatistique getAllClientFullBpmInactif();
	public ListClientStatistique getAllClientFullActif();
	public ListClientStatistique getAllClientFullBpmActif();
	public ListClientStatistique getAllClientLiaisonBpm();
	public ListClientStatistique getAllClientFullIncomplet();

	
	public ListClientStatistique getAllClientFullComplet();
	
	public ListTrsMobile getInfoPaiementFacturier(String idTransaction);
	
	public TrsMobileBus getTrsMobByTrsId(String trsId);

	
	public Client getOtpByTelephone(String telephone) throws Exception;
	
	
	public ListClientStatistique getAllCifParty();
	
	public boolean deblocageUser(String userId);
	public boolean deblocageUserTel(String tel);
	
	public void setEtatClient(List<ClientStatistique> clients );
	
	
	public List<Merchant> getAllMerchant() throws Exception;
	public List<Merchant> getChildrenMerchant(String userId) throws Exception;
	public List<PaiementMerchant> getPaiementMerchantByIntervallDate(List<String> userIds,Date debut,Date fin) throws Exception;
	public List<PaiementMerchant> getPaiementMerchantByTelAndIntervallDate(List<String> userIds,Date debut,Date fin) throws Exception;

	public List<PaiementMerchant> getAutoSweepMerchantByIntervallDate(List<String> userIds,Date debut,Date fin) throws Exception;

	

	public ClientConsultation getInfoClientByNni(String nni) throws Exception;
	public ClientConsultation getInfoClientByCif(String cif) throws Exception;
	public ClientConsultation getInfoClientByTel(String tel) throws Exception;
	
	public TrsMobile getAdditionalReference(String userId) throws Exception;
	
	public ResponseDto getUserIdByPhone(RequestDto d) throws Exception;
	public ResponseDto getKycStatusByUserId(RequestDto d) throws Exception;
	public ResponseDto getTotalCashinTrsBy(RequestDto d) throws Exception;	
	public BankilyResponse getVerificationMobile(RequestDto req) throws Exception;


}
