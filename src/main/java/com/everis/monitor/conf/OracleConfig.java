package com.everis.monitor.conf;
import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.everis.monitor.entities.Incurrido;
import com.everis.monitor.entities.User;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "oracleEntityManagerFactory", basePackages = {"com.everis.monitor.repositories.incurrido"}, transactionManagerRef = "oracleTransactionManager")
public class OracleConfig {
//
////	@Bean
////	@Primary
////	@ConfigurationProperties("spring.datasource")
////	public DataSourceProperties firstDataSourceProperties() {
////		return new DataSourceProperties();
////	}
////
////	@Bean
////	@Primary
////	@ConfigurationProperties("spring.datasource.configuration")
////	public DataSource mysqlDataSource(@Qualifier("mySqlDS") DataSourceProperties firstDataSourceProperties) {
////		return firstDataSourceProperties().initializeDataSourceBuilder().build();
////	}
//
//	@Bean
//	@ConfigurationProperties("spring.oracle")
//	public DataSourceProperties secondDataSourceProperties() {
//		return new DataSourceProperties();
//	}
//
//	@Bean
//	@ConfigurationProperties("spring.oracle.configuration")
//	public DataSource oracleDataSource(@Qualifier("oracleDS") DataSourceProperties secondDataSourceProperties) {
//		return secondDataSourceProperties().initializeDataSourceBuilder().type(DataSource.class).build();
//	}
//	
////	@Bean(name = "entityManagerFactoryMYSQL")
////	public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(
////			EntityManagerFactoryBuilder builder, @Qualifier("mySqlDS") DataSource mySqlDS) {
////		return builder.dataSource(mySqlDS).packages(User.class).persistenceUnit("users").build();
////	}
//
//	
//	@Bean(name = "oracleEntityManagerFactory")
//	public LocalContainerEntityManagerFactoryBean incurridosEntityManagerFactory(
//			EntityManagerFactoryBuilder builder, @Qualifier("oracleDS") DataSource mySqlDS) {
//		return builder.dataSource(mySqlDS).packages(REPORT_INCURRIDO.class).persistenceUnit("incurrido").build();
//	}
//	
//	@Bean(name = "oracleTransactionManager")
//	public PlatformTransactionManager transactionManager(@Qualifier("oracleEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//		return new JpaTransactionManager(entityManagerFactory);
//	}

	
	
	@Bean(name = "dataSource2")
	@ConfigurationProperties(prefix = "spring.oracle")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "oracleEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource2") DataSource dataSource) {
		HashMap<String, Object> properties = new HashMap<>();

//		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		return builder.dataSource(dataSource).properties(properties)
				.packages(Incurrido.class).persistenceUnit("Incurrido").build();
	}

	@Bean(name = "oracleTransactionManager")
	public PlatformTransactionManager oracleTransactionManager(
			@Qualifier("oracleEntityManagerFactory") EntityManagerFactory oracleEntityManagerFactory) {
		return new JpaTransactionManager(oracleEntityManagerFactory);
	}
	
	
	
	
	
	
	
}