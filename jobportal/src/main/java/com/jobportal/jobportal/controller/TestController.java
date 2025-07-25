package com.jobportal.jobportal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String test() {
        return "✅ Hello from JobPortal backend!";
    }

    @GetMapping("/api/test")
    public String apiTest() {
        return "✅ API is working";
    }
}
