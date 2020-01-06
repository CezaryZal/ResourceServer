package com.CezaryZal.controller;

import com.CezaryZal.entity.UserToDb;
import com.CezaryZal.manager.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class UserControllerImp implements UserController {

    private UserService userService;

    @Autowired
    public UserControllerImp(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{index}")
    public ResponseEntity<UserToDb> findById(@PathVariable Long index) {
        return new ResponseEntity<>(userService.findById(index), HttpStatus.OK);
    }

    @GetMapping("/name/{loginName}")
    public ResponseEntity<UserToDb> findByLoginName(@PathVariable String loginName) {
        return new ResponseEntity<>(userService.findByLoginName(loginName), HttpStatus.OK);
    }

    @GetMapping
    public List<UserToDb> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public UserToDb addNewUser(@RequestBody UserToDb userToDb) {
        return userService.addNewUser(userToDb);
    }

    @PutMapping
    public UserToDb updateUser(@RequestBody UserToDb userToDb) {
        return userService.updateUser(userToDb);
    }

    @DeleteMapping("/{index}")
    public void deleteUserById(@PathVariable Long index) {
        userService.deleteUser(index);
    }
}
