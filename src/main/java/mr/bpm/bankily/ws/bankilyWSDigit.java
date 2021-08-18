package mr.bpm.bankily.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mr.bpm.bankily.dao.MonetiqueServiceDao;
import mr.bpm.bankily.dot.BankilyResponse;
import mr.bpm.bankily.dot.Client;
import mr.bpm.bankily.dot.ClientConsultation;
import mr.bpm.bankily.dot.ListClientStatistique;
import mr.bpm.bankily.dot.ListTrsMobile;
import mr.bpm.bankily.dot.ListTrsMobileBus;
import mr.bpm.bankily.dot.Merchant;
import mr.bpm.bankily.dot.PaiementMerchant;
import mr.bpm.bankily.dot.RequestDto;
import mr.bpm.bankily.dot.RequestMerchant;
import mr.bpm.bankily.dot.ResponseDto;
import mr.bpm.bankily.dot.ResponseMerchant;
import mr.bpm.bankily.dot.TrsMobile;
import mr.bpm.bankily.dot.TrsMobileBus;
import mr.bpm.bankily.service.ClientInfoService;
import mr.bpm.bankily.service.MajBankilyService;

@CrossOrigin("*")
@RestController
public class bankilyWSDigit {

	@Autowired
	MonetiqueServiceDao monetiqueServiceDao;
	
	@Autowired
	MajBankilyService bankilyService;

	@Autowired
	ClientInfoService clientInfoService;
	
	
	
	@RequestMapping(value="/getAllMerchant",method=RequestMethod.GET)
    public @ResponseBody ResponseMerchant  getAllMerchant(
   		) throws Exception {
		
	 List<Merchant> list=monetiqueServiceDao.getAllMerchant();
	
	 ResponseMerchant res=new ResponseMerchant();
	 res.setMerchants(list);
	 
		return res;

	}
	
	
	@RequestMapping(value="/getAdditionalReference/{userId}",method=RequestMethod.GET)
    public @ResponseBody TrsMobile  getAdditionalReference(@PathVariable String userId) throws Exception {
		
		TrsMobile trs=monetiqueServiceDao.getAdditionalReference(userId);

	 
		return trs;

	}
	
	@RequestMapping(value="/getMerchant/{userId}",method=RequestMethod.GET)
    public @ResponseBody ResponseMerchant  getMerchant(@PathVariable String userId) throws Exception {
		
	 List<Merchant> list=monetiqueServiceDao.getChildrenMerchant(userId);
	
	 ResponseMerchant res=new ResponseMerchant();
	 res.setMerchants(list);
	 
		return res;

	}
	
	
	@RequestMapping(value="/getPaiementMerchant",method=RequestMethod.POST)
    public @ResponseBody ResponseMerchant  getMerchant(@RequestBody RequestMerchant req) throws Exception {
		
	 List<PaiementMerchant> list=monetiqueServiceDao.getPaiementMerchantByIntervallDate(req.getUserIds(), req.getDebut(), req.getFin());
	
	 ResponseMerchant res=new ResponseMerchant();
	 res.setPaiementMerchants(list);
	 
		return res;

	}
	
	@RequestMapping(value="/getAutoSweepMerchantByIntervallDate",method=RequestMethod.POST)
    public @ResponseBody ResponseMerchant  getAutoSweepMerchantByIntervallDate(@RequestBody RequestMerchant req) throws Exception {
		
	 List<PaiementMerchant> list=monetiqueServiceDao.getAutoSweepMerchantByIntervallDate(req.getUserIds(), req.getDebut(), req.getFin());
	
	 ResponseMerchant res=new ResponseMerchant();
	 res.setPaiementMerchants(list);
	 
		return res;

	}
	
	
	
	@RequestMapping(value="/getPaiementMerchantBytelephone",method=RequestMethod.POST)
    public @ResponseBody ResponseMerchant  getPaiementMerchantBytelephone(@RequestBody RequestMerchant req) throws Exception {
		
	 List<PaiementMerchant> list=monetiqueServiceDao.getPaiementMerchantByTelAndIntervallDate(req.getUserIds(), req.getDebut(), req.getFin());
	
	 ResponseMerchant res=new ResponseMerchant();
	 res.setPaiementMerchants(list);
	 
		return res;

	}
	
	
	
	
	@RequestMapping(value="/getInfoClientByNni/{nni}",method=RequestMethod.GET)
    public @ResponseBody ClientConsultation getInfoClientByNni(@PathVariable String nni
   		) throws Exception {
		
		ClientConsultation res=	clientInfoService.getInfoClientByNni(nni);
	
		return res;

	}
	

	
	
	@RequestMapping(value="/getInfoClientByCif/{cif}",method=RequestMethod.GET)
    public @ResponseBody ClientConsultation getInfoClientByCif(@PathVariable String cif
   		) throws Exception {
		
		ClientConsultation res=	clientInfoService.getInfoClientByCif(cif);
			
			return res;

	}
	
	@RequestMapping(value="/getInfoClientByTel/{tel}",method=RequestMethod.GET)
    public @ResponseBody ClientConsultation getInfoClientByTel(@PathVariable String tel
   		) throws Exception {
		
		ClientConsultation res=	clientInfoService.getInfoClientByTel(tel);
			
			return res;

	}
	
	@RequestMapping(value="/getCifByNni/{nni}",method=RequestMethod.GET)
     public @ResponseBody BankilyResponse getCifByNni(@PathVariable String nni
    		) throws Exception {
 		
    	BankilyResponse res= new BankilyResponse();
    	
    	String cif=monetiqueServiceDao.getCifByNni(nni);
    	
    	res.setCif(cif);
    	
 		return res;

 	}
	
	
	@RequestMapping(value="/getOtpByTelephone/{telephone}",method=RequestMethod.GET)
    public @ResponseBody Client getOtpByTelephone(@PathVariable String telephone
   		) throws Exception {
		   	
   	Client client=monetiqueServiceDao.getOtpByTelephone(telephone);
   	
	return client;

	}
	
	@RequestMapping(value="/debloquerClientBankily/{telephone}",method=RequestMethod.GET)
    public @ResponseBody void debloquerClientBankily(@PathVariable String telephone
   		) throws Exception {
		   	
          monetiqueServiceDao.debloquerClientBankily(telephone);
   	

	}
	
	@RequestMapping(value="/getTelephoneByUserId/{userId}",method=RequestMethod.GET)
    public @ResponseBody Client getTelephoneByUserId(@PathVariable String userId
   		) throws Exception {
		   	
   	Client client=monetiqueServiceDao.getTelephoneByUserId(userId);
   	
	return client;

	}
	
	@RequestMapping(value="/verifierBlocage/{telephone}",method=RequestMethod.GET)
    public @ResponseBody BankilyResponse verifierBlocage(@PathVariable String telephone
   		) throws Exception {
		   	
		BankilyResponse res= bankilyService.verifierBlocage(telephone);
   	
	return res;

	}
	
	
	
	@RequestMapping(value="/deblocageUserTel/{tel}",method=RequestMethod.GET)
    public @ResponseBody void deblocageUserTel(@PathVariable String tel
   		) throws Exception {
		   	
		 monetiqueServiceDao.deblocageUserTel(tel);
   	
	

	}
	
	
	@RequestMapping(value="/deblocageUser/{userId}",method=RequestMethod.GET)
    public @ResponseBody BankilyResponse deblocageUser(@PathVariable String userId
   		) throws Exception {
		   	
		boolean res= bankilyService.deblocageUser(userId);
   	
		BankilyResponse resp=null;
		if(res) {
			resp=new BankilyResponse();
			resp.setUserId(userId);
		}
		
		return resp;

	}
	
	
	@RequestMapping(value="/getPartyIdByTelephone/{telephone}",method=RequestMethod.GET)
    public @ResponseBody BankilyResponse getPartyIdByTelephone(@PathVariable String telephone
   		) throws Exception {
		   	
   	return monetiqueServiceDao.getPartyIdByTelephone(telephone);
      	

	}
	
	@RequestMapping(value="/getTelephoneByNni/{nni}",method=RequestMethod.GET)
    public @ResponseBody BankilyResponse getTelephoneByNni(@PathVariable String nni
   		) throws Exception {
		   	
   	return monetiqueServiceDao.getTelephoneByNni(nni);
      	

	}
	
	
	@RequestMapping(value="/setFullKyc/{nni}",method=RequestMethod.GET)
    public @ResponseBody BankilyResponse setFullKyc(@PathVariable String nni
   		) throws Exception {
		
   	BankilyResponse res= new BankilyResponse();
   	
   	boolean full=monetiqueServiceDao.setFullKyc(nni);
   	
   	int status=0;
   	if(full) {
   		status=3;
   	}
   	
   	res.setStatusUser(status);
   	
		return res;

	}
	
	
	
	@RequestMapping(value="/getTrsMobByTrsId/{trsId}",method=RequestMethod.GET)
    public @ResponseBody TrsMobileBus getTrsMobByTrsId(@PathVariable String trsId
   		) throws Exception {
		
   	
   	TrsMobileBus res=monetiqueServiceDao.getTrsMobByTrsId(trsId);
		
   	return res;
     
	}
	
	@RequestMapping(value="/getInfoPaiementFacturier/{idTransaction}",method=RequestMethod.GET)
    public @ResponseBody ListTrsMobile getInfoPaiementFacturier(@PathVariable String idTransaction) throws Exception {  	
	
		ListTrsMobile res=monetiqueServiceDao.getInfoPaiementFacturier(idTransaction);
	
   	return res;
     
	}
	

	@RequestMapping(value="/getAllTrsRechargeTA",method=RequestMethod.GET)
    public @ResponseBody ListTrsMobileBus getAllTrsRechargeTA(
   		) throws Exception {	
   	
		return monetiqueServiceDao.getAllTransRechargeTA();

	}
	

	@RequestMapping(value="/getAllClientPartialActif",method=RequestMethod.GET)
    public @ResponseBody ListClientStatistique getAllClientPartialActif(
   		) throws Exception {	
   	
		return monetiqueServiceDao.getAllClientPartialActif();
	}
	
	
	@RequestMapping(value="/getEtatClient",method=RequestMethod.POST)
    public @ResponseBody ListClientStatistique getEtatClient(
   		@RequestBody  ListClientStatistique e ) throws Exception {	
		
		return monetiqueServiceDao.getAllEtatClient(e.getClients());
	}
	
	
	@RequestMapping(value="/getAllClientPartialInactif",method=RequestMethod.GET)
    public @ResponseBody ListClientStatistique getAllClientPartialInactif(
   		) throws Exception {		
		return monetiqueServiceDao.getAllClientPartialInactif();
	}
	
	@RequestMapping(value="/getAllClientFullInactif",method=RequestMethod.GET)
    public @ResponseBody ListClientStatistique getAllClientFullInactif(
   		) throws Exception {	
		return monetiqueServiceDao.getAllClientFullInactif();
	}
	
	@RequestMapping(value="/getAllClientFullBpmInactif",method=RequestMethod.GET)
    public @ResponseBody ListClientStatistique getAllClientFullBpmInactif(
   		) throws Exception {	
		return monetiqueServiceDao.getAllClientFullBpmInactif();
	}
	
	@RequestMapping(value="/getAllClientFullActif",method=RequestMethod.GET)
    public @ResponseBody ListClientStatistique getAllClientFullActif(
   		) throws Exception {	
		return monetiqueServiceDao.getAllClientFullActif();
	}
	
	@RequestMapping(value="/getAllClientFullBpmActif",method=RequestMethod.GET)
    public @ResponseBody ListClientStatistique getAllClientFullBpmActif(
   		) throws Exception {	
		return monetiqueServiceDao.getAllClientFullBpmActif();
	}
	
	@RequestMapping(value="/getAllClientFullIncomplet",method=RequestMethod.GET)
    public @ResponseBody ListClientStatistique getAllClientFullIncomplet(
   		) throws Exception {	
		return monetiqueServiceDao.getAllClientFullIncomplet();
	}
	
	@RequestMapping(value="/getAllClientFullComplet",method=RequestMethod.GET)
    public @ResponseBody ListClientStatistique getAllClientFullComplet(
   		) throws Exception {	
		return monetiqueServiceDao.getAllClientFullComplet();
	}
	
	
	@RequestMapping(value="/setEtatClient",method=RequestMethod.GET)
    public @ResponseBody void setEtatClient( ListClientStatistique req
   		) throws Exception {	
		 monetiqueServiceDao.setEtatClient(req.getClients());
	}
	
	@RequestMapping(value="/getAllClientLiaisonBpm",method=RequestMethod.GET)
    public @ResponseBody ListClientStatistique getAllClientLiaisonBpm(
   		) throws Exception {	
		return monetiqueServiceDao.getAllClientLiaisonBpm();
	}
	
	@RequestMapping(value="/getAllCifParty",method=RequestMethod.GET)
    public @ResponseBody ListClientStatistique getAllCifParty(
   		) throws Exception {	
		return monetiqueServiceDao.getAllCifParty();
	}
	

@RequestMapping(value="/getVerificationImalByCif/{cif}",method=RequestMethod.GET)
public @ResponseBody BankilyResponse getVerificationImalByCif(@PathVariable String cif) throws Exception {
	BankilyResponse res=monetiqueServiceDao.getVerificationImalByCif(cif);
	return res;
}


@RequestMapping(value="/getVerificationMobileByTelephone/{telephone}",method=RequestMethod.GET)
public @ResponseBody BankilyResponse getVerificationMobileByTelephone(@PathVariable String telephone) throws Exception {  	
	BankilyResponse res=monetiqueServiceDao.getVerificationMobileByTelephone(telephone);
	return res;
}


@RequestMapping(value="/getVerificationMobile",method=RequestMethod.POST)
public @ResponseBody BankilyResponse getVerificationMobile(@RequestBody RequestDto req) throws Exception {  	
	BankilyResponse res=monetiqueServiceDao.getVerificationMobile(req);
	return res;
}


@RequestMapping(value="/getUserIdByPhone",method=RequestMethod.POST)
public @ResponseBody ResponseDto getUserIdByPhone(@RequestBody RequestDto req
	) throws Exception {	
	return monetiqueServiceDao.getUserIdByPhone(req);
}

@RequestMapping(value="/getStatusByUserId",method=RequestMethod.POST)
public @ResponseBody ResponseDto getStatusByUserId(@RequestBody RequestDto req
	) throws Exception {	
	return monetiqueServiceDao.getKycStatusByUserId(req);
}

@RequestMapping(value="/getTotalCashinTrsByUserId",method=RequestMethod.POST)
public @ResponseBody ResponseDto getTotalCashinTrsByUserId(@RequestBody RequestDto req
	) throws Exception {	
	return monetiqueServiceDao.getTotalCashinTrsBy(req);
}

@RequestMapping(value="/getUserIdByTelephone/{telephone}",method=RequestMethod.GET)
public @ResponseBody BankilyResponse getUserIdByTelephone(@PathVariable String telephone) throws Exception {  	
	BankilyResponse res=monetiqueServiceDao.getUserIdClientByTelephone(telephone);
	return res;
}

@RequestMapping(value="/getUserIdByLogin/{login}",method=RequestMethod.GET)
public @ResponseBody BankilyResponse getUserIdByLogin(@PathVariable String login) throws Exception {  	
	BankilyResponse res=monetiqueServiceDao.getUserIdUserByLogin(login);
	return res;
}


}
