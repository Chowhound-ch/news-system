package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * SpringBoot启动入口
 */
@EnableJpaAuditing
@SpringBootApplication
public class NewsSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsSystemApplication.class, args);
    }

}

