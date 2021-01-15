package mr.bpm.bankily.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mr.bpm.bankily.dao.MonetiqueServiceDao;
import mr.bpm.bankily.dot.BankilyResponse;
import mr.bpm.bankily.service.MajBankilyService;

@Service
public class MajBankilyServiceImpl implements MajBankilyService{


	
	@Autowired
	MonetiqueServiceDao mobiquityDao;
	
	@Override
	public boolean updateCompteBankily(String mobileNumber, String cifParticulier, String addRef) throws Exception {
		
		try {
			return mobiquityDao.getPartyIdUserId(mobileNumber, cifParticulier,addRef);
			
		}
		catch (Exception e) {
			// TODO: han
		  throw new Exception("le numero de telephone n'existe pas dans digitalWorkspace");
		}
	}

	@Override
	public BankilyResponse verifierCompte(String telephone) throws Exception {
		
		
		BankilyResponse res1=null;

		String cif=null;


		res1=mobiquityDao.getPartyIdByTelephone(telephone);
		
		if(res1!=null && res1.getPartyId()!=null) {
			
			cif=mobiquityDao.getCifByPartyId(res1.getPartyId());
			res1.setCif(cif);
		}
		
		
		
		return res1;
	}

	@Override
	public BankilyResponse verifierPinTemp(String telephone) throws Exception {
		
		BankilyResponse res1=null;
		
		res1=mobiquityDao.getInfoPINTemp(telephone);
		
		if(res1!=null && res1.getUserId() !=null) {
			
			res1.setStatusUser(mobiquityDao.getEtatUserByUserId(res1.getUserId()));
			
		}

		return res1;
	}

	@Override
	public BankilyResponse verifierBlocage(String telephone) throws Exception {
		
		BankilyResponse res1=null;
		boolean blocage=false;
		
		res1=mobiquityDao.getInfoPINTemp(telephone);
		
		if(res1!=null && res1.getUserId() !=null) {
			
			int status=mobiquityDao.getEtatUserByUserId(res1.getUserId());
			res1.setStatusUser(status);
			
			if(status!=1) {
				blocage=true;
			}
			else {
				if(res1.getTentative()>=3) {
					blocage=true;
				}
				else  {

					if(res1.getDateExpiration()!=null) {
						Calendar cDate= Calendar.getInstance();
						cDate.setTime(res1.getDateExpiration());
						// incrementation par un jour
						cDate.add(Calendar.DATE, 1); 

						Calendar cActuel=Calendar.getInstance();
						
						 if(cDate.after(cActuel)){
							 blocage=true;                
				            }
					}
					
					
				}
			}
			res1.setBlocage(blocage);
			
		}

		return res1;
		
	}

	@Override
	public boolean deblocageUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		boolean res=mobiquityDao.deblocageUser(userId);
		return res;
	}

}
