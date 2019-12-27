package com.CezaryZal.controller;

import com.CezaryZal.entity.User;

public interface UserController {

    User findById(Long id);

    User findByLoginName(String loginName);

    Iterable<User> findAll();

    User addNewUser(User user);

    User updateUser(User user);

    void deleteUserById(Long index);
}
