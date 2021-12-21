package com.cheese.admin.controller.v1;

import com.cheese.admin.error.ErrorCode;
import com.cheese.admin.exception.CouponNotFoundException;
import com.cheese.admin.exception.CustomException;
import com.cheese.admin.exception.InvalidParameterException;
import com.cheese.admin.model.request.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HealthCheckController {

    @Operation(summary = "test hello", description = "hello api example")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK !!"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
    })
    @GetMapping(path = "/health")
    public ResponseEntity<String> health(@Parameter(description = "이름", required = true, example = "Park") @RequestParam String name) {
        return ResponseEntity.ok("hello " + name);
    }


    @PostMapping("/member")
    public String memberException(@Valid @RequestBody Member dto, BindingResult result) {
        System.out.println(dto);
        if (result.hasErrors()) {
            throw new InvalidParameterException(result);
        }

        return "page/home";
    }

    @GetMapping("/exception")
    public String exceptionTest(String code) {
        switch (code) {
            case "1":
                System.out.println("hi");
//                break;
                throw new CouponNotFoundException(ErrorCode.EMAIL_DUPLICATION);
            case "3":
                int a = 3 / 0;
                break;
        }
        return "page/home";
    }
}
