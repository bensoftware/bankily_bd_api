package mr.bpm.mbanking.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mr.bpm.mbanking.dot.FullStatementCursor;
import mr.bpm.mbanking.dot.FullStatementOut;

public class FullStatementHelper {

	static public FullStatementOut toFullStatementOut(Map<String, Object> params) {
		FullStatementOut out = new FullStatementOut();

		List<Map<String, Object>> Objectcurs = (List<Map<String, Object>>) params.get("P_CURSOR");
		out.pCursor=toFullStatementCursor(Objectcurs);
		
		out.odecNetBalance = (BigDecimal) params.get("ODEC_NET_BALANCE");
		out.olRecordNo = (BigDecimal) params.get("OL_RECORD_NO");
		out.olError = (BigDecimal) params.get("OL_ERROR");
		out.osMessage = (String) params.get("OS_MESSAGE");

		return out;
	}

	static public List<FullStatementCursor> toFullStatementCursor(List<Map<String, Object>> map) {
		if (map != null && !map.isEmpty()) {
			List<FullStatementCursor> pcursor = new ArrayList<FullStatementCursor>();
			for (Iterator<Map<String, Object>> iterator = map.iterator(); iterator.hasNext();) {
				Map<String, Object> cursorRow = (Map<String, Object>) iterator.next();
				FullStatementCursor fcursor = new FullStatementCursor();

				fcursor.compCode = (BigDecimal) cursorRow.get("COMP_CODE");
				fcursor.bancheCode = (BigDecimal) cursorRow.get("BRANCH_CODE");
				fcursor.currencyCode = (BigDecimal) cursorRow.get("CURRENCY_CODE");
				fcursor.glCode = (BigDecimal) cursorRow.get("GL_CODE");
				fcursor.cifSubNo = (BigDecimal) cursorRow.get("CIF_SUB_NO");
				fcursor.slNo = (BigDecimal) cursorRow.get("GL_CODE");
				fcursor.opNo = (BigDecimal) cursorRow.get("OP_NO");
				fcursor.lineNo = (BigDecimal) cursorRow.get("LINE_NO");
				fcursor.transDate = ((java.sql.Timestamp) cursorRow.get("TRANS_DATE")).toGMTString();
				fcursor.valueDate = ((java.sql.Timestamp) cursorRow.get("VALUE_DATE")).toGMTString();
				fcursor.cvAmount = (BigDecimal) cursorRow.get("CV_AMOUNT");
				fcursor.fcAmount = (BigDecimal) cursorRow.get("FC_AMOUNT");
				fcursor.balance = (BigDecimal) cursorRow.get("BALANCE");
				fcursor.description = (String) cursorRow.get("DESCRIPTION");
				fcursor.description_arabe = (String) cursorRow.get("DESCRIPTION_ARAB");
				fcursor.description1_arabe = (String) cursorRow.get("DESCRIPTION1_ARAB");
				fcursor.description2_arabe = (String) cursorRow.get("DESCRIPTION2_ARAB");
				fcursor.jvType = (BigDecimal) cursorRow.get("JV_TYPE");
				fcursor.osTransType = (String) cursorRow.get("OS_TRANS_TYPE");
				fcursor.odecOpenningBal = (BigDecimal) cursorRow.get("ODEC_OPENING_BAL");
				fcursor.odecClosingBal = (BigDecimal) cursorRow.get("ODEC_CLOSING_BAL");
				fcursor.ctsTrsNo = (BigDecimal) cursorRow.get("CTS_TRS_NO");
				fcursor.addDate1 = ((java.sql.Timestamp) cursorRow.get("ADD_DATE1")).toGMTString();
				
				fcursor.instruction1 = (String) cursorRow.get("INSTRUCTION1");
				fcursor.instruction2 = (String) cursorRow.get("INSTRUCTION2");
				fcursor.instruction3 = (String) cursorRow.get("INSTRUCTION3");
				fcursor.instruction4 = (String) cursorRow.get("INSTRUCTION4");

				pcursor.add(fcursor);
			}

			return pcursor;
		}
		return null;
	}

}
