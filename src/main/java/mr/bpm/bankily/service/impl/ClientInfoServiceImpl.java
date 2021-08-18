package mr.bpm.bankily.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mr.bpm.bankily.dao.MonetiqueServiceDao;
import mr.bpm.bankily.dot.ClientConsultation;
import mr.bpm.bankily.dot.ClientNni;
import mr.bpm.bankily.service.ClientInfoService;
import mr.bpm.bankily.service.EtatCivilService;

@Service
public class ClientInfoServiceImpl implements ClientInfoService{
    
	
	@Autowired
	MonetiqueServiceDao mobiquityDao;
    
	
	@Autowired
	EtatCivilService etatCivilService;
    
	@Override
	public ClientConsultation getInfoClientByNni(String nni) throws Exception {
	
		ClientConsultation cl= mobiquityDao.getInfoClientByNni(nni);
	
		String nniC= cl.getNni();
		
		try {
			ClientNni c= etatCivilService.getInfoNni(nniC);		
			cl.setPicture(c.getImg());
			c=null;
		} catch (Exception e) {
			// TODO: handle exception
		}

       
		return cl;
	}

	@Override
	public ClientConsultation getInfoClientByCif(String cif) throws Exception {
		ClientConsultation cl= mobiquityDao.getInfoClientByCif(cif);
		
		String nniC= cl.getNni();
		
		try {
			ClientNni c= etatCivilService.getInfoNni(nniC);		
			cl.setPicture(c.getImg());
			c=null;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cl;
	}

	@Override
	public ClientConsultation getInfoClientByTel(String tel) throws Exception {
		ClientConsultation cl= mobiquityDao.getInfoClientByTel(tel);
		
		String nniC= cl.getNni();
		
		try {
			ClientNni c= etatCivilService.getInfoNni(nniC);		
			cl.setPicture(c.getImg());
			c=null;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cl;
	}
	


}
