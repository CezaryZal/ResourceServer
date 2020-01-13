package com.CezaryZal.controller;

import com.CezaryZal.entity.health.calendar.UserAuthentication;
import org.springframework.http.ResponseEntity;

import javax.naming.NameNotFoundException;
import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface UserHcController {

    ResponseEntity<UserAuthentication> findById(Long id) throws AccountNotFoundException;

    ResponseEntity<UserAuthentication> findByLoginName(String loginName) throws AccountNotFoundException;

    boolean isExistsUserAuthenticationByLoginName(String loginName);

    List<UserAuthentication> findAll();

    UserAuthentication addNewUser(UserAuthentication userAuthentication);

    UserAuthentication updateUser(UserAuthentication userAuthentication);

    void deleteUserById(Long index);
}
