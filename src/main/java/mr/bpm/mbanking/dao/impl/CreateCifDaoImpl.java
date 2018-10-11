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
				.addValue("AL_CHANNEL_ID", inCreateCif.alChannelId)
				.addValue("AS_USER_ID", inCreateCif.asUserId)
				.addValue("AS_MACHINE_NAME", inCreateCif.asMachineName)
				.addValue("AL_API_CODE", inCreateCif.alApiCode)
				.addValue("AL_COMP_CODE", inCreateCif.alCompCode)
				.addValue("AL_BRANCH_CODE", inCreateCif.alBranchCode)
				.addValue("AL_CIF_TYPE", inCreateCif.alCifType)
				.addValue("AL_ID_TYPE", inCreateCif.alIdType)
				.addValue("ADT_ESTAB_DATE", inCreateCif.adtEstabDate)
				.addValue("AS_SHORT_NAME_ENG", inCreateCif.asShortNameEng)
				.addValue("AS_SHORT_NAME_ARAB", inCreateCif.asShortNameArab)
				.addValue("AS_LONG_NAME_ENG", inCreateCif.asLongNameEng)
				.addValue("AS_LONG_NAME_ARAB", inCreateCif.asLongNameArab)
				.addValue("AS_ID_NO", inCreateCif.asIdNo)
				.addValue("AS_LANGUAGE", inCreateCif.asLanguage)
				.addValue("AL_NATION_CODE", inCreateCif.alNationCode)
				.addValue("AL_COUNTRY_CODE", inCreateCif.alCountryCode)
				.addValue("AL_PRIORITY_CODE", inCreateCif.alPriorityCode)
				.addValue("AS_RESIDENT", inCreateCif.asResident)
				.addValue("AL_CIVIL_CODE", inCreateCif.alCivilCode)
				.addValue("AS_CREATED_BY", inCreateCif.asCreatedBy)
				.addValue("AL_DEPT", inCreateCif.alDept)
				.addValue("AL_DIVISION", inCreateCif.alDivision)
				.addValue("AL_ECO_SECTOR", inCreateCif.alEcoSector)
				.addValue("AS_FIRST_NAME_ENG", inCreateCif.asFirstNameEng)
				.addValue("AS_LAST_NAME_ENG", inCreateCif.asLastNameEng)
				.addValue("AS_TEL", inCreateCif.asTel)
				.addValue("AS_FIRST_NAME_ARAB", inCreateCif.asFirstNameArab)
				.addValue("AS_SEC_NAME_ARAB", inCreateCif.asSecNameArab)
				.addValue("AS_LAST_NAME_ARAB", inCreateCif.asLastNameArab)
				.addValue("AS_ADDRESS1_ENG", inCreateCif.asAddress1Eng)
				.addValue("AS_ADDRESS2_ENG", inCreateCif.asAddress2Eng)
				.addValue("AS_ADDRESS3_ENG", inCreateCif.asAddress3Eng)
				.addValue("AS_AUTH_ID", inCreateCif.asAuthId)
				.addValue("AS_AUTH_NAME", inCreateCif.asAuthName)
				.addValue("AS_SEC_NAME_ENG", inCreateCif.asSecNameEng)
				.addValue("AS_REL_OFFICER", inCreateCif.asRelOfficer)
				.addValue("ADT_DATE_CREATED", inCreateCif.adtDateCreated)
				.addValue("ADT_DATE_MODIFIED", inCreateCif.adtDateModified)
				.addValue("AS_STATUS", inCreateCif.asStatus)
				.addValue("AS_TYPE", inCreateCif.asType)
				.addValue("AS_KYC_COMPLETED", inCreateCif.asKycCompleted)
				.addValue("AS_MARITAL_STATUS", inCreateCif.asMaritalStatus)
				.addValue("AS_PC_IND", inCreateCif.asPcInd)
				.addValue("AS_POPULATED", inCreateCif.asPopulated)
				.addValue("AS_SHOW_SECRET_NO", inCreateCif.asShowSecretNo)
				.addValue("AL_REL_OFF_ID", inCreateCif.alRelOffId)
				.addValue("AL_MONTHLY_SALARY", inCreateCif.alMonthlySalary)
				.addValue("AL_SUB_ECO_SECTOR", inCreateCif.alSubEcoSector)
				.addValue("AS_SEXE", inCreateCif.asSexe)
				.addValue("AS_ADD_REF", inCreateCif.asAddRef)
				.addValue("AS_BILL_FLAG", inCreateCif.asBillFlag)
				.addValue("AS_IND", inCreateCif.asInd)
				.addValue("AL_TRX_TYPE", inCreateCif.alTrxType)
				.addValue("AL_CY", inCreateCif.alCy)
				.addValue("AL_ACC_BR", inCreateCif.alAccBr)
				.addValue("AL_ACC_CY", inCreateCif.alAccCy)
				.addValue("AL_ACC_GL", inCreateCif.alAccGl)
				.addValue("AL_ACC_CIF", inCreateCif.alAccCif)
				.addValue("AL_ACC_SL", inCreateCif.alAccSl)
				.addValue("ADT_ADD_Date1", inCreateCif.adtAddDate1)
				.addValue("ADT_ADD_Date2", inCreateCif.adtAddDate2)
				.addValue("ADT_ADD_Date3", inCreateCif.adtAddDate3)
				.addValue("ADT_ADD_Date4", inCreateCif.adtAddDate4)
				.addValue("ADT_ADD_Date5", inCreateCif.adtAddDate5)
				.addValue("AL_ADD_Number1", inCreateCif.alAddNumber1)
				.addValue("AL_ADD_Number2", inCreateCif.alAddNumber2)
				.addValue("AL_ADD_Number3", inCreateCif.alAddNumber3)
				.addValue("AL_ADD_Number4", inCreateCif.alAddNumber4)
				.addValue("AL_ADD_Number5", inCreateCif.alAddNumber5)
				.addValue("AS_ADD_String1", inCreateCif.asAddString)
				.addValue("AS_ADD_String2", inCreateCif.asAddString2)
				.addValue("AS_ADD_String3", inCreateCif.asAddString3)
				.addValue("AS_ADD_String4", inCreateCif.asAddString4)
				.addValue("AS_ADD_String5", inCreateCif.asAddString5)
				.addValue("AS_ADD_String6", inCreateCif.asAddString6)
				.addValue("AS_ADD_String7", inCreateCif.asAddString7)
				.addValue("AS_ADD_String8", inCreateCif.asAddString8)
				.addValue("AS_ADD_String9", inCreateCif.asAddString9)
				.addValue("AS_ADD_String10", inCreateCif.asAddString10)
				.addValue("AS_ADD_String11", inCreateCif.asAddString11)
				.addValue("AS_ADD_String12", inCreateCif.asAddString12)
				.addValue("AS_ADD_String13", inCreateCif.asAddString13)
				.addValue("AS_ADD_String14", inCreateCif.asAddString14)
				.addValue("AS_ADD_String15", inCreateCif.asAddString15
						);
	
		Map<String, Object> out = jdbcCall.execute(in);

		return CreateCifHelper.toCreateCifOut(out);
	}

}
