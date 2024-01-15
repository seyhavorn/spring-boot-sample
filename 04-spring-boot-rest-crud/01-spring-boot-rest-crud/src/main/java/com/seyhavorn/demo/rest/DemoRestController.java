package com.seyhavorn.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {
    //add code Hello endpoint:

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }
}
