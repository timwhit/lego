package com.whitney.support;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableAutoConfiguration
@EnableJms
@ComponentScan(value = { "com.whitney.support", "com.whitney.common" })
public class SupportApplication extends AnnotationConfigEmbeddedWebApplicationContext {

}