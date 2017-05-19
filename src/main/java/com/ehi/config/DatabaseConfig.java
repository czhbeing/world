package com.ehi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {

	@Primary
	@Bean(name = "dsDev")
	@ConfigurationProperties(prefix = "spring.mysql1.datasource")
	public DataSource devDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "dsQa")
	@ConfigurationProperties(prefix = "spring.mysql2.datasource")
	public DataSource qaDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "devJdbc")
	@Autowired
	public JdbcTemplate devJdbcTemplate(@Qualifier("dsDev") DataSource dsDev) {
		return new JdbcTemplate(dsDev);
	}

	@Bean(name = "qaJdbc")
	@Autowired
	public JdbcTemplate qaJdbcTemplate(@Qualifier("dsQa") DataSource dsQa) {
		return new JdbcTemplate(dsQa);
	}

}
