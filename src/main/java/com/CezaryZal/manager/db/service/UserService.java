package com.CezaryZal.manager.db.service;

import com.CezaryZal.entity.User;

import javax.naming.NameNotFoundException;
import java.util.List;

public interface UserService {

    User findById(Long index) throws NameNotFoundException;

    User findByLoginName(String loginName) throws NameNotFoundException;

    List<User> findAll();

    User addNewUser(User user);

    User updateUser(User user);

    void deleteUser(Long index);
}
