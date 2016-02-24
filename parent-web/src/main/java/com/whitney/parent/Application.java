package com.whitney.parent;

import com.whitney.sales.SalesApplication;
import com.whitney.support.SupportApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application {
    public static void main(String[] args) throws Exception {
        start(SalesApplication.class).profiles("local.sales").run(args);
        start(SupportApplication.class).profiles("local").run(args);
    }

    private static SpringApplicationBuilder start(Object sources) {
        return new SpringApplicationBuilder(Application.class).showBanner(false).child(sources);
    }
}