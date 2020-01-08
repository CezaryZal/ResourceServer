package com.CezaryZal.controller;

import com.CezaryZal.entity.UserHc;
import com.CezaryZal.manager.db.service.UserHcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class UserHcControllerImp implements UserHcController {

    private UserHcService userHCService;

    @Autowired
    public UserHcControllerImp(UserHcService userHCService) {
        this.userHCService = userHCService;
    }

    @GetMapping("/{index}")
    public ResponseEntity<UserHc> findById(@PathVariable Long index) {
        return new ResponseEntity<>(userHCService.findById(index), HttpStatus.OK);
    }

    @GetMapping("/name/{loginName}")
    public ResponseEntity<UserHc> findByLoginName(@PathVariable String loginName) {
        return new ResponseEntity<>(userHCService.findByLoginName(loginName), HttpStatus.OK);
    }

    @GetMapping
    public List<UserHc> findAll() {
        return userHCService.findAll();
    }

    @PostMapping
    public UserHc addNewUser(@RequestBody UserHc userHc) {
        return userHCService.addNewUser(userHc);
    }

    @PutMapping
    public UserHc updateUser(@RequestBody UserHc userHc) {
        return userHCService.updateUser(userHc);
    }

    @DeleteMapping("/{index}")
    public void deleteUserById(@PathVariable Long index) {
        userHCService.deleteUser(index);
    }
}
