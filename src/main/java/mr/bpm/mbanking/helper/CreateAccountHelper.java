package mr.bpm.mbanking.helper;

import java.math.BigDecimal;
import java.util.Map;

import mr.bpm.mbanking.dot.PApiCreateAccountOut;

public class CreateAccountHelper {

	//méthode pour stockage de classe sortie 
		static public PApiCreateAccountOut toCreateAccountOut(Map<String, Object> params) {
			PApiCreateAccountOut out = new PApiCreateAccountOut();
			//remplissage des champs de classe de sortie out 
			out.osAddRef = (String) params.get("OS_ADD_REF");
			out.olTrsNo = (BigDecimal) params.get("OL_TRS_NO");
			out.olPointRate = (BigDecimal) params.get("OL_POINT_RATE");
			out.odtMateDate = ((java.sql.Timestamp) params.get("ODT_MATE_DATE")).toGMTString();
			out.olNewBal = (BigDecimal) params.get("OL_NEW_BAL");
			out.osAccName = (String) params.get("OS_ACC_NAME");
			out.olErrorCode = (BigDecimal) params.get("OL_ERROR_CODE");
			out.osErrorDesc = (String) params.get("OS_ERROR_DESC");
			
			return out;
		}
}
