package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mr.bpm.mbanking.dao.RetCheckBookReqDao;
import mr.bpm.mbanking.dot.PApiRetchqbookReqIn;
import mr.bpm.mbanking.dot.PApiRetchqbookReqOut;


@Component
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PApiRetchqbookReqWS {

	@Autowired
	RetCheckBookReqDao bookReqDao ;
	
	@WebMethod
	@WebResult(name="pApiRetchqbookReqOut")
	public PApiRetchqbookReqOut pApiRetchqbookReq(@WebParam(name="pApiRetchqbookReqIn") PApiRetchqbookReqIn in) {
		return bookReqDao.getRetCheckBookReq(in);
	}
} 
