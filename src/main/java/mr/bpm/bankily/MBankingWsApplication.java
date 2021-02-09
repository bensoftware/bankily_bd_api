package mr.bpm.bankily;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import mr.bpm.bankily.dao.MonetiqueServiceDao;
import mr.bpm.bankily.service.ClientInfoService;
import mr.bpm.bankily.service.MajBankilyService;


@SpringBootApplication
public class MBankingWsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MBankingWsApplication.class, args);
/*		Logger logger = LoggerFactory.getLogger(MBankingWsApplication.class);
		logger.trace("calling the "+FullStatementWS.class.getSimpleName()+"API");
		logger.debug("calling the "+FullStatementWS.class.getSimpleName()+"API");
		logger.info("calling the "+FullStatementWS.class.getSimpleName()+"API");
		logger.warn("calling the "+FullStatementWS.class.getSimpleName()+"API");
		logger.error("calling the "+FullStatementWS.class.getSimpleName()+"API");*/
	}
	
	@Bean	
	public RestTemplate getRest() {
		    SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

	        factory.setConnectTimeout(60000);
	        factory.setReadTimeout(60000);

	        return new RestTemplate(factory);	}
	
	
	@Autowired
	MonetiqueServiceDao monetiqueServiceDao;
	
	@Autowired
	MajBankilyService majBankilyService;
	
	@Autowired
	ClientInfoService clientInfoService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//clientInfoService.getInfoClientByNni("4440552234");
//	BankilyResponse res= majBankilyService.verifierBlocage("20510245");
//	System.err.println(res);
		
	//	Client res= monetiqueServiceDao.getOtpByTelephone("34212133");
		
	//	System.out.println(res);
		
	//	BankilyResponse ff=	monetiqueServiceDao.getPartyIdByTelephone("34212133");
	   	
	//   	System.out.println(ff);

	//BankilyResponse res=	majBankilyService.verifierPinTemp("47452304");
	//System.out.println(res);
	
	//int r= monetiqueServiceDao.getEtatUserByUserId("UA200423.1342.04805");
	
	//System.out.println(r);
	//	TrsMobileBus res= monetiqueServiceDao.getTransRechargeByIdTrans("0120040311243324332");
	//	System.out.println(res);
	//	monetiqueServiceDao.getInfoPaiementSnde("0120032017292962536");
		
	//	Client c=monetiqueServiceDao.getPartyIdByTelephone("34212133");
	//	System.out.println(c.getPartyId());

/*		
		Date date=new Date(2019-1990, 11-1, 20);
		
		
		System.out.println(date);*/
		
	//	monetiqueServiceDao.getAllClientPartialKyc(date);
	//	monetiqueServiceDao.isFullKyc("1842979922");
	//	monetiqueServiceDao.getTelephone("9265197307", "42505252");
	//	monetiqueServiceDao.getAllRecharge(11173, "3");
		
		//ListFacture lf= GetFactureSnde(11898, "00018000082100000220109");
		
		//System.out.println(lf.getIndex());
		//monetiqueServiceDao.getClByPan("5303471005144452");
		
		//monetiqueServiceDao.getAuthByPan("5303471005144452");
		
		//monetiqueServiceDao.getHistByPan("5303471005144452");
		
	// SoldeCarte m=	monetiqueServiceDao.getSoldeCarte(Double.parseDouble("5303471005144536"));
	 
	 //System.out.println(m);
		
		//monetiqueServiceDao.traitement1();
		
/*		String fdu="15012019";
		String fau="15012019";		
			    DateFormat df=new SimpleDateFormat("ddMMyyyy");

			 Date du=df.parse(fdu);
			 Date au =df.parse(fau);	
			 
		List<MonetiqueClass> list=monetiqueServiceDao.getDailyValidSSByDateIntervall(du, au);
		
		System.out.println("size "+list.size());
	 */
	}
	

}

