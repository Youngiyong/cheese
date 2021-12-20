package com.cheese.zuul;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/v1/auth")
@RestController
public class TestController {

    @GetMapping("/callback")
    public String user(@RequestParam String code, @RequestParam String scope, @RequestParam String client_info, @RequestParam String state) {
        System.out.println(code+ " "+ scope + " "+ client_info +  " " + state);
        return "USER";
    }
}
