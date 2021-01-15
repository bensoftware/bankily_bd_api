package mr.bpm.bankily.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import mr.bpm.bankily.dao.MonetiqueServiceDao;
import mr.bpm.bankily.dot.BankilyResponse;
import mr.bpm.bankily.dot.ListTrsMobile;
import mr.bpm.bankily.dot.TrsMobileBus;
import mr.bpm.bankily.service.MajBankilyService;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
@Component
public class ApiBankilyWS {
	
	
	@Autowired
	MonetiqueServiceDao monetiqueServiceDao;
	
	@Autowired
	MajBankilyService majBankilyService;
	
    final Logger logger = LoggerFactory.getLogger(ApiBankilyWS.class);
    final 	ObjectMapper mapper = new ObjectMapper();
	
    
    
    
    @WebMethod
  	@WebResult(name = "updateCompteBankily")
     public @ResponseBody BankilyResponse updateCompteBankily(@WebParam(name="telephone") String mobileNumber,
    		 @WebParam(name="cif") String cifParticulier,
    		 @WebParam(name="addRef") String addRef) throws Exception {
 		
    	BankilyResponse res= new BankilyResponse();
    	res.setUpdateMajBankily(majBankilyService.updateCompteBankily(mobileNumber, cifParticulier, addRef));
    	
 		
 		return res;

 	}
    
    
    @WebMethod
   	@WebResult(name = "getAdditionalRefByCif")
      public @ResponseBody BankilyResponse getAdditionalRefByCif(
     		 @WebParam(name="cif") String cif
     		) throws Exception {
  		
     	BankilyResponse res= monetiqueServiceDao.getAdditionalRefByCif(cif);
  		return res;

  	}
    
    
    
    @WebMethod
   	@WebResult(name = "verifierPinTemp")
      public @ResponseBody BankilyResponse verifierPinTemp(
     		 @WebParam(name="telephone") String mobileNumber
     		) throws Exception {
  		
     	BankilyResponse res= majBankilyService.verifierPinTemp(mobileNumber);
  		return res;

  	}
    
    
    @WebMethod
  	@WebResult(name = "verifierCompte")
     public @ResponseBody BankilyResponse verifierCompte(
    		 @WebParam(name="telephone") String mobileNumber
    		) throws Exception {
 		
    	BankilyResponse res= majBankilyService.verifierCompte(mobileNumber);
 		return res;

 	}
    
    
    @WebMethod
  	@WebResult(name = "getCifByNni")
     public @ResponseBody BankilyResponse getCifByNni(
    		 @WebParam(name="nni") String nni
    		) throws Exception {
 		
    	BankilyResponse res= new BankilyResponse();
    	
    	String cif=monetiqueServiceDao.getCifByNni(nni);
    	
    	res.setCif(cif);
    	
 		return res;

 	}
    
/*    @WebMethod
  	@WebResult(name = "getInfoPaiementSnde")
     public @ResponseBody TrsMobileBus getTransRechargeByIdTrans(@WebParam(name="idTrans") String idTrans) throws Exception {
 		
    	TrsMobileBus t = monetiqueServiceDao.getTransRechargeByIdTrans(idTrans);
 		return t;

 	}*/
  /*  
    @WebMethod
 	@WebResult(name = "return")
    public @ResponseBody TransImal getVerifieTransImal(@WebParam(name="idTrans") String idTrans) throws Exception {
		
		TransImal t = monetiqueServiceDao.getVerifieTransImal(idTrans);
		
		return t;

	}
	
    @WebMethod
	@WebResult(name = "return")
	public @ResponseBody ListTransImal getAllTransNoSucces(@WebParam(name="index1") String index1,@WebParam(name="index2") String index2,@WebParam(name="operateur") int operateur) throws Exception {
		
		ListTransImal t = monetiqueServiceDao.getAllTransNoSucces(index1, index2, operateur);
		
		return t;

	}*/
	
} 
