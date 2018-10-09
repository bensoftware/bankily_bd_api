package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mr.bpm.mbanking.dao.CreateAccountDao;
import mr.bpm.mbanking.dot.PApiCreateAccountIn;
import mr.bpm.mbanking.dot.PApiCreateAccountOut;


@Component
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PApiCreateAccountWS {

	@Autowired
	CreateAccountDao accountDao ;
	
	@WebMethod
	public PApiCreateAccountOut pApiCreateAccount(@WebParam(name="papicreateaccount") PApiCreateAccountIn in) {

		return accountDao.getCreateAccount(in);
	}
} 
