package com.CezaryZal.controller;

import com.CezaryZal.entity.UserLogin;
import com.CezaryZal.manager.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.NameNotFoundException;
import javax.security.auth.login.AccountNotFoundException;

@RestController
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> getTokenByUserLogin(@RequestBody UserLogin inputUserLogin) throws NameNotFoundException, AccountNotFoundException {
         return new ResponseEntity<>(loginService.getTokenByUserLogin(inputUserLogin), HttpStatus.OK);
    }

}
