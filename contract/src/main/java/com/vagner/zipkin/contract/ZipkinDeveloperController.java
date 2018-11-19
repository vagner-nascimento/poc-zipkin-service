package com.vagner.zipkin.contract;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/developers")
public class ZipkinDeveloperController {
    @Autowired
    private ZipkinDeveloperFacade zipkinFacade;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ApplicationProperties appProperties;
    @Autowired
    private ApplicationProperties properties;

    @GetMapping(value = "/salaries", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DeveloperResponse> getDeveloperSalaries() {
        return zipkinFacade.getDeveloperSalaries();
    }

    @GetMapping("/message")
    public String message() {
        rabbitTemplate.convertAndSend(appProperties.getQueuePocZipkin(), "body");
        return "Sent the message to Rabbit. Let's wait for 'poc-zipkin-service1' to get it.";
    }
}
