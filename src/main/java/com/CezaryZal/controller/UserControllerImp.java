package com.CezaryZal.controller;

import com.CezaryZal.entity.User;
import com.CezaryZal.manager.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/admin/user")
public class UserControllerImp implements UserController {

    private UserService userService;

    public UserControllerImp(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{index}")
    public Optional<User> findById(@PathVariable Long index) {
        return userService.findById(index);
    }
}
