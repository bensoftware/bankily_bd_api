package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import mr.bpm.mbanking.dot.PApiTransferEx3In;
import mr.bpm.mbanking.dot.PApiTransferEx3Out;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)

public class PApiTransferEx3WS {

	@WebMethod
	PApiTransferEx3Out pApiTransferEx3(@WebParam(name="papitransferex3") PApiTransferEx3In in) {

		return null;
	}
} 
