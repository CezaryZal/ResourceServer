package com.CezaryZal.controller;

import com.CezaryZal.entity.UserHc;
import org.springframework.http.ResponseEntity;

import javax.naming.NameNotFoundException;
import java.util.List;

public interface UserHcController {

    ResponseEntity<UserHc> findById(Long id) throws NameNotFoundException;

    ResponseEntity<UserHc> findByLoginName(String loginName) throws NameNotFoundException;

    List<UserHc> findAll();

    UserHc addNewUser(UserHc userHc);

    UserHc updateUser(UserHc userHc);

    void deleteUserById(Long index);
}
