package mr.bpm.mbanking.helper;



import java.math.BigDecimal;
import java.util.Map;

import mr.bpm.mbanking.dot.FullStatementOut;
import mr.bpm.mbanking.dot.PApiCheckNniOut;

public class CheckNniHelper {

	//méthode pour stockage de classe sortie 
	static public PApiCheckNniOut toCheckNniOut(Map<String, Object> params) {
		PApiCheckNniOut out = new PApiCheckNniOut();
		//remplissage des champs de classe de sortie out 
		out.olTransactionId = (BigDecimal) params.get("OL_TRANSACTION_ID");
		out.olErrorCode = (BigDecimal) params.get("OL_ERROR_CODE");
		out.osErrorDesc = (String) params.get("OS_ERROR_DESC");

		return out;
	}

}
