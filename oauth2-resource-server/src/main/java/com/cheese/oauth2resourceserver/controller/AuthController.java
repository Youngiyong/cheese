package com.cheese.oauth2resourceserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1")
@RestController
public class AuthController {

    @GetMapping("/auth")
    public String root() {
        return "root";
    }

}
