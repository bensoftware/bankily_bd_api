package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.stereotype.Component;

import mr.bpm.mbanking.dot.PApiTransferEx3In;
import mr.bpm.mbanking.dot.PApiTransferEx3Out;


//@Component
@WebService(name = "PApiTransferEx3WS")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PApiTransferEx3WS {

	@WebMethod
	public PApiTransferEx3Out pApiTransferEx3(@WebParam(name="papitransferex3") PApiTransferEx3In in) {

		return null;
	}
} 
