package com.ex.config;

import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import javax.sql.DataSource;
import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class PersistenceConfig {

    /**
     * This bean sets up the database configurations
     * @return returns the configured dataSource bean
     */
    @Bean
    public DataSource dataSource() {
        System.out.println("Setting up datasource");
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://project2.cyrfeoigkzgl.us-east-1.rds.amazonaws.com:5432/postgres");
        ds.setUsername("postgres");
        ds.setPassword("p4sSw0rD");
        ds.setDriverClassName(Driver.class.getName());
        return ds;
    }

    /**
     * This bean sets up the projects our LocalSessionFactoryBean
     * @return returns the configured entityManager bean
     */
    @Bean
    public LocalSessionFactoryBean entityManager() {
        System.out.println("Setting up Session Factory");
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(this.dataSource());
        sf.setPackagesToScan("com.ex.Models");
        sf.setHibernateProperties(this.getHibernateProperties());
        return sf;
    }

    /**
     * this bean sets up the projects transactionManager
     * @return returns the configured transactionManager bean
     */
    @Bean
    public HibernateTransactionManager transactionManager() {
        System.out.println("Setting up Transaction Manager");
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(this.entityManager().getObject());
        return txManager;
    }

    /**
     * this method configures our Hibernate properties for the project
     * @return returns property configuration object for Hibernate
     */
    private Properties getHibernateProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.format_sql", "true");
        return props;
    }
}