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

import mr.bpm.mbanking.dao.GetBalanceAmfDao;
import mr.bpm.mbanking.helper.GetBalanceAmfHelper;
import mr.bpm.mbanking.dot.PApiGetBalanceAmfIn;
import mr.bpm.mbanking.dot.PApiGetBalanceAmfOut;

@Repository
public class GetBalanceAmfImpl implements GetBalanceAmfDao{

	@Autowired
	  private DataSource dataSource;
	  private JdbcTemplate jdbcTemplate;

	  @PostConstruct
	  private void postConstruct() {
	      jdbcTemplate = new JdbcTemplate(dataSource);
	  }

	@Override
	public PApiGetBalanceAmfOut getBalanceAmf(PApiGetBalanceAmfIn inGetBalanceAmf) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("P_API_GET_BALANCE_AMF");
     SqlParameterSource in = new MapSqlParameterSource()
				.addValue("AL_COMP_CODE", inGetBalanceAmf.alCompCode)
				.addValue("AL_BRANCH_CODE", inGetBalanceAmf.alBranchCode)
				.addValue("AL_CURRENCY_CODE", inGetBalanceAmf.alCurrencyCode)
				.addValue("AL_GLCODE", inGetBalanceAmf.alGlcode)
				.addValue("AL_CIF_SUB_NO",inGetBalanceAmf.alCifSubNo)
				.addValue("AL_SL_NO", inGetBalanceAmf.alSlNo)
				.addValue("AL_ADDITIONAL_REF", inGetBalanceAmf.alAdditionalRef)
				.addValue("AS_ACTIVE_WITHD", inGetBalanceAmf.asActiveWithd);
		
		Map<String, Object> out = jdbcCall.execute(in);
		
		
       return GetBalanceAmfHelper.toGetBalanceAmf(out);
	}

}
