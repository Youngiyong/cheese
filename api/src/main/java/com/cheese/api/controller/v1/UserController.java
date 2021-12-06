package com.cheese.api.controller.v1;

import com.cheese.core.dto.request.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1")
@RestController
public class UserController {

    @GetMapping("/users")
    public String findAllUsers() {
        return "findAllUsers";
    }

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable String id) {
        return "getUserById";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable String id) {
        return "deleteUserById";
    }

    @PostMapping("/users/{id}")
    public String postUsers(@RequestBody LoginRequest payload) {
        return "postUsers";
    }
}
