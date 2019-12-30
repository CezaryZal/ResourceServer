package com.CezaryZal.controller;

import com.CezaryZal.entity.User;
import org.springframework.http.ResponseEntity;

import javax.naming.NameNotFoundException;
import java.util.List;

public interface UserController {

    ResponseEntity<User> findById(Long id) throws NameNotFoundException;

    ResponseEntity<User> findByLoginName(String loginName) throws NameNotFoundException;

    List<User> findAll();

    User addNewUser(User user);

    User updateUser(User user);

    void deleteUserById(Long index);
}
