package mr.bpm.mbanking;

import javax.xml.ws.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mr.bpm.mbanking.ws.MonetiqueWS;

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
	MonetiqueWS monetiqueWS;
	
	
	@Bean
	public Endpoint getServerFullstatement() {
		
	 Endpoint endpoint=	Endpoint.publish("http://"+url+":"+port+"/ws/monetique/service",monetiqueWS);
	 return endpoint;
	
	}
	
	

}
