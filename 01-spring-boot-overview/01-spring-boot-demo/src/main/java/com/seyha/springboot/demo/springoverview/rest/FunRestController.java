package com.seyha.springboot.demo.springoverview.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello() {
        return "<h1>Hello world<h1/>";
    }

    @GetMapping("/get")
    public String sage() {
        String text = "Hello"
                +" World Oke";
        return "<h1>"+ text+ "<h1/>";
    }
}
