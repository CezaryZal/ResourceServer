package com.CezaryZal.controller;

import com.CezaryZal.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserControllerImp implements UserController {

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return new User(1L, "login", "password", false, "role", "perrrr", 1L);
    }
}
