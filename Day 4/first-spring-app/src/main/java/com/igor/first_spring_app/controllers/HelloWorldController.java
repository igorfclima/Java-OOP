package com.igor.first_spring_app.controllers;

import com.igor.first_spring_app.services.HelloWorldServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello-world")
@RestController
public class HelloWorldController {
    @Autowired
    private  HelloWorldServices helloWorldServices;

    @GetMapping
    public String helloWorld() {
        return helloWorldServices.helloWorld("Igor");
    }
}
