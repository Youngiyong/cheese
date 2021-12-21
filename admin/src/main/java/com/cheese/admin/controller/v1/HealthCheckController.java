package com.cheese.admin.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @GetMapping(path = "/health")
    public String healthCheck() {
        return "OK";
    }
}
