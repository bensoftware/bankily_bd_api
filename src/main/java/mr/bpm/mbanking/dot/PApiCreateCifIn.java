package mr.bpm.mbanking.dot;

import java.math.BigDecimal;

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
	
	public String  adtEstabDate;
	
	public String asShortNameEng;
	public String asShortNameArab;
	public String asLongNameEng;
	public String asLongNameArab;
	public String asIdNo;
	public String asLanguage;
	public BigDecimal alNationCode;
	public BigDecimal alCountryCode;
	public BigDecimal alPriorityCode;
	public String asResident;
	public BigDecimal alCivilCode;
	public String asCreatedBy;
	public BigDecimal alDept;
	public BigDecimal alDivision;
	public BigDecimal alEcoSector; 
	public String asFirstNameEng;
	public String asLastNameEng;
	public String asTel;
	public String asFirstNameArab;
	public String asSecNameArab;
	public String asLastNameArab;  
	public String asAddress1Eng;
	public String asAddress2Eng;
	public String asAddress3Eng;
	public String asAuthId;
	public String asAuthName;
	public String asSecNameEng;
	public String asRelOfficer;
	public String adtDateCreated;
	public String adtDateModified;
	public String asStatus;
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
	public String asInd;
	public BigDecimal alTrxType;
	public BigDecimal alCy;
	public BigDecimal alAccBr;
	public BigDecimal alAccCy;
	public BigDecimal alAccGl;
	public BigDecimal alAccCif;
	public BigDecimal alAccSl;
	public String adtAddDate1;
	public String adtAddDate2;
	public String adtAddDate3;
	public String adtAddDate4;
	public String adtAddDate5;
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
