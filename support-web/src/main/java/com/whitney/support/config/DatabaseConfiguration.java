package com.whitney.support.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.whitney.support.data.dao")
@EntityScan("com.whitney.support.data.dto")
@EnableTransactionManagement
public class DatabaseConfiguration {

}