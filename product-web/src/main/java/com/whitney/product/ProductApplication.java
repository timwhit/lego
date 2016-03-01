package com.whitney.product;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableAutoConfiguration
@EnableJms
@ComponentScan(value = { "com.whitney.product", "com.whitney.common" })
public class ProductApplication extends AnnotationConfigEmbeddedWebApplicationContext {

}