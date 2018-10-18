package mr.bpm.mbanking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.annotation.ApplicationScope;

import mr.bpm.mbanking.ws.FullStatementWS;

@SpringBootApplication
public class MBankingWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MBankingWsApplication.class, args);
		Logger logger = LoggerFactory.getLogger(MBankingWsApplication.class);
		logger.trace("calling the "+FullStatementWS.class.getSimpleName()+"API");
		logger.debug("calling the "+FullStatementWS.class.getSimpleName()+"API");
		logger.info("calling the "+FullStatementWS.class.getSimpleName()+"API");
		logger.warn("calling the "+FullStatementWS.class.getSimpleName()+"API");
		logger.error("calling the "+FullStatementWS.class.getSimpleName()+"API");
	}
	
}

