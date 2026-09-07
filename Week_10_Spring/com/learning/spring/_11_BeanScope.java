package com.learning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.learning.spring")
public class _11_BeanScope {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        _11_BeanScope.class
                );


        /*
         * Singleton
         */

        SingletonStudent student1 =
                context.getBean(
                        SingletonStudent.class
                );

        SingletonStudent student2 =
                context.getBean(
                        SingletonStudent.class
                );

        System.out.println(
                "Singleton same object: "
                        + (student1 == student2)
        );


        /*
         * Prototype
         */

        PrototypeStudent student3 =
                context.getBean(
                        PrototypeStudent.class
                );

        PrototypeStudent student4 =
                context.getBean(
                        PrototypeStudent.class
                );

        System.out.println(
                "Prototype same object: "
                        + (student3 == student4)
        );
    }
}


/*
 * Singleton
 *
 * Default Spring scope.
 */

@Component
@Scope("singleton")
class SingletonStudent {
}


/*
 * Prototype
 *
 * New instance whenever requested.
 */

@Component
@Scope("prototype")
class PrototypeStudent {
}