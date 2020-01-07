package com.CezaryZal.manager.db.service;

import com.CezaryZal.entity.UserToDb;

import java.util.List;

public interface UserService {

    UserToDb findById(Long index);

    UserToDb findByLoginName(String loginName);

    List<UserToDb> findAll();

    UserToDb addNewUser(UserToDb userToDb);

    UserToDb updateUser(UserToDb userToDb);

    void deleteUser(Long index);

}
