package com.CezaryZal.manager.db.service;

import com.CezaryZal.entity.UserToDb;
import com.CezaryZal.exceptions.UserNotFoundException;
import com.CezaryZal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserToDb findById(Long index) {
        return userRepository.findById(index)
                .orElseThrow(() -> new UserNotFoundException("User not found by id"));
    }

    public UserToDb findByLoginName(String loginName) {
        return userRepository.findByLoginName(loginName)
                .orElseThrow(() -> new UserNotFoundException("User not found by id by loginName"));
    }

    public List<UserToDb> findAll() {
        return (List<UserToDb>) userRepository.findAll();
    }

    public UserToDb addNewUser(UserToDb userToDb) {
        return userRepository.save(userToDb);
    }

    public UserToDb updateUser(UserToDb userToDb) {
        return userRepository.save(userToDb);
    }

    public void deleteUser(Long index) {
        userRepository.deleteById(index);
    }
}
