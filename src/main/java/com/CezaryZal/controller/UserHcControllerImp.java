package com.CezaryZal.controller;

import com.CezaryZal.entity.health.calendar.UserAuthentication;
import com.CezaryZal.manager.health.calendar.service.UserHcAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class UserHcControllerImp implements UserHcController {

    private UserHcAuthService userHCAuthService;

    @Autowired
    public UserHcControllerImp(UserHcAuthService userHCAuthService) {
        this.userHCAuthService = userHCAuthService;
    }

    @GetMapping("/{index}")
    public ResponseEntity<UserAuthentication> findById(@PathVariable Long index) {
        return new ResponseEntity<>(userHCAuthService.findById(index), HttpStatus.OK);
    }

    @GetMapping("/name/{loginName}")
    public ResponseEntity<UserAuthentication> findByLoginName(@PathVariable String loginName) {
        return new ResponseEntity<>(userHCAuthService.findByLoginName(loginName), HttpStatus.OK);
    }

    @GetMapping
    public List<UserAuthentication> findAll() {
        return userHCAuthService.findAll();
    }

    @PostMapping
    public UserAuthentication addNewUser(@RequestBody UserAuthentication userAuthentication) {
        return userHCAuthService.addNewUser(userAuthentication);
    }

    @PutMapping
    public UserAuthentication updateUser(@RequestBody UserAuthentication userAuthentication) {
        return userHCAuthService.updateUser(userAuthentication);
    }

    @DeleteMapping("/{index}")
    public void deleteUserById(@PathVariable Long index) {
        userHCAuthService.deleteUser(index);
    }
}
