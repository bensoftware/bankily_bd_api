package mr.bpm.mbanking.dao.impl;

import static org.mockito.Mockito.after;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import mr.bpm.mbanking.dao.CheckNniDao;
import mr.bpm.mbanking.dot.PApiCheckNniIn;
import mr.bpm.mbanking.dot.PApiCheckNniOut;
import mr.bpm.mbanking.helper.CheckNniHelper;
import mr.bpm.mbanking.helper.FullStatementHelper;

@Repository
public class CheckNniDaoImpl implements CheckNniDao {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public PApiCheckNniOut getCheckNni(PApiCheckNniIn inCheckNni) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("P_API_CHECK_NNI");
        SqlParameterSource in = new MapSqlParameterSource()
				.addValue("AL_CHANNEL_ID", inCheckNni.alChannelId)
				.addValue("AS_USER_ID", inCheckNni.asUseerId)
				.addValue("AS_MACHINE_NAME", inCheckNni.asMachineName)
				.addValue("AL_API_CODE", inCheckNni.alApiCode)
				.addValue("AL_COMP_CODE", inCheckNni.alCompCode)
				.addValue("AL_INDICATOR", inCheckNni.alIndicator)
				.addValue("AL_CIF_NNI", inCheckNni.alCifNni)
				.addValue("AS_ADD_REFERENCE", inCheckNni.asAddReference)
				.addValue("ADT_DATE_CREATED", inCheckNni.adtDateCreated)
				.addValue("AS_ACC_TYPE", inCheckNni.asAccType)
				.addValue("AS_GMI_FLAG", inCheckNni.asGmiFlag)
				;
		
		Map<String, Object> out = jdbcCall.execute(in);
		
       return CheckNniHelper.toCheckNniOut(out);
	}

}
