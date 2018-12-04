package com.tutorial.web.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement //Hibernate 설정
@ComponentScan(basePackages= {"com.tutorial.web.dao", "com.tutorial.web.service"})
public class ServiceContextConfig {
	
	@Bean
	public BasicDataSource basicDataSource() {

		BasicDataSource basicDataSource = new BasicDataSource();

		// db 연결 설정
		/*mssql-server*/
		basicDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		basicDataSource.setUrl("jdbc:sqlserver://211.238.142.251:1433;databaseName=lecture");
		basicDataSource.setUsername("sist");
		basicDataSource.setPassword("dclass");
		
		/*mysql*/
/*		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost/newlecturedb?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf8");
		basicDataSource.setUsername("hong");
		basicDataSource.setPassword("1234");*/

		// 커넥션풀 설정
		basicDataSource.setRemoveAbandoned(true);
		basicDataSource.setInitialSize(20);
		basicDataSource.setMaxActive(30);
		return basicDataSource;
	}
	
	
	//Hibernate 설정을 위한 Bean 객체들
	@Bean //스프링이 깨어날때 담아주자
	public LocalSessionFactoryBean sessionFactory() {
		
		Properties props = new Properties();
		//props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"); 
		props.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect"); //연결할 DB가 무엇인지 설정
		props.put("hibernate.show_sql", "true"); //콘솔에 찍어주세요
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(basicDataSource());
		sessionFactoryBean.setPackagesToScan("com.newlecture.web.academy.entity"); //스캔할곳 설정
		sessionFactoryBean.setHibernateProperties(props); //map개체
		
		return sessionFactoryBean;
	}
	
	//sessionFactory를 위한 설정
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject()); 
		//transactionManager는 sessionFactory를 반환해야 하는데 위 LocalSessionFactoryBean이 SessionFactory를 만들었다, getObject()로 반환할 수 있다.
		return transactionManager;
	}
	
	@Bean
	public JavaMailSender mailSender() {
		// 이메일을 보내기 위한 준비작업
		
		// 이메일 보낼 때 이용할 smtp 정보
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setDefaultEncoding("UTF-8");
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("");
		mailSender.setPassword("");

		// 이메일 보낼 때 이용할 설정값
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.smtp.auth", true);
		javaMailProperties.put("mail.smtp.starttls.enable", true);
		javaMailProperties.put("mail.debug", true);
		mailSender.setJavaMailProperties(javaMailProperties);
		
		return mailSender;
		
	}
	
}