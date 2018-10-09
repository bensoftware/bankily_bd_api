package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import mr.bpm.mbanking.dot.FullStatementIn;
import mr.bpm.mbanking.dot.FullStatementOut;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)

public class FullStatementWS {

	@WebMethod
	FullStatementOut pApiFullStatement(@WebParam(name="fullstatement") FullStatementIn in) {

		
		FullStatementOut out=new FullStatementOut();
		out.osMessage="med lemine";
		
		
		return out;
	}
} 
