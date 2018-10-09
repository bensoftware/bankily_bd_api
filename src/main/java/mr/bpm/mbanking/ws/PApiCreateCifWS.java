package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import mr.bpm.mbanking.dot.PApiCreateCifIn;
import mr.bpm.mbanking.dot.PApiCreateCifOut;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)

public class PApiCreateCifWS {

	@WebMethod
	PApiCreateCifOut pApiCreateCif(@WebParam(name="papicreatecif") PApiCreateCifIn in) {

		return null;
	}
} 
