package mr.bpm.mbanking.ws;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mr.bpm.mbanking.dao.MonetiqueServiceDao;
import mr.bpm.mbanking.dot.ListHistorique;
import mr.bpm.mbanking.dot.ListMonetiqueCarte;
import mr.bpm.mbanking.dot.ListPan;
import mr.bpm.mbanking.dot.SoldeCarte;

@Component
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class MonetiqueWS extends SpringBeanAutowiringSupport{

	@Autowired
	MonetiqueServiceDao monetiqueServiceDao ;
	
	
	DateFormat df=new SimpleDateFormat("ddMMyyyy");
	
	@WebMethod
	@WebResult(name = "AuthOut")
	public ListMonetiqueCarte getAuth(@WebParam(name="pan") double pan) {
		
		return   new ListMonetiqueCarte(monetiqueServiceDao.getAuthByPan(pan));
	}
	
	@WebMethod
	@WebResult(name = "ClearingOut")
	public ListMonetiqueCarte getCl(@WebParam(name="pan") double pan) {
		
		return  new ListMonetiqueCarte(monetiqueServiceDao.getClByPan(pan));
	}
	
	@WebMethod
	@WebResult(name = "HistoriqueOut")
	public ListHistorique getHist(@WebParam(name="pan") double pan) {
		return  new ListHistorique(monetiqueServiceDao.getHistByPan(pan));
	}
	
	@WebMethod
	@WebResult(name = "PanOut")
	public ListPan getPans() {
		return  new ListPan(monetiqueServiceDao.getAllCarte());
	}
	
	@WebMethod
	@WebResult(name = "SoldeOut")
	public SoldeCarte SoldeOut(@WebParam(name="pan") double pan) {
		return  monetiqueServiceDao.getSoldeCarte(pan);
	}
	
	@WebMethod
	@WebResult(name = "SlSSOut")
	public ListMonetiqueCarte SoldeSSOut(@WebParam(name="du") Date du , @WebParam(name="au") Date au)  {
		
		return   new ListMonetiqueCarte(monetiqueServiceDao.getDailyValidSSByDateIntervall(du, au));
	}
	
	/*@WebMethod
	@WebResult(name = "SlSSOut")
	public ListMonetiqueCarte SoldeSSOut(@WebParam(name="du") String du , @WebParam(name="au") String au) throws ParseException {
		
		 Date ddu=df.parse(du);
		 Date dau =df.parse(au);	
		
		return   new ListMonetiqueCarte(monetiqueServiceDao.getDailyValidSSByDateIntervall(ddu, dau));
	}*/

} 
