package mr.bpm.mbanking.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mr.bpm.mbanking.dot.PApiGetCifAccountsCursor;
import mr.bpm.mbanking.dot.PApiGetCifAccountsOut;


public class GetCifAccountsHelper {

	static public PApiGetCifAccountsOut toGetCifAccountsOut(Map<String, Object> params) {
		PApiGetCifAccountsOut out = new PApiGetCifAccountsOut();

		List<Map<String, Object>> Objectcurs = (List<Map<String, Object>>) params.get("P_CURSOR");
		out.pCursor=toGetCifAccountsCursor(Objectcurs);
		
		out.OlTransactionId = (BigDecimal) params.get("OL_TRANSACTION_ID");
		out.OlErrorCode = (BigDecimal) params.get("OL_ERROR_CODE");
		out.OsErrorDesc = (String) params.get("OS_ERROR_DESC");

		return out;
	}

	static public List<PApiGetCifAccountsCursor> toGetCifAccountsCursor(List<Map<String, Object>> map) {
		if (map != null && !map.isEmpty()) {
			List<PApiGetCifAccountsCursor> pcursor = new ArrayList<PApiGetCifAccountsCursor>();
			for (Iterator<Map<String, Object>> iterator = map.iterator(); iterator.hasNext();) {
				Map<String, Object> cursorRow = (Map<String, Object>) iterator.next();
				PApiGetCifAccountsCursor fcursor = new PApiGetCifAccountsCursor();

				fcursor.olBranchCode = (BigDecimal) cursorRow.get("OL_BRANCH_CODE");
				fcursor.osIsoCyCode = (String) cursorRow.get("OS_ISO_CY_CODE");
				fcursor.olCurrencyCode = (BigDecimal) cursorRow.get("OL_CURRENCY_CODE");
				fcursor.olGlCode = (BigDecimal) cursorRow.get("OL_GL_CODE");
				fcursor.olCifSubNo = (BigDecimal) cursorRow.get("OL_CIF_SUB_NO");
				fcursor.osCifName = (String) cursorRow.get("OS_CIF_NAME");
				fcursor.olSlNo = (BigDecimal) cursorRow.get("OL_SL_NO");
				fcursor.osAddReference = (String) cursorRow.get("OSS_ADD_REFERENCE");
				fcursor.osGlNameEng = (String) cursorRow.get("OS_GL_NAME_ENG");
				fcursor.osGlNameArab = (String) cursorRow.get("OS_GL_NAME_ARAB");
				//fcursor.transDate = ((java.sql.Timestamp) cursorRow.get("TRANS_DATE")).toGMTString();
				fcursor.osBriefNameEng = (String) cursorRow.get("OS_BRIEF_NAME_ENG");
				fcursor.osBriefNameArab = (String) cursorRow.get("OS_BRIEF_NAME_ARAB");
				fcursor.osLongNameEng = (String) cursorRow.get("OS_LONG_NAME_ENG");
				fcursor.osLongNameArab = (String) cursorRow.get("OS_LONG_NAME_ARAB");
				fcursor.odecFcBal = (BigDecimal) cursorRow.get("ODEC_FC_BAL");
				fcursor.odecFcAvailBal = (BigDecimal) cursorRow.get("ODEC_FC_AVAIL_BAL");
				fcursor.odecCvBal = (BigDecimal) cursorRow.get("ODEC_CV_BAL");
				fcursor.odecCvAvailBal = (BigDecimal) cursorRow.get("ODEC_CV_AVAIL_BAL");
				fcursor.osStatus = (String) cursorRow.get("OS_STATUS");
				fcursor.odOpenDate = (Date) ( cursorRow.get("OD_OPEN_DATE"));
				fcursor.odMaturity = (Date) ( cursorRow.get("OD_MATURITY"));
				fcursor.olCardNumber = (BigDecimal) cursorRow.get("OL_CARD_NUMBER");
				fcursor.osCardType = (String) cursorRow.get("OS_CARD_TYPE");
				fcursor.odecHoldAmount = (BigDecimal) cursorRow.get("ODEC_HOLD_AMOUNT");
				fcursor.odecToDayCreditAmount = (BigDecimal) cursorRow.get("ODEC_TODAY_CREDIT_AMOUNT");
				fcursor.odecToDayDebitAmount = (BigDecimal) cursorRow.get("ODEC_TODAY_DEBIT_AMOUNT");
				fcursor.odecToDayFloatAmount = (BigDecimal) cursorRow.get("ODEC_TODAY_FLOAT_AMOUNT");
				fcursor.osAccountType = (String) cursorRow.get("OS_ACCOUNT_TYPE");
				fcursor.osOfficerName = (String) cursorRow.get("OS_OFFICER_NAME");
				fcursor.olNoAccounts = (BigDecimal) cursorRow.get("OL_NO_ACCOUNTS");
				fcursor.olMaturityDays = (BigDecimal) cursorRow.get("OL_MATURITY_DAYS");
				fcursor.osPftTo = (String) cursorRow.get("OS_PFT_TO");
				fcursor.osRenew = (String) cursorRow.get("OS_RENEW");
				fcursor.odDate = (Date) ( cursorRow.get("OD_DATE"));
				fcursor.olPtRate = (BigDecimal) cursorRow.get("OL_PT_RATE");
				fcursor.olTrfCy = (BigDecimal) cursorRow.get("OL_TRF_CY");
				fcursor.olTrfGl = (BigDecimal) cursorRow.get("OL_TRF_GL");
				fcursor.olTrfCif = (BigDecimal) cursorRow.get("OL_TRF_CIF");
				fcursor.olTrfSl = (BigDecimal) cursorRow.get("OL_TRF_SL");
				fcursor.osModarabaType = (String) cursorRow.get("OS_MODARABA_TYPE");
				fcursor.olBankId = (BigDecimal) cursorRow.get("OL_BANK_ID");
				fcursor.osBankAccId = (String) cursorRow.get("OS_BANK_ACC_ID");
				fcursor.osAdress1Eng = (String) cursorRow.get("OS_ADDRESS1_ENG");
				fcursor.osAdress2Eng = (String) cursorRow.get("OS_ADDRESS2_ENG");
				fcursor.osAdress3Eng = (String) cursorRow.get("OS_ADDRESS3_ENG");
				fcursor.osCityEng = (String) cursorRow.get("OS_CITY_ENG");
				fcursor.olCountry = (BigDecimal) cursorRow.get("OL_COUNTRY");
				fcursor.olDealNo = (BigDecimal) cursorRow.get("OL_DEAL_NO");
				fcursor.osDealCustomNo = (String) cursorRow.get("OS_DEAL_CUSTOM_NO");
				fcursor.olStateCode = (BigDecimal) cursorRow.get("OL_STATE_CODE");
				fcursor.osPostCode = (String) cursorRow.get("OS_POSTCODE");
				fcursor.osGmiFlag = (String) cursorRow.get("OS_GMI_FLAG");
				fcursor.olErrorCode = (BigDecimal) cursorRow.get("OL_ERROR_CODE");
				fcursor.osErrorDesc = (String) cursorRow.get("OS_ERROR_DESC");

				pcursor.add(fcursor);
			}

			return pcursor;
		}
		return null;
	}
}
