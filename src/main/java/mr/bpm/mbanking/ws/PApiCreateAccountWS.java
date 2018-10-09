package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import mr.bpm.mbanking.dot.PApiCreateAccountIn;
import mr.bpm.mbanking.dot.PApiCreateAccountOut;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)

public class PApiCreateAccountWS {

	@WebMethod
	PApiCreateAccountOut pApiCreateAccount(@WebParam(name="papicreateaccount") PApiCreateAccountIn in) {

		return null;
	}
} 
