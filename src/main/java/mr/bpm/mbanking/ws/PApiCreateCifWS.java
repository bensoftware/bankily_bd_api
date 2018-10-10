package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mr.bpm.mbanking.dao.CreateCifDao;
import mr.bpm.mbanking.dot.PApiCreateCifIn;
import mr.bpm.mbanking.dot.PApiCreateCifOut;


@Component
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PApiCreateCifWS {

	@Autowired
	CreateCifDao cifDao ;
	
	@WebMethod
	public PApiCreateCifOut pApiCreateCif(@WebParam(name="papicreatecif") PApiCreateCifIn in) {

		return cifDao.getCif(in);
	}
} 
