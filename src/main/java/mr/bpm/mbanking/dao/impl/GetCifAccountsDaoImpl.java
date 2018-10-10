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

import mr.bpm.mbanking.dao.GetCifAccountsDao;
import mr.bpm.mbanking.dot.PApiGetCifAccountsIn;
import mr.bpm.mbanking.dot.PApiGetCifAccountsOut;
import mr.bpm.mbanking.helper.FullStatementHelper;
import mr.bpm.mbanking.helper.GetCifAccountsHelper;

@Repository
public class GetCifAccountsDaoImpl implements GetCifAccountsDao{

	@Autowired
	  private DataSource dataSource;
	  private JdbcTemplate jdbcTemplate;

	  @PostConstruct
	  private void postConstruct() {
	      jdbcTemplate = new JdbcTemplate(dataSource);
	  }

	@Override
	public PApiGetCifAccountsOut getCifAccounts(PApiGetCifAccountsIn inGetCifAccounts) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("P_API_GET_CIF_ACCOUNTS1");
        SqlParameterSource in = new MapSqlParameterSource()
				.addValue("AL_CHANNEL_ID", inGetCifAccounts.alChannelId)
				.addValue("AS_USER_ID", inGetCifAccounts.asUserId)
				.addValue("AS_MACHINE_NAME", inGetCifAccounts.asMachineName)
				.addValue("AL_API_CODE", inGetCifAccounts.alApiCode)
				.addValue("AL_COMP_CODE",inGetCifAccounts.alCompCode)
				.addValue("AL_INDICATOR", inGetCifAccounts.alIndicator)
				.addValue("AL_CIF_NO", inGetCifAccounts.alCifNo)
				.addValue("AS_ADD_REFERENCE", inGetCifAccounts.asAddReference)
				.addValue("ADT_DATE_CREATED", inGetCifAccounts.adtDateCreated)
				.addValue("AS_ACC_TYPE", inGetCifAccounts.asAccType)
				.addValue("AS_GMI_FLAG",inGetCifAccounts.asGmiFlag)
				
				;
		
		Map<String, Object> out = jdbcCall.execute(in);
		
       return GetCifAccountsHelper.toGetCifAccountsOut(out);
	}

}
