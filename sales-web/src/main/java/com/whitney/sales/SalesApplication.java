package com.whitney.sales;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableAutoConfiguration
@EnableJms
@ComponentScan(value = { "com.whitney.sales", "com.whitney.common" })
public class SalesApplication extends AnnotationConfigEmbeddedWebApplicationContext {

}