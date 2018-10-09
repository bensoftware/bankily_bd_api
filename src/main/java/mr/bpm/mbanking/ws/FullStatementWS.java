package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mr.bpm.mbanking.dao.FullStatementDao;
import mr.bpm.mbanking.dot.FullStatementIn;
import mr.bpm.mbanking.dot.FullStatementOut;

@Component
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class FullStatementWS extends SpringBeanAutowiringSupport{

	@Autowired
	FullStatementDao fullStatementDao ;
	
	@WebMethod
	public FullStatementOut pApiFullStatement(@WebParam(name="fullstatement") FullStatementIn in) {

		return fullStatementDao.getFullStatement(in);
	}

} 
