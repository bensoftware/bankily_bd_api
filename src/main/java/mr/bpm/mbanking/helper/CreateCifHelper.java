package mr.bpm.mbanking.helper;

import java.math.BigDecimal;
import java.util.Map;

import mr.bpm.mbanking.dot.PApiCreateCifOut;

public class CreateCifHelper {

	// méthode pour stockage de classe sortie
	static public PApiCreateCifOut toCreateCifOut(Map<String, Object> params) {
		PApiCreateCifOut out = new PApiCreateCifOut();
		// remplissage des champs de classe de sortie out
		out.olCifNo = (BigDecimal) params.get("OL_CIF_NO");
		out.olErrorCode = (BigDecimal) params.get("OL_ERROR_CODE");
		out.osErrorDesc = (String) params.get("OS_ERROR_DESC");

		return out;
	}
}
