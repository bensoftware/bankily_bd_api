package mr.bpm.mbanking.dot;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class PApiCreateCifIn {
	
	@XmlElement (required = true)
	public BigDecimal alChannelId;
	
	@XmlElement (required = true)
	public	String asUserId;
	
	@XmlElement (required = true)
	public String asMachineName;
	
	@XmlElement (required = true)
	public BigDecimal alApiCode;
	
	@XmlElement (required = true)
	public BigDecimal alCompCode;
	
	@XmlElement (required = true)
	public BigDecimal alBranchCode;
	
	@XmlElement (required = true)
	public BigDecimal alCifType;
	
	@XmlElement (required = true)
	public BigDecimal alIdType;
	
	public Date  adtEstabDate;
	
	public String asShortNameEng;
	public String asShortNameArab;
	
	@XmlElement (required = true)
	public String asLongNameEng;
	
	@XmlElement (required = true)
	public String asLongNameArab;
	
	@XmlElement (required = true)
	public String asIdNo;
	
	public String asLanguage;
	
	@XmlElement (required = true)
	public BigDecimal alNationCode;
	
	@XmlElement (required = true)
	public BigDecimal alCountryCode;
	
	@XmlElement (required = true)
	public BigDecimal alPriorityCode;
	
	public String asResident;
	
	@XmlElement (required = true)
	public BigDecimal alCivilCode;
	
	public String asCreatedBy;
	
	@XmlElement (required = true)
	public BigDecimal alDept;
	
	@XmlElement (required = true)
	public BigDecimal alDivision;
	
	@XmlElement (required = true)
	public BigDecimal alEcoSector; 
	
	public String asFirstNameEng;
	public String asLastNameEng;
	
	@XmlElement (required = true)
	public String asTel;
	
	public String asFirstNameArab;
	public String asSecNameArab;
	public String asLastNameArab;  
	
	@XmlElement (required = true)
	public String asAddress1Eng;
	public String asAddress2Eng;
	public String asAddress3Eng;
	public String asAuthId;
	public String asAuthName;
	public String asSecNameEng;
	public String asRelOfficer;

	public Date adtDateCreated;
	public Date adtDateModified;
	@XmlElement (required = true)
	public String asStatus;
	
	@XmlElement (required = true)
	public String asType;
	
	public String asKycCompleted;
	public String asMaritalStatus;
	public String asPcInd;
	public String asPopulated;
	public String asShowSecretNo;
	public BigDecimal alRelOffId;
	public BigDecimal alMonthlySalary;
	public BigDecimal alSubEcoSector;
	public String asSexe;
	public String asAddRef;
	public String asBillFlag;
	
	@XmlElement (required = true)
	public String asInd;
	
	public BigDecimal alTrxType;
	public BigDecimal alCy;
	public BigDecimal alAccBr;
	public BigDecimal alAccCy;
	public BigDecimal alAccGl;
	public BigDecimal alAccCif;
	public BigDecimal alAccSl;
	public Date adtAddDate1;
	public Date adtAddDate2;
	public Date adtAddDate3;
	public Date adtAddDate4;
	public Date adtAddDate5;
	public BigDecimal alAddNumber1;
	public BigDecimal alAddNumber2;
	public BigDecimal alAddNumber3;
	public BigDecimal alAddNumber4;
	public BigDecimal alAddNumber5;
	public String asAddString;
	public String asAddString2;
	public String asAddString3;
	public String asAddString4;
	public String asAddString5;
	public String asAddString6;
	public String asAddString7;
	public String asAddString8;
	public String asAddString9;
	public String asAddString10;
	public String asAddString11;
	public String asAddString12;
	public String asAddString13;
	public String asAddString14;
	public String asAddString15;
}
