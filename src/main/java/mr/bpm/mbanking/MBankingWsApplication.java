package mr.bpm.mbanking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mr.bpm.mbanking.dao.MonetiqueServiceDao;
import mr.bpm.mbanking.dot.MonetiqueClass;
import mr.bpm.mbanking.dot.SoldeCarte;

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
	
	@Autowired
	MonetiqueServiceDao monetiqueServiceDao;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
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

