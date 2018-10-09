package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.stereotype.Component;

import mr.bpm.mbanking.dot.PApiRetchqbookReqIn;
import mr.bpm.mbanking.dot.PApiRetchqbookReqOut;


@Component
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PApiRetchqbookReqWS {

	@WebMethod
	public PApiRetchqbookReqOut pApiRetchqbookReq(@WebParam(name="papiretchqbookreq") PApiRetchqbookReqIn in) {

		return null;
	}
} 
