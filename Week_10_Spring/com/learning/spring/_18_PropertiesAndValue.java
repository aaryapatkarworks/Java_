package com.learning.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
class ApplicationInfo {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String version;

    @Value("${app.author}")
    private String author;

    public void display() {

        System.out.println("Application: " + appName);
        System.out.println("Version: " + version);
        System.out.println("Author: " + author);
    }
}

@ComponentScan("com.learning.spring")
class PropertyConfig {
}

public class _18_PropertiesAndValue {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PropertyConfig.class);

        ApplicationInfo info =
                context.getBean(ApplicationInfo.class);

        info.display();

        context.close();
    }
}