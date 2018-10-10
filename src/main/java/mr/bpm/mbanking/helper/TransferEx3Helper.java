package mr.bpm.mbanking.helper;

import java.math.BigDecimal;
import java.util.Map;

import mr.bpm.mbanking.dot.PApiTransferEx3Out;

public class TransferEx3Helper {

	//méthode pour stockage de classe sortie 
	static public PApiTransferEx3Out toTransferEx3Out(Map<String, Object> params) {
		PApiTransferEx3Out out = new PApiTransferEx3Out();
		//remplissage des champs de classe de sortie out 
		out.olShareRef = (BigDecimal) params.get("OL_SHARE_REF");
		out.odecAvail = (BigDecimal) params.get("ODEC_AVAIL");
		out.olTrxCode = (BigDecimal) params.get("OL_TRX_CODE");
		out.olTransactionId = (BigDecimal) params.get("OL_TRANSACTION_ID");
		out.olErrorCode = (BigDecimal) params.get("OL_ERROR_CODE");
		out.osMessage = (String) params.get("OS_MESSAGE");
		
		return out;
	}
}
