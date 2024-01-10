package com.seyha.springboot.demo.springoverview.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello() {
        return "<h1>Hello world<h1/>";
    }
    @GetMapping("/workout")
    public String getDetailWorkout() {
        return "<h1>Run a hard 5K!<h1/>";
    }

    @GetMapping("/fortune")
    public String getDetailFortune() {
        return "<h1>Today is your lucky day, Have a nice Day!!<h1/>";
    }
}
