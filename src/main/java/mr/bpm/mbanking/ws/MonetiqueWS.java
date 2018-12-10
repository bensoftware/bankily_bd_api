package mr.bpm.mbanking.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mr.bpm.mbanking.dao.MonetiqueServiceDao;
import mr.bpm.mbanking.dot.Historique;
import mr.bpm.mbanking.dot.ListHistorique;
import mr.bpm.mbanking.dot.ListMonetiqueCarte;
import mr.bpm.mbanking.dot.MonetiqueClass;

@Component
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class MonetiqueWS extends SpringBeanAutowiringSupport{

	@Autowired
	MonetiqueServiceDao monetiqueServiceDao ;
	
	@WebMethod
	@WebResult(name = "AuthOut")
	public ListMonetiqueCarte getAuth(@WebParam(name="pan") String pan) {
		
		return   new ListMonetiqueCarte(monetiqueServiceDao.getAuthByPan(pan));
	}
	
	@WebMethod
	@WebResult(name = "ClearingOut")
	public ListMonetiqueCarte getCl(@WebParam(name="pan") String pan) {
		
		return  new ListMonetiqueCarte(monetiqueServiceDao.getClByPan(pan));
	}
	
	@WebMethod
	@WebResult(name = "HistoriqueOut")
	public ListHistorique getHist(@WebParam(name="pan") String pan) {
		return  new ListHistorique(monetiqueServiceDao.getHistByPan(pan));
	}

} 
