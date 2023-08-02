package com.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan("com.demo")
@SpringBootApplication
public class WalkApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalkApplication.class, args);
    }

}
