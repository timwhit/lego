package com.whitney.parent;

import com.whitney.product.ProductApplication;
import com.whitney.queue.QueueApplication;
import com.whitney.sales.SalesApplication;
import com.whitney.support.SupportApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import java.util.Optional;

@Configuration
public class Application {
    public static final String SPRING_PROFILES_ACTIVE = "lego.profiles.active";
    public static final String DEFAULT_PROFILE = "local";

    public static void main(String[] args) throws Exception {
        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);

        String profile = Optional.ofNullable(source.getProperty(SPRING_PROFILES_ACTIVE)).orElse(DEFAULT_PROFILE);

        start(SalesApplication.class).profiles(profile + ".sales").run(args);
        start(SupportApplication.class).profiles(profile + ".support").run(args);
        start(ProductApplication.class).profiles(profile + ".product").run(args);
        start(QueueApplication.class).profiles(profile + ".queue").web(false).run(args);
    }

    private static SpringApplicationBuilder start(Object sources) {
        return new SpringApplicationBuilder(Application.class).showBanner(false).child(sources);
    }
}