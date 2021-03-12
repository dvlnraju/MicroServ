package com.OAuth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.OAuth.bean.AuthUser;
import com.OAuth.service.AuthUserService;

@RestController
//@RequestMapping("/oauth/users")
public class UserController {

    @Autowired
    private AuthUserService authUserService;

    @PostMapping(value = "/oauth/users")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthUser register(UserDto userDto) {
        return authUserService.register(userDto);
    }

}
