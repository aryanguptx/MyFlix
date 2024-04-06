package com.pes.movies.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Health {
    @GetMapping("/health")
    public String healthCheck(){
        return "200 OK";
    }
}
