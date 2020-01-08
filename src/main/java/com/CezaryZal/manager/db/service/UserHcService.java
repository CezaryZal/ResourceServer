package com.CezaryZal.manager.db.service;

import com.CezaryZal.entity.UserHc;

import java.util.List;

public interface UserHcService {

    UserHc findById(Long index);

    UserHc findByLoginName(String loginName);

    List<UserHc> findAll();

    UserHc addNewUser(UserHc userHc);

    UserHc updateUser(UserHc userHc);

    void deleteUser(Long index);

}
