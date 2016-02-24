package com.whitney.support;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(value = { "com.whitney.sales", "com.whitney.common" })
public class SupportApplication extends AnnotationConfigEmbeddedWebApplicationContext {
    @Value("${support.port:8082}")
    private Integer port;

    @Bean
    public EmbeddedServletContainerFactory embeddedServletContainerFactory() {
        return new TomcatEmbeddedServletContainerFactory(port);
    }
}