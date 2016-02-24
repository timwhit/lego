package com.whitney.sales.config;

import org.apache.commons.lang3.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Configuration of web application with Servlet 3.0 APIs.
 */
@Configuration
//@AutoConfigureAfter({ CacheConfiguration.class, LocaleConfiguration.class })
public class WebConfigurer implements ServletContextInitializer {
    private static final Logger LOG = LoggerFactory.getLogger(WebConfigurer.class);

    @Autowired
    private Environment env;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        LOG.info("Web application configuration, using profiles: {}", Arrays.toString(env.getActiveProfiles()));

        this.initH2Console(servletContext);

        LOG.info("Web application fully configured");
    }

    /**
     * Initializes H2 console
     */
    private void initH2Console(ServletContext servletContext) {
        LOG.debug("Initialize H2 console");
        ServletRegistration.Dynamic h2ConsoleServlet = servletContext.addServlet("H2Console", new org.h2.server.web.WebServlet());
        h2ConsoleServlet.addMapping("/console/*");
        h2ConsoleServlet.setLoadOnStartup(1);
    }

    /**
     * Overrides the default StringHttpMessageConverter provided by Spring Boot.
     * Makes sure that text is output in UTF-8
     *
     * @return HTTP messages in UTF-8 encoding
     */
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(Charset.forName(CharEncoding.UTF_8));
    }

    /**
     * Sets text responses to have ;charset=utf-8 in the content-type header
     *
     * @return A filter with ;charset=utf-8 in the content-type header
     */
    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding(CharEncoding.UTF_8);
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
}