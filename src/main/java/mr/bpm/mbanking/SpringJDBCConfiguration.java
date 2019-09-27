package mr.bpm.mbanking;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
 
@Configuration
public class SpringJDBCConfiguration {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //MySQL database we are using
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@30.30.1.90:1528:monprod");//change url
        dataSource.setUsername("mxp");//change userid
        dataSource.setPassword("MxpBpm2017");//change pwd
        
 
        return dataSource;
    }
 
/*    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }*/

}