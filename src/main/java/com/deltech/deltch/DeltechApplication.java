package com.deltech.deltch;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableRabbit
@SpringBootApplication
@EntityScan(basePackages = "domain.entities")
@EnableJpaRepositories(basePackages = "infra.repository")
@ComponentScan(basePackages = {"http","application", "infra", "domain"})
public class DeltechApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeltechApplication.class, args);
    }

}
