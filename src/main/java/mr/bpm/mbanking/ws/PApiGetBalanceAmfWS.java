package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mr.bpm.mbanking.dao.GetBalanceAmfDao;
import mr.bpm.mbanking.dao.GetCifAccountsDao;
import mr.bpm.mbanking.dot.PApiGetBalanceAmfIn;
import mr.bpm.mbanking.dot.PApiGetBalanceAmfOut;
import mr.bpm.mbanking.dot.PApiGetCifAccountsIn;
import mr.bpm.mbanking.dot.PApiGetCifAccountsOut;


@Component
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PApiGetBalanceAmfWS {

	@Autowired
	GetBalanceAmfDao balanceAmfDao ;
	
	@WebMethod
	@WebResult(name="pApiGetBalanceAmfOut")
	public PApiGetBalanceAmfOut pApiGetBalanceAmf(@WebParam(name="pApiGetBalanceAmfIn") PApiGetBalanceAmfIn in) {
		return balanceAmfDao.getBalanceAmf(in);
	}
} 
