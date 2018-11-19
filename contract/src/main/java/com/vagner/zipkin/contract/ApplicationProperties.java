package com.vagner.zipkin.contract;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ApplicationProperties {
    @Value("${app.rabbitmq.queue}")
    private String queuePocZipkin;
}
