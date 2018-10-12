package com.scalefocus.tibco.camel.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author Evgeni Stoykov
 */
@SpringBootApplication
@EnableJms
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
