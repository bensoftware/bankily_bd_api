package mr.bpm.mbanking;

import javax.xml.ws.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mr.bpm.mbanking.ws.FullStatementWS;
import mr.bpm.mbanking.ws.PApiCheckNniWS;
import mr.bpm.mbanking.ws.PApiCreateAccountWS;
import mr.bpm.mbanking.ws.PApiCreateCifWS;
import mr.bpm.mbanking.ws.PApiGetCifAccountsWS;
import mr.bpm.mbanking.ws.PApiRetchqbookReqWS;
import mr.bpm.mbanking.ws.PApiTransferEx3WS;

@Configuration
public class ConfigSOAP {

/*	@Bean
	public SimpleJaxWsServiceExporter getServer() {
		
		SimpleJaxWsServiceExporter exporter=new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://192.168.0.50:8888/ws/mbanking");
	  
		return exporter;
	}*/	
	@Value("${soap.server.url}")
	public String url;
	
	@Value("${soap.server.port}")
	public String port;	
	
	@Autowired
	FullStatementWS fullStatementWS;
	
	@Autowired
	PApiCheckNniWS apiCheckNniWS;
	
	@Autowired
	PApiCreateAccountWS apiCreateAccountWS;
	
/*	@Autowired
	PApiCreateCifWS apiCreateCifWS;
	
	@Autowired
	PApiGetCifAccountsWS apiGetCifAccountsWS;
	
	@Autowired
	PApiRetchqbookReqWS apiRetchqbookReqWS;
	
	@Autowired
	PApiTransferEx3WS apiTransferEx3WS;
	*/
	
	@Bean
	public Endpoint getServerFullstatement() {
		
	 Endpoint endpoint=	Endpoint.publish("http://"+url+":"+port+"/ws/mbanking/fullstatement",fullStatementWS);
	 return endpoint;
	
	}
	
	@Bean
	public Endpoint getServerPapichecknni() {
		
	 Endpoint endpoint=	Endpoint.publish("http://"+url+":"+port+"/ws/mbanking/papichecknni", apiCheckNniWS);
	 return endpoint;
	
	}
	
	@Bean
	public Endpoint getServerPapicreateaccount() {
		
	 Endpoint endpoint=	Endpoint.publish("http://"+url+":"+port+"/ws/mbanking/papicreateaccount", apiCreateAccountWS);
	 return endpoint;
	
	}
	
/*	@Bean
	public Endpoint getServerPapicreatecif() {
		
	 Endpoint endpoint=	Endpoint.publish("http://"+url+":"+port+"/ws/mbanking/papicreatecif", apiCreateCifWS);
	 return endpoint;
	
	}
	
	@Bean
	public Endpoint getServerPapigetcifaccounts() {
		
	 Endpoint endpoint=	Endpoint.publish("http://"+url+":"+port+"/ws/mbanking/papigetcifaccounts", apiGetCifAccountsWS);
	 return endpoint;
	
	}
	
	@Bean
	public Endpoint getServerPapiretchqbookreq() {
		
	 Endpoint endpoint=	Endpoint.publish("http://"+url+":"+port+"/ws/mbanking/papiretchqbookreq", apiRetchqbookReqWS);
	 return endpoint;
	
	}
	
	@Bean
	public Endpoint getServerPapitransferex3() {
		
	 Endpoint endpoint=	Endpoint.publish("http://"+url+":"+port+"/ws/mbanking/papitransferex3", apiTransferEx3WS);
	 return endpoint;
	
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	


	
}
