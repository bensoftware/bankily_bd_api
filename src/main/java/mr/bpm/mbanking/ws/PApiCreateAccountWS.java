package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.stereotype.Component;

import mr.bpm.mbanking.dot.PApiCreateAccountIn;
import mr.bpm.mbanking.dot.PApiCreateAccountOut;


//@Component
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PApiCreateAccountWS {

	@WebMethod
	public PApiCreateAccountOut pApiCreateAccount(@WebParam(name="papicreateaccount") PApiCreateAccountIn in) {

		return null;
	}
} 
