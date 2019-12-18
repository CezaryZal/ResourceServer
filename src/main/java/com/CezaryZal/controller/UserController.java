package com.CezaryZal.controller;

import com.CezaryZal.entity.User;

import java.util.Optional;

public interface UserController {

    Optional<User> findById(Long id);

    Optional<User> findByLoginName(String loginName);

    Iterable<User> findAll();

    User addNewUser(User user);

    User updateUser(User user);

    void deleteUserById(Long index);
}
