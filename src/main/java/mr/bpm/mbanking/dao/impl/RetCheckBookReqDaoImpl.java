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

import mr.bpm.mbanking.dao.RetCheckBookReqDao;
import mr.bpm.mbanking.dot.PApiRetchqbookReqIn;
import mr.bpm.mbanking.dot.PApiRetchqbookReqOut;
import mr.bpm.mbanking.helper.RetCheckBookReqHelper;

@Repository
public class RetCheckBookReqDaoImpl implements RetCheckBookReqDao{

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public PApiRetchqbookReqOut getRetCheckBookReq(PApiRetchqbookReqIn inRetchqbookReq) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("P_API_RET_CHQBOOK_REQ_EXT_NEW");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("AL_CHANNEL_ID", inRetchqbookReq.alChannelId)
				.addValue("AS_USER_ID", inRetchqbookReq.asUserId)
				.addValue("AS_MACHINE_NAME", inRetchqbookReq.asMachineName)
				.addValue("AL_API_CODE", inRetchqbookReq.alAPiCode)
				.addValue("AL_COMPANY", inRetchqbookReq.alCompany)
				.addValue("AL_BRANCH", inRetchqbookReq.alBranch)
				.addValue("AL_ACC_BR", inRetchqbookReq.alAccBr)
				.addValue("AL_ACC_CY", inRetchqbookReq.alAccCy)
				.addValue("AL_ACC_GL", inRetchqbookReq.alAccGl)
				.addValue("AL_ACC_CIF", inRetchqbookReq.alAccCif)
				.addValue("AL_ACC_SL", inRetchqbookReq.alAccSl)
				.addValue("AS_ACCOUNT", inRetchqbookReq.asAccount)
				.addValue("AS_CHQTYPE", inRetchqbookReq.asChqtype)
				.addValue("AS_USER_TYPE", inRetchqbookReq.asUserType)
				.addValue("AL_DELIVERY_MODE", inRetchqbookReq.alDeliveryMode)
				.addValue("AL_DESTINATION_BRANCH", inRetchqbookReq.alDestinationBranch)
				.addValue("AS_DELIVERY_LOCATION", inRetchqbookReq.asDeliveryLocation)
				.addValue("AS_CARD", inRetchqbookReq.asCard)
				.addValue("AL_CARD_PRESENT", inRetchqbookReq.alCardPresent)
				;

		Map<String, Object> out = jdbcCall.execute(in);

		return RetCheckBookReqHelper.toRetCheckBookReqOut(out);
	}

}
