package com.whitney.product.config;

import liquibase.integration.spring.SpringLiquibase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.whitney.product.data.dao")
@EntityScan({ "com.whitney.product.data.dto", "com.whitney.common.converter" })
@EnableTransactionManagement
public class DatabaseConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Autowired
    private DataSource dataSource;

    @Bean
    public SpringLiquibase liquibase() {
        LOG.debug("Configuring Liquibase");
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(this.dataSource);
        liquibase.setChangeLog("classpath:db/changelog/product.db.changelog-master.yaml");
        liquibase.setContexts("development, production");

        liquibase.setShouldRun(true);

        return liquibase;
    }
}