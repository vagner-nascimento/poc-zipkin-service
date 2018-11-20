package com.vagner.zipkin;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //TODO:
    // Observaçoes: O rest template deve ser sigleton para toda a aplicaçao.
    // Caso contrário o Sleuth nao consegue juntar os spams em um só trace.
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder templateBuilder) {
        return templateBuilder.build();
    }
/*
    @Autowired
    private AmqpAdmin amqpAdmin;
    @PostConstruct
    void setup() {
        amqpAdmin.declareQueue(new Queue("poc-zipkin"));
    }
*/
}
