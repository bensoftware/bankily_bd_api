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

import mr.bpm.mbanking.dao.FullStatementDao;
import mr.bpm.mbanking.dot.FullStatementIn;
import mr.bpm.mbanking.dot.FullStatementOut;
import mr.bpm.mbanking.helper.FullStatementHelper;

@Repository
public class FullStatementDaoImpl implements FullStatementDao{
	@Autowired
	  private DataSource dataSource;
	  private JdbcTemplate jdbcTemplate;

	  @PostConstruct
	  private void postConstruct() {
	      jdbcTemplate = new JdbcTemplate(dataSource);
	  }

	@Override
	public FullStatementOut getFullStatement(FullStatementIn fullStatementIn) {
	
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("P_API_FULL_STATEMENT2");
        SqlParameterSource in = new MapSqlParameterSource()
				.addValue("AL_CHANNEL_ID", fullStatementIn.alChannelId)
				.addValue("AS_USER_ID", fullStatementIn.asUserId)
				.addValue("AS_MACHINE_NAME", fullStatementIn.asMachineName)
				.addValue("AL_API_CODE", fullStatementIn.alApiCode)
				.addValue("AL_COMPANY",fullStatementIn.alCompany)
				.addValue("AS_ACCOUNT", fullStatementIn.asAccount)
				.addValue("AD_FROM_DATE", fullStatementIn.adFromDate)
				.addValue("AD_TO_DATE", fullStatementIn.adToDate)
				.addValue("AS_VT_FLAG", fullStatementIn.asVtFlag)
				.addValue("AS_CARD", fullStatementIn.asCard)
				.addValue("AL_CARD_PRESENT",fullStatementIn.alCardPresent)
				.addValue("AL_LAST_N", fullStatementIn.alLastIn)
				.addValue("AL_DBLINK", fullStatementIn.aldbLink)
				.addValue("AS_USERID", fullStatementIn.asUserid)
				.addValue("AL_REV_FLAG",fullStatementIn.alRevFlag)
				
				;
		
		Map<String, Object> out = jdbcCall.execute(in);
		
       return FullStatementHelper.toFullStatementOut(out);
	}
	
	
}
