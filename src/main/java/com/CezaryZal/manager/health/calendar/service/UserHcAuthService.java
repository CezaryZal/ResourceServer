package com.CezaryZal.manager.health.calendar.service;

import com.CezaryZal.entity.health.calendar.UserAuthentication;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface UserHcAuthService {

    UserAuthentication findById(Long index) throws AccountNotFoundException;

    UserAuthentication findByLoginName(String loginName) throws AccountNotFoundException;

    List<UserAuthentication> findAll();

    boolean isExistsUserAuthenticationByLoginName(String loginName);

    UserAuthentication addNewUser(UserAuthentication userAuthentication);

    UserAuthentication updateUser(UserAuthentication userAuthentication);

    void deleteUser(Long index);

}
