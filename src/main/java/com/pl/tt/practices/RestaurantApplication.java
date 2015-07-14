package com.pl.tt.practices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestaurantApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(RestaurantApplication.class, args);
    }
}
