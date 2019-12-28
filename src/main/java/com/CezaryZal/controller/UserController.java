package com.CezaryZal.controller;

import com.CezaryZal.entity.User;
import org.springframework.http.ResponseEntity;

import javax.naming.NameNotFoundException;

public interface UserController {

    ResponseEntity<User> findById(Long id) throws NameNotFoundException;

    ResponseEntity<User> findByLoginName(String loginName) throws NameNotFoundException;

    Iterable<User> findAll();

    User addNewUser(User user);

    User updateUser(User user);

    void deleteUserById(Long index);
}
