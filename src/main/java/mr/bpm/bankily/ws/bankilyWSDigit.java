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
	
	
	@RequestMapping(value="/setEtatClient",method=RequestMethod.POST)
    public @ResponseBody void setEtatClient(@RequestBody  ListClientStatistique req
   		) throws Exception {	
		 monetiqueServiceDao.setEtatClient(req.getClients());
	}
	
}
