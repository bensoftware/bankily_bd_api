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
				.addValue("AL_CHANNEL_ID", fullStatementIn.al_channel_id)
				.addValue("AS_USER_ID", fullStatementIn.as_user_id)
				.addValue("AS_MACHINE_NAME", fullStatementIn.as_machine_name)
				.addValue("AL_API_CODE", fullStatementIn.al_api_code)
				.addValue("AL_COMPANY",fullStatementIn.al_company)
				.addValue("AS_ACCOUNT", fullStatementIn.as_account)
				.addValue("AD_FROM_DATE", fullStatementIn.ad_from_date)
				.addValue("AD_TO_DATE", fullStatementIn.ad_to_date)
				.addValue("AS_VT_FLAG", fullStatementIn.as_vt_flag)
				.addValue("AS_CARD", fullStatementIn.as_card)
				.addValue("AL_CARD_PRESENT",fullStatementIn.al_card_present)
				.addValue("AL_LAST_N", fullStatementIn.al_last_n)
				.addValue("AL_DBLINK", fullStatementIn.Al_dblink)
				.addValue("AS_USERID", fullStatementIn.as_userid)
				.addValue("AL_REV_FLAG",fullStatementIn.Al_rev_flag)
				
				;
		
		Map<String, Object> out = jdbcCall.execute(in);
		
       return FullStatementHelper.toFullStatementOut(out);
	}
	
	
}
