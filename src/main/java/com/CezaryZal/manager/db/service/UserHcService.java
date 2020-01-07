package com.CezaryZal.manager.db.service;

import com.CezaryZal.entity.UserToHc;

import java.util.List;

public interface UserHcService {

    UserToHc findById(Long index);

    UserToHc findByLoginName(String loginName);

    List<UserToHc> findAll();

    UserToHc addNewUser(UserToHc userToHc);

    UserToHc updateUser(UserToHc userToHc);

    void deleteUser(Long index);

}
