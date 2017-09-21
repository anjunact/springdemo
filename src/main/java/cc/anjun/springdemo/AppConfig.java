package cc.anjun.springdemo;


import java.util.Properties;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import cc.anjun.springdemo.domain.User;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
@ComponentScan({ "cc.anjun.springdemo.controller","cc.anjun.springdemo.service","cc.anjun.springdemo.dao"})
@EnableWebMvc
public class AppConfig {

	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.driverClassName}")
	private String driverClassName;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driverClassName);
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	@Bean
	public DataSourceTransactionManager transactionManager() {
	    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}
	@Bean
	MultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(500000000);
		return resolver;
	}
//    @Bean
//    public SessionFactory sessionFactory(DataSource dataSource) {
//    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
//
//    	Properties props = new Properties();
//    	props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//    	props.put("hibernate.show_sql", "true");
//    	sessionBuilder.addProperties(props);
//    	
//    	sessionBuilder.addAnnotatedClass(User.class);
//    	
//    	return sessionBuilder.buildSessionFactory();
//    }
//    @Bean
//	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//		return new HibernateTransactionManager(sessionFactory);
//	}
	
}
