package com.vagner.zipkin.contract;

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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DeveloperResponse> getDeveloperSalaries() {
        return zipkinFacade.getDeveloperSalaries();
    }
}
