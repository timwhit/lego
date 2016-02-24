package com.whitney.sales.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

@Configuration
@EnableJpaRepositories(basePackages = "com.whitney.sales.data.dao")
@EntityScan({ "com.whitney.sales.data.dto", "com.whitney.sales.data.converter" })
@EnableTransactionManagement
//@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
public class DatabaseConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @PostConstruct
    public void setup() {
        /*LOG.debug("Initialize H2 console");
        ServletRegistration.Dynamic h2ConsoleServlet = servletContext.addServlet("H2Console", new org.h2.server.web.WebServlet());
        h2ConsoleServlet.addMapping("/console*//*");
                                               h2ConsoleServlet.setLoadOnStartup(1);*/
    }
}