package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mr.bpm.mbanking.dao.CheckNniDao;
import mr.bpm.mbanking.dot.PApiCheckNniIn;
import mr.bpm.mbanking.dot.PApiCheckNniOut;


@Component
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PApiCheckNniWS {
	
	@Autowired
	CheckNniDao checkNniDao ;

	@WebMethod
	public PApiCheckNniOut pApiCheckNni(@WebParam(name="papichecknni") PApiCheckNniIn in) {

		return checkNniDao.getCheckNni(in);
	}
} 
