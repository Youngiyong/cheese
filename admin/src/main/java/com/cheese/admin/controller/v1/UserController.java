package com.cheese.admin.controller.v1;
import com.cheese.core.dto.request.LoginRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1")
@RestController
public class UserController {

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'USER_PRIVILEGE', 'USER_READ_PRIVILEGE')")
    @GetMapping("/users")
    public String findAllUsers() {
        return "findAllUsers";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'USER_PRIVILEGE', 'USER_DETAIL_PRIVILEGE')")
    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable String id) {
        return "getUserById";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'USER_PRIVILEGE', 'USER_DELETE_PRIVILEGE')")
    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable String id) {
        return "deleteUserById";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'USER_PRIVILEGE', 'USER_WRITE_PRIVILEGE')")
    @PostMapping("/users/{id}")
    public String postUsers(@RequestBody LoginRequest payload) {
        return "postUsers";
    }

}
