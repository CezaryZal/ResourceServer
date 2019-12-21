package com.CezaryZal.controller;

import com.CezaryZal.entity.User;
import com.CezaryZal.entity.UserLogin;
import com.CezaryZal.manager.validator.Validator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private Validator validator;

    public LoginController(Validator validator) {
        this.validator = validator;
    }

    @PostMapping("/login")
    public User getToken(@RequestBody UserLogin userLogin){
        return validator.findUserByInputLogin(userLogin);
    }

}
