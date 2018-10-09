package mr.bpm.mbanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.stereotype.Component;

import mr.bpm.mbanking.dot.FullStatementIn;
import mr.bpm.mbanking.dot.FullStatementOut;
import mr.bpm.mbanking.dot.PApiCheckNniIn;
import mr.bpm.mbanking.dot.PApiCheckNniOut;
import mr.bpm.mbanking.dot.PApiCreateAccountIn;
import mr.bpm.mbanking.dot.PApiCreateAccountOut;
import mr.bpm.mbanking.dot.PApiCreateCifIn;
import mr.bpm.mbanking.dot.PApiCreateCifOut;
import mr.bpm.mbanking.dot.PApiGetCifAccountsIn;
import mr.bpm.mbanking.dot.PApiGetCifAccountsOut;
import mr.bpm.mbanking.dot.PApiRetchqbookReqIn;
import mr.bpm.mbanking.dot.PApiRetchqbookReqOut;
import mr.bpm.mbanking.dot.PApiTransferEx3In;
import mr.bpm.mbanking.dot.PApiTransferEx3Out;

@Component
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class AllMbankingWS {

	@WebMethod
	public FullStatementOut pApiFullStatement(@WebParam(name="fullstatement") FullStatementIn in) {

		return null;
	}
	
	@WebMethod
	public PApiCheckNniOut pApiCheckNni(@WebParam(name="papichecknni") PApiCheckNniIn in) {

		return null;
	}
	
	@WebMethod
	public PApiCreateAccountOut pApiCreateAccount(@WebParam(name="papicreateaccount") PApiCreateAccountIn in) {

		return null;
	}
	
	@WebMethod
	public PApiCreateCifOut pApiCreateCif(@WebParam(name="papicreatecif") PApiCreateCifIn in) {

		return null;
	}
	
	@WebMethod
	public PApiGetCifAccountsOut pApiGetCifAccounts(@WebParam(name="papigetcifaccounts") PApiGetCifAccountsIn in) {

		return null;
	}
	
	@WebMethod
	public PApiRetchqbookReqOut pApiRetchqbookReq(@WebParam(name="papiretchqbookreq") PApiRetchqbookReqIn in) {

		return null;
	}
	
	@WebMethod
	public PApiTransferEx3Out pApiTransferEx3(@WebParam(name="papitransferex3") PApiTransferEx3In in) {

		return null;
	}

} 
