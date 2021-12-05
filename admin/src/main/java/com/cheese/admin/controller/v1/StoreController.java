package com.cheese.admin.controller.v1;

import com.cheese.core.dto.request.LoginRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1")
@RestController
public class StoreController {

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'STORE_PRIVILEGE', 'STORE_READ_PRIVILEGE')")
    @GetMapping("/stores")
    public String findAllStores() {
        return "findAllStores";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'STORE_PRIVILEGE', 'STORE_DETAIL_PRIVILEGE')")
    @GetMapping("/stores/{id}")
    public String getStoreById(@PathVariable String id) {
        return "getStoreById";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'STORE_PRIVILEGE', 'STORE_DELETE_PRIVILEGE')")
    @DeleteMapping("/stores/{id}")
    public String deleteStoreById(@PathVariable String id) {
        return "deleteStoreById";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'STORE_PRIVILEGE', 'STORE_WRITE_PRIVILEGE')")
    @PostMapping("/stores/{id}")
    public String postStore(@RequestBody LoginRequest payload) {
        return "postStore";
    }
}
