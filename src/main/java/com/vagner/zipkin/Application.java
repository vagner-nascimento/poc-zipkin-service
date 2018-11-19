package com.vagner.zipkin;

import com.vagner.zipkin.contract.ApplicationProperties;
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
    @Autowired
    private ApplicationProperties properties;
    @Autowired
    private AmqpAdmin amqpAdmin;
/*
    @Bean
    public Sampler getSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //TODO:
    // Observaçoes: Necessário o @Bean getRestTemplate somente quando vai utilizar
    // chamadas a outros serviços. Se instanciar um novo e Zipkin nao consegue
    // fazer o trace da requisiçao.
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder templateBuilder) {
        return templateBuilder.build();
    }

    @PostConstruct
    void setup() {
        amqpAdmin.declareQueue(new Queue(properties.getQueuePocZipkin()));
    }
}
