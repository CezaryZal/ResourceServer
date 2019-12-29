package com.CezaryZal.controller;

import com.CezaryZal.entity.User;
import com.CezaryZal.manager.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.NameNotFoundException;

@RestController
@RequestMapping("/admin/user")
public class UserControllerImp implements UserController {

    private UserService userService;

    @Autowired
    public UserControllerImp(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{index}")
    public ResponseEntity<User> findById(@PathVariable Long index) throws NameNotFoundException {
        return new ResponseEntity<>(userService.findById(index), HttpStatus.OK);
    }

    @GetMapping("/name/{loginName}")
    public ResponseEntity<User> findByLoginName(@PathVariable String loginName) throws NameNotFoundException {
        return new ResponseEntity<>(userService.findByLoginName(loginName), HttpStatus.OK);
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
