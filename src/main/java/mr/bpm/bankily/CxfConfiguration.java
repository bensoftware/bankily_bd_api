package mr.bpm.bankily;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.ImportResource;

import mr.bpm.bankily.ws.ApiBankilyWS;


@Configuration
@ImportResource({"classpath:META-INF/cxf/cxf.xml"})
public class CxfConfiguration  {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	ApiBankilyWS apiWS;
	
	
  @Bean
  public ServletRegistrationBean servletRegistrationBean() {
    CXFServlet cxfServlet = new CXFServlet();

    ServletRegistrationBean servletRegistrationBean =
        new ServletRegistrationBean(cxfServlet, "/ws/bankily/*");
    servletRegistrationBean.setLoadOnStartup(1);
    return servletRegistrationBean;
  }
  
  @DependsOn("servletRegistrationBean")
  @Bean
  public EndpointImpl jaxwsEndpoint(){
     Bus bus = (Bus) applicationContext.getBean(Bus.DEFAULT_BUS_ID);
     EndpointImpl endpoint = new EndpointImpl(bus, apiWS);
     endpoint.publish("/service");
  
     return endpoint;
  }

 }