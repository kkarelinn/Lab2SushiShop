package com.example.lab2sushishop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class Lab2SushiShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab2SushiShopApplication.class, args);

    }

}
