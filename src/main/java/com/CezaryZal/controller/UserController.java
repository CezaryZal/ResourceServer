package com.CezaryZal.controller;

import com.CezaryZal.entity.User;

import java.util.Optional;

public interface UserController {

    Optional<User> findById(Long id);
}
