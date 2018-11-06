package com.vagner.zipkin.contract;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Service
public class ZipkinDeveloperFacade {
    private final String END_POINT = "http://localhost:8081/zipkin/customers/salaries/developers";
    /*
        TODO:
         Observaçoes: Este restTamplate utiliza o do @Bean declarado na Application
     */
    @Autowired
    private RestTemplate restTemplate;

    public Map<String, Long> getDeveloperSalaries() {
        try {
            return restTemplate.exchange(this.END_POINT,
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    new ParameterizedTypeReference<Map<String, Long>>() {
                    }).getBody();
        } catch (HttpClientErrorException httEx) {
            log.error(httEx.getStatusCode().toString());
            log.error(httEx.getResponseBodyAsString());
            httEx.printStackTrace();
            throw httEx;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
