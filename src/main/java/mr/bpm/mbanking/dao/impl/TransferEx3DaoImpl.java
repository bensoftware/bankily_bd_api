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

import mr.bpm.mbanking.dao.TransferEx3Dao;
import mr.bpm.mbanking.dot.PApiTransferEx3In;
import mr.bpm.mbanking.dot.PApiTransferEx3Out;
import mr.bpm.mbanking.helper.RetCheckBookReqHelper;
import mr.bpm.mbanking.helper.TransferEx3Helper;

@Repository
public class TransferEx3DaoImpl implements TransferEx3Dao {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public PApiTransferEx3Out getTransferEx3(PApiTransferEx3In inTransferEx3) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("P_API_TRANSFER_EX3");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("AL_CHANNEL_ID", inTransferEx3.alChannelId)
				.addValue("AS_USER_ID", inTransferEx3.asUserId)
				.addValue("AS_MACHINE_NAME", inTransferEx3.asMachineName)
				.addValue("AL_API_CODE", inTransferEx3.alApiCode)
				.addValue("AL_COMP_CODE", inTransferEx3.alCompCode)
				.addValue("AL_BRANCH", inTransferEx3.alBranch)
				.addValue("AL_TELLER", inTransferEx3.alTeller)
				.addValue("AL_TRXTYPE", inTransferEx3.alTrxType)
				.addValue("AL_USE_CARD_ACCNO", inTransferEx3.alUseCardAccno)
				.addValue("AS_TRANSACTION_TYPE", inTransferEx3.asTransactionType)
				.addValue("AS_CARD", inTransferEx3.asCard)
				.addValue("AL_ACC_BR", inTransferEx3.alAccBr)
				.addValue("AL_ACC_CY", inTransferEx3.alAccCy)
				.addValue("AL_ACC_GL", inTransferEx3.alAccGl)
				.addValue("AL_ACC_CIF", inTransferEx3.alAccCif)
				.addValue("AL_ACC_SL", inTransferEx3.alAccSl)
				.addValue("AS_ACCOUNT", inTransferEx3.asAccount)
				.addValue("AL_TO_ACC_BR", inTransferEx3.alToAccBr)
				.addValue("AL_TO_ACC_CY", inTransferEx3.alToAccCy)
				.addValue("AL_TO_ACC_GL", inTransferEx3.alToAccGl)
				.addValue("AL_TO_ACC_CIF", inTransferEx3.alToAccCif)
				.addValue("AL_TO_ACC_SL", inTransferEx3.alToAccSl)
				.addValue("AS_TOACCOUNT", inTransferEx3.asToAccount)
				.addValue("ADEC_AMOUNT", inTransferEx3.adecAmount)
				.addValue("AS_CURRENCY", inTransferEx3.asCurrency)
				.addValue("AS_DATE_TIME", inTransferEx3.asDateTime)
				.addValue("AS_REFERENCE", inTransferEx3.asReference)
				.addValue("AL_POS", inTransferEx3.alPos)
				.addValue("AS_DESC", inTransferEx3.asDesc)
				.addValue("AS_DESC_ARAB", inTransferEx3.asDescArab)
				.addValue("ADT_VALUE_DATE", inTransferEx3.adtValueDate)
				.addValue("AS_BILLER_CODE", inTransferEx3.asBillerCode)
				.addValue("AS_SO_REFERENCE", inTransferEx3.asSoReference)
				.addValue("AL_ADD_NUMBER", inTransferEx3.alAddNumber)
				.addValue("AL_NUM_OF_SHARES", inTransferEx3.alNumOfShares)
				.addValue("AS_INSTRUCTIONS1", inTransferEx3.asInstructions1)
				.addValue("AS_INSTRUCTIONS2", inTransferEx3.asInstructions2)
				.addValue("AS_INSTRUCTIONS3", inTransferEx3.asInstructions3)
				.addValue("AS_INSTRUCTIONS4", inTransferEx3.asInstructions4)
				.addValue("AL_TRX_PURPOSE", inTransferEx3.alTrxPurpose)
				.addValue("AS_APPROVED_TRX", inTransferEx3.asApprovedTrx)
				;

		Map<String, Object> out = jdbcCall.execute(in);

		return TransferEx3Helper.toTransferEx3Out(out);
	}

}
