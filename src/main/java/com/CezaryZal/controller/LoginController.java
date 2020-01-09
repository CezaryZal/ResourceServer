package com.CezaryZal.controller;

import com.CezaryZal.entity.app.AuthenticationRequest;
import com.CezaryZal.manager.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.login.AccountNotFoundException;
import java.util.stream.Stream;

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
//      wystarczy do stworzenia użytkownika
//    "firstName": "Anna",
//            "email": "anna@gmail.com"

    @GetMapping("/tmp")
    public String getStringFromOutside(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8081/HealthCalendar/test/hello",
                HttpMethod.GET,
                null,
                String.class);

        Stream.of(responseEntity.getBody()).forEach(System.out::println);

        return "fff";
    }

}
