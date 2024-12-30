package com.lead_management_system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    @GetMapping("/hello")
    public String getHello() {
        return "Hello";
    }

    @PostMapping("/hello")
    public String getHello(@RequestBody String str) {
        return str;
    }
}
