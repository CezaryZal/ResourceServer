package com.CezaryZal.manager.db.service;

import com.CezaryZal.entity.UserToDb;
import com.CezaryZal.exceptions.UserNotFoundException;
import com.CezaryZal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserToDb findById(Long index) {
        return userRepository.findById(index)
                .orElseThrow(() -> new UserNotFoundException("User not found by id"));
    }

    public UserToDb findByLoginName(String loginName) {
        return userRepository.findByLoginName(loginName)
                .orElseThrow(() -> new UserNotFoundException("User not found by loginName"));
    }

    public List<UserToDb> findAll() {
        return (List<UserToDb>) userRepository.findAll();
    }

    public UserToDb addNewUser(UserToDb userToDb) {
        String passwordBcrypt = passwordEncoder.encode(userToDb.getPassword());
        userToDb.setPassword(passwordBcrypt);
        return userRepository.save(userToDb);
    }

    public UserToDb updateUser(UserToDb userToDb) {
        return userRepository.save(userToDb);
    }

    public void deleteUser(Long index) {
        userRepository.deleteById(index);
    }


}
