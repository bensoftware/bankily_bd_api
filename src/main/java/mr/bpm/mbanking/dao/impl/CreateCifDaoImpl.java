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

import mr.bpm.mbanking.dao.CreateCifDao;
import mr.bpm.mbanking.dot.PApiCreateCifIn;
import mr.bpm.mbanking.dot.PApiCreateCifOut;
import mr.bpm.mbanking.helper.CreateAccountHelper;
import mr.bpm.mbanking.helper.CreateCifHelper;

@Repository
public class CreateCifDaoImpl implements CreateCifDao{

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public PApiCreateCifOut getCif(PApiCreateCifIn inCreateCif) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("P_API_CREATE_CIF");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("AL_CHANNEL_ID", inCreateCif.AL_CHANNEL_ID)
				.addValue("AS_USER_ID", inCreateCif.AS_USER_ID)
				.addValue("AS_MACHINE_NAME", inCreateCif.AS_MACHINE_NAME)
				.addValue("AL_API_CODE", inCreateCif.AL_API_CODE)
				.addValue("AL_COMP_CODE", inCreateCif.AL_COMP_CODE)
				.addValue("AL_BRANCH_CODE", inCreateCif.AL_BRANCH_CODE)
				.addValue("AL_CIF_TYPE", inCreateCif.AL_CIF_TYPE)
				.addValue("AL_ID_TYPE", inCreateCif.AL_ID_TYPE)
				.addValue("ADT_ESTAB_DATE", inCreateCif.ADT_ESTAB_DATE)
				.addValue("AS_SHORT_NAME_ENG", inCreateCif.AS_SHORT_NAME_ENG)
				.addValue("AS_SHORT_NAME_ARAB", inCreateCif.AS_SHORT_NAME_ARAB)
				.addValue("AS_LONG_NAME_ENG", inCreateCif.AS_LONG_NAME_ENG)
				.addValue("AS_LONG_NAME_ARAB", inCreateCif.AS_LONG_NAME_ARAB)
				.addValue("AS_ID_NO", inCreateCif.AS_ID_NO)
				.addValue("AS_LANGUAGE", inCreateCif.AS_LANGUAGE)
				.addValue("AL_NATION_CODE", inCreateCif.AL_NATION_CODE)
				.addValue("AL_COUNTRY_CODE", inCreateCif.AL_COUNTRY_CODE)
				.addValue("AL_PRIORITY_CODE", inCreateCif.AL_PRIORITY_CODE)
				.addValue("AS_RESIDENT", inCreateCif.AS_RESIDENT)
				.addValue("AL_CIVIL_CODE", inCreateCif.AL_CIVIL_CODE)
				.addValue("AS_CREATED_BY", inCreateCif.AS_CREATED_BY)
				.addValue("AL_DEPT", inCreateCif.AL_DEPT)
				.addValue("AL_DIVISION", inCreateCif.AL_DIVISION)
				.addValue("AL_ECO_SECTOR", inCreateCif.AL_ECO_SECTOR)
				.addValue("AS_FIRST_NAME_ENG", inCreateCif.AS_FIRST_NAME_ENG)
				.addValue("AS_LAST_NAME_ENG", inCreateCif.AS_LAST_NAME_ENG)
				.addValue("AS_TEL", inCreateCif.AS_TEL)
				.addValue("AS_FIRST_NAME_ARAB", inCreateCif.AS_FIRST_NAME_ARAB)
				.addValue("AS_SEC_NAME_ARAB", inCreateCif.AS_SEC_NAME_ARAB)
				.addValue("AS_LAST_NAME_ARAB", inCreateCif.AS_LAST_NAME_ARAB)
				.addValue("AS_ADDRESS1_ENG", inCreateCif.AS_ADDRESS1_ENG)
				.addValue("AS_ADDRESS2_ENG", inCreateCif.AS_ADDRESS2_ENG)
				.addValue("AS_ADDRESS3_ENG", inCreateCif.AS_ADDRESS3_ENG)
				.addValue("AS_AUTH_ID", inCreateCif.AS_AUTH_ID)
				.addValue("AS_AUTH_NAME", inCreateCif.AS_AUTH_NAME)
				.addValue("AS_SEC_NAME_ENG", inCreateCif.AS_SEC_NAME_ENG)
				.addValue("AS_REL_OFFICER", inCreateCif.AS_REL_OFFICER)
				.addValue("ADT_DATE_CREATED", inCreateCif.ADT_DATE_CREATED)
				.addValue("ADT_DATE_MODIFIED", inCreateCif.ADT_DATE_MODIFIED)
				.addValue("AS_STATUS", inCreateCif.AS_STATUS)
				.addValue("AS_TYPE", inCreateCif.AS_TYPE)
				.addValue("AS_KYC_COMPLETED", inCreateCif.AS_KYC_COMPLETED)
				.addValue("AS_MARITAL_STATUS", inCreateCif.AS_MARITAL_STATUS)
				.addValue("AS_PC_IND", inCreateCif.AS_PC_IND)
				.addValue("AS_POPULATED", inCreateCif.AS_POPULATED)
				.addValue("AS_SHOW_SECRET_NO", inCreateCif.AS_SHOW_SECRET_NO)
				.addValue("AL_REL_OFF_ID", inCreateCif.AL_REL_OFF_ID)
				.addValue("AL_MONTHLY_SALARY", inCreateCif.AL_MONTHLY_SALARY)
				.addValue("AL_SUB_ECO_SECTOR", inCreateCif.AL_SUB_ECO_SECTOR)
				.addValue("AS_SEXE", inCreateCif.AS_SEXE)
				.addValue("AS_ADD_REF", inCreateCif.AS_ADD_REF)
				.addValue("AS_BILL_FLAG", inCreateCif.AS_BILL_FLAG)
				.addValue("AS_IND", inCreateCif.AS_IND)
				.addValue("AL_TRX_TYPE", inCreateCif.AL_TRX_TYPE)
				.addValue("AL_CY", inCreateCif.AL_CY)
				.addValue("AL_ACC_BR", inCreateCif.AL_ACC_BR)
				.addValue("AL_ACC_CY", inCreateCif.AL_ACC_CY)
				.addValue("AL_ACC_GL", inCreateCif.AL_ACC_GL)
				.addValue("AL_ACC_CIF", inCreateCif.AL_ACC_CIF)
				.addValue("AL_ACC_SL", inCreateCif.AL_ACC_SL)
				.addValue("ADT_ADD_DATE1", inCreateCif.ADT_ADD_DATE1)
				.addValue("ADT_ADD_DATE2", inCreateCif.ADT_ADD_DATE2)
				.addValue("ADT_ADD_DATE3", inCreateCif.ADT_ADD_DATE3)
				.addValue("ADT_ADD_DATE4", inCreateCif.ADT_ADD_DATE4)
				.addValue("ADT_ADD_DATE5", inCreateCif.ADT_ADD_DATE5)
				.addValue("AL_ADD_NUMBER1", inCreateCif.AL_ADD_NUMBER1)
				.addValue("AL_ADD_NUMBER2", inCreateCif.AL_ADD_NUMBER2)
				.addValue("AL_ADD_NUMBER3", inCreateCif.AL_ADD_NUMBER3)
				.addValue("AL_ADD_NUMBER4", inCreateCif.AL_ADD_NUMBER4)
				.addValue("AL_ADD_NUMBER5", inCreateCif.AL_ADD_NUMBER5)
				.addValue("AS_ADD_STRING", inCreateCif.AS_ADD_STRING)
				.addValue("AS_ADD_STRING2", inCreateCif.AS_ADD_STRING2)
				.addValue("AS_ADD_STRING3", inCreateCif.AS_ADD_STRING3)
				.addValue("AS_ADD_STRING4", inCreateCif.AS_ADD_STRING4)
				.addValue("AS_ADD_STRING5", inCreateCif.AS_ADD_STRING5)
				.addValue("AS_ADD_STRING6", inCreateCif.AS_ADD_STRING6)
				.addValue("AS_ADD_STRING7", inCreateCif.AS_ADD_STRING7)
				.addValue("AS_ADD_STRING8", inCreateCif.AS_ADD_STRING8)
				.addValue("AS_ADD_STRING9", inCreateCif.AS_ADD_STRING9)
				.addValue("AS_ADD_STRING10", inCreateCif.AS_ADD_STRING10)
				.addValue("AS_ADD_STRING11", inCreateCif.AS_ADD_STRING11)
				.addValue("AS_ADD_STRING12", inCreateCif.AS_ADD_STRING12)
				.addValue("AS_ADD_STRING13", inCreateCif.AS_ADD_STRING13)
				.addValue("AS_ADD_STRING14", inCreateCif.AS_ADD_STRING14)
				.addValue("AS_ADD_STRING15", inCreateCif.AS_ADD_STRING15
						);
	
		Map<String, Object> out = jdbcCall.execute(in);

		return CreateCifHelper.toCreateCifOut(out);
	}

}
