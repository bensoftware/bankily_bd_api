package mr.bpm.bankily;
import javax.sql.DataSource;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import mr.bpm.bankily.helper.SecurityConstants;

 

@Configuration
public class SpringJDBCConfiguration {
	

	PooledPBEStringEncryptor encryptor=null;

	String host,pwdDigit,usernameDigit,pwdParty,usernameParty,pwdInstr,usernameInstr,usernameBus,pwdBus,usernameMobiq,pwdMobiq;
	
	
	public SpringJDBCConfiguration(
			@Value("${adr.db}") String host,
			@Value("${pwd.db.digitalworkspace}") String pwdDigit,
			@Value("${username.db.digitalworkspace}") String usernameDigit,
			@Value("${pwd.db.party}") String pwdParty,
			@Value("${username.db.party}") String usernameParty,
			@Value("${pwd.db.instrumentmgmt}") String pwdInstr,
			@Value("${username.db.instrumentmgmt}") String usernameInstr,
			@Value("${pwd.db.bus}") String pwdBus,
			@Value("${username.db.bus}") String usernameBus,
			@Value("${username.db.mobiq}") String usernameMobiq,
			@Value("${pwd.db.mobiq}") String pwdMobiq
			
			) {

		
		encryptor = new PooledPBEStringEncryptor();
		encryptor.setPoolSize(4);
		encryptor.setPassword(SecurityConstants.KEY);
		encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
		
		
		this.host=host;
		this.pwdDigit=decrypte(pwdDigit);
		this.usernameDigit=usernameDigit;
		this.pwdParty=decrypte(pwdParty);
		this.usernameParty=usernameParty;
		this.pwdInstr=decrypte(pwdInstr);
		this.usernameInstr=usernameInstr;
		this.usernameBus=usernameBus;
		this.pwdBus=decrypte(pwdBus);
		this.usernameMobiq=usernameMobiq;
		this.pwdMobiq=decrypte(pwdMobiq);
		
	}
	
	  private String decrypte(String encode) {

			return encryptor.decrypt(encode);
	  }
	  
	  
	
/*	  @Bean
	    public DataSource dataSource(@Value("${adr.db}") String host,@Value("${pwd.db}") String pwd, @Value("${username.db}") String username) {
		  
		  String pass= decrypte(pwd);
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        //MySQL database we are using
	        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	        dataSource.setUrl("jdbc:oracle:thin:@"+host);//change url
	        dataSource.setUsername(username);//change userid
	        dataSource.setPassword(pass);//change pwd

	        return dataSource;
	    }
*/
	  
	  // ////////////////////////////////////
	  
	  @Bean   
	    @ConfigurationProperties(prefix="spring.digitalworkspace")
	    public DataSource dataSourceDigitalWorkspace() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        //MySQL database we are using
	        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	        dataSource.setUrl("jdbc:oracle:thin:@"+host);//change url
	        dataSource.setUsername(usernameDigit);//change userid
	        dataSource.setPassword(pwdDigit);//change pwd
	       
	        return dataSource;
	    }
	    
	    @Bean("jdbcDigitalworkspace")
	    public JdbcTemplate createJdbcTemplate1(@Autowired @Qualifier("dataSourceDigitalWorkspace") DataSource dataSourceDigitalWorkspace){
	      //  return new JdbcTemplate(dataSourceDigitalWorkspace);
	    	   JdbcTemplate jdbcTemplate = new JdbcTemplate();
	           jdbcTemplate.setDataSource(dataSourceDigitalWorkspace());
	           return jdbcTemplate;
	    }
	    
	    
	    @Bean
	    @ConfigurationProperties(prefix="spring.party")
	    public DataSource dataSourceParty() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        //MySQL database we are using
	        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	        dataSource.setUrl("jdbc:oracle:thin:@"+host);//change url
	        dataSource.setUsername(usernameParty);//change userid
	        dataSource.setPassword(pwdParty);//change pwd
	       
	        return dataSource;
	    }
	    
	    @Bean("jdbcParty")
	    public JdbcTemplate createJdbcTemplate2(@Autowired @Qualifier("dataSourceParty") DataSource dataSourceParty){
	        return new JdbcTemplate(dataSourceParty);
	    }
	    
	    
	    
	    @Bean
	    @ConfigurationProperties(prefix="spring.instrumentmgmt")
	    public DataSource dataSourceInstrumentMgmt() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        //MySQL database we are using
	        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	        dataSource.setUrl("jdbc:oracle:thin:@"+host);//change url
	        dataSource.setUsername(usernameInstr);//change userid
	        dataSource.setPassword(pwdInstr);//change pwd
	        return dataSource;
	    }
	    
	    @Bean("jdbcInstrumentmgmt")
	    public JdbcTemplate createJdbcTemplate3(@Autowired @Qualifier("dataSourceInstrumentMgmt") DataSource dataSourceInstrumentMgmt){
	        return new JdbcTemplate(dataSourceInstrumentMgmt);
	    }
	  
	    
	    
	    @Bean
	    @ConfigurationProperties(prefix="spring.bus")
	    public DataSource dataSourceBus() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        //MySQL database we are using
	        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	        dataSource.setUrl("jdbc:oracle:thin:@"+host);//change url
	        dataSource.setUsername(usernameBus);//change userid
	        dataSource.setPassword(pwdBus);//change pwd
	        return dataSource;
	    }
	    
	    @Bean("jdbcBus")
	    public JdbcTemplate createJdbcTemplate4(@Autowired @Qualifier("dataSourceBus") DataSource dataSourceBus){
	        return new JdbcTemplate(dataSourceBus);
	    }
	    
	    
	    
	    @Bean
	    @ConfigurationProperties(prefix="spring.mobiq")
	    public DataSource dataSourceMobiq() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        //MySQL database we are using
	        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	        dataSource.setUrl("jdbc:oracle:thin:@"+host);//change url
	        dataSource.setUsername(usernameMobiq);//change userid
	        dataSource.setPassword(pwdMobiq);//change pwd
	        return dataSource;
	    }
	    
	    @Bean("jdbcMobiq")
	    public JdbcTemplate createJdbcTemplate5(@Autowired @Qualifier("dataSourceMobiq") DataSource dataSourceMobiq){
	        return new JdbcTemplate(dataSourceMobiq);
	    }
	    
	
	
	  
}