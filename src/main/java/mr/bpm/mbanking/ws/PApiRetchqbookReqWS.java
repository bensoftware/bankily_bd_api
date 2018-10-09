package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import mr.bpm.mbanking.dot.PApiRetchqbookReqIn;
import mr.bpm.mbanking.dot.PApiRetchqbookReqOut;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)

public class PApiRetchqbookReqWS {

	@WebMethod
	PApiRetchqbookReqOut pApiRetchqbookReq(@WebParam(name="papiretchqbookreq") PApiRetchqbookReqIn in) {

		return null;
	}
} 
