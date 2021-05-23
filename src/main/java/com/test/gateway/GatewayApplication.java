package com.test.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayApplication {
    public static final Logger logger = LoggerFactory.getLogger(GatewayApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        .title("Gateway REST API")
                        .description("Gateway API created using Spring Boot")
                        .version("1.0")
                        .contact(new Contact("Fredy Almenares", "", "bitmaet@gmail.com"))
                        .build())
                .directModelSubstitute(Timestamp.class, LocalDateTime.class)
                .select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }
}
