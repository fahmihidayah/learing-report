/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.conf;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 *
 * @author fahmi
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.widsons.leport.repository"}, entityManagerFactoryRef = "emf")
@PropertySource("classpath:/application.properties")
public class DataBaseConf {

    @Autowired
    Environment environment;

    @Value("#{ environment['db.driver']}")
    protected String driverClassName;
    @Value("#{ environment['db.url']}")
    protected String dbUrl;
    @Value("#{ environment['db.username']}")
    protected String username;
    @Value("#{ environment['db.password']}")
    protected String password;
    
    @Value("#{ environment['hibernate.dialect']}")
    protected String hibernateDialect;
    
    @Value("#{ environment['hibernate.show_sql']}")
    protected String isShowSql;
    
    @Value("#{ environment['entitymanager.packages.to.scan']}")
    protected String entityManagerPackage;
    
    @Value("#{ environment['hibernate.hbm2ddl.auto']}")
    protected String auto;
    
    @Value("#{ environment['hibernate.hbm2ddl.import_files']}")
    protected String importFiles;
    

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(1800000);
        dataSource.setNumTestsPerEvictionRun(3);
        dataSource.setMinEvictableIdleTimeMillis(1800000);
        return dataSource;
    }
    
    public Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", isShowSql);
        properties.put("hibernate.hbm2ddl.auto", auto);
        properties.put("hibernate.hbm2ddl.import_files", importFiles);
        return properties;
    }
    
    @Bean(name = "emf")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
        localContainerEntityManagerFactoryBean.setPackagesToScan(entityManagerPackage);
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setJpaProperties(hibernateProperties());
        return localContainerEntityManagerFactoryBean;
    }
    
    /**
     *
     * @param entityManagerFactory
     * @return
     */
    @Bean(name = "transactionManager")
    public JpaTransactionManager getJpaTransactionManager(){
            JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
            jpaTransactionManager.setEntityManagerFactory(getEntityManagerFactory().getObject());
            return jpaTransactionManager;
    }
    

}
