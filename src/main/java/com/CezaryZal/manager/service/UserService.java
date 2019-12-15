package com.CezaryZal.manager.service;

import com.CezaryZal.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long index);
}
