package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello/{name}")
    public Greeting hello(@PathVariable String name) {
        return new Greeting("Hello, " + name + "!", "1.0");
    }

    @GetMapping("/greet")
    public Greeting greet(
        @RequestParam String name,
        @RequestParam(defaultValue = "1.0") String version
    ) {
        return new Greeting("Hello, " + name + "!", version);
    }

    @PostMapping("/hello")
    public Greeting create(@RequestBody Greeting request) {
        return new Greeting("Received: " + request.getMessage(), request.getVersion());
    }
}