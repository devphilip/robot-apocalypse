package com.devphilip.robotapocalypse;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RobotApocalypseApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobotApocalypseApplication.class, args);
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(new Info().title("Robot Apocalypse REST API").version("v0.0.1")
                .description("Robot Apocalypse Documentation using Open API Specification")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                .contact(new Contact().name("Philip Akpeki").email("philipakpeki@gmail.com")));
    }

}
