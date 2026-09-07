package com.learning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.learning.spring")
public class _07_Component {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        _07_Component.class
                );

        EngineComponent engine =
                context.getBean(EngineComponent.class);

        engine.start();
    }
}


/*
 * @Component tells Spring:
 *
 * Create and manage an object
 * of this class as a Spring Bean.
 */

@Component
class EngineComponent {

    public void start() {

        System.out.println(
                "Engine Bean created using @Component"
        );
    }
}