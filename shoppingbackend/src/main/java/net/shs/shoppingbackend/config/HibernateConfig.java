package net.shs.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="net.shs.shoppingbackend.dto")
@EnableTransactionManagement
public class HibernateConfig {
	private static final String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlineshopping";
	private static final String DATABASE_DRIVER="org.h2.Driver";
	private static final String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private static final String DATABASE_USERNAME="sa";
	private static final String DATABASE_PASSWORD="";
	
	@Bean
	private DataSource getDataSource() {
		BasicDataSource basicDataSource=new BasicDataSource();
		//providing the database connection information
		basicDataSource.setDriverClassName(DATABASE_DRIVER);
		basicDataSource.setUrl(DATABASE_URL);
		basicDataSource.setUsername(DATABASE_USERNAME);
		basicDataSource.setPassword(DATABASE_PASSWORD);
		
		return basicDataSource;
	}
	@Bean
	public SessionFactory getSessionFactory(DataSource basicdataSource) {
		
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(basicdataSource);
		builder.addProperties(getHibernateProperties());	//add Hibernate Properties
		builder.scanPackages("net.shs.shoppingbackend.dto");
		return builder.buildSessionFactory();
	}
	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect",DATABASE_DIALECT);
		properties.put("hibernate.show_sql",true);
		properties.put("hibernate.format_sql",true);
		return properties;
	}
	//Hibernate transactionManger configuration
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
		
	}
}
