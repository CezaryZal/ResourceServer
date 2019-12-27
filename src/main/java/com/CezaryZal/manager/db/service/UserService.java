package com.CezaryZal.manager.db.service;

import com.CezaryZal.entity.User;

import java.util.Optional;

public interface UserService {

    User findById(Long index);

    User findByLoginName(String loginName);

    Iterable<User> findAll();

    User addNewUser(User user);

    User updateUser(User user);

    void deleteUser(Long index);
}
