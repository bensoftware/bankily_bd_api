package mr.bpm.mbanking.helper;

import java.math.BigDecimal;
import java.util.Map;

import mr.bpm.mbanking.dot.PApiRetchqbookReqOut;


public class RetCheckBookReqHelper {

	//méthode pour stockage de classe sortie 
			static public PApiRetchqbookReqOut toRetCheckBookReqOut(Map<String, Object> params) {
				PApiRetchqbookReqOut out = new PApiRetchqbookReqOut();
				//remplissage des champs de classe de sortie out 
				out.osAccStatus = (String) params.get("OS_ACC_STATUS");
				out.osCardStatus = (String) params.get("OS_CARD_STATUS");
				out.olError = (BigDecimal) params.get("OL_ERROR");
				out.osErrMsg = (String) params.get("OS_ERR_MSG");
				
				return out;
			}

}
