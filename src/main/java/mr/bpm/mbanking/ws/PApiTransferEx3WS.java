package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mr.bpm.mbanking.dao.TransferEx3Dao;
import mr.bpm.mbanking.dot.PApiTransferEx3In;
import mr.bpm.mbanking.dot.PApiTransferEx3Out;


@Component
@WebService(name = "PApiTransferEx3WS")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PApiTransferEx3WS {

	@Autowired
	TransferEx3Dao ex3Dao ;
	
	@WebMethod
	@WebResult(name="pApiTransferEx3Out")
	public PApiTransferEx3Out pApiTransferEx3(@WebParam(name="pApiTransferEx3In") PApiTransferEx3In in) {
		return ex3Dao.getTransferEx3(in);
	}
} 
