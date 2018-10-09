package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import mr.bpm.mbanking.dot.FullStatementIn;
import mr.bpm.mbanking.dot.FullStatementOut;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)

public interface FullStatementWS {

	@WebMethod
	FullStatementOut pApiFullStatement(FullStatementIn in);
}
