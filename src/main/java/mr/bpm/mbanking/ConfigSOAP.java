package mr.bpm.mbanking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class ConfigSOAP {

	@Bean
	public SimpleJaxWsServiceExporter getServer() {
		
		SimpleJaxWsServiceExporter exporter=new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://192.168.0.50:8888/ws/mbanking");
	  
		return exporter;
	}	
	


	
}
