package com.CezaryZal.controller;

import com.CezaryZal.entity.UserLogin;
import com.CezaryZal.manager.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> getTokenByUserLogin(@RequestBody UserLogin inputUserLogin){
        return loginService.getTokenByUserLogin(inputUserLogin);
    }

}
