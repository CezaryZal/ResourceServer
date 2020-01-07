package com.CezaryZal.controller;

import com.CezaryZal.entity.UserToHc;
import org.springframework.http.ResponseEntity;

import javax.naming.NameNotFoundException;
import java.util.List;

public interface UserController {

    ResponseEntity<UserToHc> findById(Long id) throws NameNotFoundException;

    ResponseEntity<UserToHc> findByLoginName(String loginName) throws NameNotFoundException;

    List<UserToHc> findAll();

    UserToHc addNewUser(UserToHc userToHc);

    UserToHc updateUser(UserToHc userToHc);

    void deleteUserById(Long index);
}
