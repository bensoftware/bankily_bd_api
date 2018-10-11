package mr.bpm.mbanking.dao.impl;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import mr.bpm.mbanking.dao.CreateAccountDao;
import mr.bpm.mbanking.dot.PApiCreateAccountIn;
import mr.bpm.mbanking.dot.PApiCreateAccountOut;
import mr.bpm.mbanking.helper.CreateAccountHelper;

@Repository
public class CreateAccountDaoImpl implements CreateAccountDao {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public PApiCreateAccountOut getCreateAccount(PApiCreateAccountIn inCreateAccount) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("P_API_ACCOUNT_CREATION_2");
		SqlParameterSource in = new MapSqlParameterSource().addValue("AL_CHANNEL_ID", inCreateAccount.alChannelId)
				.addValue("AS_USER_ID", inCreateAccount.asUserId)
				.addValue("AS_MACHINE_NAME", inCreateAccount.asMachineName)
				.addValue("AL_API_CODE", inCreateAccount.alAPiCode)
				.addValue("ADT_DATE", inCreateAccount.adtDate)
				.addValue("AL_COMP_CODE", inCreateAccount.alCompCode)
				.addValue("AL_BRANCH_CODE", inCreateAccount.alBranchCode)
				.addValue("AS_CURRENCY_CODE", inCreateAccount.asCurrencyCode)
				.addValue("AL_GL_CODE", inCreateAccount.alGlCode)
				.addValue("AL_CIF_SUB_NO", inCreateAccount.alCifSubNo)
				.addValue("AS_TELLER_ID", inCreateAccount.asTellerId)
				.addValue("AS_RENEW", inCreateAccount.asRenew)
				.addValue("AL_TRF_BR", inCreateAccount.alTrfBr)
				.addValue("AL_TRF_CY", inCreateAccount.alTrfCy)
				.addValue("AL_TRF_GL", inCreateAccount.alTrfGl)
				.addValue("AL_TRF_CIF", inCreateAccount.alTrfCif)
				.addValue("AL_TRF_SL", inCreateAccount.alTrfSl)
				.addValue("AS_TRF_ADD_REF", inCreateAccount.asTrfAddRef)
				.addValue("AS_PFT_POST_TO", inCreateAccount.asPftPostTo)
				.addValue("AL_PROFIT_BR", inCreateAccount.alProfitBr)
				.addValue("AL_PROFIT_CY", inCreateAccount.alProfitCy)
				.addValue("AL_PROFIT_GL", inCreateAccount.alProfitGl)
				.addValue("AL_PROFIT_CIF", inCreateAccount.alProfitCif)
				.addValue("AL_PROFIT_SL", inCreateAccount.alProfitSl)
				.addValue("AS_PROFIT_ADD_REF", inCreateAccount.asProfitAddRef)
				.addValue("AL_MATURITY_GL", inCreateAccount.alMaturityGl)
				.addValue("AS_EXT_TRF", inCreateAccount.asExtTrf)
				.addValue("AL_OFF_BR", inCreateAccount.alOffBr)
				.addValue("AL_OFF_CY", inCreateAccount.alOffCy)
				.addValue("AL_OFF_GL", inCreateAccount.alOffGl)
				.addValue("AL_OFF_CIF", inCreateAccount.aloffCIF)
				.addValue("AL_OFF_SL", inCreateAccount.aloffSL)
				.addValue("AS_OFF_ADD_REF", inCreateAccount.asoffAddRef)
				.addValue("AL_TRANSFER_AM", inCreateAccount.alTransfertAm)
				.addValue("AL_DEBIT_BRANCH", inCreateAccount.alDebitBranch)
				.addValue("AL_DEBIT_CURRENCY", inCreateAccount.alDebitCurrency)
				.addValue("AL_DEBIT_GL_CODE", inCreateAccount.alDebitGlCode)
				.addValue("AL_DEBIT_CIF_SUB_NO", inCreateAccount.alDebitCifSubNo)
				.addValue("AL_DEBIT_SL", inCreateAccount.alDebitSl)
				.addValue("AS_DEBIT_ADD_REF", inCreateAccount.asDebitAddRef)
				.addValue("AS_REMARKS", inCreateAccount.asRemarks)
				.addValue("AL_DIV_CODE", inCreateAccount.alDivCode)
				.addValue("AL_DEPT_CODE", inCreateAccount.alDeptCode)
				.addValue("AS_REFERENCE", inCreateAccount.asReference)
				.addValue("AL_POS", inCreateAccount.alPos)
				.addValue("AS_INST1", inCreateAccount.asInst1)
				.addValue("AS_INST2", inCreateAccount.asInst2)
				.addValue("AL_TRXTYPE", inCreateAccount.alTrxType)
				.addValue("AS_STATUS", inCreateAccount.asStatus)
				.addValue("AS_CREATED_TRX", inCreateAccount.asCreatedTrx)
				.addValue("ADT_MATURITY_DATE", inCreateAccount.adtMaturityDate);

		Map<String, Object> out = jdbcCall.execute(in);

		return CreateAccountHelper.toCreateAccountOut(out);

	}

}
