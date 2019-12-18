package com.CezaryZal.controller;

import com.CezaryZal.entity.User;
import com.CezaryZal.manager.dbService.UserService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/name/{loginName}")
    public Optional<User> findByLoginName(@PathVariable String loginName){
        return userService.findByLoginName(loginName);
    }

    @GetMapping
    public Iterable<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public User addNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{index}")
    public void deleteUserById(@PathVariable Long index) {
        userService.deleteUser(index);
    }
}
