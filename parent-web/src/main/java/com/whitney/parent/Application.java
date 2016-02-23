package com.whitney.parent;

import com.whitney.sales.SalesApplication;
import com.whitney.support.SupportApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) throws Exception {
        start(SupportApplication.class).run(args);
        start(SalesApplication.class).run(args);
    }

    private static SpringApplicationBuilder start(Object sources) {
        return new SpringApplicationBuilder(Application.class).showBanner(false).child(sources);
    }
}