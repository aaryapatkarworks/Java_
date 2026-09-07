package com.learning.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

interface EnvironmentService {

    void showEnvironment();
}

@Component
@Profile("dev")
class DevelopmentService implements EnvironmentService {

    @Override
    public void showEnvironment() {
        System.out.println("Development environment");
    }
}

@Component
@Profile("prod")
class ProductionService implements EnvironmentService {

    @Override
    public void showEnvironment() {
        System.out.println("Production environment");
    }
}

@ComponentScan("com.learning.spring")
class ProfileConfig {
}

public class _19_SpringProfiles {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.getEnvironment()
                .setActiveProfiles("dev");

        context.register(ProfileConfig.class);

        context.refresh();

        EnvironmentService service =
                context.getBean(EnvironmentService.class);

        service.showEnvironment();

        context.close();
    }
}