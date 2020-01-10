package com.CezaryZal.manager.health.calendar.service;

import com.CezaryZal.entity.health.calendar.UserAuthentication;

import java.util.List;

public interface UserHcAuthService {

    UserAuthentication findById(Long index);

    UserAuthentication findByLoginName(String loginName);

    List<UserAuthentication> findAll();

    boolean isExistsUserAuthenticationByLoginName(String loginName);

    UserAuthentication addNewUser(UserAuthentication userAuthentication);

    UserAuthentication updateUser(UserAuthentication userAuthentication);

    void deleteUser(Long index);

}
