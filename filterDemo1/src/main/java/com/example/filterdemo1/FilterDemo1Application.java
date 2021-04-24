package com.example.filterdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ServletComponentScan("com.example.filterdemo1.filter")
public class FilterDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(FilterDemo1Application.class, args);
    }

}
