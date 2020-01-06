package com.CezaryZal.controller;

import com.CezaryZal.entity.UserToDb;
import org.springframework.http.ResponseEntity;

import javax.naming.NameNotFoundException;
import java.util.List;

public interface UserController {

    ResponseEntity<UserToDb> findById(Long id) throws NameNotFoundException;

    ResponseEntity<UserToDb> findByLoginName(String loginName) throws NameNotFoundException;

    List<UserToDb> findAll();

    UserToDb addNewUser(UserToDb userToDb);

    UserToDb updateUser(UserToDb userToDb);

    void deleteUserById(Long index);
}
