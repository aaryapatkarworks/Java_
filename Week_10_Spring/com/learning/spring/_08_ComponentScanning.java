package com.learning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.learning.spring")
public class _08_ComponentScanning {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        _08_ComponentScanning.class
                );

        EngineScanning engine =
                context.getBean(EngineScanning.class);

        engine.start();
    }
}


@Component
class EngineScanning {

    public void start() {

        System.out.println(
                "Engine found through Component Scanning"
        );
    }
}