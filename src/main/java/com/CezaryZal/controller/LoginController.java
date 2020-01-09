package com.CezaryZal.controller;

import com.CezaryZal.entity.app.AuthenticationRequest;
import com.CezaryZal.entity.health.calendar.InputUser;
import com.CezaryZal.entity.health.calendar.UserAuthentication;
import com.CezaryZal.manager.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;

@RestController
@RequestMapping("/api")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> getTokenByUserLogin(@RequestBody AuthenticationRequest inputAuthenticationRequest) throws AccountNotFoundException {
         return new ResponseEntity<>(loginService.getTokenByUserLogin(inputAuthenticationRequest), HttpStatus.OK);
    }

    @PostMapping("/new-account")
    public ResponseEntity<String> getUserCreatorFromHcApplication(@RequestBody InputUser inputUser){
        return new ResponseEntity<>(loginService.creteNewAccount(inputUser), HttpStatus.OK);
    }
}
