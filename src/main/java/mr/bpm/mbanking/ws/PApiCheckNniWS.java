package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.stereotype.Component;

import mr.bpm.mbanking.dot.PApiCheckNniIn;
import mr.bpm.mbanking.dot.PApiCheckNniOut;


//@Component
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PApiCheckNniWS {

	@WebMethod
	public PApiCheckNniOut pApiCheckNni(@WebParam(name="papichecknni") PApiCheckNniIn in) {

		return null;
	}
} 
