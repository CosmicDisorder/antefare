package com.github.cosmicdisorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class AntefareApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntefareApplication.class, args);
    }
}
