package com.CezaryZal.controller;

import com.CezaryZal.entity.User;
import com.CezaryZal.entity.UserLogin;
import com.CezaryZal.manager.ApiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private ApiService apiService;

    public LoginController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/login")
    public String getTokenByUserLogin(@RequestBody UserLogin inputUserLogin){
        return apiService.getTokenByUserLogin(inputUserLogin);
    }

}
