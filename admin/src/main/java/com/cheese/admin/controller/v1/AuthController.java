package com.cheese.admin.controller.v1;

import com.cheese.admin.error.ErrorCode;
import com.cheese.admin.exception.CouponNotFoundException;
import com.cheese.admin.exception.CustomException;
import com.cheese.admin.exception.InvalidParameterException;
import com.cheese.admin.model.request.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/v1")
@RestController
public class AuthController {

    @GetMapping("/auth")
    public String root() {
        return "root";
    }


}
