package com.CezaryZal.controller;

import com.CezaryZal.entity.UserLogin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String getToken(@RequestBody UserLogin userLogin){
        return userLogin.getPassword();
    }

}
