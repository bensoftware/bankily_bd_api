package mr.bpm.mbanking.helper;

import java.math.BigDecimal;
import java.util.Map;

import mr.bpm.mbanking.dot.PApiGetBalanceAmfOut;

public class GetBalanceAmfHelper {

	static public PApiGetBalanceAmfOut toGetBalanceAmf(Map<String, Object> params) {
		PApiGetBalanceAmfOut out = new PApiGetBalanceAmfOut();		
		out.odecBalance = (BigDecimal) params.get("ODEC_BALANCE");
		out.olError = (BigDecimal) params.get("OL_ERROR");
		return out;
	}

}
