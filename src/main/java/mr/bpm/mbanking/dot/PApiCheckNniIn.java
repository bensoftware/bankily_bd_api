package mr.bpm.mbanking.dot;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class PApiCheckNniIn {
	public BigDecimal alChannelId;
	public String asUseerId;
	public String asMachineName;
	public BigDecimal alApiCode;
	public BigDecimal alCompCode;
	public BigDecimal alIndicator;
	public String alCifNni;
	public String asAddReference;
	@XmlElement (required = false, nillable = true)
	public String adtDateCreated;
	public String asAccType;
	public String asGmiFlag;
}
