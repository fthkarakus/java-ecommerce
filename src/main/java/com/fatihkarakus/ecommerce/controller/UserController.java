package com.fatihkarakus.ecommerce.controller;

import com.fatihkarakus.ecommerce.dto.ResponseDto;
import com.fatihkarakus.ecommerce.dto.user.SignupDto;
import com.fatihkarakus.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    // two apis

    // signup
    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto) {
        return userService.signUp(signupDto);
    }

    // signin

}
