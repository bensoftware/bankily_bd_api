package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.stereotype.Component;

import mr.bpm.mbanking.dot.PApiGetCifAccountsIn;
import mr.bpm.mbanking.dot.PApiGetCifAccountsOut;


//@Component
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PApiGetCifAccountsWS {

	@WebMethod
	public PApiGetCifAccountsOut pApiGetCifAccounts(@WebParam(name="papigetcifaccounts") PApiGetCifAccountsIn in) {

		return null;
	}
} 
