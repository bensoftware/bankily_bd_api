package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mr.bpm.mbanking.dot.FullStatementIn;
import mr.bpm.mbanking.dot.FullStatementOut;

//@Component
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class FullStatementWS extends SpringBeanAutowiringSupport{

	@WebMethod
	public FullStatementOut pApiFullStatement(@WebParam(name="fullstatement") FullStatementIn in) {

		return null;
	}

} 
