package com.vagner.zipkin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.metric.SpanMetricReporter;
import org.springframework.cloud.sleuth.zipkin.ZipkinProperties;

@SpringBootApplication
public class Application {
    @Autowired
    private SpanMetricReporter spanMetricReporter;
    @Autowired
    private ZipkinProperties zipkinProperties;
    @Value("${spring.sleuth.web.skipPattern}")
    private String skipPattern;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
