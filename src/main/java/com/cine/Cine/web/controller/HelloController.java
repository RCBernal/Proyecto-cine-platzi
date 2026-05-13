package com.cine.Cine.web.controller;

import com.cine.Cine.domain.service.PlatziPlayAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final String platform;
    private final PlatziPlayAiService aiservice;

    public HelloController(@Value("${spring.application.name}") String platform, PlatziPlayAiService aiservice) {
        this.platform = platform;
        this.aiservice = aiservice;
    }

    @GetMapping("/hello")
    public String hello(){
        return this.aiservice.generatereading(this.platform);
    }
}
