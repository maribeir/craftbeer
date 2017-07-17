package com.beerhouse;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

/**
 * Classe de configuração do DataSource.
 * 
 * @author Matheus R. Torres
 * @version 1.0.0
 * 
 */
@Configuration
public class DataSourceConfiguration {
	
	private static final String TEMP_DIRECTORY = System.getProperty("java.io.tmpdir");
	 
    @Bean(name = "mainDataSource")
	public DataSource createMainDataSource() {
    	
	    JdbcDataSource ds = new JdbcDataSource();
	    ds.setURL("jdbc:h2:"+TEMP_DIRECTORY+"/craftbeer;MODE=MySQL");
	    
	    return ds;
	}
}